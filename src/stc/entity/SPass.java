package stc.entity;

import java.io.Serializable;

public class SPass implements Serializable{
    private  String SNO;
    private  String SPASSWORD;

    public SPass() {
    }

    public SPass(String SPASSWORD, String SNO) {
        this.SPASSWORD = SPASSWORD;
        this.SNO = SNO;
    }

    public String getSNO() {
        return SNO;
    }

    public void setSNO(String SNO) {
        this.SNO = SNO;
    }

    public String getSPASSWORD() {
        return SPASSWORD;
    }

    public void setSPASSWORD(String SPASSWORD) {
        this.SPASSWORD = SPASSWORD;
    }

    @Override
    public String toString() {
        return "SPass{" +
                "SNO='" + SNO + '\'' +
                ", SPASSWORD='" + SPASSWORD + '\'' +
                '}';
    }
}
