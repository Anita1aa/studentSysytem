package stc.entity;

public class TC {
    private  String TNO;
    private String TNAME;
    private String CNO;
    private  String CNAME;
    private String CREDIT;

    public TC() {
    }

    public String getTNO() {
        return TNO;
    }

    public void setTNO(String TNO) {
        this.TNO = TNO;
    }

    public String getTNAME() {
        return TNAME;
    }

    public void setTNAME(String TNAME) {
        this.TNAME = TNAME;
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

    @Override
    public String toString() {
        return "TC{" +
                "TNO='" + TNO + '\'' +
                ", TNAME='" + TNAME + '\'' +
                ", CNO='" + CNO + '\'' +
                ", CNAME='" + CNAME + '\'' +
                ", CREDIT=" + CREDIT +
                '}';
    }
}
