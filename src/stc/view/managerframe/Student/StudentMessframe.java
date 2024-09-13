/*
 * Created by JFormDesigner on Thu Jun 13 14:38:41 CST 2024
 */

package stc.view.managerframe.Student;

import stc.dao.CourseDao;
import stc.dao.StudentDao;
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
public class StudentMessframe extends JFrame {
    public StudentMessframe() {
        initComponents();
    }

    public JFrame getFrame1() {
        return frame1;
    }

    public void fillTable(List<? extends Student> stumess){
        //TO DO
        DefaultTableModel stdm= (DefaultTableModel) tableStuMess.getModel();
        if (stumess.isEmpty()) {
            stdm.setRowCount(0);//设置为0行
        }else{
            stdm.setRowCount(0);//设置为0行
            for(Student stum : stumess){
                Vector v=new Vector<>();
                v.add(stdm.getRowCount()+1);//序号
                v.add(stum.getSNO());
                v.add(stum.getSNAME());
                v.add(stum.getSSEX());
                v.add(stum.getSAGE());
                v.add(stum.getSDEPT());
                stdm.addRow(v);
            }
        }
    }

    private void AddTea(ActionEvent e) {
        // TODO add your code here
        new AddStuframe().getFrame1().setVisible(true);
    }

    private void selectStuMess(ActionEvent e) {
        // TODO add your code here
        //创建学生类以接收填入的信息
        Student student=new Student();
        student.setSNO(textFieldSno.getText());
        student.setSNAME(textFieldSname.getText());
        //获取性别
        if(comboBoxSsex.getSelectedItem().toString()=="--请选择--"){
            student.setSSEX(null);
        }
        else {
            student.setSSEX(comboBoxSsex.getSelectedItem().toString());
        }
        //获取年龄
        student.setSAGE(textFieldSage.getText());
        //获取学院
        if(comboBoxSdept.getSelectedItem().toString()=="--请选择--"){
            student.setSDEPT(null);
        }
        else {
            student.setSDEPT(comboBoxSdept.getSelectedItem().toString());
        }
        //调用dao实现查询
        StudentDao studentDao=new StudentDao();
        List<? extends Student> studata=studentDao.queryStuMess(student);
        //将数据放入表格
        if(!studata.isEmpty()){
            fillTable(studata);
        }
        else{
            fillTable(studata);
            JOptionPane.showMessageDialog(StudentMessframe.this, "查询失败！请检查输入条件！");
        }
    }

    private void updateStuMess(ActionEvent e) {
        // TODO add your code here
        //创建学生类接收信息
        Student student=new Student();
        student.setSNO(textFieldSno2.getText());
        student.setSNAME(textFieldSname2.getText());
        if(comboBoxSsex2.getSelectedItem()=="--请选择--"){
            student.setSSEX(null);
        }else{
            student.setSSEX((String) comboBoxSsex2.getSelectedItem());
        }
        student.setSAGE(textFieldSage2.getText());
        if(comboBoxSdept2.getSelectedItem()=="--请选择--"){
            student.setSDEPT(null);
        }else{
            student.setSDEPT((String)comboBoxSdept2.getSelectedItem());
        }
        //创建DAO类完成数据库操作
        StudentDao studentDao=new StudentDao();
        boolean isok=studentDao.ManUpdateStudent(student);
        if(isok)
        {
            JOptionPane.showMessageDialog(this,"学生基本信息修改成功！");
        } else{
            JOptionPane.showMessageDialog(this,"修改失败！请检查输入信息！");
        }
    }

    private void deleteStuMess(ActionEvent e) {
        // TODO add your code here
        //创建学生类接收信息
        Student student =new Student();
        student.setSNO(textFieldSno2.getText());
        //创建DAO类完成数据库操作
        StudentDao studentDao=new StudentDao();
        boolean isok=studentDao.DeleteStudent(student);
        if(isok) {
            JOptionPane.showMessageDialog(this,"学生信息删除成功！");
        } else{
            JOptionPane.showMessageDialog(this,"学生信息删除失败！");
        }
    }

    private void tableStuMessMousePressed(MouseEvent e) {
        // TODO add your code here
        int row=tableStuMess.getSelectedRow();
        textFieldSno2.setEnabled(false);
        textFieldSno2.setText((String) tableStuMess.getValueAt(row,1));
        textFieldSname2.setText((String) tableStuMess.getValueAt(row,2));
        textFieldSage2.setText((String) tableStuMess.getValueAt(row,4));
        String Ssex=tableStuMess.getValueAt(row,3).toString();
        if(Ssex.equals("女")){
            comboBoxSsex2.setSelectedIndex(2);
        } else if (Ssex.equals("男")) {
            comboBoxSsex2.setSelectedIndex(1);
        }else {
            comboBoxSsex2.setSelectedIndex(0);
        }
        String Sdept= (String) tableStuMess.getValueAt(row,5);
        //为空报错
        switch (Sdept) {
            case "格兰芬多":
                comboBoxSdept2.setSelectedIndex(1);
                break;
            case "斯莱特林":
                comboBoxSdept2.setSelectedIndex(2);
                break;
            case "拉文克劳":
                comboBoxSdept2.setSelectedIndex(3);
                break;
            case "赫奇帕奇":
                comboBoxSdept2.setSelectedIndex(4);
                break;
            default:
                comboBoxSdept2.setSelectedIndex(0);
                break;
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("stc.view.test");
        frame1 = new JFrame();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        buttonupdate = new JButton();
        scrollPane2 = new JScrollPane();
        tableStuMess = new JTable();
        buttonAdd = new JButton();
        buttonSelect = new JButton();
        comboBoxSdept = new JComboBox<>();
        textFieldSno = new JTextField();
        textFieldSname = new JTextField();
        comboBoxSsex = new JComboBox<>();
        buttonDelete = new JButton();
        label6 = new JLabel();
        textFieldSage = new JTextField();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        comboBoxSdept2 = new JComboBox<>();
        textFieldSno2 = new JTextField();
        textFieldSname2 = new JTextField();
        comboBoxSsex2 = new JComboBox<>();
        textFieldSage2 = new JTextField();
        label13 = new JLabel();

        //======== frame1 ========
        {
            frame1.setIconImage(new ImageIcon(getClass().getResource("/image/school.jpg")).getImage());
            frame1.setTitle(bundle.getString("Updateframe.frame1.title"));
            frame1.setFont(new Font(Font.DIALOG, Font.PLAIN, 40));
            frame1.setMinimumSize(new Dimension(1400, 860));
            frame1.setPreferredSize(new Dimension(1400, 860));
            Container frame1ContentPane = frame1.getContentPane();

            //---- label1 ----
            label1.setText(bundle.getString("Updateframe.label1.text"));
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));

            //---- label2 ----
            label2.setText(bundle.getString("Updateframe.label2.text"));
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 10f));

            //---- label3 ----
            label3.setText(bundle.getString("Updateframe.label3.text"));
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 10f));

            //---- label4 ----
            label4.setText(bundle.getString("Updateframe.label4.text"));
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 10f));

            //---- label5 ----
            label5.setText(bundle.getString("Updateframe.label5.text"));
            label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 10f));

            //---- buttonupdate ----
            buttonupdate.setFont(buttonupdate.getFont().deriveFont(buttonupdate.getFont().getSize() + 11f));
            buttonupdate.setText(bundle.getString("Updateframe.buttonupdate.text"));
            buttonupdate.addActionListener(e -> updateStuMess(e));

            //======== scrollPane2 ========
            {

                //---- tableStuMess ----
                tableStuMess.setFont(tableStuMess.getFont().deriveFont(tableStuMess.getFont().getSize() + 12f));
                tableStuMess.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "\u5e8f\u53f7", "\u5b66\u53f7", "\u59d3\u540d", "\u6027\u522b", "\u5e74\u9f84", "\u5b66\u9662"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        String.class, String.class, String.class, String.class, Integer.class, String.class
                    };
                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return columnTypes[columnIndex];
                    }
                });
                {
                    TableColumnModel cm = tableStuMess.getColumnModel();
                    cm.getColumn(1).setPreferredWidth(50);
                }
                tableStuMess.setAlignmentX(10.0F);
                tableStuMess.setAlignmentY(7.0F);
                tableStuMess.setRowHeight(50);
                tableStuMess.setRowMargin(0);
                tableStuMess.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        tableStuMessMousePressed(e);
                    }
                });
                scrollPane2.setViewportView(tableStuMess);
            }

            //---- buttonAdd ----
            buttonAdd.setFont(buttonAdd.getFont().deriveFont(buttonAdd.getFont().getSize() + 11f));
            buttonAdd.setText(bundle.getString("Updateframe.buttonAdd.text"));
            buttonAdd.addActionListener(e -> AddTea(e));

            //---- buttonSelect ----
            buttonSelect.setFont(buttonSelect.getFont().deriveFont(buttonSelect.getFont().getSize() + 11f));
            buttonSelect.setText(bundle.getString("Updateframe.buttonSelect.text"));
            buttonSelect.addActionListener(e -> selectStuMess(e));

            //---- comboBoxSdept ----
            comboBoxSdept.setFont(comboBoxSdept.getFont().deriveFont(comboBoxSdept.getFont().getSize() + 10f));
            comboBoxSdept.setModel(new DefaultComboBoxModel<>(new String[] {
                "--\u8bf7\u9009\u62e9--",
                "\u683c\u5170\u82ac\u591a",
                "\u65af\u83b1\u7279\u6797",
                "\u62c9\u6587\u514b\u52b3",
                "\u8d6b\u5947\u5e15\u5947"
            }));

            //---- textFieldSno ----
            textFieldSno.setFont(textFieldSno.getFont().deriveFont(textFieldSno.getFont().getSize() + 10f));

            //---- textFieldSname ----
            textFieldSname.setFont(textFieldSname.getFont().deriveFont(textFieldSname.getFont().getSize() + 10f));

            //---- comboBoxSsex ----
            comboBoxSsex.setFont(comboBoxSsex.getFont().deriveFont(comboBoxSsex.getFont().getSize() + 10f));
            comboBoxSsex.setModel(new DefaultComboBoxModel<>(new String[] {
                "--\u8bf7\u9009\u62e9--",
                "\u7537",
                "\u5973"
            }));

            //---- buttonDelete ----
            buttonDelete.setFont(buttonDelete.getFont().deriveFont(buttonDelete.getFont().getSize() + 11f));
            buttonDelete.setText(bundle.getString("Updateframe.buttonDelete.text"));
            buttonDelete.addActionListener(e -> deleteStuMess(e));

            //---- label6 ----
            label6.setText(bundle.getString("Updateframe.label6.text"));
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 10f));

            //---- textFieldSage ----
            textFieldSage.setFont(textFieldSage.getFont().deriveFont(textFieldSage.getFont().getSize() + 10f));

            //---- label7 ----
            label7.setText(bundle.getString("Updateframe.label7.text"));
            label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 10f));

            //---- label8 ----
            label8.setText(bundle.getString("Updateframe.label8.text"));
            label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 10f));

            //---- label9 ----
            label9.setText(bundle.getString("Updateframe.label9.text"));
            label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 10f));

            //---- label10 ----
            label10.setText(bundle.getString("Updateframe.label10.text"));
            label10.setFont(label10.getFont().deriveFont(label10.getFont().getSize() + 10f));

            //---- label11 ----
            label11.setText(bundle.getString("Updateframe.label11.text"));
            label11.setFont(label11.getFont().deriveFont(label11.getFont().getSize() + 10f));

            //---- label12 ----
            label12.setText(bundle.getString("Updateframe.label12.text"));
            label12.setFont(label12.getFont().deriveFont(label12.getFont().getSize() + 10f));

            //---- comboBoxSdept2 ----
            comboBoxSdept2.setFont(comboBoxSdept2.getFont().deriveFont(comboBoxSdept2.getFont().getSize() + 10f));
            comboBoxSdept2.setModel(new DefaultComboBoxModel<>(new String[] {
                "--\u8bf7\u9009\u62e9--",
                "\u683c\u5170\u82ac\u591a",
                "\u65af\u83b1\u7279\u6797",
                "\u62c9\u6587\u514b\u52b3",
                "\u8d6b\u5947\u5e15\u5947"
            }));

            //---- textFieldSno2 ----
            textFieldSno2.setFont(textFieldSno2.getFont().deriveFont(textFieldSno2.getFont().getSize() + 10f));

            //---- textFieldSname2 ----
            textFieldSname2.setFont(textFieldSname2.getFont().deriveFont(textFieldSname2.getFont().getSize() + 10f));

            //---- comboBoxSsex2 ----
            comboBoxSsex2.setFont(comboBoxSsex2.getFont().deriveFont(comboBoxSsex2.getFont().getSize() + 10f));
            comboBoxSsex2.setModel(new DefaultComboBoxModel<>(new String[] {
                "--\u8bf7\u9009\u62e9--",
                "\u7537",
                "\u5973"
            }));

            //---- textFieldSage2 ----
            textFieldSage2.setFont(textFieldSage2.getFont().deriveFont(textFieldSage2.getFont().getSize() + 10f));

            //---- label13 ----
            label13.setText(bundle.getString("Updateframe.label13.text"));
            label13.setFont(label13.getFont().deriveFont(label13.getFont().getSize() + 10f));

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addComponent(label7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label1)
                                .addGap(6, 6, 6)
                                .addComponent(textFieldSno, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldSname, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxSsex, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldSage, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxSdept, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollPane2)
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                        .addComponent(label6)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonSelect, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                        .addComponent(label13)
                                        .addGap(6, 6, 6)
                                        .addComponent(label8)
                                        .addGap(6, 6, 6)
                                        .addComponent(textFieldSno2, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                        .addComponent(label9)
                                        .addGap(6, 6, 6)
                                        .addComponent(textFieldSname2, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(label10))
                                    .addComponent(buttonupdate, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addComponent(comboBoxSsex2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                        .addComponent(label11)
                                        .addGap(6, 6, 6)
                                        .addComponent(textFieldSage2, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(label12)
                                        .addGap(6, 6, 6)
                                        .addComponent(comboBoxSdept2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                        .addComponent(buttonDelete, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label7)
                            .addComponent(label1)
                            .addComponent(textFieldSno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2)
                            .addComponent(textFieldSname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3)
                            .addComponent(comboBoxSsex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4)
                            .addComponent(textFieldSage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5)
                            .addComponent(comboBoxSdept, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                            .addComponent(textFieldSno2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldSname2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxSsex2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldSage2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxSdept2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(frame1ContentPaneLayout.createParallelGroup()
                                    .addComponent(label13)
                                    .addComponent(label8)
                                    .addComponent(label9)
                                    .addComponent(label10)
                                    .addComponent(label11)
                                    .addComponent(label12))))
                        .addGap(39, 39, 39)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonSelect)
                            .addComponent(label6)
                            .addComponent(buttonAdd)
                            .addComponent(buttonDelete)
                            .addComponent(buttonupdate))
                        .addContainerGap(60, Short.MAX_VALUE))
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JFrame frame1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JButton buttonupdate;
    private JScrollPane scrollPane2;
    private JTable tableStuMess;
    private JButton buttonAdd;
    private JButton buttonSelect;
    private JComboBox<String> comboBoxSdept;
    private JTextField textFieldSno;
    private JTextField textFieldSname;
    private JComboBox<String> comboBoxSsex;
    private JButton buttonDelete;
    private JLabel label6;
    private JTextField textFieldSage;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JComboBox<String> comboBoxSdept2;
    private JTextField textFieldSno2;
    private JTextField textFieldSname2;
    private JComboBox<String> comboBoxSsex2;
    private JTextField textFieldSage2;
    private JLabel label13;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) {

        new StudentMessframe().frame1.setVisible(true);
    }
}
