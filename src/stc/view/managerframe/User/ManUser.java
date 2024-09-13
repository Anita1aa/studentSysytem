/*
 * Created by JFormDesigner on Fri Jun 14 16:39:31 CST 2024
 */

package stc.view.managerframe.User;

import stc.dao.Userdao;
import stc.entity.MPass;
import stc.util.IDandPassword;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author jane
 */
public class ManUser extends JFrame {
    public ManUser() {
        initComponents();
    }

    private void setagain(ActionEvent e) {
        // TODO add your code here
        textFieldusername.setText(null);
        textFieldNewpassword.setText(null);
        textFieldConfirmpassword.setText(null);
    }

    private void canclepassword(ActionEvent e) {
        // TODO add your code here
        this.frame1.dispose();
    }

    private void updateMpassword(ActionEvent e) {
        // TODO add your code here
        //创建学生账号类
        MPass mPass=new MPass();
        //判断信息是否符合要求
        String Newusername=textFieldusername.getText();
        String Newpassword=textFieldNewpassword.getText();
        String Confirmpassword=textFieldConfirmpassword.getText();
        if(Newusername==null ||Newusername.isEmpty()||Newpassword==null || Newpassword.isEmpty() || Confirmpassword==null || Confirmpassword.isEmpty()){
            JOptionPane.showMessageDialog(ManUser.this, "请填写用户名、新密码以及确认密码！");
            return ;
        }
        //获取填写的数据
        //获取原来的用户名、密码
        IDandPassword iDandPassword=new IDandPassword();
        mPass=iDandPassword.getMID();
        System.out.println(mPass.getMID());
        mPass.setMPASSWORD(Confirmpassword);
        //通过dao把数据给数据库
        Userdao userdao=new Userdao();
        boolean isaddbase=userdao.UpdateMpass(mPass,Newusername);
        if (isaddbase) {
            JOptionPane.showMessageDialog(ManUser.this, "密码修改成功");
        }else{
            JOptionPane.showMessageDialog(ManUser.this, "密码修改失败！");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("stc.view.test");
        frame1 = new JFrame();
        label2 = new JLabel();
        label3 = new JLabel();
        label7 = new JLabel();
        textFieldNewpassword = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        textFieldusername = new JTextField();
        label4 = new JLabel();
        textFieldConfirmpassword = new JTextField();
        button3 = new JButton();

        //======== frame1 ========
        {
            frame1.setIconImage(new ImageIcon(getClass().getResource("/image/school.jpg")).getImage());
            frame1.setTitle(bundle.getString("ManUser.frame1.title"));
            frame1.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
            frame1.setMinimumSize(new Dimension(690, 520));
            frame1.setPreferredSize(new Dimension(690, 520));
            Container frame1ContentPane = frame1.getContentPane();

            //---- label2 ----
            label2.setText(bundle.getString("ManUser.label2.text"));
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 12f));

            //---- label3 ----
            label3.setText(bundle.getString("ManUser.label3.text"));
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 12f));

            //---- label7 ----
            label7.setText(bundle.getString("ManUser.label7.text"));
            label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 17f));

            //---- textFieldNewpassword ----
            textFieldNewpassword.setFont(textFieldNewpassword.getFont().deriveFont(textFieldNewpassword.getFont().getSize() + 11f));

            //---- button1 ----
            button1.setText(bundle.getString("ManUser.button1.text"));
            button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 13f));
            button1.addActionListener(e -> updateMpassword(e));

            //---- button2 ----
            button2.setText(bundle.getString("ManUser.button2.text"));
            button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 13f));
            button2.addActionListener(e -> canclepassword(e));

            //---- textFieldusername ----
            textFieldusername.setFont(textFieldusername.getFont().deriveFont(textFieldusername.getFont().getSize() + 11f));

            //---- label4 ----
            label4.setText(bundle.getString("ManUser.label4.text"));
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 12f));

            //---- textFieldConfirmpassword ----
            textFieldConfirmpassword.setFont(textFieldConfirmpassword.getFont().deriveFont(textFieldConfirmpassword.getFont().getSize() + 11f));

            //---- button3 ----
            button3.setText(bundle.getString("ManUser.button3.text"));
            button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 13f));
            button3.addActionListener(e -> setagain(e));

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
                                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                        .addComponent(label4)
                                        .addGap(30, 30, 30))
                                    .addGroup(GroupLayout.Alignment.TRAILING, frame1ContentPaneLayout.createSequentialGroup()
                                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(label3)
                                            .addComponent(label2))
                                        .addGap(42, 42, 42)))
                                .addGroup(frame1ContentPaneLayout.createParallelGroup()
                                    .addComponent(textFieldusername, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldNewpassword, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldConfirmpassword, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
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
                            .addComponent(textFieldusername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldNewpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3))
                        .addGap(50, 50, 50)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(textFieldConfirmpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button3)
                            .addComponent(button2)
                            .addComponent(button1))
                        .addContainerGap(84, Short.MAX_VALUE))
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
    private JTextField textFieldNewpassword;
    private JButton button1;
    private JButton button2;
    private JTextField textFieldusername;
    private JLabel label4;
    private JTextField textFieldConfirmpassword;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args) {

        new ManUser().frame1.setVisible(true);
    }
}
