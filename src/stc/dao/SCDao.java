package stc.dao;

import stc.entity.*;

import java.util.ArrayList;
import java.util.List;

public class SCDao extends Basedao{
    //管理员查询学生选课信息
    public List<? extends SC> ManquerySC(SC sc){
        String sql="select SC.SNO as SNO,STUDENT.SNAME as SNAME,SC.CNO as CNO,COURSE.CNAME as CNAME,COURSE.CREDIT as CREDIT,SC.GRADE as GRADE " +
                "from STUDENT,COURSE,SC WHERE SC.SNO=student.SNO AND SC.CNO=COURSE.CNO";
        //多条件组合查询
        List<Object> params=new ArrayList<>();
        if(sc.getSNO()!=null && !"".equals(sc.getSNO())){
            sql+=" and SC.SNO=?";
            params.add(sc.getSNO());
        }
        if(sc.getSNAME()!=null && !"".equals(sc.getSNAME())){
            sql+=" and STUDENT.SNAME=?";
            params.add(sc.getSNAME());
        }
        if(sc.getCNO()!=null && !"".equals(sc.getCNO())){
            sql+=" and SC.CNO=?";
            params.add(sc.getCNO());
        }
        if(sc.getCNAME()!=null && !"".equals(sc.getCNAME())){
            sql+=" and COURSE.CNAME=?";
            params.add(sc.getCNAME());
        }
        if(sc.getCREDIT()!=null && !"".equals(sc.getCREDIT())){
            sql+=" and COURSE.CREDIT=?";
            params.add(sc.getCREDIT());
        }
        //获取查询结果
        List<? extends SC> list=super.query(sc.getClass(),sql,params.toArray());
        return list;
    }

    //录入学生成绩
    public boolean SetStuGrade(SC sc){
        String sql="update SC set GRADE=? WHERE SNO=? AND CNO=?";
        Object[] params={sc.getGRADE(),sc.getSNO(),sc.getCNO()};
        int rows=super.update(sql,params);
        return rows>0;
    }

    //学生选课
    public boolean SselectCourse(SC sc){
        String sql="insert into SC (SNO,CNO) values (?,?)";
        Object[] params={sc.getSNO(),sc.getCNO()};
        int rows=super.update(sql,params);
        return rows>0;
    }

    //学生退课
    public boolean SdeselectCourse(SC sc){
        String sql="delete from SC WHERE SNO=? and CNO=?";
        Object[] params={sc.getSNO(),sc.getCNO()};
        int rows=super.update(sql,params);
        return rows>0;
    }

}
