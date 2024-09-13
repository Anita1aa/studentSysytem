package stc.dao;

import stc.entity.Course;
import stc.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDao extends Basedao{
    //管理员添加学生
    public boolean AddStudent(Student student){
        String sql="insert into Student (SNO,SNAME,SSEX,SAGE,SDEPT) values(?,?,?,?,?)";
        Object[] params={student.getSNO(),student.getSNAME(),student.getSSEX(),student.getSAGE(),student.getSDEPT()};
        int rows=super.update(sql,params);
        return rows>0;
    }

    //学生修改学生信息
    public boolean UpdateStudent(Student student){
        String sql1="update student set SNAME=? WHERE SNO=?";
        String sql2="update student set SAGE=? WHERE SNO=?";
        Object[] params1 ={student.getSNAME(),student.getSNO()};
        Object[] params2 ={student.getSAGE(),student.getSNO()};
        int rows1 =super.update(sql1, params1);
        int rows2=super.update(sql2,params2);
        return (rows1>0) && (rows2>0);
    }

    //管理员修改学生信息
    public boolean ManUpdateStudent(Student student){
        String sql1="update student set SNAME=? WHERE SNO=?";
        String sql2="update student set SSEX=? WHERE SNO=?";
        String sql3="update student set SAGE=? WHERE SNO=?";
        String sql4="update student set SDEPT=? WHERE SNO=?";
        Object[] params1 ={student.getSNAME(),student.getSNO()};
        Object[] params2 ={student.getSSEX(),student.getSNO()};
        Object[] params3 ={student.getSAGE(),student.getSNO()};
        Object[] params4 ={student.getSDEPT(),student.getSNO()};
        int rows1 =super.update(sql1, params1);
        int rows2=super.update(sql2,params2);
        int rows3 =super.update(sql3, params3);
        int rows4 =super.update(sql4, params4);
        return (rows1>0) || (rows2>0)|| (rows3>0)|| (rows4>0);
    }

    //删除学生
    public boolean DeleteStudent(Student student){
        String sql ="delete from STUDENT WHERE SNO=?";
        Object[] params={student.getSNO()};
        int rows=super.update(sql,params);
        return rows>0;
    }

    //根据学号查询单个学生
    public Student queryStuMessOne(String Sno){
        String sql="select SNO,SNAME,SSEX,SAGE,SDEPT from Student WHERE SNO=?";
        Student student=new Student();
        student=queryBean(student.getClass(),sql,Sno);
        return student;
    }

    //查询学生_多条件组合查询
    public List<? extends Student>queryStuMess(Student student){
        String sql="select SNO,SNAME,SSEX,SAGE,SDEPT from Student WHERE 1=1";
        List<Object> params=new ArrayList<>();
        if(student.getSNO()!=null && !"".equals(student.getSNO())){
            sql+=" and SNO=?";
            params.add(student.getSNO());
        }
        if(student.getSNAME()!=null && !"".equals(student.getSNAME())){
            sql+=" and SNAME=?";
            params.add(student.getSNAME());
        }
        if(student.getSSEX()!=null && !"".equals(student.getSSEX())){
            sql+=" and SSEX=?";
            params.add(student.getSSEX());
        }
        if(student.getSAGE()!=null &&!"".equals(student.getSAGE())){
            sql+=" and SAGE=?";
            params.add(student.getSAGE());
        }
        if(student.getSDEPT()!=null && !"".equals(student.getSDEPT())){
            sql+=" and SDEPT=?";
            params.add(student.getSDEPT());
        }
        //获取查询结果
        List<? extends Student> list=super.query(student.getClass(),sql,params.toArray());
        return list;
    }

}
