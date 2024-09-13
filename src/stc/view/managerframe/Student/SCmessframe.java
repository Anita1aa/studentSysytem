/*
 * Created by JFormDesigner on Fri Jun 14 13:16:04 CST 2024
 */

package stc.view.managerframe.Student;

import stc.dao.SCDao;
import stc.entity.SC;

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
public class SCmessframe extends JFrame {
    public SCmessframe() {
        initComponents();
    }

    public void fillTable(List<? extends SC> scmess) {
        //TO DO
        DefaultTableModel sctdm = (DefaultTableModel) tableSCmess.getModel();
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

    private void selectSCmess(ActionEvent e) {
        // TODO add your code here
        //创建课程类以接收填入的信息
        SC sc=new SC();
        sc.setCNO(textFieldCno.getText());
        sc.setCNAME(textFieldCname.getText());
        sc.setSNO(textFieldSno.getText());
        sc.setSNAME(textFieldSname.getText());
        sc.setCREDIT(null);
        //调用dao实现查询
        SCDao scDao=new SCDao();
        List<? extends SC> scdata= scDao.ManquerySC(sc);
        //将数据放入表格
        if(!scdata.isEmpty()){
            fillTable(scdata);
        }
        else{
            fillTable(scdata);
            JOptionPane.showMessageDialog(SCmessframe.this, "查询失败！请检查输入条件！");
        }
    }

    private void setagain(ActionEvent e) {
        // TODO add your code here
        textFieldSno.setText(null);
        textFieldSname.setText(null);
        textFieldCno.setText(null);
        textFieldCname.setText(null);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("stc.view.test");
        frame2 = new JFrame();
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        tableSCmess = new JTable();
        button3 = new JButton();
        textFieldCno = new JTextField();
        label5 = new JLabel();
        textFieldSname = new JTextField();
        textFieldCname = new JTextField();
        textFieldSno = new JTextField();
        label4 = new JLabel();
        label3 = new JLabel();
        label6 = new JLabel();
        button4 = new JButton();

        //======== frame2 ========
        {
            frame2.setIconImage(new ImageIcon(getClass().getResource("/image/school.jpg")).getImage());
            frame2.setTitle(bundle.getString("SCmessframe.frame2.title"));
            frame2.setFont(new Font(Font.DIALOG, Font.PLAIN, 40));
            frame2.setMinimumSize(new Dimension(980, 800));
            frame2.setPreferredSize(new Dimension(980, 800));
            Container frame2ContentPane = frame2.getContentPane();

            //---- label1 ----
            label1.setText(bundle.getString("SCmessframe.label1.text"));
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));

            //---- label2 ----
            label2.setText(bundle.getString("SCmessframe.label2.text"));
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 10f));

            //======== scrollPane2 ========
            {

                //---- tableSCmess ----
                tableSCmess.setFont(tableSCmess.getFont().deriveFont(tableSCmess.getFont().getSize() + 12f));
                tableSCmess.setModel(new DefaultTableModel(
                    new Object[][] {
                        {null, null, null, null, null, null},
                    },
                    new String[] {
                        "\u5b66\u53f7", "\u59d3\u540d", "\u8bfe\u7a0b\u53f7", "\u8bfe\u7a0b\u540d", "\u8bfe\u7a0b\u5b66\u5206", "\u6210\u7ee9"
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
                    TableColumnModel cm = tableSCmess.getColumnModel();
                    cm.getColumn(0).setPreferredWidth(50);
                }
                tableSCmess.setAlignmentX(10.0F);
                tableSCmess.setAlignmentY(7.0F);
                tableSCmess.setRowHeight(50);
                tableSCmess.setRowMargin(0);
                scrollPane2.setViewportView(tableSCmess);
            }

            //---- button3 ----
            button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 11f));
            button3.setText(bundle.getString("SCmessframe.button3.text"));
            button3.addActionListener(e -> selectSCmess(e));

            //---- textFieldCno ----
            textFieldCno.setFont(textFieldCno.getFont().deriveFont(textFieldCno.getFont().getSize() + 10f));

            //---- label5 ----
            label5.setText(bundle.getString("SCmessframe.label5.text"));
            label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 10f));

            //---- textFieldSname ----
            textFieldSname.setFont(textFieldSname.getFont().deriveFont(textFieldSname.getFont().getSize() + 10f));

            //---- textFieldCname ----
            textFieldCname.setFont(textFieldCname.getFont().deriveFont(textFieldCname.getFont().getSize() + 10f));

            //---- textFieldSno ----
            textFieldSno.setFont(textFieldSno.getFont().deriveFont(textFieldSno.getFont().getSize() + 10f));

            //---- label4 ----
            label4.setText(bundle.getString("SCmessframe.label4.text"));
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 10f));

            //---- label3 ----
            label3.setText(bundle.getString("SCmessframe.label3.text"));
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 10f));

            //---- label6 ----
            label6.setText(bundle.getString("SCmessframe.label6.text"));
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 10f));

            //---- button4 ----
            button4.setFont(button4.getFont().deriveFont(button4.getFont().getSize() + 11f));
            button4.setText(bundle.getString("SCmessframe.button4.text"));
            button4.addActionListener(e -> setagain(e));

            GroupLayout frame2ContentPaneLayout = new GroupLayout(frame2ContentPane);
            frame2ContentPane.setLayout(frame2ContentPaneLayout);
            frame2ContentPaneLayout.setHorizontalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                            .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                .addGroup(frame2ContentPaneLayout.createParallelGroup()
                                    .addComponent(label5)
                                    .addComponent(label1))
                                .addGap(34, 34, 34)
                                .addGroup(frame2ContentPaneLayout.createParallelGroup()
                                    .addComponent(label2)
                                    .addComponent(label3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(frame2ContentPaneLayout.createParallelGroup()
                                    .addComponent(textFieldCno, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldSno, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(frame2ContentPaneLayout.createParallelGroup()
                                    .addComponent(label6)
                                    .addComponent(label4))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(frame2ContentPaneLayout.createParallelGroup()
                                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                        .addComponent(textFieldCname, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                        .addComponent(button4, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                        .addComponent(textFieldSname, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))))
                        .addGap(106, 106, 106))
            );
            frame2ContentPaneLayout.setVerticalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1)
                            .addComponent(textFieldCno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2)
                            .addComponent(label4)
                            .addComponent(textFieldCname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button4))
                        .addGap(18, 18, 18)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldSno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldSname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5)
                            .addComponent(label3)
                            .addComponent(label6)
                            .addComponent(button3))
                        .addGap(40, 40, 40)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(73, Short.MAX_VALUE))
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
    private JTable tableSCmess;
    private JButton button3;
    private JTextField textFieldCno;
    private JLabel label5;
    private JTextField textFieldSname;
    private JTextField textFieldCname;
    private JTextField textFieldSno;
    private JLabel label4;
    private JLabel label3;
    private JLabel label6;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
