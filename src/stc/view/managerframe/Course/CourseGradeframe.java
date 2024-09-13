/*
 * Created by JFormDesigner on Fri Jun 14 13:03:22 CST 2024
 */

package stc.view.managerframe.Course;

import stc.dao.SCDao;
import stc.entity.SC;
import stc.entity.Student;

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
public class CourseGradeframe extends JFrame {
    public CourseGradeframe() {
        initComponents();
    }

    public void fillTable(List<? extends SC> scmess) {
        //TO DO
        DefaultTableModel sctdm = (DefaultTableModel) tableSCgrade.getModel();
        if (scmess.isEmpty()) {
            sctdm.setRowCount(0);//设置为0行
        } else {
            sctdm.setRowCount(0);//设置为0行
            for (SC sctm : scmess) {
                Vector v = new Vector<>();
                v.add(sctm.getSNO());
                v.add(sctm.getSNAME());
                v.add(sctm.getCNO());
                v.add(sctm.getCNAME());
                v.add(sctm.getCREDIT());
                v.add(sctm.getGRADE());
                sctdm.addRow(v);
            }
        }
    }

    private void selectGrade(ActionEvent e) {
        // TODO add your code here
        //创建课程类以接收填入的信息
        SC sc=new SC();
        sc.setCNO(textFieldCno.getText());
        sc.setCNAME(textFieldCname.getText());
        sc.setCREDIT(textFieldCredit.getText());
        sc.setSNO(null);
        sc.setSNAME(null);
        //调用dao实现查询
        SCDao scDao=new SCDao();
        List<? extends SC> scdata= scDao.ManquerySC(sc);
        //将数据放入表格
        if(!scdata.isEmpty()){
            fillTable(scdata);
        }
        else{
            fillTable(scdata);
            JOptionPane.showMessageDialog(CourseGradeframe.this, "查询失败！请检查输入条件！");
        }
    }

    private void setagain(ActionEvent e) {
        // TODO add your code here
        textFieldCno.setText(null);
        textFieldCname.setText(null);
        textFieldCredit.setText(null);
    }

    private SC scselect;

    private void setGrade(ActionEvent e) {
        // TODO add your code here
        SC sc=new SC();
        sc.setSNO(textFieldSno2.getText());
        sc.setCNO(textFieldCno2.getText());
        String Grade=textFieldGrade.getText();
        if(Grade.isEmpty()&&"".equals(Grade)){
            JOptionPane.showMessageDialog(this,"请输入成绩！");
            return ;
        }
        else{
            sc.setGRADE(Grade);
        }
        SCDao scdao=new SCDao();
        boolean isok=scdao.SetStuGrade(sc);
        if(isok){
            JOptionPane.showMessageDialog(this,"成绩录入成功！");
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(this,"成绩录入失败！请检查成绩填写是否正确！");
        }
    }

    private void tableSCgradeMousePressed(MouseEvent e) {
        // TODO add your code here
        //获得行号,每一列的值
        int row=tableSCgrade.getSelectedRow();
        textFieldSno2.setEnabled(false);
        textFieldSname2.setEnabled(false);
        textFieldCno2.setEnabled(false);
        textFieldCname2.setEnabled(false);
        textFieldSno2.setText((String) tableSCgrade.getValueAt(row,0));
        textFieldSname2.setText((String) tableSCgrade.getValueAt(row,1));
        textFieldCno2.setText((String) tableSCgrade.getValueAt(row,2));
        textFieldCname2.setText((String) tableSCgrade.getValueAt(row,3));
        textFieldGrade.setText((String) tableSCgrade.getValueAt(row,5));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("stc.view.test");
        frame2 = new JFrame();
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        tableSCgrade = new JTable();
        button3 = new JButton();
        textFieldCno = new JTextField();
        button5 = new JButton();
        textFieldCname = new JTextField();
        label4 = new JLabel();
        button6 = new JButton();
        label3 = new JLabel();
        label5 = new JLabel();
        textFieldCredit = new JTextField();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        textFieldSno2 = new JTextField();
        textFieldCno2 = new JTextField();
        textFieldSname2 = new JTextField();
        textFieldGrade = new JTextField();
        textFieldCname2 = new JTextField();

        //======== frame2 ========
        {
            frame2.setIconImage(new ImageIcon(getClass().getResource("/image/school.jpg")).getImage());
            frame2.setTitle(bundle.getString("Gradeaddframe.frame2.title"));
            frame2.setFont(new Font(Font.DIALOG, Font.PLAIN, 40));
            frame2.setMinimumSize(new Dimension(980, 880));
            frame2.setPreferredSize(new Dimension(980, 880));
            Container frame2ContentPane = frame2.getContentPane();

            //---- label1 ----
            label1.setText(bundle.getString("Gradeaddframe.label1.text"));
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));

            //---- label2 ----
            label2.setText(bundle.getString("Gradeaddframe.label2.text"));
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 10f));

            //======== scrollPane2 ========
            {

                //---- tableSCgrade ----
                tableSCgrade.setFont(tableSCgrade.getFont().deriveFont(tableSCgrade.getFont().getSize() + 12f));
                tableSCgrade.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "\u5b66\u53f7", "\u59d3\u540d", "\u8bfe\u7a0b\u53f7", "\u8bfe\u7a0b\u540d", "\u8bfe\u7a0b\u5b66\u5206", "\u6210\u7ee9"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        String.class, String.class, String.class, Object.class, String.class, String.class
                    };
                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return columnTypes[columnIndex];
                    }
                });
                {
                    TableColumnModel cm = tableSCgrade.getColumnModel();
                    cm.getColumn(0).setPreferredWidth(50);
                }
                tableSCgrade.setAlignmentX(10.0F);
                tableSCgrade.setAlignmentY(7.0F);
                tableSCgrade.setRowHeight(50);
                tableSCgrade.setRowMargin(0);
                tableSCgrade.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        tableSCgradeMousePressed(e);
                    }
                });
                scrollPane2.setViewportView(tableSCgrade);
            }

            //---- button3 ----
            button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 11f));
            button3.setText(bundle.getString("Gradeaddframe.button3.text"));
            button3.addActionListener(e -> selectGrade(e));

            //---- textFieldCno ----
            textFieldCno.setFont(textFieldCno.getFont().deriveFont(textFieldCno.getFont().getSize() + 10f));

            //---- button5 ----
            button5.setFont(button5.getFont().deriveFont(button5.getFont().getSize() + 11f));
            button5.setText(bundle.getString("Gradeaddframe.button5.text"));
            button5.addActionListener(e -> setagain(e));

            //---- textFieldCname ----
            textFieldCname.setFont(textFieldCname.getFont().deriveFont(textFieldCname.getFont().getSize() + 10f));

            //---- label4 ----
            label4.setText(bundle.getString("Gradeaddframe.label4.text"));
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 10f));

            //---- button6 ----
            button6.setFont(button6.getFont().deriveFont(button6.getFont().getSize() + 11f));
            button6.setText(bundle.getString("Gradeaddframe.button6.text"));
            button6.addActionListener(e -> setGrade(e));

            //---- label3 ----
            label3.setText(bundle.getString("Gradeaddframe.label3.text_2"));
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 10f));

            //---- label5 ----
            label5.setText(bundle.getString("Gradeaddframe.label5.text"));
            label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 10f));

            //---- textFieldCredit ----
            textFieldCredit.setFont(textFieldCredit.getFont().deriveFont(textFieldCredit.getFont().getSize() + 10f));

            //---- label6 ----
            label6.setText(bundle.getString("Gradeaddframe.label6.text"));
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 10f));

            //---- label7 ----
            label7.setText(bundle.getString("Gradeaddframe.label7.text"));
            label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 10f));

            //---- label8 ----
            label8.setText(bundle.getString("Gradeaddframe.label8.text"));
            label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 10f));

            //---- label9 ----
            label9.setText(bundle.getString("Gradeaddframe.label9.text"));
            label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 10f));

            //---- label10 ----
            label10.setText(bundle.getString("Gradeaddframe.label10.text"));
            label10.setFont(label10.getFont().deriveFont(label10.getFont().getSize() + 10f));

            //---- label11 ----
            label11.setText(bundle.getString("Gradeaddframe.label11.text"));
            label11.setFont(label11.getFont().deriveFont(label11.getFont().getSize() + 10f));

            //---- textFieldSno2 ----
            textFieldSno2.setFont(textFieldSno2.getFont().deriveFont(textFieldSno2.getFont().getSize() + 10f));

            //---- textFieldCno2 ----
            textFieldCno2.setFont(textFieldCno2.getFont().deriveFont(textFieldCno2.getFont().getSize() + 10f));

            //---- textFieldSname2 ----
            textFieldSname2.setFont(textFieldSname2.getFont().deriveFont(textFieldSname2.getFont().getSize() + 10f));

            //---- textFieldGrade ----
            textFieldGrade.setFont(textFieldGrade.getFont().deriveFont(textFieldGrade.getFont().getSize() + 10f));

            //---- textFieldCname2 ----
            textFieldCname2.setFont(textFieldCname2.getFont().deriveFont(textFieldCname2.getFont().getSize() + 10f));

            GroupLayout frame2ContentPaneLayout = new GroupLayout(frame2ContentPane);
            frame2ContentPane.setLayout(frame2ContentPaneLayout);
            frame2ContentPaneLayout.setHorizontalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(0, 59, Short.MAX_VALUE)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 781, GroupLayout.PREFERRED_SIZE)
                            .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                    .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                            .addComponent(label6)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label8))
                                        .addComponent(label7))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                            .addComponent(textFieldSno2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label9))
                                        .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                            .addComponent(textFieldCno2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                            .addGap(27, 27, 27)
                                            .addComponent(label10)))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(frame2ContentPaneLayout.createParallelGroup()
                                        .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                            .addComponent(textFieldSname2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                            .addGap(36, 36, 36)
                                            .addComponent(label11)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(textFieldGrade, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                            .addComponent(textFieldCname2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(button6, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))))
                                .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                    .addGroup(frame2ContentPaneLayout.createParallelGroup()
                                        .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                            .addComponent(label1)
                                            .addGap(34, 34, 34)
                                            .addComponent(label2))
                                        .addComponent(label3))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(frame2ContentPaneLayout.createParallelGroup()
                                        .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                            .addComponent(textFieldCno, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                            .addGap(12, 12, 12)
                                            .addComponent(label4))
                                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(frame2ContentPaneLayout.createParallelGroup()
                                        .addComponent(button5, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                            .addComponent(textFieldCname, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                            .addGap(12, 12, 12)
                                            .addComponent(label5)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(textFieldCredit, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(73, Short.MAX_VALUE))
            );
            frame2ContentPaneLayout.setVerticalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1)
                            .addComponent(label2)
                            .addComponent(textFieldCname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldCno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4)
                            .addComponent(textFieldCredit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5))
                        .addGap(29, 29, 29)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(button3)
                            .addComponent(button5))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label6)
                            .addComponent(label8)
                            .addComponent(textFieldSno2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label11)
                            .addComponent(textFieldSname2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label9)
                            .addComponent(textFieldGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label7)
                            .addComponent(textFieldCno2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldCname2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label10)
                            .addComponent(button6))
                        .addGap(60, 60, 60))
            );
            frame2.pack();
            frame2.setLocationRelativeTo(frame2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    public JFrame getFrame2() {
        return frame2;
    }// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JFrame frame2;
    private JLabel label1;
    private JLabel label2;
    private JScrollPane scrollPane2;
    private JTable tableSCgrade;
    private JButton button3;
    private JTextField textFieldCno;
    private JButton button5;
    private JTextField textFieldCname;
    private JLabel label4;
    private JButton button6;
    private JLabel label3;
    private JLabel label5;
    private JTextField textFieldCredit;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JTextField textFieldSno2;
    private JTextField textFieldCno2;
    private JTextField textFieldSname2;
    private JTextField textFieldGrade;
    private JTextField textFieldCname2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args) {

        new CourseGradeframe().frame2.setVisible(true);
    }
}
