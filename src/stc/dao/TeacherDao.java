package stc.dao;

import stc.entity.Student;
import stc.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherDao extends Basedao{
    //添加教师
    public boolean AddTeacher(Teacher teacher){
        String sql="insert into Teacher (TNO,TNAME,TETITLE,TSALARY) values(?,?,?,?)";
        Object[] params={teacher.getTNO(),teacher.getTNAME(),teacher.getTETITLE(),teacher.getTSALARY()};
        int rows=super.update(sql,params);
        return rows>0;
    }

    //管理员修改教师信息
    public boolean ManUpdateTeacher(Teacher teacher){
        String sql1="update Teacher set TNAME=? WHERE TNO=?";
        String sql2="update Teacher set TETITLE=? WHERE TNO=?";
        String sql3="update Teacher set TSLARY=? WHERE TNO=?";
        Object[] params1 ={teacher.getTNAME(),teacher.getTNO()};
        Object[] params2 ={teacher.getTETITLE(),teacher.getTNO()};
        Object[] params3 ={teacher.getTSALARY(),teacher.getTNO()};
        int rows1 =super.update(sql1, params1);
        int rows2=super.update(sql2,params2);
        int rows3 =super.update(sql3, params3);
        return (rows1>0) || (rows2>0)|| (rows3>0);
    }

    //删除教师
    public boolean DeleteTeacher(Teacher teacher){
        String sql ="delete from Teacher WHERE TNO=?";
        Object[] params={teacher.getTNO()};
        int rows=super.update(sql,params);
        return rows>0;
    }

    //查询教师
    public List<? extends Teacher> queryTeaMess(Teacher teacher){
        String sql="select TNO,TNAME,TETITLE,TSALARY from TEACHER WHERE 1=1";
        //多条件组合查询
        List<Object> params=new ArrayList<>();
        if(teacher.getTNO()!=null && !"".equals(teacher.getTNO())){
            sql+=" and TNO=?";
            params.add(teacher.getTNO());
        }
        if(teacher.getTNAME()!=null && !"".equals(teacher.getTNAME())){
            sql+=" and TNAME=?";
            params.add(teacher.getTNAME());
        }
        if(teacher.getTETITLE()!=null && !"".equals(teacher.getTETITLE())){
            sql+=" and TETITLE=?";
            params.add(teacher.getTETITLE());
        }
        //获取查询结果
        List<? extends Teacher> list=super.query(teacher.getClass(),sql,params.toArray());
        return list;
    }
}
