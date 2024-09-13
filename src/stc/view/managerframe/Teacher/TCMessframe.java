/*
 * Created by JFormDesigner on Fri Jun 14 14:55:31 CST 2024
 */

package stc.view.managerframe.Teacher;

import stc.dao.TCDao;
import stc.entity.TC;

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
public class TCMessframe extends JFrame {
    public TCMessframe() {
        initComponents();
    }

    public void fillTable(List<? extends TC> tcmess) {
        //TO DO
        DefaultTableModel sctdm = (DefaultTableModel) tableTCmess.getModel();
        if (tcmess.isEmpty()) {
            sctdm.setRowCount(0);//设置为0行
        } else {
            sctdm.setRowCount(0);//设置为0行
            for (TC tctm : tcmess) {
                Vector v = new Vector<>();
                v.add(tctm.getTNO());
                v.add(tctm.getTNAME());
                v.add(tctm.getCNO());
                v.add(tctm.getCNAME());
                v.add(tctm.getCREDIT());
                sctdm.addRow(v);
            }
        }
    }

    private void selectTCmess(ActionEvent e) {
        // TODO add your code here
        TC tc=new TC();
        tc.setTNO(textFieldTno.getText());
        tc.setTNAME(textFieldTname.getText());
        tc.setCNO(textFieldCno.getText());
        tc.setCNAME(textFieldCname.getText());
        tc.setCREDIT(null);
        //调用dao实现查询
        TCDao tcDao=new TCDao();
        List<? extends TC> tcdata= tcDao.ManqueryTC(tc);
        //将数据放入表格
        if(!tcdata.isEmpty()){
            fillTable(tcdata);
        }
        else{
            fillTable(tcdata);
            JOptionPane.showMessageDialog(TCMessframe.this, "查询失败！请检查输入条件！");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("stc.view.test");
        frame2 = new JFrame();
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        tableTCmess = new JTable();
        button3 = new JButton();
        textFieldCno = new JTextField();
        label5 = new JLabel();
        textFieldTname = new JTextField();
        textFieldCname = new JTextField();
        textFieldTno = new JTextField();
        label4 = new JLabel();
        label3 = new JLabel();
        label6 = new JLabel();

        //======== frame2 ========
        {
            frame2.setIconImage(new ImageIcon(getClass().getResource("/image/school.jpg")).getImage());
            frame2.setTitle(bundle.getString("TCMessframe.frame2.title"));
            frame2.setFont(new Font(Font.DIALOG, Font.PLAIN, 40));
            frame2.setMinimumSize(new Dimension(980, 800));
            frame2.setPreferredSize(new Dimension(980, 800));
            Container frame2ContentPane = frame2.getContentPane();

            //---- label1 ----
            label1.setText(bundle.getString("TCMessframe.label1.text"));
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));

            //---- label2 ----
            label2.setText(bundle.getString("TCMessframe.label2.text"));
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 10f));

            //======== scrollPane2 ========
            {

                //---- tableTCmess ----
                tableTCmess.setFont(tableTCmess.getFont().deriveFont(tableTCmess.getFont().getSize() + 12f));
                tableTCmess.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "\u5de5\u53f7", "\u59d3\u540d", "\u8bfe\u7a0b\u53f7", "\u8bfe\u7a0b\u540d", "\u8bfe\u7a0b\u5b66\u5206"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        String.class, String.class, String.class, String.class, String.class
                    };
                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return columnTypes[columnIndex];
                    }
                });
                {
                    TableColumnModel cm = tableTCmess.getColumnModel();
                    cm.getColumn(0).setPreferredWidth(50);
                }
                tableTCmess.setAlignmentX(10.0F);
                tableTCmess.setAlignmentY(7.0F);
                tableTCmess.setRowHeight(50);
                tableTCmess.setRowMargin(0);
                scrollPane2.setViewportView(tableTCmess);
            }

            //---- button3 ----
            button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 11f));
            button3.setText(bundle.getString("TCMessframe.button3.text"));
            button3.addActionListener(e -> selectTCmess(e));

            //---- textFieldCno ----
            textFieldCno.setFont(textFieldCno.getFont().deriveFont(textFieldCno.getFont().getSize() + 10f));

            //---- label5 ----
            label5.setText(bundle.getString("TCMessframe.label5.text"));
            label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 10f));

            //---- textFieldTname ----
            textFieldTname.setFont(textFieldTname.getFont().deriveFont(textFieldTname.getFont().getSize() + 10f));

            //---- textFieldCname ----
            textFieldCname.setFont(textFieldCname.getFont().deriveFont(textFieldCname.getFont().getSize() + 10f));

            //---- textFieldTno ----
            textFieldTno.setFont(textFieldTno.getFont().deriveFont(textFieldTno.getFont().getSize() + 10f));

            //---- label4 ----
            label4.setText(bundle.getString("TCMessframe.label4.text"));
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 10f));

            //---- label3 ----
            label3.setText(bundle.getString("TCMessframe.label3.text"));
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 10f));

            //---- label6 ----
            label6.setText(bundle.getString("TCMessframe.label6.text"));
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 10f));

            GroupLayout frame2ContentPaneLayout = new GroupLayout(frame2ContentPane);
            frame2ContentPane.setLayout(frame2ContentPaneLayout);
            frame2ContentPaneLayout.setHorizontalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 797, GroupLayout.PREFERRED_SIZE)
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
                                    .addComponent(textFieldTno, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(frame2ContentPaneLayout.createParallelGroup()
                                    .addComponent(label6)
                                    .addComponent(label4))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(frame2ContentPaneLayout.createParallelGroup()
                                    .addComponent(textFieldCname, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                        .addComponent(textFieldTname, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(51, Short.MAX_VALUE))
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
                            .addComponent(textFieldCname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldTno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldTname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5)
                            .addComponent(label3)
                            .addComponent(label6)
                            .addComponent(button3))
                        .addGap(43, 43, 43)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(70, Short.MAX_VALUE))
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
    private JTable tableTCmess;
    private JButton button3;
    private JTextField textFieldCno;
    private JLabel label5;
    private JTextField textFieldTname;
    private JTextField textFieldCname;
    private JTextField textFieldTno;
    private JLabel label4;
    private JLabel label3;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args) {
        new TCMessframe().frame2.setVisible(true);
    }
}
