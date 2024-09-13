/*
 * Created by JFormDesigner on Fri Jun 14 22:00:09 CST 2024
 */

package stc.view.managerframe.Course;

import stc.dao.CourseDao;
import stc.entity.Course;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author jane
 */
public class AddCourseframe extends JFrame {
    public AddCourseframe() {
        initComponents();
    }

    private void AddCourse(ActionEvent e) {
        // TODO add your code here
        //创建教师类
        Course course=new Course();
        //判断信息是否符合要求
        String Cno=textFieldCno.getText();
        String Cname =textFieldCname.getText();
        String Credit=textFieldCredit.getText();
        String Tno=textFieldTea.getText();
        if(Cno==null || Cno.isEmpty() || Cname ==null || Cname.isEmpty() || Credit ==null || Credit.isEmpty()||Tno ==null || Tno.isEmpty()){
            JOptionPane.showMessageDialog(AddCourseframe.this, "请完整填写信息！");
            return ;
        }
        //获取填写的数据
        course.setCNO(Cno);
        course.setCNAME(Cname);
        course.setCREDIT(Credit);
        course.setTNO(textFieldTea.getText());
        //通过dao把数据给数据库
        CourseDao courseDao=new CourseDao();
        boolean isaddbase=courseDao.AddCourse(course);
        if (isaddbase) {
            JOptionPane.showMessageDialog(AddCourseframe.this, "课程基本信息添加成功！");
        }else{
            JOptionPane.showMessageDialog(AddCourseframe.this, "添加失败请重新操作！");
        }
    }

    private void setagain(ActionEvent e) {
        // TODO add your code here
        textFieldCno.setText(null);
        textFieldCname.setText(null);
        textFieldCredit.setText(null);
        textFieldTea.setText(null);
    }

    private void exitAddframe(ActionEvent e) {
        // TODO add your code here
        this.frame1.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("stc.view.test");
        frame1 = new JFrame();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label7 = new JLabel();
        textFieldCno = new JTextField();
        textFieldCname = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        textFieldCredit = new JTextField();
        label4 = new JLabel();
        textFieldTea = new JTextField();

        //======== frame1 ========
        {
            frame1.setIconImage(new ImageIcon(getClass().getResource("/image/school.jpg")).getImage());
            frame1.setTitle(bundle.getString("AddCourse.frame1.title"));
            frame1.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
            frame1.setMinimumSize(new Dimension(690, 600));
            frame1.setPreferredSize(new Dimension(690, 600));
            Container frame1ContentPane = frame1.getContentPane();

            //---- label1 ----
            label1.setText(bundle.getString("AddCourse.label1.text"));
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 12f));

            //---- label2 ----
            label2.setText(bundle.getString("AddCourse.label2.text"));
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 12f));

            //---- label3 ----
            label3.setText(bundle.getString("AddCourse.label3.text"));
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 12f));

            //---- label7 ----
            label7.setText(bundle.getString("AddCourse.label7.text"));
            label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 17f));

            //---- textFieldCno ----
            textFieldCno.setFont(textFieldCno.getFont().deriveFont(textFieldCno.getFont().getSize() + 11f));

            //---- textFieldCname ----
            textFieldCname.setFont(textFieldCname.getFont().deriveFont(textFieldCname.getFont().getSize() + 11f));

            //---- button1 ----
            button1.setText(bundle.getString("AddCourse.button1.text"));
            button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 13f));
            button1.addActionListener(e -> AddCourse(e));

            //---- button2 ----
            button2.setText(bundle.getString("AddCourse.button2.text"));
            button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 13f));
            button2.addActionListener(e -> setagain(e));

            //---- button3 ----
            button3.setText(bundle.getString("AddCourse.button3.text"));
            button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 13f));
            button3.addActionListener(e -> exitAddframe(e));

            //---- textFieldCredit ----
            textFieldCredit.setFont(textFieldCredit.getFont().deriveFont(textFieldCredit.getFont().getSize() + 11f));

            //---- label4 ----
            label4.setText(bundle.getString("AddCourse.label4.text"));
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 12f));

            //---- textFieldTea ----
            textFieldTea.setFont(textFieldTea.getFont().deriveFont(textFieldTea.getFont().getSize() + 11f));

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(label7))
                            .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                    .addGap(78, 78, 78)
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                    .addGap(88, 88, 88)
                                    .addComponent(button3, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.LEADING, frame1ContentPaneLayout.createSequentialGroup()
                                    .addGroup(frame1ContentPaneLayout.createParallelGroup()
                                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                                            .addGroup(GroupLayout.Alignment.TRAILING, frame1ContentPaneLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(frame1ContentPaneLayout.createParallelGroup()
                                                    .addComponent(label1)
                                                    .addComponent(label2))
                                                .addGap(24, 24, 24))
                                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addComponent(label3)
                                                .addGap(14, 14, 14)))
                                        .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                            .addGap(31, 31, 31)
                                            .addComponent(label4)))
                                    .addGap(23, 23, 23)
                                    .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(textFieldCname, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                            .addComponent(textFieldCno, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                            .addComponent(textFieldCredit, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                                        .addComponent(textFieldTea, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(90, Short.MAX_VALUE))
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(label7)
                        .addGap(45, 45, 45)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1)
                            .addComponent(textFieldCno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(textFieldCname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(textFieldCredit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldTea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button1)
                            .addComponent(button3)
                            .addComponent(button2))
                        .addGap(55, 55, 55))
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
    private JLabel label3;
    private JLabel label7;
    private JTextField textFieldCno;
    private JTextField textFieldCname;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTextField textFieldCredit;
    private JLabel label4;
    private JTextField textFieldTea;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) {

        new AddCourseframe().frame1.setVisible(true);
    }
}
