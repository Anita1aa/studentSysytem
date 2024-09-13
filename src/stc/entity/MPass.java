package stc.entity;

import java.io.Serializable;

public class MPass implements Serializable {
    private String MID;
    private String MPASSWORD;

    public MPass() {
    }

    public MPass(String MID, String MPASSWORD) {
        this.MID = MID;
        this.MPASSWORD = MPASSWORD;
    }

    public String getMID() {
        return MID;
    }

    public void setMID(String MID) {
        this.MID = MID;
    }

    public String getMPASSWORD() {
        return MPASSWORD;
    }

    public void setMPASSWORD(String MPASSWORD) {
        this.MPASSWORD = MPASSWORD;
    }

    @Override
    public String toString() {
        return "MPass{" +
                "MID='" + MID + '\'' +
                ", MPASSWORD='" + MPASSWORD + '\'' +
                '}';
    }
}
