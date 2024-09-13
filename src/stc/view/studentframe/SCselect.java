/*
 * Created by JFormDesigner on Fri Jun 14 16:42:46 CST 2024
 */

package stc.view.studentframe;

import stc.dao.CourseDao;
import stc.dao.SCDao;
import stc.entity.Course;
import stc.entity.SC;
import stc.entity.STC;
import stc.util.IDandPassword;
import stc.view.managerframe.Course.CourseMessframe;

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
public class SCselect extends JFrame {
    public SCselect() {
        initComponents();
    }

    public void fillTable(List<? extends STC> coumess,String Sno) {
        //TO DO
        DefaultTableModel ctdm = (DefaultTableModel) tableselectCou.getModel();
        if (coumess.isEmpty()) {
            ctdm.setRowCount(0);//设置为0行
        } else {
            ctdm.setRowCount(0);//设置为0行
            for (STC ctum : coumess) {
                Vector v = new Vector<>();
                v.add(ctdm.getRowCount() + 1);//序号
                v.add(ctum.getCNO());
                v.add(ctum.getCNAME());
                v.add(ctum.getCREDIT());
                v.add(ctum.getTNAME());
                String statselect="";
                String stat=ctum.getSNO();
                if(stat==null){
                    statselect="未选修";
                }else if(stat.isEmpty()){
                    statselect="未选修";
                }else{
                    statselect="选修";
                }
                v.add(statselect);
                ctdm.addRow(v);
            }
        }
    }

    private void selectCourse(ActionEvent e) {
        // TODO add your code here
        //创建课程类以接收填入的信息
        IDandPassword iDandPassword=new IDandPassword();
        String Sno=iDandPassword.getSID().getSNO();
        STC stc=new STC();
        stc.setCNO(textFieldCno.getText());
        stc.setCNAME(textFieldCname.getText());
        stc.setCREDIT(textFieldCredit.getText());
        stc.setTNAME(null);
        stc.setSNO(Sno);

        //调用dao实现查询
        CourseDao courseDao=new CourseDao();
        List<? extends STC> coudata=courseDao.StuSelectC(stc);
        //将数据放入表格
        if(!coudata.isEmpty()){
            fillTable(coudata,Sno);
        }
        else{
            fillTable(coudata,Sno);
            JOptionPane.showMessageDialog(this, "查询失败！请检查输入条件！");
        }
    }

    private void takeCourse(ActionEvent e) {
        // TODO add your code here
        SC sc=new SC();
        IDandPassword iDandPassword=new IDandPassword();
        sc.setSNO(iDandPassword.getSID().getSNO());
        sc.setCNO(textFieldCno2.getText());
        SCDao scDao=new SCDao();
        boolean isok=scDao.SselectCourse(sc);
        if(isok){
            JOptionPane.showMessageDialog(this,"选课成功！");
        }else{
            JOptionPane.showMessageDialog(this,"选课失败！");
        }
    }

    private void deselectCourse(ActionEvent e) {
        // TODO add your code here
        SC sc=new SC();
        IDandPassword iDandPassword=new IDandPassword();
        sc.setSNO(iDandPassword.getSID().getSNO());
        sc.setCNO(textFieldCno2.getText());
        SCDao scDao=new SCDao();
        boolean isok=scDao.SdeselectCourse(sc);
        if(isok){
            JOptionPane.showMessageDialog(this,"退课成功！");
        }else{
            JOptionPane.showMessageDialog(this,"退课失败！");
        }
    }

    private void tableselectCouMousePressed(MouseEvent e) {
        // TODO add your code here
        int row=tableselectCou.getSelectedRow();
        textFieldCno2.setEnabled(false);
        textFieldCname2.setEnabled(false);
        textFieldCredit2.setEnabled(false);
        textFieldTFCou.setEnabled(false);
        textFieldCno2.setText((String) tableselectCou.getValueAt(row,1));
        textFieldCname2.setText((String) tableselectCou.getValueAt(row,2));
        textFieldCredit2.setText((String) tableselectCou.getValueAt(row,3));
        textFieldTFCou.setText((String) tableselectCou.getValueAt(row,5));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("stc.view.test");
        frame2 = new JFrame();
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        tableselectCou = new JTable();
        textFieldCno = new JTextField();
        textFieldCname = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        textFieldCredit = new JTextField();
        label3 = new JLabel();
        label6 = new JLabel();
        textFieldCno2 = new JTextField();
        textFieldCname2 = new JTextField();
        label7 = new JLabel();
        label8 = new JLabel();
        textFieldCredit2 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label9 = new JLabel();
        label10 = new JLabel();
        textFieldTFCou = new JTextField();

        //======== frame2 ========
        {
            frame2.setIconImage(new ImageIcon(getClass().getResource("/image/school.jpg")).getImage());
            frame2.setTitle(bundle.getString("SCselect.frame2.title"));
            frame2.setFont(new Font(Font.DIALOG, Font.PLAIN, 40));
            frame2.setMinimumSize(new Dimension(1030, 900));
            frame2.setPreferredSize(new Dimension(1030, 900));
            Container frame2ContentPane = frame2.getContentPane();

            //---- label1 ----
            label1.setText(bundle.getString("SCselect.label1.text"));
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));

            //---- label2 ----
            label2.setText(bundle.getString("SCselect.label2.text"));
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 10f));

            //======== scrollPane2 ========
            {

                //---- tableselectCou ----
                tableselectCou.setFont(tableselectCou.getFont().deriveFont(tableselectCou.getFont().getSize() + 12f));
                tableselectCou.setModel(new DefaultTableModel(
                    new Object[][] {
                        {null, null, null, null, null, null},
                    },
                    new String[] {
                        "\u5e8f\u53f7", "\u8bfe\u7a0b\u53f7", "\u8bfe\u7a0b\u540d", "\u8bfe\u7a0b\u5b66\u5206", "\u4efb\u8bfe\u8001\u5e08", "\u9009\u8bfe\u72b6\u6001"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        String.class, String.class, String.class, String.class, String.class, String.class
                    };
                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return columnTypes[columnIndex];
                    }
                });
                {
                    TableColumnModel cm = tableselectCou.getColumnModel();
                    cm.getColumn(1).setPreferredWidth(50);
                }
                tableselectCou.setAlignmentX(10.0F);
                tableselectCou.setAlignmentY(7.0F);
                tableselectCou.setRowHeight(50);
                tableselectCou.setRowMargin(0);
                tableselectCou.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        tableselectCouMousePressed(e);
                    }
                });
                scrollPane2.setViewportView(tableselectCou);
            }

            //---- textFieldCno ----
            textFieldCno.setFont(textFieldCno.getFont().deriveFont(textFieldCno.getFont().getSize() + 10f));

            //---- textFieldCname ----
            textFieldCname.setFont(textFieldCname.getFont().deriveFont(textFieldCname.getFont().getSize() + 10f));

            //---- label4 ----
            label4.setText(bundle.getString("SCselect.label4.text"));
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 10f));

            //---- label5 ----
            label5.setText(bundle.getString("SCselect.label5.text"));
            label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 10f));

            //---- textFieldCredit ----
            textFieldCredit.setFont(textFieldCredit.getFont().deriveFont(textFieldCredit.getFont().getSize() + 10f));

            //---- label3 ----
            label3.setText(bundle.getString("SCselect.label3.text"));
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 10f));

            //---- label6 ----
            label6.setText(bundle.getString("SCselect.label6.text"));
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 10f));

            //---- textFieldCno2 ----
            textFieldCno2.setFont(textFieldCno2.getFont().deriveFont(textFieldCno2.getFont().getSize() + 10f));

            //---- textFieldCname2 ----
            textFieldCname2.setFont(textFieldCname2.getFont().deriveFont(textFieldCname2.getFont().getSize() + 10f));

            //---- label7 ----
            label7.setText(bundle.getString("SCselect.label7.text"));
            label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 10f));

            //---- label8 ----
            label8.setText(bundle.getString("SCselect.label8.text"));
            label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 10f));

            //---- textFieldCredit2 ----
            textFieldCredit2.setFont(textFieldCredit2.getFont().deriveFont(textFieldCredit2.getFont().getSize() + 10f));

            //---- button1 ----
            button1.setText(bundle.getString("SCselect.button1.text"));
            button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 10f));
            button1.addActionListener(e -> takeCourse(e));

            //---- button2 ----
            button2.setText(bundle.getString("SCselect.button2.text"));
            button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 10f));
            button2.addActionListener(e -> deselectCourse(e));

            //---- button3 ----
            button3.setText(bundle.getString("SCselect.button3.text"));
            button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 10f));
            button3.addActionListener(e -> selectCourse(e));

            //---- label9 ----
            label9.setText(bundle.getString("SCselect.label9.text"));
            label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 10f));

            //---- label10 ----
            label10.setText(bundle.getString("SCselect.label10.text"));
            label10.setFont(label10.getFont().deriveFont(label10.getFont().getSize() + 10f));

            //---- textFieldTFCou ----
            textFieldTFCou.setFont(textFieldTFCou.getFont().deriveFont(textFieldTFCou.getFont().getSize() + 10f));

            GroupLayout frame2ContentPaneLayout = new GroupLayout(frame2ContentPane);
            frame2ContentPane.setLayout(frame2ContentPaneLayout);
            frame2ContentPaneLayout.setHorizontalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(label9)
                                .addGap(208, 208, 208))
                            .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(label6)
                                    .addComponent(label7))
                                .addGap(18, 18, 18)
                                .addGroup(frame2ContentPaneLayout.createParallelGroup()
                                    .addComponent(textFieldCno2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldCname2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(frame2ContentPaneLayout.createParallelGroup()
                                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                        .addComponent(label8)
                                        .addGap(18, 18, 18)
                                        .addComponent(textFieldCredit2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                        .addComponent(label10)
                                        .addGap(18, 18, 18)
                                        .addComponent(textFieldTFCou, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(GroupLayout.Alignment.TRAILING, frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(0, 50, Short.MAX_VALUE)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup()
                            .addComponent(label3)
                            .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(scrollPane2)
                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textFieldCno, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label4)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textFieldCname, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label5)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textFieldCredit, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addGap(59, 59, 59)
                                    .addComponent(button3, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))))
                        .addGap(74, 74, 74))
            );
            frame2ContentPaneLayout.setVerticalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldCno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4)
                            .addComponent(textFieldCname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5)
                            .addComponent(textFieldCredit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button3)
                            .addComponent(label1))
                        .addGap(50, 50, 50)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(label9)
                            .addComponent(label3))
                        .addGap(18, 18, 18)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label8)
                                    .addComponent(textFieldCredit2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label10)
                                    .addComponent(textFieldTFCou, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label6)
                                    .addComponent(textFieldCno2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label7)
                                    .addComponent(textFieldCname2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(GroupLayout.Alignment.LEADING, frame2ContentPaneLayout.createSequentialGroup()
                                .addComponent(button2)
                                .addGap(29, 29, 29)
                                .addComponent(button1)))
                        .addGap(89, 89, 89))
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
    private JTable tableselectCou;
    private JTextField textFieldCno;
    private JTextField textFieldCname;
    private JLabel label4;
    private JLabel label5;
    private JTextField textFieldCredit;
    private JLabel label3;
    private JLabel label6;
    private JTextField textFieldCno2;
    private JTextField textFieldCname2;
    private JLabel label7;
    private JLabel label8;
    private JTextField textFieldCredit2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label9;
    private JLabel label10;
    private JTextField textFieldTFCou;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args) {

        new SCselect().frame2.setVisible(true);
    }
}
