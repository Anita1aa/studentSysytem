package stc.entity;

public class Course {
    private String CNO;
    private String CNAME;
    private String CREDIT;
    private String TNO;

    public Course() {
    }

    public Course(String CNO, String CNAME, String CREDIT, String TNO) {
        this.CNO = CNO;
        this.CNAME = CNAME;
        this.CREDIT = CREDIT;
        this.TNO = TNO;
    }

    public String getCNO() {
        return CNO;
    }

    public void setCNO(String CNO) {
        this.CNO = CNO;
    }

    public String getCNAME() {
        return CNAME;
    }

    public void setCNAME(String CNAME) {
        this.CNAME = CNAME;
    }

    public String getCREDIT() {
        return CREDIT;
    }

    public void setCREDIT(String CREDIT) {
        this.CREDIT = CREDIT;
    }

    public String getTNO() {
        return TNO;
    }

    public void setTNO(String TNO) {
        this.TNO = TNO;
    }

    @Override
    public String toString() {
        return "Course{" +
                "CNO='" + CNO + '\'' +
                ", CNAME='" + CNAME + '\'' +
                ", CREDIT='" + CREDIT + '\'' +
                ", TNO='" + TNO + '\'' +
                '}';
    }
}
