/*
 * Created by JFormDesigner on Fri Jun 14 15:21:16 CST 2024
 */

package stc.view.managerframe.Stat;

import stc.dao.StatDao;
import stc.entity.Credit;
import stc.entity.Title;

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
public class StatTea extends JFrame {
    public StatTea() {
        initComponents();
    }


    public void fillTable(List<? extends Title> cgmess) {
        //TO DO
        DefaultTableModel cgtdm = (DefaultTableModel) tableTitle.getModel();
        if (cgmess.isEmpty()) {
            cgtdm.setRowCount(0);//设置为0行
        } else {
            cgtdm.setRowCount(0);//设置为0行
            for (Title cgtm : cgmess) {
                Vector v = new Vector<>();
                v.add(cgtm.getTETITLE());
                v.add(cgtm.getTNUMBER());
                v.add(cgtm.getAVGSALARY());
                cgtdm.addRow(v);
            }
        }
    }

    private void StatTitle(ActionEvent e) {
        // TODO add your code here
        Title title =new Title();
        if(comboBoxTitle.getSelectedItem().toString()=="--请选择--"){
            title.setTETITLE(null);
        }
        else {
           title.setTETITLE(comboBoxTitle.getSelectedItem().toString());
        }
        //调用dao实现查询
        StatDao statDao=new StatDao();
        List<? extends Title> tidata= statDao.ManStatALLTitle(title);
        //将数据放入表格
        if(!tidata.isEmpty()){
            fillTable(tidata);
        }
        else{
            fillTable(tidata);
            JOptionPane.showMessageDialog(StatTea.this, "查询失败！请检查输入条件！");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("stc.view.test");
        frame2 = new JFrame();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        tableTitle = new JTable();
        button3 = new JButton();
        label8 = new JLabel();
        comboBoxTitle = new JComboBox<>();

        //======== frame2 ========
        {
            frame2.setIconImage(new ImageIcon(getClass().getResource("/image/school.jpg")).getImage());
            frame2.setTitle(bundle.getString("StatTea.frame2.title"));
            frame2.setFont(new Font(Font.DIALOG, Font.PLAIN, 40));
            frame2.setMinimumSize(new Dimension(680, 710));
            frame2.setPreferredSize(new Dimension(680, 710));
            Container frame2ContentPane = frame2.getContentPane();

            //---- label2 ----
            label2.setText(bundle.getString("StatTea.label2.text"));
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 10f));

            //======== scrollPane2 ========
            {

                //---- tableTitle ----
                tableTitle.setFont(tableTitle.getFont().deriveFont(tableTitle.getFont().getSize() + 12f));
                tableTitle.setModel(new DefaultTableModel(
                    new Object[][] {
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                    },
                    new String[] {
                        "\u804c\u79f0", "\u6559\u5e08\u6570\u91cf", "\u5e73\u5747\u5de5\u8d44"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        String.class, String.class, String.class
                    };
                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return columnTypes[columnIndex];
                    }
                });
                {
                    TableColumnModel cm = tableTitle.getColumnModel();
                    cm.getColumn(0).setPreferredWidth(50);
                }
                tableTitle.setAlignmentX(10.0F);
                tableTitle.setAlignmentY(7.0F);
                tableTitle.setRowHeight(50);
                tableTitle.setRowMargin(0);
                scrollPane2.setViewportView(tableTitle);
            }

            //---- button3 ----
            button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 11f));
            button3.setText(bundle.getString("StatTea.button3.text"));
            button3.addActionListener(e -> StatTitle(e));

            //---- label8 ----
            label8.setText(bundle.getString("StatTea.label8.text"));
            label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 10f));

            //---- comboBoxTitle ----
            comboBoxTitle.setFont(comboBoxTitle.getFont().deriveFont(comboBoxTitle.getFont().getSize() + 10f));
            comboBoxTitle.setModel(new DefaultComboBoxModel<>(new String[] {
                "--\u8bf7\u9009\u62e9--",
                "\u6559\u6388",
                "\u526f\u6559\u6388",
                "\u8bb2\u5e08",
                "\u52a9\u6559"
            }));

            GroupLayout frame2ContentPaneLayout = new GroupLayout(frame2ContentPane);
            frame2ContentPane.setLayout(frame2ContentPaneLayout);
            frame2ContentPaneLayout.setHorizontalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup()
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 545, GroupLayout.PREFERRED_SIZE)
                            .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                .addComponent(label2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label8)
                                .addGap(18, 18, 18)
                                .addComponent(comboBoxTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 63, Short.MAX_VALUE))
            );
            frame2ContentPaneLayout.setVerticalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(label8)
                            .addComponent(comboBoxTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button3))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
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
    private JTable tableTitle;
    private JButton button3;
    private JLabel label8;
    private JComboBox<String> comboBoxTitle;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) {
        new StatTea().frame2.setVisible(true);
    }
}
