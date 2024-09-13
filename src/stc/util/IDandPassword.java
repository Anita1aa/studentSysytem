package stc.util;

import stc.entity.MPass;
import stc.entity.SPass;

import static stc.util.InOutPut.*;

public class IDandPassword {

    private static String filename="src/UserType.txt";

    public void writeSID(String Sno,String Spassword){
        SPass sPass=new SPass();
        sPass.setSNO(Sno);
        sPass.setSPASSWORD(Spassword);
        storeObject(filename,sPass);
    }

    public SPass getSID(){
        SPass sPass=new SPass();
        sPass= (SPass) readObject(filename);
        return sPass;
    }

    public void writeMID(String MID,String Mpassword){
        MPass mPass =new MPass();
        mPass.setMID(MID);
        mPass.setMPASSWORD(Mpassword);
        storeObject(filename, mPass);
    }

    public MPass getMID(){
        MPass mPass=new MPass();
        mPass= (MPass) readObject(filename);
        return mPass;
    }

    public void clearSMID(){
        clearFileContent(filename);
    }

}
