package stc.dao;
import stc.entity.MPass;
import stc.entity.SPass;
import stc.entity.Teacher;
import stc.util.IDandPassword;

import java.util.ArrayList;
import java.util.List;

//管理员数据库访问层
public class Userdao extends Basedao {
    //学生登录操作
    public boolean loginStudent(String username,String password)
    {
        SPass spass=new SPass();
        String sql="select SNO,SPASSWORD from Spass where SNO=? and SPASSWORD=?";
        List<? extends SPass> spque = super.query(spass.getClass(), sql, username, password);
        if(!spque.isEmpty()){
            System.out.println(spque);
            //将用户名和密码写入UserType.txt文件当中
            IDandPassword iDandPassword=new IDandPassword();
            iDandPassword.writeSID(username,password);
            return true;
        }
        return false;
    }

    //管理员登录操作
    public boolean loginManager(String username,String password){
        MPass mpass= new MPass();
        String sql="select MID,MPASSWORD from Mpass where MID=? and Mpassword=?";
        List<? extends MPass> mpque = super.query(mpass.getClass(), sql, username, password);
        if(!mpque.isEmpty()){
            System.out.println(mpque);
            //将用户名和密码写入UserType.txt文件当中
            IDandPassword iDandPassword=new IDandPassword();
            iDandPassword.writeMID(username,password);
            return true;
        }
        return false;
    }

    //新增管理员用户
    public boolean IDmanager(MPass mpass){
        String sql="insert into MPass (MID,MPASSWORD) values(?,?)";
        Object[] params={mpass.getMID(),mpass.getMPASSWORD()};
        int rows=super.update(sql,params);
        return rows>0;
    }
    //新增学生用户
    public boolean IDstudent(SPass spass){
        String sql="insert into SPass (SNO,SPASSWORD) values(?,?)";
        Object[] params={spass.getSNO(),spass.getSPASSWORD()};
        int rows=super.update(sql,params);
        return rows>0;
    }

    //学生修改密码操作
    public boolean UpdateSpass(SPass sPass) {
        String sql = "update Spass set SPASSWORD=? where SNO=?";
        Object[] params = {sPass.getSPASSWORD(), sPass.getSNO()};
        int rows = super.update(sql, params);
        return rows > 0;
    }

    //管理员修改密码操作
    public boolean UpdateMpass(MPass mPass,String newusername) {
        String sql1 = "update Mpass set MPASSWORD=? where MID=?";
        String sql2 = "update Mpass set MID=? where MID=?";
        Object[] params1 = {mPass.getMPASSWORD(), mPass.getMID()};
        Object[] params2 = {newusername, mPass.getMID()};
        int row1 = super.update(sql1, params1);
        int row2 = super.update(sql2, params2);
        return (row1 > 0)&&(row2>0);
    }

    //管理员管理账号
    public List<? extends SPass> ManSCpass(SPass sPass) {
        String sql = "select SNO,SPASSWORD from Spass WHERE 1=1";
        //获取查询结果
        List<Object> params=new ArrayList<>();
        if(sPass.getSNO()!=null && !"".equals(sPass.getSNO())){
            sql+=" and SNO=?";
            params.add(sPass.getSNO());
        }
        List<? extends SPass> list=super.query(sPass.getClass(),sql,params.toArray());
        return list;
    }
}

