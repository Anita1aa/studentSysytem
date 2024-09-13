package stc.entity;

public class Credit {
    private String SNO;
    private String SNAME;
    private String ALLCREDIT;

    public Credit() {
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

    public String getALLCREDIT() {
        return ALLCREDIT;
    }

    public void setALLCREDIT(String ALLCREDIT) {
        this.ALLCREDIT = ALLCREDIT;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "SNO='" + SNO + '\'' +
                ", SNAME='" + SNAME + '\'' +
                ", ALLCREDIT='" + ALLCREDIT + '\'' +
                '}';
    }
}
