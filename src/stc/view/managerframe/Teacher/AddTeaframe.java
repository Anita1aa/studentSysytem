/*
 * Created by JFormDesigner on Fri Jun 14 21:23:34 CST 2024
 */

package stc.view.managerframe.Teacher;

import stc.dao.TeacherDao;
import stc.entity.Teacher;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author jane
 */
public class AddTeaframe extends JFrame {
    public AddTeaframe() {
        initComponents();
    }

    private void AddTea(ActionEvent e) {
        // TODO add your code here
        //创建教师类
        Teacher teacher=new Teacher();
        //判断信息是否符合要求
        String Tno=textFieldTno.getText();
        String Tname=textFieldTname.getText();
        String Tsalary=textFieldTsalary.getText();
        if(Tno==null || Tno.isEmpty() || Tname==null || Tname.isEmpty() || Tsalary==null || Tsalary.isEmpty()){
            JOptionPane.showMessageDialog(AddTeaframe.this, "请正确填写工号、姓名或工资！");
            return ;
        }
        //获取填写的数据
        teacher.setTNO(Tno);
        teacher.setTNAME(Tname);
        if(comboBoxTetitle.getSelectedItem().toString()=="---请选择---"){
            teacher.setTETITLE(null);
        }
        else {
            teacher.setTETITLE(comboBoxTetitle.getSelectedItem().toString());
        }
        teacher.setTSALARY(Tsalary);
        //通过dao把数据给数据库
        TeacherDao teacherdao=new TeacherDao();
        boolean isaddbase=teacherdao.AddTeacher(teacher);
        if (isaddbase) {
            JOptionPane.showMessageDialog(AddTeaframe.this, "教师基本信息添加成功！");
        }else{
            JOptionPane.showMessageDialog(AddTeaframe.this, "添加失败请重新操作！");
        }
    }

    private void setagain(ActionEvent e) {
        // TODO add your code here
        textFieldTno.setText(null);
        textFieldTname.setText(null);
        comboBoxTetitle.setSelectedIndex(0);
        textFieldTsalary.setText(null);
    }

    private void exitAddTea(ActionEvent e) {
        // TODO add your code here
        this.frame1.dispose();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("stc.view.test");
        frame1 = new JFrame();
        label1 = new JLabel();
        label2 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        textFieldTno = new JTextField();
        textFieldTname = new JTextField();
        textFieldTsalary = new JTextField();
        comboBoxTetitle = new JComboBox<>();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== frame1 ========
        {
            frame1.setIconImage(new ImageIcon(getClass().getResource("/image/school.jpg")).getImage());
            frame1.setTitle(bundle.getString("AddTeaframe.frame1.title"));
            frame1.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
            frame1.setMinimumSize(new Dimension(690, 620));
            frame1.setPreferredSize(new Dimension(690, 620));
            Container frame1ContentPane = frame1.getContentPane();

            //---- label1 ----
            label1.setText(bundle.getString("AddTeaframe.label1.text"));
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 12f));

            //---- label2 ----
            label2.setText(bundle.getString("AddTeaframe.label2.text"));
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 12f));

            //---- label5 ----
            label5.setText(bundle.getString("AddTeaframe.label5.text"));
            label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 12f));

            //---- label6 ----
            label6.setText(bundle.getString("AddTeaframe.label6.text"));
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 12f));

            //---- label7 ----
            label7.setText(bundle.getString("AddTeaframe.label7.text"));
            label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 17f));

            //---- textFieldTno ----
            textFieldTno.setFont(textFieldTno.getFont().deriveFont(textFieldTno.getFont().getSize() + 11f));

            //---- textFieldTname ----
            textFieldTname.setFont(textFieldTname.getFont().deriveFont(textFieldTname.getFont().getSize() + 11f));

            //---- textFieldTsalary ----
            textFieldTsalary.setFont(textFieldTsalary.getFont().deriveFont(textFieldTsalary.getFont().getSize() + 11f));

            //---- comboBoxTetitle ----
            comboBoxTetitle.setFont(comboBoxTetitle.getFont().deriveFont(comboBoxTetitle.getFont().getSize() + 11f));
            comboBoxTetitle.setModel(new DefaultComboBoxModel<>(new String[] {
                "---\u8bf7\u9009\u62e9---",
                "\u6559\u6388",
                "\u526f\u6559\u6388",
                "\u8bb2\u5e08",
                "\u52a9\u6559"
            }));

            //---- button1 ----
            button1.setText(bundle.getString("AddTeaframe.button1.text"));
            button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 13f));
            button1.addActionListener(e -> AddTea(e));

            //---- button2 ----
            button2.setText(bundle.getString("AddTeaframe.button2.text"));
            button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 13f));
            button2.addActionListener(e -> setagain(e));

            //---- button3 ----
            button3.setText(bundle.getString("AddTeaframe.button3.text"));
            button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 13f));
            button3.addActionListener(e -> exitAddTea(e));

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
                                .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                        .addGap(97, 97, 97)
                                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(label1)
                                            .addComponent(label2)
                                            .addComponent(label5)
                                            .addComponent(label6))
                                        .addGap(40, 40, 40)
                                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(textFieldTname, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                                            .addComponent(textFieldTno, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                                            .addComponent(comboBoxTetitle, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                                            .addComponent(textFieldTsalary, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))))))
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
                            .addComponent(textFieldTno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                            .addComponent(label2)
                            .addComponent(textFieldTname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(comboBoxTetitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label6)
                            .addComponent(textFieldTsalary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(142, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, frame1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(450, Short.MAX_VALUE)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button2)
                            .addComponent(button1)
                            .addComponent(button3))
                        .addGap(60, 60, 60))
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
    private JLabel label1;
    private JLabel label2;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JTextField textFieldTno;
    private JTextField textFieldTname;
    private JTextField textFieldTsalary;
    private JComboBox<String> comboBoxTetitle;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args) {

        new AddTeaframe().frame1.setVisible(true);
    }
}
