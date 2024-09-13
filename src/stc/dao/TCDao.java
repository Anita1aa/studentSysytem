package stc.dao;

import stc.entity.SC;
import stc.entity.TC;

import java.util.ArrayList;
import java.util.List;

public class TCDao extends Basedao{
    //管理员查询教师授课信息
    public List<? extends TC> ManqueryTC(TC tc){
        String sql="select TC.TNO as TNO,TEACHER.TNAME as TNAME,TC.CNO as CNO,COURSE.CNAME as CNAME,COURSE.CREDIT as CREDIT " +
                "from TEACHER,COURSE,TC WHERE TC.TNO=TEACHER.TNO AND TC.CNO=COURSE.CNO";
        //多条件组合查询
        List<Object> params=new ArrayList<>();
        if(tc.getTNO()!=null && !"".equals(tc.getTNO())){
            sql+=" and TC.TNO=?";
            params.add(tc.getTNO());
        }
        if(tc.getTNAME()!=null && !"".equals(tc.getTNAME())){
            sql+=" and TEACHER.TNAME=?";
            params.add(tc.getTNAME());
        }
        if(tc.getCNO()!=null && !"".equals(tc.getCNO())){
            sql+=" and TC.CNO=?";
            params.add(tc.getCNO());
        }
        if(tc.getCNAME()!=null && !"".equals(tc.getCNAME())){
            sql+=" and COURSE.CNAME=?";
            params.add(tc.getCNAME());
        }
        if(tc.getCREDIT()!=null && !"".equals(tc.getCREDIT())){
            sql+=" and COURSE.CREDIT=?";
            params.add(tc.getCREDIT());
        }
        //获取查询结果
        List<? extends TC> list=super.query(tc.getClass(),sql,params.toArray());
        return list;
    }
}
