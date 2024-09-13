/*
 * Created by JFormDesigner on Sat Jun 15 15:42:26 CST 2024
 */

package stc.view.managerframe.User;

import stc.dao.SCDao;
import stc.dao.TCDao;
import stc.dao.Userdao;
import stc.entity.SPass;
import stc.entity.TC;
import stc.view.managerframe.Teacher.TCMessframe;

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
public class UserMan extends JFrame {
    public UserMan() {
        initComponents();
    }

    public void fillTable(List<? extends SPass> tcmess) {
        //TO DO
        DefaultTableModel sctdm = (DefaultTableModel) tableUser.getModel();
        if (tcmess.isEmpty()) {
            sctdm.setRowCount(0);//设置为0行
        } else {
            sctdm.setRowCount(0);//设置为0行
            for (SPass tctm : tcmess) {
                Vector v = new Vector<>();
                v.add(sctdm.getRowCount()+1);
                v.add(tctm.getSNO());
                v.add(tctm.getSPASSWORD());
                sctdm.addRow(v);
            }
        }
    }

    private void selectUser(ActionEvent e) {
        // TODO add your code here
        SPass sPass =new SPass();
        sPass.setSNO(textFieldUname.getText());
        sPass.setSPASSWORD(textFieldPassword.getText());
        //调用dao实现查询
        Userdao userdao=new Userdao();
        List<? extends SPass> tcdata= userdao.ManSCpass(sPass);
        //将数据放入表格
        if(!tcdata.isEmpty()){
            fillTable(tcdata);
        }
        else{
            fillTable(tcdata);
            JOptionPane.showMessageDialog(UserMan.this, "查询失败！请检查输入条件！");
        }
    }

    private void setagain(ActionEvent e) {
        // TODO add your code here
        textFieldPassword.setText(null);
    }


    private void table1MousePressed(MouseEvent e) {
        // TODO add your code here
        int row=tableUser.getSelectedRow();
        textFieldUname2.setEnabled(false);
        textFieldUname2.setText((String) tableUser.getValueAt(row,1));
        textFieldPassword.setText((String) tableUser.getValueAt(row,2));
    }

    private void updatepassword(ActionEvent e) {
        // TODO add your code here
        SPass sPass=new SPass();
        sPass.setSNO(textFieldUname2.getText());
        String password=textFieldPassword.getText();
        if(password.isEmpty()){
            JOptionPane.showMessageDialog(this,"密码为空！请输入密码！");
            return ;
        }else{
             sPass.setSPASSWORD(password);
        }
        Userdao userdao=new Userdao();
        boolean isok=userdao.UpdateSpass(sPass);
        if(isok){
            JOptionPane.showMessageDialog(this,"密码修改成功！");
        }else{
            JOptionPane.showMessageDialog(this,"密码修改失败！");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("stc.view.test");
        frame2 = new JFrame();
        label1 = new JLabel();
        scrollPane2 = new JScrollPane();
        tableUser = new JTable();
        button3 = new JButton();
        textFieldUname = new JTextField();
        button5 = new JButton();
        label3 = new JLabel();
        label2 = new JLabel();
        label4 = new JLabel();
        textFieldUname2 = new JTextField();
        textFieldPassword = new JTextField();
        label5 = new JLabel();
        label8 = new JLabel();
        button6 = new JButton();

        //======== frame2 ========
        {
            frame2.setIconImage(new ImageIcon(getClass().getResource("/image/school.jpg")).getImage());
            frame2.setTitle(bundle.getString("UserMan.frame2.title"));
            frame2.setFont(new Font(Font.DIALOG, Font.PLAIN, 40));
            frame2.setMinimumSize(new Dimension(800, 900));
            frame2.setPreferredSize(new Dimension(800, 900));
            Container frame2ContentPane = frame2.getContentPane();

            //---- label1 ----
            label1.setText(bundle.getString("UserMan.label1.text"));
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));

            //======== scrollPane2 ========
            {

                //---- tableUser ----
                tableUser.setFont(tableUser.getFont().deriveFont(tableUser.getFont().getSize() + 12f));
                tableUser.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "\u5e8f\u53f7", "\u7528\u6237\u540d", "\u5bc6\u7801"
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
                    TableColumnModel cm = tableUser.getColumnModel();
                    cm.getColumn(1).setPreferredWidth(50);
                }
                tableUser.setAlignmentX(10.0F);
                tableUser.setAlignmentY(7.0F);
                tableUser.setRowHeight(50);
                tableUser.setRowMargin(0);
                tableUser.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        table1MousePressed(e);
                    }
                });
                scrollPane2.setViewportView(tableUser);
            }

            //---- button3 ----
            button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 11f));
            button3.setText(bundle.getString("UserMan.button3.text"));
            button3.addActionListener(e -> selectUser(e));

            //---- textFieldUname ----
            textFieldUname.setFont(textFieldUname.getFont().deriveFont(textFieldUname.getFont().getSize() + 10f));

            //---- button5 ----
            button5.setFont(button5.getFont().deriveFont(button5.getFont().getSize() + 11f));
            button5.setText(bundle.getString("UserMan.button5.text"));
            button5.addActionListener(e -> updatepassword(e));

            //---- label3 ----
            label3.setText(bundle.getString("UserMan.label3.text"));
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 10f));

            //---- label2 ----
            label2.setText(bundle.getString("UserMan.label2.text"));
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 10f));

            //---- label4 ----
            label4.setText(bundle.getString("UserMan.label4.text"));
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 10f));

            //---- textFieldUname2 ----
            textFieldUname2.setFont(textFieldUname2.getFont().deriveFont(textFieldUname2.getFont().getSize() + 10f));

            //---- textFieldPassword ----
            textFieldPassword.setFont(textFieldPassword.getFont().deriveFont(textFieldPassword.getFont().getSize() + 10f));

            //---- label5 ----
            label5.setText(bundle.getString("UserMan.label5.text"));
            label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 10f));

            //---- label8 ----
            label8.setText(bundle.getString("UserMan.label8.text"));
            label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 10f));

            //---- button6 ----
            button6.setFont(button6.getFont().deriveFont(button6.getFont().getSize() + 11f));
            button6.setText(bundle.getString("UserMan.button6.text"));
            button6.addActionListener(e -> setagain(e));

            GroupLayout frame2ContentPaneLayout = new GroupLayout(frame2ContentPane);
            frame2ContentPane.setLayout(frame2ContentPaneLayout);
            frame2ContentPaneLayout.setHorizontalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup()
                            .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(label2)
                                    .addComponent(label4))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                        .addComponent(textFieldUname2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(label8)
                                        .addGap(18, 18, 18)
                                        .addComponent(textFieldPassword, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                        .addComponent(button6, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(button5, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 570, GroupLayout.PREFERRED_SIZE)
                                .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addGap(18, 18, 18)
                                    .addComponent(label3)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textFieldUname, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                    .addGap(72, 72, 72)
                                    .addComponent(button3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(59, Short.MAX_VALUE))
            );
            frame2ContentPaneLayout.setVerticalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(label1)
                            .addComponent(textFieldUname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button3))
                        .addGap(60, 60, 60)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label8)
                            .addComponent(textFieldUname2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5)
                            .addComponent(label4)
                            .addComponent(textFieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(label2)
                            .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button6)
                                .addComponent(button5)))
                        .addGap(63, 63, 63))
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
    private JScrollPane scrollPane2;
    private JTable tableUser;
    private JButton button3;
    private JTextField textFieldUname;
    private JButton button5;
    private JLabel label3;
    private JLabel label2;
    private JLabel label4;
    private JTextField textFieldUname2;
    private JTextField textFieldPassword;
    private JLabel label5;
    private JLabel label8;
    private JButton button6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) {

        new UserMan().frame2.setVisible(true);
    }
}
