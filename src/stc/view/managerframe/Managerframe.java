/*
 * Created by JFormDesigner on Wed Jun 12 22:40:37 CST 2024
 */

package stc.view.managerframe;

import stc.util.IDandPassword;
import stc.view.managerframe.Course.CourseGradeframe;
import stc.view.managerframe.Course.CourseMessframe;
import stc.view.managerframe.Stat.StatCourse;
import stc.view.managerframe.Stat.StatSC;
import stc.view.managerframe.Stat.StatTea;
import stc.view.managerframe.Student.SCmessframe;
import stc.view.managerframe.Student.StudentMessframe;
import stc.view.managerframe.Teacher.TCMessframe;
import stc.view.managerframe.Teacher.TeacherMessframe;
import stc.view.managerframe.User.ManUser;
import stc.view.managerframe.User.UserMan;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author jane
 */
public class Managerframe extends JFrame {
    public Managerframe() {
        initComponents();
    }

    private void StuBaseMess(ActionEvent e) {
        // TODO add your code here
        new StudentMessframe().getFrame1().setVisible(true);
    }

    private void SCmess(ActionEvent e) {
        // TODO add your code here
        new SCmessframe().getFrame2().setVisible(true);
    }

    private void TeacherMess(ActionEvent e) {
        // TODO add your code here
        new TeacherMessframe().getFrame2().setVisible(true);
    }

    private void TCMess(ActionEvent e) {
        // TODO add your code here
        new TCMessframe().getFrame2().setVisible(true);
    }

    private void CourseMess(ActionEvent e) {
        // TODO add your code here
        new CourseMessframe().getFrame2().setVisible(true);
    }

    private void GradeAdd(ActionEvent e) {
        // TODO add your code here
        new CourseGradeframe().getFrame2().setVisible(true);
    }

    private void SCstat(ActionEvent e) {
        // TODO add your code here
        new StatSC().getFrame2().setVisible(true);
    }

    private void CourseStat(ActionEvent e) {
        // TODO add your code here
        new StatCourse().getFrame2().setVisible(true);
    }

    private void TSstat(ActionEvent e) {
        // TODO add your code here
        new StatTea().getFrame2().setVisible(true);
    }

    private void ManagerframeClosing(WindowEvent e) {
        // TODO add your code here
        IDandPassword iDandPassword=new IDandPassword();
        iDandPassword.clearSMID();
    }

    private void Manpassupdate(ActionEvent e) {
        // TODO add your code here
        new ManUser().getFrame1().setVisible(true);
    }

    private void UserManger(ActionEvent e) {
        // TODO add your code here
        new UserMan().getFrame2().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("stc.view.test");
        MJframe = new JFrame();
        menuBar3 = new JMenuBar();
        menu2 = new JMenu();
        menuItem4 = new JMenuItem();
        menuItem1 = new JMenuItem();
        menu3 = new JMenu();
        menuItem6 = new JMenuItem();
        menuItem7 = new JMenuItem();
        menu5 = new JMenu();
        menuItem16 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menu4 = new JMenu();
        menuItem3 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menuItem8 = new JMenuItem();
        menu1 = new JMenu();
        menuItem9 = new JMenuItem();
        menuItem10 = new JMenuItem();
        label1 = new JLabel();

        //======== MJframe ========
        {
            MJframe.setTitle(bundle.getString("MJframe.Managerframe.title"));
            MJframe.setIconImage(new ImageIcon(getClass().getResource("/image/school.jpg")).getImage());
            MJframe.setMinimumSize(new Dimension(1200, 800));
            MJframe.setPreferredSize(new Dimension(1200, 800));
            MJframe.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
            MJframe.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    ManagerframeClosing(e);
                }
            });
            Container MJframeContentPane = MJframe.getContentPane();

            //======== menuBar3 ========
            {

                //======== menu2 ========
                {
                    menu2.setText(bundle.getString("MJframe.menu2.text"));
                    menu2.setFont(menu2.getFont().deriveFont(menu2.getFont().getSize() + 12f));

                    //---- menuItem4 ----
                    menuItem4.setText(bundle.getString("MJframe.menuItem4.text"));
                    menuItem4.setFont(menuItem4.getFont().deriveFont(menuItem4.getFont().getSize() + 8f));
                    menuItem4.addActionListener(e -> StuBaseMess(e));
                    menu2.add(menuItem4);

                    //---- menuItem1 ----
                    menuItem1.setText(bundle.getString("MJframe.menuItem1.text"));
                    menuItem1.setFont(menuItem1.getFont().deriveFont(menuItem1.getFont().getSize() + 8f));
                    menuItem1.addActionListener(e -> SCmess(e));
                    menu2.add(menuItem1);
                }
                menuBar3.add(menu2);

                //======== menu3 ========
                {
                    menu3.setText(bundle.getString("MJframe.menu3.text"));
                    menu3.setFont(menu3.getFont().deriveFont(menu3.getFont().getSize() + 12f));

                    //---- menuItem6 ----
                    menuItem6.setText(bundle.getString("MJframe.menuItem6.text"));
                    menuItem6.setFont(menuItem6.getFont().deriveFont(menuItem6.getFont().getSize() + 8f));
                    menuItem6.addActionListener(e -> TeacherMess(e));
                    menu3.add(menuItem6);

                    //---- menuItem7 ----
                    menuItem7.setText(bundle.getString("MJframe.menuItem7.text"));
                    menuItem7.setFont(menuItem7.getFont().deriveFont(menuItem7.getFont().getSize() + 8f));
                    menuItem7.addActionListener(e -> TCMess(e));
                    menu3.add(menuItem7);
                }
                menuBar3.add(menu3);

                //======== menu5 ========
                {
                    menu5.setText(bundle.getString("MJframe.menu5.text"));
                    menu5.setFont(menu5.getFont().deriveFont(menu5.getFont().getSize() + 12f));

                    //---- menuItem16 ----
                    menuItem16.setText(bundle.getString("MJframe.menuItem16.text"));
                    menuItem16.setFont(menuItem16.getFont().deriveFont(menuItem16.getFont().getSize() + 8f));
                    menuItem16.addActionListener(e -> CourseMess(e));
                    menu5.add(menuItem16);

                    //---- menuItem2 ----
                    menuItem2.setText(bundle.getString("MJframe.menuItem2.text"));
                    menuItem2.setFont(menuItem2.getFont().deriveFont(menuItem2.getFont().getSize() + 8f));
                    menuItem2.addActionListener(e -> GradeAdd(e));
                    menu5.add(menuItem2);
                }
                menuBar3.add(menu5);

                //======== menu4 ========
                {
                    menu4.setText(bundle.getString("Managerframe.menu4.text"));
                    menu4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));

                    //---- menuItem3 ----
                    menuItem3.setText(bundle.getString("Managerframe.menuItem3.text"));
                    menuItem3.setFont(menuItem3.getFont().deriveFont(menuItem3.getFont().getSize() + 8f));
                    menuItem3.addActionListener(e -> SCstat(e));
                    menu4.add(menuItem3);

                    //---- menuItem5 ----
                    menuItem5.setText(bundle.getString("Managerframe.menuItem5.text"));
                    menuItem5.setFont(menuItem5.getFont().deriveFont(menuItem5.getFont().getSize() + 8f));
                    menuItem5.addActionListener(e -> CourseStat(e));
                    menu4.add(menuItem5);

                    //---- menuItem8 ----
                    menuItem8.setText(bundle.getString("Managerframe.menuItem8.text"));
                    menuItem8.setFont(menuItem8.getFont().deriveFont(menuItem8.getFont().getSize() + 8f));
                    menuItem8.addActionListener(e -> TSstat(e));
                    menu4.add(menuItem8);
                }
                menuBar3.add(menu4);

                //======== menu1 ========
                {
                    menu1.setText(bundle.getString("MJframe.menu1.text"));
                    menu1.setFont(menu1.getFont().deriveFont(menu1.getFont().getSize() + 12f));

                    //---- menuItem9 ----
                    menuItem9.setText(bundle.getString("Managerframe.menuItem9.text"));
                    menuItem9.setFont(menuItem9.getFont().deriveFont(menuItem9.getFont().getSize() + 8f));
                    menuItem9.addActionListener(e -> Manpassupdate(e));
                    menu1.add(menuItem9);

                    //---- menuItem10 ----
                    menuItem10.setText(bundle.getString("Managerframe.menuItem10.text"));
                    menuItem10.setFont(menuItem10.getFont().deriveFont(menuItem10.getFont().getSize() + 8f));
                    menuItem10.addActionListener(e -> UserManger(e));
                    menu1.add(menuItem10);
                }
                menuBar3.add(menu1);
            }
            MJframe.setJMenuBar(menuBar3);

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/image/hogwarts.jpg")));

            GroupLayout MJframeContentPaneLayout = new GroupLayout(MJframeContentPane);
            MJframeContentPaneLayout.setHonorsVisibility(false);
            MJframeContentPane.setLayout(MJframeContentPaneLayout);
            MJframeContentPaneLayout.setHorizontalGroup(
                MJframeContentPaneLayout.createParallelGroup()
                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
            );
            MJframeContentPaneLayout.setVerticalGroup(
                MJframeContentPaneLayout.createParallelGroup()
                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
            );
            MJframe.pack();
            MJframe.setLocationRelativeTo(MJframe.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    public JFrame getMJframe() {
        return MJframe;
    }

    public void setMJframe(JFrame MJframe) {
        this.MJframe = MJframe;
    }// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JFrame MJframe;
    private JMenuBar menuBar3;
    private JMenu menu2;
    private JMenuItem menuItem4;
    private JMenuItem menuItem1;
    private JMenu menu3;
    private JMenuItem menuItem6;
    private JMenuItem menuItem7;
    private JMenu menu5;
    private JMenuItem menuItem16;
    private JMenuItem menuItem2;
    private JMenu menu4;
    private JMenuItem menuItem3;
    private JMenuItem menuItem5;
    private JMenuItem menuItem8;
    private JMenu menu1;
    private JMenuItem menuItem9;
    private JMenuItem menuItem10;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) {

        new Managerframe().MJframe.setVisible(true);
    }
}
