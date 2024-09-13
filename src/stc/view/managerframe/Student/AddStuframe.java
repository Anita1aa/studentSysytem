/*
 * Created by JFormDesigner on Wed Jun 12 11:06:37 CST 2024
 */

package stc.view.managerframe.Student;

import stc.dao.StudentDao;
import stc.dao.Userdao;
import stc.entity.SPass;
import stc.entity.Student;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * @author jane
 */
public class AddStuframe extends JFrame {
    public AddStuframe() {
        initComponents();
    }

    private void comboBox1ItemStateChanged(ItemEvent e) {
        // TODO add your code here
    }

    private void Addstudent(ActionEvent e) {
        // TODO add your code here
        //创建学生类，学生用户类
        Student student=new Student();
        SPass spass=new SPass();
        //判断信息是否符合要求
        String Sno=textFieldSno.getText();
        String Sname=textFieldSname.getText();
        String Sagetext=textFieldSage.getText();
        String password=textFieldpassword.getText();
        if(Sno==null || Sno.isEmpty() || Sname==null || Sname.isEmpty()||Sagetext==null || Sagetext.isEmpty() ||password==null || password.isEmpty()){
            JOptionPane.showMessageDialog(AddStuframe.this, "请填写学号、年龄、姓名和密码！");
            return ;
        }
        //获取填写的数据
        student.setSNO(Sno);
        student.setSNAME(Sname);
        if(radioButton1.isSelected()) {
            student.setSSEX("男");
        }
        else if(radioButton2.isSelected()) {
            student.setSSEX("女");
        }
        student.setSAGE(Sagetext);
        if(comboBoxSdept.getSelectedItem().toString()=="---请选择---"){
            student.setSDEPT(null);
        }
        else {
            student.setSDEPT(comboBoxSdept.getSelectedItem().toString());
        }
        //账号密码
        spass.setSNO(textFieldSno.getText());
        spass.setSPASSWORD(password);
        //通过dao把数据给数据库
        StudentDao studentdao=new StudentDao();
        Userdao userdao =new Userdao();
        boolean isaddbase=false;
        isaddbase= studentdao.AddStudent(student);
        boolean isaddpassword=false;
        if (isaddbase){
            isaddpassword= userdao.IDstudent(spass);
            if(isaddpassword){
                JOptionPane.showMessageDialog(AddStuframe.this, "学生基本信息添加成功！\n密码设置成功！");
            }
            else{
                JOptionPane.showMessageDialog(AddStuframe.this, "添加失败请重新操作！");
            }
        }
        else {
            JOptionPane.showMessageDialog(AddStuframe.this, "添加失败请重新操作！");
        }
    }

    private void setagain(ActionEvent e) {
        // TODO add your code here
        textFieldSno.setText(null);
        textFieldSname.setText(null);
        radioButton1.setSelected(false);
        radioButton2.setSelected(false);
        textFieldSage.setText(null);
        comboBoxSdept.setSelectedIndex(0);
        textFieldpassword.setText(null);
    }

    private void exitAddframe(ActionEvent e) {
        // TODO add your code here
        this.frame1.dispose();
    }

    public JFrame getFrame1() {
        return frame1;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("stc.view.test");
        frame1 = new JFrame();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        textFieldSno = new JTextField();
        textFieldSname = new JTextField();
        textFieldpassword = new JTextField();
        comboBoxSdept = new JComboBox<>();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        textFieldSage = new JTextField();

        //======== frame1 ========
        {
            frame1.setIconImage(new ImageIcon(getClass().getResource("/image/school.jpg")).getImage());
            frame1.setTitle(bundle.getString("Addframe.frame1.title"));
            frame1.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
            frame1.setMinimumSize(new Dimension(690, 735));
            frame1.setPreferredSize(new Dimension(690, 735));
            Container frame1ContentPane = frame1.getContentPane();

            //---- label1 ----
            label1.setText(bundle.getString("Addframe.label1.text"));
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 12f));

            //---- label2 ----
            label2.setText(bundle.getString("Addframe.label2.text"));
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 12f));

            //---- label3 ----
            label3.setText(bundle.getString("Addframe.label3.text"));
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 12f));

            //---- label4 ----
            label4.setText(bundle.getString("Addframe.label4.text"));
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 12f));

            //---- label5 ----
            label5.setText(bundle.getString("Addframe.label5.text"));
            label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 12f));

            //---- label6 ----
            label6.setText(bundle.getString("Addframe.label6.text"));
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 12f));

            //---- label7 ----
            label7.setText(bundle.getString("Addframe.label7.text"));
            label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 17f));

            //---- textFieldSno ----
            textFieldSno.setFont(textFieldSno.getFont().deriveFont(textFieldSno.getFont().getSize() + 11f));

            //---- textFieldSname ----
            textFieldSname.setFont(textFieldSname.getFont().deriveFont(textFieldSname.getFont().getSize() + 11f));

            //---- textFieldpassword ----
            textFieldpassword.setFont(textFieldpassword.getFont().deriveFont(textFieldpassword.getFont().getSize() + 11f));

            //---- comboBoxSdept ----
            comboBoxSdept.setFont(comboBoxSdept.getFont().deriveFont(comboBoxSdept.getFont().getSize() + 11f));
            comboBoxSdept.setModel(new DefaultComboBoxModel<>(new String[] {
                "---\u8bf7\u9009\u62e9---",
                "\u683c\u5170\u82ac\u591a",
                "\u65af\u83b1\u7279\u6797",
                "\u62c9\u6587\u514b\u52b3",
                "\u8d6b\u5947\u5e15\u5947"
            }));

            //---- button1 ----
            button1.setText(bundle.getString("Addframe.button1.text"));
            button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 13f));
            button1.addActionListener(e -> Addstudent(e));

            //---- button2 ----
            button2.setText(bundle.getString("Addframe.button2.text"));
            button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 13f));
            button2.addActionListener(e -> setagain(e));

            //---- button3 ----
            button3.setText(bundle.getString("Addframe.button3.text"));
            button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 13f));
            button3.addActionListener(e -> exitAddframe(e));

            //---- radioButton1 ----
            radioButton1.setText(bundle.getString("Addframe.radioButton1.text"));
            radioButton1.setFont(radioButton1.getFont().deriveFont(radioButton1.getFont().getSize() + 11f));

            //---- radioButton2 ----
            radioButton2.setText(bundle.getString("Addframe.radioButton2.text"));
            radioButton2.setFont(radioButton2.getFont().deriveFont(radioButton2.getFont().getSize() + 11f));

            //---- textFieldSage ----
            textFieldSage.setFont(textFieldSage.getFont().deriveFont(textFieldSage.getFont().getSize() + 11f));

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(label7))
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                        .addGap(96, 96, 96)
                                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(label1)
                                            .addComponent(label2)
                                            .addComponent(label3)
                                            .addComponent(label4)
                                            .addComponent(label6)
                                            .addComponent(label5))
                                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addComponent(radioButton1)
                                                .addGap(163, 163, 163)
                                                .addComponent(radioButton2))
                                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addGroup(frame1ContentPaneLayout.createParallelGroup()
                                                    .addComponent(textFieldSage, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(textFieldpassword, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                                                        .addComponent(comboBoxSdept, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                                                        .addComponent(textFieldSname, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                                                        .addComponent(textFieldSno, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)))))))))
                        .addContainerGap(85, Short.MAX_VALUE))
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(label7)
                        .addGap(45, 45, 45)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                            .addComponent(label1)
                            .addComponent(textFieldSno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                            .addComponent(label2)
                            .addComponent(textFieldSname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(radioButton1)
                            .addComponent(radioButton2))
                        .addGap(52, 52, 52)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(textFieldSage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(comboBoxSdept, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label6)
                            .addComponent(textFieldpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button1)
                            .addComponent(button3)
                            .addComponent(button2))
                        .addGap(45, 45, 45))
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JFrame frame1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JTextField textFieldSno;
    private JTextField textFieldSname;
    private JTextField textFieldpassword;
    private JComboBox<String> comboBoxSdept;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JTextField textFieldSage;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) {

        new AddStuframe().frame1.setVisible(true);
    }
}
