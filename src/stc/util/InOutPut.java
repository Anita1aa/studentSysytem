package stc.util;

import stc.entity.SPass;

import java.io.*;

public class InOutPut {
    //读写文件
    //从文件中读取对象
        public static Object readObject(String filename) {

            FileInputStream fis = null;
            ObjectInputStream ois = null;
            Object object = null;
            try {
                //创建输入流
                fis = new FileInputStream(filename);
                //创建对象输入流
                ois = new ObjectInputStream(fis);
                //读取
                object = ois.readObject();
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("第一次加载 无文件");
            } finally {
                //关闭文件
                try {
                    if (fis != null) fis.close();
                    if (ois != null) ois.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return object;
        }
        //将对象写入文件
        public static void storeObject(String filename, Object object) {

            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            try {
                //创建文件输出流
                fos = new FileOutputStream(filename);
                //创建对象输入流
                oos = new ObjectOutputStream(fos);
                //写出对象
                oos.writeObject(object);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fos != null) fos.close();
                    if (oos != null) oos.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        //清空文件内容
        public static void clearFileContent(String filename) {
            FileOutputStream fos = null;
            try {
                // 打开文件输出流，如果文件不存在则创建它，如果已存在则覆盖它
                fos = new FileOutputStream(filename, false); // 第二个参数为false表示不追加内容，而是覆盖
                // 因为我们没有写入任何内容，所以文件现在已经被清空了
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fos != null) fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        //测试
    /*public static void main(String[] args) {
        SPass sPass=new SPass();
        sPass.setSNO("2021001");
        sPass.setSPASSWORD("123456");
        //storeObject("src/UserType.txt",sPass);
        //SPass sPass1=(SPass) readObject("src/UserType.txt");
        //System.out.println(sPass1.getSNO()+"_____"+sPass1.getSPASSWORD());
        clearFileContent("src/UserType.txt");
        //SPass sPass1=(SPass) readObject("src/UserType.txt");
        //System.out.println(sPass1.getSNO()+"_____"+sPass1.getSPASSWORD());
    }*/
}

