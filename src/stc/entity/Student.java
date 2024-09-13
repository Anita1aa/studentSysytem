package stc.entity;

//一个类就是一张表、一行是一个对象，每一列是一个属性
public class Student {
    private String SNO;
    private String SNAME;
    private String SSEX;
    private String SAGE;
    private String SDEPT;

    public Student() {
    }

    public Student(String SNO, String SNAME, String SSEX, String SAGE, String SDEPT) {
        this.SNO = SNO;
        this.SNAME = SNAME;
        this.SSEX = SSEX;
        this.SAGE = SAGE;
        this.SDEPT = SDEPT;
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

    public String getSSEX() {
        return SSEX;
    }

    public void setSSEX(String SSEX) {
        this.SSEX = SSEX;
    }

    public String getSAGE() {
        return SAGE;
    }

    public void setSAGE(String SAGE) {
        this.SAGE = SAGE;
    }

    public String getSDEPT() {
        return SDEPT;
    }

    public void setSDEPT(String SDEPT) {
        this.SDEPT = SDEPT;
    }

    @Override
    public String toString() {
        return "Student{" +
                "SNO='" + SNO + '\'' +
                ", SNAME='" + SNAME + '\'' +
                ", SSEX='" + SSEX + '\'' +
                ", SAGE=" + SAGE +
                ", SDEPT='" + SDEPT + '\'' +
                '}';
    }
}
