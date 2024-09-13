/*
 * Created by JFormDesigner on Fri Jun 14 12:48:37 CST 2024
 */

package stc.view.managerframe.Course;

import stc.dao.CourseDao;
import stc.entity.Course;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author jane
 */
public class CourseMessframe extends JFrame {
    public CourseMessframe() {
        initComponents();
    }

    private void AddCourse(ActionEvent e) {
        // TODO add your code here
        new AddCourseframe().getFrame1().setVisible(true);
    }

    public void fillTable(List<? extends Course> coumess) {
        //TO DO
        DefaultTableModel ctdm = (DefaultTableModel) tableCouMess.getModel();
        if (coumess.isEmpty()) {
            ctdm.setRowCount(0);//设置为0行
        } else {
            ctdm.setRowCount(0);//设置为0行
            for (Course ctum : coumess) {
                Vector v = new Vector<>();
                v.add(ctdm.getRowCount() + 1);//序号
                v.add(ctum.getCNO());
                v.add(ctum.getCNAME());
                v.add(ctum.getCREDIT());
                ctdm.addRow(v);
            }
        }
    }

    private void selectCourse(ActionEvent e) {
        // TODO add your code here
        // TODO add your code here
        //创建课程类以接收填入的信息
        Course course=new Course();
        course.setCNO(textFieldCno.getText());
        course.setCNAME(textFieldCname.getText());
        course.setTNO(null);
        //调用dao实现查询
        CourseDao courseDao=new CourseDao();
        List<? extends Course> coudata=courseDao.queryCouMess(course);
        //将数据放入表格
        if(!coudata.isEmpty()){
            fillTable(coudata);
        }
        else{
            fillTable(coudata);
            JOptionPane.showMessageDialog(CourseMessframe.this, "查询失败！请检查输入条件！");
        }
    }

    private void tableCouMessMousePressed(MouseEvent e) {
        // TODO add your code here
        int row=tableCouMess.getSelectedRow();
        textFieldCno2.setEnabled(false);
        textFieldCno2.setText((String) tableCouMess.getValueAt(row,1));
        textFieldCname2.setText((String) tableCouMess.getValueAt(row,2));
        textFieldCredit2.setText((String) tableCouMess.getValueAt(row,3));
    }

    private void updateCourse(ActionEvent e) {
        // TODO add your code here
        //创建课程类接收信息
        Course course=new Course();
        course.setCNO(textFieldCno2.getText());
        course.setCNAME(textFieldCname2.getText());
        course.setCREDIT(textFieldCredit2.getText());
        //创建DAO类完成数据库操作
        CourseDao courseDao=new CourseDao();
        boolean isok1=false;
        boolean isok2=false;
        if(course.getCNAME().isEmpty()&&course.getCREDIT().isEmpty()){
            JOptionPane.showMessageDialog(this,"信息并没有发生变化！无需修改！");
        }else{
            if(!course.getCNAME().isEmpty()){
                isok1=courseDao.UpdateCourseCname(course);
            }
            if(!course.getCREDIT().isEmpty()){
                isok2=courseDao.UpdateCourseCredit(course);
            }
        }
        if(isok1 || isok2)
        {
            JOptionPane.showMessageDialog(this,"课程名和学分修改成功！");
        } else{
            JOptionPane.showMessageDialog(this,"修改失败！请检查输入信息！");
        }
    }

    private void deleteCourse(ActionEvent e) {
        // TODO add your code here
        //创建课程类接收信息
        Course course=new Course();
        course.setCNO(textFieldCno2.getText());
        //创建DAO类完成数据库操作
        CourseDao courseDao=new CourseDao();
        boolean isok=courseDao.DeleteCourse(course);
        if(isok) {
            JOptionPane.showMessageDialog(this,"课程信息删除成功！");
        } else{
            JOptionPane.showMessageDialog(this,"课程信息删除失败！");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("stc.view.test");
        frame2 = new JFrame();
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        tableCouMess = new JTable();
        button2 = new JButton();
        button3 = new JButton();
        textFieldCno = new JTextField();
        button4 = new JButton();
        button5 = new JButton();
        textFieldCname = new JTextField();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label11 = new JLabel();
        textFieldCno2 = new JTextField();
        textFieldCname2 = new JTextField();
        label13 = new JLabel();
        label4 = new JLabel();
        textFieldCredit2 = new JTextField();

        //======== frame2 ========
        {
            frame2.setIconImage(new ImageIcon(getClass().getResource("/image/school.jpg")).getImage());
            frame2.setTitle(bundle.getString("CourseMessframe.frame2.title"));
            frame2.setFont(new Font(Font.DIALOG, Font.PLAIN, 40));
            frame2.setMinimumSize(new Dimension(980, 820));
            frame2.setPreferredSize(new Dimension(980, 820));
            Container frame2ContentPane = frame2.getContentPane();

            //---- label1 ----
            label1.setText(bundle.getString("CourseMessframe.label1.text"));
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));

            //---- label2 ----
            label2.setText(bundle.getString("CourseMessframe.label2.text"));
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 10f));

            //======== scrollPane2 ========
            {

                //---- tableCouMess ----
                tableCouMess.setFont(tableCouMess.getFont().deriveFont(tableCouMess.getFont().getSize() + 12f));
                tableCouMess.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "\u5e8f\u53f7", "\u8bfe\u7a0b\u53f7", "\u8bfe\u7a0b\u540d", "\u8bfe\u7a0b\u5b66\u5206"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        String.class, String.class, String.class, String.class
                    };
                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return columnTypes[columnIndex];
                    }
                });
                {
                    TableColumnModel cm = tableCouMess.getColumnModel();
                    cm.getColumn(1).setPreferredWidth(50);
                }
                tableCouMess.setAlignmentX(10.0F);
                tableCouMess.setAlignmentY(7.0F);
                tableCouMess.setRowHeight(50);
                tableCouMess.setRowMargin(0);
                tableCouMess.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        tableCouMessMousePressed(e);
                    }
                });
                scrollPane2.setViewportView(tableCouMess);
            }

            //---- button2 ----
            button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 11f));
            button2.setText(bundle.getString("CourseMessframe.button2.text"));
            button2.addActionListener(e -> deleteCourse(e));

            //---- button3 ----
            button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 11f));
            button3.setText(bundle.getString("CourseMessframe.button3.text"));
            button3.addActionListener(e -> selectCourse(e));

            //---- textFieldCno ----
            textFieldCno.setFont(textFieldCno.getFont().deriveFont(textFieldCno.getFont().getSize() + 10f));

            //---- button4 ----
            button4.setFont(button4.getFont().deriveFont(button4.getFont().getSize() + 11f));
            button4.setText(bundle.getString("CourseMessframe.button4.text"));
            button4.addActionListener(e -> AddCourse(e));

            //---- button5 ----
            button5.setFont(button5.getFont().deriveFont(button5.getFont().getSize() + 11f));
            button5.setText(bundle.getString("CourseMessframe.button5.text"));
            button5.addActionListener(e -> updateCourse(e));

            //---- textFieldCname ----
            textFieldCname.setFont(textFieldCname.getFont().deriveFont(textFieldCname.getFont().getSize() + 10f));

            //---- label6 ----
            label6.setText(bundle.getString("CourseMessframe.label6.text"));
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 10f));

            //---- label7 ----
            label7.setText(bundle.getString("CourseMessframe.label7.text"));
            label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 10f));

            //---- label8 ----
            label8.setText(bundle.getString("CourseMessframe.label8.text"));
            label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 10f));

            //---- label11 ----
            label11.setText(bundle.getString("CourseMessframe.label11.text"));
            label11.setFont(label11.getFont().deriveFont(label11.getFont().getSize() + 10f));

            //---- textFieldCno2 ----
            textFieldCno2.setFont(textFieldCno2.getFont().deriveFont(textFieldCno2.getFont().getSize() + 10f));

            //---- textFieldCname2 ----
            textFieldCname2.setFont(textFieldCname2.getFont().deriveFont(textFieldCname2.getFont().getSize() + 10f));

            //---- label13 ----
            label13.setText(bundle.getString("CourseMessframe.label13.text"));
            label13.setFont(label13.getFont().deriveFont(label13.getFont().getSize() + 10f));

            //---- label4 ----
            label4.setText(bundle.getString("CourseMessframe.label4.text"));
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 10f));

            //---- textFieldCredit2 ----
            textFieldCredit2.setFont(textFieldCredit2.getFont().deriveFont(textFieldCredit2.getFont().getSize() + 10f));

            GroupLayout frame2ContentPaneLayout = new GroupLayout(frame2ContentPane);
            frame2ContentPane.setLayout(frame2ContentPaneLayout);
            frame2ContentPaneLayout.setHorizontalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                .addComponent(label6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label1)
                                .addGap(18, 18, 18)
                                .addComponent(textFieldCno, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(label2)
                                .addGap(18, 18, 18)
                                .addComponent(textFieldCname, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                            .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                .addGroup(frame2ContentPaneLayout.createParallelGroup()
                                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                        .addComponent(label7)
                                        .addGap(23, 23, 23)
                                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                                .addComponent(label8)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textFieldCno2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(button5, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(label13))
                                .addGap(21, 21, 21)
                                .addComponent(label11)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(frame2ContentPaneLayout.createParallelGroup()
                                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                        .addComponent(textFieldCname2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(label4)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textFieldCredit2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(button4, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))))
                            .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE))
                        .addContainerGap(37, Short.MAX_VALUE))
            );
            frame2ContentPaneLayout.setVerticalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button3)
                            .addComponent(textFieldCname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2)
                            .addComponent(label6)
                            .addComponent(label1)
                            .addComponent(textFieldCno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldCno2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label8)
                            .addComponent(label7)
                            .addComponent(label11)
                            .addComponent(textFieldCname2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4)
                            .addComponent(textFieldCredit2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label13)
                            .addComponent(button5)
                            .addComponent(button2)
                            .addComponent(button4))
                        .addContainerGap(60, Short.MAX_VALUE))
            );
            frame2.pack();
            frame2.setLocationRelativeTo(frame2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    public JFrame getFrame2() {
        return frame2;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JFrame frame2;
    private JLabel label1;
    private JLabel label2;
    private JScrollPane scrollPane2;
    private JTable tableCouMess;
    private JButton button2;
    private JButton button3;
    private JTextField textFieldCno;
    private JButton button4;
    private JButton button5;
    private JTextField textFieldCname;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label11;
    private JTextField textFieldCno2;
    private JTextField textFieldCname2;
    private JLabel label13;
    private JLabel label4;
    private JTextField textFieldCredit2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) {

        new CourseMessframe().frame2.setVisible(true);
    }
}
