package stc.entity;

public class Teacher {
    private String TNO;
    private String TNAME;
    private String TETITLE;
    private String TSALARY;

    public Teacher() {
    }

    public Teacher(String TNO, String TNAME, String TETITLE, String TSALARY) {
        this.TNO = TNO;
        this.TNAME = TNAME;
        this.TETITLE = TETITLE;
        this.TSALARY = TSALARY;
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

    public String getTETITLE() {
        return TETITLE;
    }

    public void setTETITLE(String TETITLE) {
        this.TETITLE = TETITLE;
    }

    public String getTSALARY() {
        return TSALARY;
    }

    public void setTSALARY(String TSALARY) {
        this.TSALARY = TSALARY;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "TNO='" + TNO + '\'' +
                ", TNAME='" + TNAME + '\'' +
                ", TETITLE='" + TETITLE + '\'' +
                ", TSALARY=" + TSALARY +
                '}';
    }
}
