/*
 * Created by JFormDesigner on Thu Jun 13 22:58:27 CST 2024
 */

package stc.view.managerframe.Teacher;

import stc.dao.TeacherDao;
import stc.entity.Teacher;

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
public class TeacherMessframe extends JFrame {
    public TeacherMessframe() {
        initComponents();
    }

    private void AddTeaMess(ActionEvent e) {
        // TODO add your code here
    }

    private void AddTea(ActionEvent e) {
        // TODO add your code here
        new AddTeaframe().getFrame1().setVisible(true);

    }

    public void fillTable(List<? extends Teacher> ttumess) {
        //TO DO
        DefaultTableModel ttdm = (DefaultTableModel) tableTeaMess.getModel();
        if (ttumess.isEmpty()) {
            ttdm.setRowCount(0);//设置为0行
        } else {
            ttdm.setRowCount(0);//设置为0行
            for (Teacher ttum : ttumess) {
                Vector v = new Vector<>();
                v.add(ttdm.getRowCount() + 1);//序号
                v.add(ttum.getTNO());
                v.add(ttum.getTNAME());
                v.add(ttum.getTETITLE());
                v.add(ttum.getTSALARY());
                ttdm.addRow(v);
            }
        }
    }

    private void selectTeaMess(ActionEvent e) {
        // TODO add your code here
        //创建学生类以接收填入的信息
        Teacher teacher=new Teacher();
        teacher.setTNO(textFieldTno.getText());
        teacher.setTNAME(textFieldTname.getText());
        //获取职称
        if(comboBoxTetile.getSelectedItem().toString()=="--请选择--"){
            teacher.setTETITLE(null);
        }
        else {
            teacher.setTETITLE(comboBoxTetile.getSelectedItem().toString());
        }
        //调用dao实现查询
        TeacherDao studentDao=new TeacherDao();
        List<? extends Teacher> ttudata=studentDao.queryTeaMess(teacher);
        //将数据放入表格
        if(!ttudata.isEmpty()){
            fillTable(ttudata);
        }
        else{
            fillTable(ttudata);
            JOptionPane.showMessageDialog(TeacherMessframe.this, "查询失败！请检查输入条件！");
        }
    }

    private void updateTeamess(ActionEvent e) {
        // TODO add your code here
        //创建教师类接收信息
        Teacher teacher =new Teacher();
        teacher.setTNO(textFieldTno2.getText());
        teacher.setTNAME(textFieldTname2.getText());
        if(comboBoxTetile2.getSelectedItem()=="--请选择--"){
            teacher.setTETITLE(null);
        }else{
            teacher.setTETITLE((String) comboBoxTetile2.getSelectedItem());
        }
        teacher.setTSALARY(textFieldTSalary.getText());
        //创建DAO类完成数据库操作
        TeacherDao teacherDao=new TeacherDao();
        boolean isok=teacherDao.ManUpdateTeacher(teacher);
        if(isok)
        {
            JOptionPane.showMessageDialog(this,"教师基本信息修改成功！");
        } else{
            JOptionPane.showMessageDialog(this,"修改失败！请检查输入信息！");
        }
    }

    private void deleteTeaMess(ActionEvent e) {
        // TODO add your code here
        //创建教师类接收信息
        Teacher teacher =new Teacher();
        teacher.setTNO(textFieldTno2.getText());
        //创建DAO类完成数据库操作
        TeacherDao teacherDao=new TeacherDao();
        boolean isok=teacherDao.DeleteTeacher(teacher);
        if(isok) {
            JOptionPane.showMessageDialog(this,"教师信息删除成功！");
        } else{
            JOptionPane.showMessageDialog(this,"教师信息删除失败！");
        }
    }

    private void tableTeaMessMousePressed(MouseEvent e) {
        // TODO add your code here
        int row=tableTeaMess.getSelectedRow();
        textFieldTno2.setEnabled(false);
        textFieldTno2.setText((String) tableTeaMess.getValueAt(row,1));
        textFieldTname2.setText((String) tableTeaMess.getValueAt(row,2));
        textFieldTSalary.setText((String) tableTeaMess.getValueAt(row,4));
        String Title = (String) tableTeaMess.getValueAt(row,3);
        //为空报错
        switch (Title) {
            case "教授":
                comboBoxTetile2.setSelectedIndex(1);
                break;
            case "副教授":
                comboBoxTetile2.setSelectedIndex(2);
                break;
            case "讲师":
                comboBoxTetile2.setSelectedIndex(3);
                break;
            case "助教":
                comboBoxTetile2.setSelectedIndex(4);
                break;
            default:
                comboBoxTetile2.setSelectedIndex(0);
                break;
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("stc.view.test");
        frame2 = new JFrame();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        scrollPane2 = new JScrollPane();
        tableTeaMess = new JTable();
        buttonDelete = new JButton();
        buttonSelect = new JButton();
        textFieldTno = new JTextField();
        textFieldTname = new JTextField();
        comboBoxTetile = new JComboBox<>();
        buttonAdd = new JButton();
        label5 = new JLabel();
        buttonUpdate = new JButton();
        label6 = new JLabel();
        label4 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        textFieldTno2 = new JTextField();
        textFieldTname2 = new JTextField();
        comboBoxTetile2 = new JComboBox<>();
        label9 = new JLabel();
        textFieldTSalary = new JTextField();
        label10 = new JLabel();

        //======== frame2 ========
        {
            frame2.setIconImage(new ImageIcon(getClass().getResource("/image/school.jpg")).getImage());
            frame2.setTitle(bundle.getString("TeacherMess.frame2.title"));
            frame2.setFont(new Font(Font.DIALOG, Font.PLAIN, 40));
            frame2.setMinimumSize(new Dimension(1050, 900));
            frame2.setPreferredSize(new Dimension(1050, 900));
            Container frame2ContentPane = frame2.getContentPane();

            //---- label1 ----
            label1.setText(bundle.getString("TeacherMess.label1.text"));
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));

            //---- label2 ----
            label2.setText(bundle.getString("TeacherMess.label2.text"));
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 10f));

            //---- label3 ----
            label3.setText(bundle.getString("TeacherMess.label3.text"));
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 10f));

            //======== scrollPane2 ========
            {

                //---- tableTeaMess ----
                tableTeaMess.setFont(tableTeaMess.getFont().deriveFont(tableTeaMess.getFont().getSize() + 12f));
                tableTeaMess.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "\u5e8f\u53f7", "\u5de5\u53f7", "\u59d3\u540d", "\u804c\u79f0", "\u5de5\u8d44"
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
                    TableColumnModel cm = tableTeaMess.getColumnModel();
                    cm.getColumn(1).setPreferredWidth(50);
                }
                tableTeaMess.setAlignmentX(10.0F);
                tableTeaMess.setAlignmentY(7.0F);
                tableTeaMess.setRowHeight(50);
                tableTeaMess.setRowMargin(0);
                tableTeaMess.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        tableTeaMessMousePressed(e);
                    }
                });
                scrollPane2.setViewportView(tableTeaMess);
            }

            //---- buttonDelete ----
            buttonDelete.setFont(buttonDelete.getFont().deriveFont(buttonDelete.getFont().getSize() + 11f));
            buttonDelete.setText(bundle.getString("TeacherMess.buttonDelete.text"));
            buttonDelete.addActionListener(e -> deleteTeaMess(e));

            //---- buttonSelect ----
            buttonSelect.setFont(buttonSelect.getFont().deriveFont(buttonSelect.getFont().getSize() + 11f));
            buttonSelect.setText(bundle.getString("TeacherMess.buttonSelect.text"));
            buttonSelect.addActionListener(e -> selectTeaMess(e));

            //---- textFieldTno ----
            textFieldTno.setFont(textFieldTno.getFont().deriveFont(textFieldTno.getFont().getSize() + 10f));

            //---- textFieldTname ----
            textFieldTname.setFont(textFieldTname.getFont().deriveFont(textFieldTname.getFont().getSize() + 10f));

            //---- comboBoxTetile ----
            comboBoxTetile.setFont(comboBoxTetile.getFont().deriveFont(comboBoxTetile.getFont().getSize() + 10f));
            comboBoxTetile.setModel(new DefaultComboBoxModel<>(new String[] {
                "--\u8bf7\u9009\u62e9--",
                "\u6559\u6388",
                "\u526f\u6559\u6388",
                "\u8bb2\u5e08",
                "\u52a9\u6559"
            }));

            //---- buttonAdd ----
            buttonAdd.setFont(buttonAdd.getFont().deriveFont(buttonAdd.getFont().getSize() + 11f));
            buttonAdd.setText(bundle.getString("TeacherMess.buttonAdd.text"));
            buttonAdd.addActionListener(e -> AddTea(e));

            //---- label5 ----
            label5.setText(bundle.getString("TeacherMess.label5.text"));
            label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 10f));

            //---- buttonUpdate ----
            buttonUpdate.setFont(buttonUpdate.getFont().deriveFont(buttonUpdate.getFont().getSize() + 11f));
            buttonUpdate.setText(bundle.getString("TeacherMess.buttonUpdate.text"));
            buttonUpdate.addActionListener(e -> updateTeamess(e));

            //---- label6 ----
            label6.setText(bundle.getString("TeacherMess.label6.text"));
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 10f));

            //---- label4 ----
            label4.setText(bundle.getString("TeacherMess.label4.text"));
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 10f));

            //---- label7 ----
            label7.setText(bundle.getString("TeacherMess.label7.text"));
            label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 10f));

            //---- label8 ----
            label8.setText(bundle.getString("TeacherMess.label8.text"));
            label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 10f));

            //---- textFieldTno2 ----
            textFieldTno2.setFont(textFieldTno2.getFont().deriveFont(textFieldTno2.getFont().getSize() + 10f));

            //---- textFieldTname2 ----
            textFieldTname2.setFont(textFieldTname2.getFont().deriveFont(textFieldTname2.getFont().getSize() + 10f));

            //---- comboBoxTetile2 ----
            comboBoxTetile2.setFont(comboBoxTetile2.getFont().deriveFont(comboBoxTetile2.getFont().getSize() + 10f));
            comboBoxTetile2.setModel(new DefaultComboBoxModel<>(new String[] {
                "--\u8bf7\u9009\u62e9--",
                "\u6559\u6388",
                "\u526f\u6559\u6388",
                "\u8bb2\u5e08",
                "\u52a9\u6559"
            }));

            //---- label9 ----
            label9.setText(bundle.getString("TeacherMess.label9.text"));
            label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 10f));

            //---- textFieldTSalary ----
            textFieldTSalary.setFont(textFieldTSalary.getFont().deriveFont(textFieldTSalary.getFont().getSize() + 10f));

            //---- label10 ----
            label10.setText(bundle.getString("TeacherMess.label10.text"));
            label10.setFont(label10.getFont().deriveFont(label10.getFont().getSize() + 10f));

            GroupLayout frame2ContentPaneLayout = new GroupLayout(frame2ContentPane);
            frame2ContentPane.setLayout(frame2ContentPaneLayout);
            frame2ContentPaneLayout.setHorizontalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup()
                            .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                .addComponent(label1)
                                .addGap(18, 18, 18)
                                .addComponent(label6)
                                .addGap(18, 18, 18)
                                .addComponent(textFieldTno, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(label2)
                                .addGap(18, 18, 18)
                                .addComponent(textFieldTname, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(label3)
                                .addGap(18, 18, 18)
                                .addComponent(comboBoxTetile, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
                            .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                .addGroup(frame2ContentPaneLayout.createParallelGroup()
                                    .addComponent(label4)
                                    .addComponent(label5))
                                .addGap(32, 32, 32)
                                .addComponent(label9)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(buttonSelect, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldTno2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(label7)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldTname2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(label8)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(comboBoxTetile2, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                        .addGap(97, 97, 97)
                                        .addComponent(buttonUpdate, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonDelete, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addGroup(frame2ContentPaneLayout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, frame2ContentPaneLayout.createSequentialGroup()
                                        .addComponent(label10)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textFieldTSalary, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(buttonAdd, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                            .addComponent(scrollPane2, GroupLayout.Alignment.TRAILING))
                        .addGap(68, 68, 68))
            );
            frame2ContentPaneLayout.setVerticalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1)
                            .addComponent(label6)
                            .addComponent(textFieldTno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldTname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2)
                            .addComponent(comboBoxTetile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3))
                        .addGap(60, 60, 60)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(textFieldTSalary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label10)
                            .addComponent(comboBoxTetile2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label8)
                            .addComponent(textFieldTname2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label7)
                            .addComponent(textFieldTno2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label9))
                        .addGap(36, 36, 36)
                        .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(buttonAdd)
                            .addComponent(buttonDelete)
                            .addComponent(buttonSelect)
                            .addComponent(buttonUpdate))
                        .addContainerGap(72, Short.MAX_VALUE))
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
    private JLabel label3;
    private JScrollPane scrollPane2;
    private JTable tableTeaMess;
    private JButton buttonDelete;
    private JButton buttonSelect;
    private JTextField textFieldTno;
    private JTextField textFieldTname;
    private JComboBox<String> comboBoxTetile;
    private JButton buttonAdd;
    private JLabel label5;
    private JButton buttonUpdate;
    private JLabel label6;
    private JLabel label4;
    private JLabel label7;
    private JLabel label8;
    private JTextField textFieldTno2;
    private JTextField textFieldTname2;
    private JComboBox<String> comboBoxTetile2;
    private JLabel label9;
    private JTextField textFieldTSalary;
    private JLabel label10;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) {

        new TeacherMessframe().frame2.setVisible(true);
    }
}
