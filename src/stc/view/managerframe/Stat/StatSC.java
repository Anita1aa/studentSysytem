/*
 * Created by JFormDesigner on Fri Jun 14 15:21:01 CST 2024
 */

package stc.view.managerframe.Stat;

import stc.dao.StatDao;
import stc.entity.CG;
import stc.entity.Credit;

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
public class StatSC extends JFrame {
    public StatSC() {
        initComponents();
    }

    public void fillTable(List<? extends Credit> cgmess) {
        //TO DO
        DefaultTableModel cgtdm = (DefaultTableModel) tableStatSC.getModel();
        if (cgmess.isEmpty()) {
            cgtdm.setRowCount(0);//设置为0行
        } else {
            cgtdm.setRowCount(0);//设置为0行
            for (Credit cgtm : cgmess) {
                Vector v = new Vector<>();
                v.add(cgtdm.getRowCount()+1);
                v.add(cgtm.getSNO());
                v.add(cgtm.getSNAME());
                v.add(cgtm.getALLCREDIT());
                cgtdm.addRow(v);
            }
        }
    }

    private void StatSC(ActionEvent e) {
        // TODO add your code here
        Credit credit =new Credit();
        credit.setSNO(textFieldSno.getText());
        credit.setSNAME(textFieldSname.getText());
        credit.setALLCREDIT(null);
        //调用dao实现查询
        StatDao statDao=new StatDao();
        List<? extends Credit> cgdata= statDao.ManStatALLCredit(credit);
        //将数据放入表格
        if(!cgdata.isEmpty()){
            fillTable(cgdata);
        }
        else{
            fillTable(cgdata);
            JOptionPane.showMessageDialog(StatSC.this, "查询失败！请检查输入条件！");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("stc.view.test");
        frame2 = new JFrame();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        tableStatSC = new JTable();
        button3 = new JButton();
        label7 = new JLabel();
        textFieldSno = new JTextField();
        textFieldSname = new JTextField();
        label8 = new JLabel();

        //======== frame2 ========
        {
            frame2.setIconImage(new ImageIcon(getClass().getResource("/image/school.jpg")).getImage());
            frame2.setTitle(bundle.getString("StatSC.frame2.title"));
            frame2.setFont(new Font(Font.DIALOG, Font.PLAIN, 40));
            frame2.setMinimumSize(new Dimension(860, 720));
            frame2.setPreferredSize(new Dimension(870, 720));
            Container frame2ContentPane = frame2.getContentPane();

            //---- label2 ----
            label2.setText(bundle.getString("StatSC.label2.text"));
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 10f));

            //======== scrollPane2 ========
            {

                //---- tableStatSC ----
                tableStatSC.setFont(tableStatSC.getFont().deriveFont(tableStatSC.getFont().getSize() + 12f));
                tableStatSC.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "\u5e8f\u53f7", "\u5b66\u53f7", "\u59d3\u540d", "\u603b\u5b66\u5206"
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
                    TableColumnModel cm = tableStatSC.getColumnModel();
                    cm.getColumn(1).setPreferredWidth(50);
                }
                tableStatSC.setAlignmentX(10.0F);
                tableStatSC.setAlignmentY(7.0F);
                tableStatSC.setRowHeight(50);
                tableStatSC.setRowMargin(0);
                scrollPane2.setViewportView(tableStatSC);
            }

            //---- button3 ----
            button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 11f));
            button3.setText(bundle.getString("StatSC.button3.text"));
            button3.addActionListener(e -> StatSC(e));

            //---- label7 ----
            label7.setText(bundle.getString("StatSC.label7.text"));
            label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 10f));

            //---- textFieldSno ----
            textFieldSno.setFont(textFieldSno.getFont().deriveFont(textFieldSno.getFont().getSize() + 10f));

            //---- textFieldSname ----
            textFieldSname.setFont(textFieldSname.getFont().deriveFont(textFieldSname.getFont().getSize() + 10f));

            //---- label8 ----
            label8.setText(bundle.getString("StatSC.label8.text_2"));
            label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 10f));

            GroupLayout frame2ContentPaneLayout = new GroupLayout(frame2ContentPane);
            frame2ContentPane.setLayout(frame2ContentPaneLayout);
            frame2ContentPaneLayout.setHorizontalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrollPane2)
                            .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                .addComponent(label2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldSno, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(label8)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldSname, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 88, Short.MAX_VALUE))
            );
            frame2ContentPaneLayout.setVerticalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(label7)
                            .addComponent(label8)
                            .addComponent(textFieldSno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldSname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button3))
                        .addGap(56, 56, 56)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(44, Short.MAX_VALUE))
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
    private JLabel label2;
    private JScrollPane scrollPane2;
    private JTable tableStatSC;
    private JButton button3;
    private JLabel label7;
    private JTextField textFieldSno;
    private JTextField textFieldSname;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) {

        new StatSC().frame2.setVisible(true);
    }
}
