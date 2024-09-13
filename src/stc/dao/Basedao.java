package stc.dao;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

//数据库相关操作封装
public class Basedao {

    private static String driver = "oracle.jdbc.driver.OracleDriver";
    private static String url = "jdbc:oracle:thin:@localhost:1522/mystc";
    private static String username = "stc";
    private static String password = "stcstc";

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    //获取连接数据库方法
    public Connection getconnection() {
        if (connection == null) {
            try {
                //加载驱动
                Class.forName(driver);
                //创建连接
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("连接成功!");
            } catch (Exception e) {
                System.out.println("连接失败!");
                e.printStackTrace();
            }
        }
        return connection;
    }

    //关闭数据库连接
    public void closeconnection() {
        if (resultSet != null) {
            try {
                resultSet.close();
                resultSet = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
                preparedStatement = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //数据增删改操作
    public int update(String sql, Object...params) {
        int rows=-1;
        try {
            //获取连接
            connection = getconnection();
            //预编译
            preparedStatement=connection.prepareStatement(sql);
            if(params!=null && params.length>0) {
                for(int i=0;i<params.length;i++){
                    preparedStatement.setObject(i+1,params[i]);
                }
            }
            //rows返回修改的行数
            rows=preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //释放连接
        closeconnection();
        return rows;
    }

    //数据查询操作
    public <T> List<T> query(Class<T> clazz ,String sql,Object...params) {
        List<T> list=new ArrayList<>();
        try {
            connection=getconnection();
            preparedStatement=connection.prepareStatement(sql);
            if(params!=null && params.length>0) {
                for(int i=0;i<params.length;i++){
                    preparedStatement.setObject(i+1,params[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();
            //获取结果集中的元数据对象——包含列的数量、每个列的名称
            ResultSetMetaData metaData=resultSet.getMetaData();
            int columnCount =metaData.getColumnCount();
            //处理结果
            while(resultSet.next()){
                //循环一次，代表有一行数据，通过反射创建一个对象
                T t=clazz.newInstance();
                //循环遍历当前列，循环几次看有多少列
                for (int i = 1; i <= columnCount; i++) {
                    //通过下标获取列的值
                    Object value = resultSet.getObject(i);
                    //获取当前拿到的列的名字=对象属性名
                    String fieldName = metaData.getColumnLabel(i);
                    //通过类对象和fileName获取要封装的对象的属性
                    Field field = clazz.getDeclaredField(fieldName);
                    //突破私有属性
                    field.setAccessible(true);
                    //转换数据类型
                    if(!Objects.isNull(value)){
                        if ("java.math.BigDecimal".equals(value.getClass().getName())){
                            value=String.valueOf(value);
                        }
                        if ("java.sql.Timestamp".equals(value.getClass().getName())){
                            Timestamp tt=(Timestamp)value;
                            value=new Date(tt.getTime());
                        }
                    }else{
                        value=null;
                    }

                    field.set(t,value);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //释放连接
        closeconnection();
        return list;
    }

    // 查询获取单个结果
    public <T> T queryBean(Class<T> clazz ,String sql,Object...params){
        List<T> list = this.query(clazz, sql, params);
        if(list==null || list.size()==0){
            return null;
        }
        return list.get(0);
    }

}

