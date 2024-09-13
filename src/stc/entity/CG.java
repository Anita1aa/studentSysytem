package stc.entity;

public class CG {
    private String CNO;
    private String CNAME;
    private String AVGGRADE;
    private String MINGRADE;
    private String MAXGRADE;

    public CG() {
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

    public String getAVGGRADE() {
        return AVGGRADE;
    }

    public void setAVGGRADE(String AVGGRADE) {
        this.AVGGRADE = AVGGRADE;
    }

    public String getMINGRADE() {
        return MINGRADE;
    }

    public void setMINGRADE(String MINGRADE) {
        this.MINGRADE = MINGRADE;
    }

    public String getMAXGRADE() {
        return MAXGRADE;
    }

    public void setMAXGRADE(String MAXGRADE) {
        this.MAXGRADE = MAXGRADE;
    }

    @Override
    public String toString() {
        return "CG{" +
                "CNO='" + CNO + '\'' +
                ", CNAME='" + CNAME + '\'' +
                ", AVGGRADE='" + AVGGRADE + '\'' +
                ", MINGRADE='" + MINGRADE + '\'' +
                ", MAXGRADE='" + MAXGRADE + '\'' +
                '}';
    }
}
