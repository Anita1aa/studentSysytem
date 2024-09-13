/*
 * Created by JFormDesigner on Fri Jun 14 16:30:38 CST 2024
 */

package stc.view.studentframe;

import stc.dao.SCDao;
import stc.entity.SC;
import stc.util.IDandPassword;

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
public class SCGframe extends JFrame {
    public SCGframe() {
        initComponents();
        textFieldAllCredit.setEnabled(false);
    }

    public void fillTable(List<? extends SC> scmess) {
        //TO DO
        DefaultTableModel sctdm = (DefaultTableModel) tableSCGmess.getModel();
        if (scmess.isEmpty()) {
            sctdm.setRowCount(0);//设置为0行
        } else {
            sctdm.setRowCount(0);//设置为0行
            for (SC sctm : scmess) {
                Vector v = new Vector<>();
                v.add(sctdm.getRowCount()+1);
                v.add(sctm.getCNO());
                v.add(sctm.getCNAME());
                v.add(sctm.getCREDIT());
                v.add(sctm.getGRADE());
                sctdm.addRow(v);
            }
        }
    }

    private void selectSCG(ActionEvent e) {
        // TODO add your code here
        //创建课程类以接收填入的信息
        SC sc=new SC();
        sc.setCNO(textFieldCno.getText());
        sc.setCNAME(textFieldCname.getText());
        IDandPassword iDandPassword=new IDandPassword();
        sc.setSNO(iDandPassword.getSID().getSNO());
        sc.setSNAME(null);
        sc.setCREDIT(null);
        //调用dao实现查询
        SCDao scDao=new SCDao();
        List<? extends SC> scdata= scDao.ManquerySC(sc);
        //将数据放入表格
        if(!scdata.isEmpty()){
            fillTable(scdata);
            //计算总学分
            double AllCredit=0;
            if(textFieldAllCredit.getText().isEmpty()){
                for (SC sctm : scdata) {
                    AllCredit+=Double.parseDouble(sctm.getCREDIT());
                }
                textFieldAllCredit.setText(String.valueOf(AllCredit));
            }
        }
        else{
            fillTable(scdata);
            JOptionPane.showMessageDialog(this, "查询失败！请检查输入条件！");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("stc.view.test");
        frame2 = new JFrame();
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        tableSCGmess = new JTable();
        textFieldCno = new JTextField();
        textFieldCname = new JTextField();
        label4 = new JLabel();
        button1 = new JButton();
        label3 = new JLabel();
        textFieldAllCredit = new JTextField();

        //======== frame2 ========
        {
            frame2.setIconImage(new ImageIcon(getClass().getResource("/image/school.jpg")).getImage());
            frame2.setTitle(bundle.getString("SCGframe.frame2.title"));
            frame2.setFont(new Font(Font.DIALOG, Font.PLAIN, 40));
            frame2.setMinimumSize(new Dimension(850, 780));
            frame2.setPreferredSize(new Dimension(850, 780));
            Container frame2ContentPane = frame2.getContentPane();

            //---- label1 ----
            label1.setText(bundle.getString("SCGframe.label1.text"));
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));

            //---- label2 ----
            label2.setText(bundle.getString("SCGframe.label2.text"));
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 10f));

            //======== scrollPane2 ========
            {

                //---- tableSCGmess ----
                tableSCGmess.setFont(tableSCGmess.getFont().deriveFont(tableSCGmess.getFont().getSize() + 12f));
                tableSCGmess.setModel(new DefaultTableModel(
                    new Object[][] {
                        {null, null, null, null, null},
                    },
                    new String[] {
                        "\u5e8f\u53f7", "\u8bfe\u7a0b\u53f7", "\u8bfe\u7a0b\u540d", "\u8bfe\u7a0b\u5b66\u5206", "\u6210\u7ee9"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        String.class, String.class, String.class, String.class, Integer.class
                    };
                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return columnTypes[columnIndex];
                    }
                });
                {
                    TableColumnModel cm = tableSCGmess.getColumnModel();
                    cm.getColumn(1).setPreferredWidth(50);
                }
                tableSCGmess.setAlignmentX(10.0F);
                tableSCGmess.setAlignmentY(7.0F);
                tableSCGmess.setRowHeight(50);
                tableSCGmess.setRowMargin(0);
                scrollPane2.setViewportView(tableSCGmess);
            }

            //---- textFieldCno ----
            textFieldCno.setFont(textFieldCno.getFont().deriveFont(textFieldCno.getFont().getSize() + 10f));

            //---- textFieldCname ----
            textFieldCname.setFont(textFieldCname.getFont().deriveFont(textFieldCname.getFont().getSize() + 10f));

            //---- label4 ----
            label4.setText(bundle.getString("SCGframe.label4.text"));
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 10f));

            //---- button1 ----
            button1.setText(bundle.getString("SCGframe.button1.text"));
            button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 10f));
            button1.addActionListener(e -> selectSCG(e));

            //---- label3 ----
            label3.setText(bundle.getString("SCGframe.label3.text"));
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 10f));

            //---- textFieldAllCredit ----
            textFieldAllCredit.setFont(textFieldAllCredit.getFont().deriveFont(textFieldAllCredit.getFont().getSize() + 10f));

            GroupLayout frame2ContentPaneLayout = new GroupLayout(frame2ContentPane);
            frame2ContentPane.setLayout(frame2ContentPaneLayout);
            frame2ContentPaneLayout.setHorizontalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                .addComponent(label1)
                                .addGap(43, 43, 43)
                                .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                        .addComponent(label3)
                                        .addGap(18, 18, 18)
                                        .addComponent(textFieldAllCredit, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                        .addComponent(label2)
                                        .addGap(18, 18, 18)
                                        .addComponent(textFieldCno, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                        .addGap(67, 67, 67)
                                        .addComponent(label4)
                                        .addGap(18, 18, 18)
                                        .addComponent(textFieldCname, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))))
                        .addGap(49, 49, 49))
            );
            frame2ContentPaneLayout.setVerticalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldCname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4)
                            .addComponent(label1)
                            .addComponent(label2)
                            .addComponent(textFieldCno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button1)
                            .addComponent(label3)
                            .addComponent(textFieldAllCredit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
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
    private JTable tableSCGmess;
    private JTextField textFieldCno;
    private JTextField textFieldCname;
    private JLabel label4;
    private JButton button1;
    private JLabel label3;
    private JTextField textFieldAllCredit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args) {
        new SCGframe().frame2.setVisible(true);
    }
}
