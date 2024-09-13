import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testdb {
    //测试
    public static void main(String[] args) {
        //连接数据库的四个参数
        String driver="oracle.jdbc.driver.OracleDriver";
        String url="jdbc:oracle:thin:@localhost:1522/mystc";
        String username="stc";
        String password="stcstc";

        try {
            //加载驱动
            Class.forName(driver);
            //创建连接
            Connection connection= DriverManager.getConnection(url,username,password);
            //创建声明
            Statement statement = connection.createStatement();
            //执行SQL语句,返回执行后影响到的行数
            String sql="insert into Student (SNO,Sname,Ssex,Sage,Sdept) values('2021052','秋张','女',20,'拉文克劳')";
            String sql1 ="update Student set Sage=19 where Sno='2021052'";
            String sql2 ="delete Student where Sno='2021052'";
            int row = statement.executeUpdate(sql2);

            //查询语句,返回结果集
            String sql3 ="select * from Student";
            ResultSet resultSet = statement.executeQuery(sql3);
            //遍历结果集,游标最开始指向第一行之前,next返回true表示当前指向行记录不为空
            while(resultSet.next()){
                //一列一列取数据
                String sno = resultSet.getString("Sno");
                String sname = resultSet.getString("Sname");
                String ssex = resultSet.getString("Ssex");
                int sage = resultSet.getInt("Sage");
                String sdept = resultSet.getString("Sdept");
                System.out.println(sno+"=="+sname+"=="+ssex+"=="+sage+"=="+sdept);
            }

            if(row>0){
                System.out.println("插入成功!");
            }
            else {
                System.out.println("插入失败!");
            }
            //关闭连接
            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("连接成功!");
        } catch (Exception e) {
            System.out.println("连接失败!");
            e.printStackTrace();
        }

    }
}


/*//设置标签
//1、把图片添加到标签，把标签的大小设为和图片大小相同，把标签放在分层面板最底层
ImageIcon bg=new ImageIcon("hogwarts.jpg");
JLabel label=new JLabel(bg);
        label.setSize(bg.getIconWidth(),bg.getIconHeight());
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
//2、把窗口面板设为内容面板且透明、流动布局
JPanel pan=(JPanel)this.getContentPane();
        pan.setOpaque(false);
        pan.setLayout(new FlowLayout());
//3、把组件和面板添加到窗口面板
JButton btn=new JButton("测试按钮");
        pan.add(btn);
        this.setSize(bg.getIconWidth(),bg.getIconHeight());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 */