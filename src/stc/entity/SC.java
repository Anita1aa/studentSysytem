package stc.entity;

public class SC {
    private String SNO;
    private String SNAME;
    private String CNO;
    private String CNAME;
    private String CREDIT;
    private String GRADE;

    public SC() {
    }

    public String getSNO() {
        return SNO;
    }

    public void setSNO(String SNO) {
        this.SNO = SNO;
    }

    public String getSNAME() {
        return SNAME;
    }

    public void setSNAME(String SNAME) {
        this.SNAME = SNAME;
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

    public String getGRADE() {
        return GRADE;
    }

    public void setGRADE(String GRADE) {
        this.GRADE = GRADE;
    }

    @Override
    public String toString() {
        return "SC{" +
                "SNO='" + SNO + '\'' +
                ", SNAME='" + SNAME + '\'' +
                ", CNO='" + CNO + '\'' +
                ", CNAME='" + CNAME + '\'' +
                ", CREDIT='" + CREDIT + '\'' +
                ", GRADE='" + GRADE + '\'' +
                '}';
    }
}
