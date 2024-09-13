package stc.dao;

import stc.entity.Course;
import stc.entity.STC;

import java.util.ArrayList;
import java.util.List;

public class CourseDao extends Basedao{
    //添加课程
    public boolean AddCourse(Course course){
        String sql1="insert into Course (CNO,CNAME,CREDIT) values(?,?,?)";
        String sql2="insert into TC (TNO,CNO) values(?,?)";
        Object[] params1={course.getCNO(),course.getCNAME(),course.getCREDIT()};
        Object[] params2={course.getTNO(),course.getCNO()};
        int rows1=super.update(sql1,params1);
        if(!course.getTNO().isEmpty()){
            super.update(sql2,params2);
        }
        return rows1>0;
    }
    //修改课程名
    public boolean UpdateCourseCname(Course course){
        String sql="update COURSE set CNAME=? WHERE CNO=?";
        Object[] params={course.getCNAME(),course.getCNO(),};
        int rows=super.update(sql,params);
        return rows>0;
    }
    //修改课程名
    public boolean UpdateCourseCredit(Course course){
        String sql="update COURSE set CREDIT=? WHERE CNO=?";
        Object[] params={course.getCREDIT(),course.getCNO()};
        int rows=super.update(sql,params);
        return rows>0;
    }
    //删除课程
    public boolean DeleteCourse(Course course){
        String sql ="delete from COURSE WHERE CNO=?";
        Object[] params={course.getCNO()};
        int rows=super.update(sql,params);
        return rows>0;
    }
    //查询课程
    public List<? extends Course> queryCouMess(Course course){
        String sql="select CNO,CNAME,CREDIT from COURSE WHERE 1=1";
        //多条件组合查询
        List<Object> params=new ArrayList<>();
        if(course.getCNO()!=null && !"".equals(course.getCNO())){
            sql+=" and CNO=?";
            params.add(course.getCNO());
        }
        if(course.getCNAME()!=null && !"".equals(course.getCNAME())){
            sql+=" and CNAME=?";
            params.add(course.getCNAME());
        }
        //获取查询结果
        List<? extends Course> list=super.query(course.getClass(),sql,params.toArray());
        return list;
    }

    //学生选课显示界面
    public List<? extends STC> StuSelectC(STC stc){
        //多条件组合查询
        String sql="SELECT COURSE.CNO AS CNO,COURSE.CNAME AS CNAME,COURSE.CREDIT AS CREDIT,TEACHER.TNAME AS TNAME, SC.SNO  AS SNO "+
                "FROM COURSE LEFT OUTER JOIN SC ON COURSE.CNO = SC.CNO AND SC.SNO =? " +
                "LEFT OUTER JOIN TC ON COURSE.CNO = TC.CNO " +
                "LEFT OUTER JOIN TEACHER ON TC.TNO = TEACHER.TNO " +
                "WHERE 1=1";
        List<Object> params=new ArrayList<>();
        params.add(stc.getSNO());
        if(stc.getCNO()!=null && !"".equals(stc.getCNO())){
            sql+=" and COURSE.CNO=?";
            params.add(stc.getCNO());
        }
        if(stc.getCNAME()!=null && !"".equals(stc.getCNAME())){
            sql+=" and COURSE.CNAME=?";
            params.add(stc.getCNAME());
        }
        if(stc.getCREDIT()!=null && !"".equals(stc.getCREDIT())){
            sql+=" and COURSE.CREDIT=?";
            params.add(stc.getCREDIT());
        }
        //获取查询结果
        List<? extends STC> list=super.query(stc.getClass(),sql,params.toArray());
        return list;
    }
}
