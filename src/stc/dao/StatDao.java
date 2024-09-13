package stc.dao;

import stc.entity.CG;
import stc.entity.Credit;
import stc.entity.SC;
import stc.entity.Title;

import java.util.ArrayList;
import java.util.List;

public class StatDao extends Basedao{
    //管理员统计课程成绩信息
    public List<? extends CG> ManStatCG(CG cg){
        String sql="SELECT SC.CNO, COURSE.CNAME, AVG(GRADE) AS AVGGRADE, MIN(GRADE) AS MINGRADE, MAX(GRADE) AS MAXGRADE " +
                "FROM COURSE JOIN SC ON SC.CNO = COURSE.CNO GROUP BY SC.CNO, COURSE.CNAME HAVING 1=1";
        //多条件组合查询
        List<Object> params=new ArrayList<>();
        if(cg.getCNO()!=null && !"".equals(cg.getCNO())){
            sql+=" and SC.CNO=?";
            params.add(cg.getCNO());
        }
        if(cg.getCNAME()!=null && !"".equals(cg.getCNAME())){
            sql+=" and COURSE.CNAME=?";
            params.add(cg.getCNAME());
        }
        //获取查询结果
        List<? extends CG> list=super.query(cg.getClass(),sql,params.toArray());
        return list;
    }


    //管理员统计学生总学分信息
    public List<? extends Credit> ManStatALLCredit(Credit credit){
        String sql="SELECT SC.SNO, STUDENT.SNAME, SUM(COURSE.CREDIT) AS ALLCREDIT FROM STUDENT " +
                "JOIN SC ON STUDENT.SNO = SC.SNO JOIN COURSE ON SC.CNO = COURSE.CNO GROUP BY SC.SNO,STUDENT.SNAME HAVING 1=1";
        //多条件组合查询
        List<Object> params=new ArrayList<>();
        if(credit.getSNO()!=null && !"".equals(credit.getSNO())){
            sql+=" and SC.SNO=?";
            params.add(credit.getSNO());
        }
        if(credit.getSNAME()!=null && !"".equals(credit.getSNAME())){
            sql+=" and STUDENT.SNAME=?";
            params.add(credit.getSNAME());
        }
        //获取查询结果
        List<? extends Credit> list=super.query(credit.getClass(),sql,params.toArray());
        return list;
    }

    //管理员统计教师职称信息
    public List<? extends Title> ManStatALLTitle(Title title){
        String sql="select TETITLE,COUNT(*) AS TNUMBER,AVG(TSALARY) AS AVGSALARY FROM TEACHER GROUP BY TETITLE HAVING 1=1";
        //多条件组合查询
        List<Object> params=new ArrayList<>();
        if(title.getTETITLE()!=null && !"".equals(title.getTETITLE())){
            sql+=" and TETITLE=?";
            params.add(title.getTETITLE());
        }
        //获取查询结果
        List<? extends Title> list=super.query(title.getClass(),sql,params.toArray());
        return list;
    }
}
