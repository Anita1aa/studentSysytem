package stc.entity;

public class Title {
    private String TETITLE;
    private String TNUMBER;
    private String AVGSALARY;

    public Title() {
    }

    public Title(String TETITLE, String TNUMBER, String AVGSALARY) {
        this.TETITLE = TETITLE;
        this.TNUMBER = TNUMBER;
        this.AVGSALARY = AVGSALARY;
    }

    public String getTETITLE() {
        return TETITLE;
    }

    public void setTETITLE(String TETITLE) {
        this.TETITLE = TETITLE;
    }

    public String getTNUMBER() {
        return TNUMBER;
    }

    public void setTNUMBER(String TNUMBER) {
        this.TNUMBER = TNUMBER;
    }

    public String getAVGSALARY() {
        return AVGSALARY;
    }

    public void setAVGSALARY(String AVGSALARY) {
        this.AVGSALARY = AVGSALARY;
    }

    @Override
    public String toString() {
        return "Title{" +
                "TETITLE='" + TETITLE + '\'' +
                ", TNUMBER='" + TNUMBER + '\'' +
                ", AVGSALARY='" + AVGSALARY + '\'' +
                '}';
    }
}
