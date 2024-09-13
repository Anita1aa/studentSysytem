package stc.entity;

public class STC {
    private String CNO;
    private String CNAME;
    private String CREDIT;
    private String TNAME;
    private String SNO;

    public STC() {
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

    public String getTNAME() {
        return TNAME;
    }

    public void setTNAME(String TNAME) {
        this.TNAME = TNAME;
    }

    public String getSNO() {
        return SNO;
    }

    public void setSNO(String SNO) {
        this.SNO = SNO;
    }

    @Override
    public String toString() {
        return "STC{" +
                "CNO='" + CNO + '\'' +
                ", CNAME='" + CNAME + '\'' +
                ", CREDIT='" + CREDIT + '\'' +
                ", TNAME='" + TNAME + '\'' +
                ", SNO='" + SNO + '\'' +
                '}';
    }
}
