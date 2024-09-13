/*
 * Created by JFormDesigner on Fri Jun 14 15:21:27 CST 2024
 */

package stc.view.managerframe.Stat;

import stc.dao.SCDao;
import stc.dao.StatDao;
import stc.entity.CG;
import stc.entity.SC;
import stc.view.managerframe.Course.CourseGradeframe;

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
public class StatCourse extends JFrame {
    public StatCourse() {
        initComponents();
    }

    public void fillTable(List<? extends CG> cgmess) {
        //TO DO
        DefaultTableModel cgtdm = (DefaultTableModel) tableCGstat.getModel();
        if (cgmess.isEmpty()) {
            cgtdm.setRowCount(0);//设置为0行
        } else {
            cgtdm.setRowCount(0);//设置为0行
            for (CG cgtm : cgmess) {
                Vector v = new Vector<>();
                v.add(cgtdm.getRowCount()+1);
                v.add(cgtm.getCNO());
                v.add(cgtm.getCNAME());
                v.add(cgtm.getAVGGRADE());
                v.add(cgtm.getMINGRADE());
                v.add(cgtm.getMAXGRADE());
                cgtdm.addRow(v);
            }
        }
    }

    private void StatSelect(ActionEvent e) {
        // TODO add your code here
        //创建课程成绩以接收填入的信息
        CG cg =new CG();
        cg.setCNO(textFieldCno.getText());
        cg.setCNAME(textFieldCname.getText());
        cg.setAVGGRADE(null);
        cg.setMINGRADE(null);
        cg.setMAXGRADE(null);
        //调用dao实现查询
        StatDao statDao=new StatDao();
        List<? extends CG> cgdata= statDao.ManStatCG(cg);
        //将数据放入表格
        if(!cgdata.isEmpty()){
            fillTable(cgdata);
        }
        else{
            fillTable(cgdata);
            JOptionPane.showMessageDialog(StatCourse.this, "查询失败！请检查输入条件！");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("stc.view.test");
        frame2 = new JFrame();
        scrollPane2 = new JScrollPane();
        tableCGstat = new JTable();
        button3 = new JButton();
        label3 = new JLabel();
        label5 = new JLabel();
        textFieldCno = new JTextField();
        label6 = new JLabel();
        textFieldCname = new JTextField();

        //======== frame2 ========
        {
            frame2.setIconImage(new ImageIcon(getClass().getResource("/image/school.jpg")).getImage());
            frame2.setTitle(bundle.getString("StatCourse.frame2.title"));
            frame2.setFont(new Font(Font.DIALOG, Font.PLAIN, 40));
            frame2.setMinimumSize(new Dimension(910, 780));
            frame2.setPreferredSize(new Dimension(910, 780));
            Container frame2ContentPane = frame2.getContentPane();

            //======== scrollPane2 ========
            {

                //---- tableCGstat ----
                tableCGstat.setFont(tableCGstat.getFont().deriveFont(tableCGstat.getFont().getSize() + 12f));
                tableCGstat.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "\u5e8f\u53f7", "\u8bfe\u7a0b\u53f7", "\u8bfe\u7a0b\u540d", "\u5e73\u5747\u5206", "\u6700\u4f4e\u5206", "\u6700\u9ad8\u5206"
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
                    TableColumnModel cm = tableCGstat.getColumnModel();
                    cm.getColumn(1).setPreferredWidth(50);
                }
                tableCGstat.setAlignmentX(10.0F);
                tableCGstat.setAlignmentY(7.0F);
                tableCGstat.setRowHeight(50);
                tableCGstat.setRowMargin(0);
                scrollPane2.setViewportView(tableCGstat);
            }

            //---- button3 ----
            button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 11f));
            button3.setText(bundle.getString("StatCourse.button3.text"));
            button3.addActionListener(e -> StatSelect(e));

            //---- label3 ----
            label3.setText(bundle.getString("StatCourse.label3.text"));
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 10f));

            //---- label5 ----
            label5.setText(bundle.getString("StatCourse.label5.text"));
            label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 10f));

            //---- textFieldCno ----
            textFieldCno.setFont(textFieldCno.getFont().deriveFont(textFieldCno.getFont().getSize() + 10f));

            //---- label6 ----
            label6.setText(bundle.getString("StatCourse.label6.text"));
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 10f));

            //---- textFieldCname ----
            textFieldCname.setFont(textFieldCname.getFont().deriveFont(textFieldCname.getFont().getSize() + 10f));

            GroupLayout frame2ContentPaneLayout = new GroupLayout(frame2ContentPane);
            frame2ContentPane.setLayout(frame2ContentPaneLayout);
            frame2ContentPaneLayout.setHorizontalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 721, GroupLayout.PREFERRED_SIZE)
                            .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                .addComponent(label3)
                                .addGap(12, 12, 12)
                                .addComponent(label5)
                                .addGap(18, 18, 18)
                                .addComponent(textFieldCno, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(label6)
                                .addGap(25, 25, 25)
                                .addComponent(textFieldCname, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(button3)))
                        .addGap(0, 62, Short.MAX_VALUE))
            );
            frame2ContentPaneLayout.setVerticalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(label5)
                            .addComponent(textFieldCno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6)
                            .addComponent(textFieldCname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button3))
                        .addGap(67, 67, 67)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(89, Short.MAX_VALUE))
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
    private JScrollPane scrollPane2;
    private JTable tableCGstat;
    private JButton button3;
    private JLabel label3;
    private JLabel label5;
    private JTextField textFieldCno;
    private JLabel label6;
    private JTextField textFieldCname;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) {

        new StatCourse().frame2.setVisible(true);
    }
}
