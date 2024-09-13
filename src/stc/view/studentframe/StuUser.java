/*
 * Created by JFormDesigner on Fri Jun 14 16:23:10 CST 2024
 */

package stc.view.studentframe;

import stc.dao.Userdao;
import stc.entity.SPass;
import stc.util.IDandPassword;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author jane
 */
public class StuUser extends JFrame {
    public StuUser() {
        initComponents();
    }

    private void updatepassword(ActionEvent e) {
        // TODO add your code here
        //创建学生账号类
        SPass sPass=new SPass();
        //判断信息是否符合要求
        String Newpassword=textFieldNewpass.getText();
        String Confirmpassword=textFieldCofirmpass.getText();
        if(Newpassword==null || Newpassword.isEmpty() || Confirmpassword==null || Confirmpassword.isEmpty()){
            JOptionPane.showMessageDialog(StuUser.this, "请填写新密码并确认密码！");
            return ;
        }
        //获取填写的数据
        //获取原来的学号、密码
        IDandPassword iDandPassword=new IDandPassword();
        sPass=iDandPassword.getSID();
        sPass.setSPASSWORD(Confirmpassword);
        //通过dao把数据给数据库
        Userdao userdao=new Userdao();
        boolean isaddbase=userdao.UpdateSpass(sPass);
        if (isaddbase) {
            JOptionPane.showMessageDialog(StuUser.this, "密码修改成功");
        }else{
            JOptionPane.showMessageDialog(StuUser.this, "密码修改失败！");
        }
    }

    private void setagain(ActionEvent e) {
        // TODO add your code here
        textFieldNewpass.setText(null);
        textFieldCofirmpass.setText(null);
    }

    private void exitupdateframe(ActionEvent e) {
        // TODO add your code here
        this.frame1.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("stc.view.test");
        frame1 = new JFrame();
        label2 = new JLabel();
        label3 = new JLabel();
        label7 = new JLabel();
        textFieldCofirmpass = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        textFieldNewpass = new JTextField();
        button3 = new JButton();

        //======== frame1 ========
        {
            frame1.setIconImage(new ImageIcon(getClass().getResource("/image/school.jpg")).getImage());
            frame1.setTitle(bundle.getString("StuUser.frame1.title"));
            frame1.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
            frame1.setMinimumSize(new Dimension(690, 480));
            frame1.setPreferredSize(new Dimension(690, 480));
            Container frame1ContentPane = frame1.getContentPane();

            //---- label2 ----
            label2.setText(bundle.getString("StuUser.label2.text"));
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 12f));

            //---- label3 ----
            label3.setText(bundle.getString("StuUser.label3.text"));
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 12f));

            //---- label7 ----
            label7.setText(bundle.getString("StuUser.label7.text"));
            label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 17f));

            //---- textFieldCofirmpass ----
            textFieldCofirmpass.setFont(textFieldCofirmpass.getFont().deriveFont(textFieldCofirmpass.getFont().getSize() + 11f));

            //---- button1 ----
            button1.setText(bundle.getString("StuUser.button1.text"));
            button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 13f));
            button1.addActionListener(e -> updatepassword(e));

            //---- button2 ----
            button2.setText(bundle.getString("StuUser.button2.text"));
            button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 13f));
            button2.addActionListener(e -> setagain(e));

            //---- textFieldNewpass ----
            textFieldNewpass.setFont(textFieldNewpass.getFont().deriveFont(textFieldNewpass.getFont().getSize() + 11f));

            //---- button3 ----
            button3.setText(bundle.getString("StuUser.button3.text"));
            button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 13f));
            button3.addActionListener(e -> exitupdateframe(e));

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addGap(275, 275, 275)
                                .addComponent(label7))
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(frame1ContentPaneLayout.createParallelGroup()
                                    .addComponent(label3)
                                    .addGroup(GroupLayout.Alignment.TRAILING, frame1ContentPaneLayout.createSequentialGroup()
                                        .addComponent(label2)
                                        .addGap(12, 12, 12)))
                                .addGap(30, 30, 30)
                                .addGroup(frame1ContentPaneLayout.createParallelGroup()
                                    .addComponent(textFieldNewpass, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldCofirmpass, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(58, Short.MAX_VALUE))
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(label7)
                        .addGap(38, 38, 38)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(textFieldNewpass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(textFieldCofirmpass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button1)
                            .addComponent(button3)
                            .addComponent(button2))
                        .addContainerGap(52, Short.MAX_VALUE))
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    public JFrame getFrame1() {
        return frame1;
    }// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JFrame frame1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label7;
    private JTextField textFieldCofirmpass;
    private JButton button1;
    private JButton button2;
    private JTextField textFieldNewpass;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) {
        new StuUser().frame1.setVisible(true);
    }
}
