/*
 * Created by JFormDesigner on Wed Jun 12 23:04:29 CST 2024
 */

package stc.view.studentframe;

import stc.util.IDandPassword;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author jane
 */
public class Studentframe {
    public Studentframe() {
        initComponents();
    }

    private void SelectCourse(ActionEvent e) {
        // TODO add your code here
        //Jframe.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);    // 设置模式类型。
        new SCselect().getFrame2().setVisible(true);
    }

    private void GradeStu(ActionEvent e) {
        // TODO add your code here
        new SCGframe().getFrame2().setVisible(true);
    }

    private void Stupassword(ActionEvent e) {
        // TODO add your code here
        new StuUser().getFrame1().setVisible(true);
    }

    private void StuBaseMess(ActionEvent e) {
        // TODO add your code here
        new StuMessframe().getFrame1().setVisible(true);
    }

    private void StudentframeClosing(WindowEvent e) {
        // TODO add your code here
        IDandPassword iDandPassword=new IDandPassword();
        iDandPassword.clearSMID();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("stc.view.test");
        Jframe = new JFrame();
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menu2 = new JMenu();
        menuItem4 = new JMenuItem();
        SnameMenu = new JMenu();
        menuItem5 = new JMenuItem();
        label1 = new JLabel();

        //======== Jframe ========
        {
            Jframe.setIconImage(new ImageIcon(getClass().getResource("/image/school.jpg")).getImage());
            Jframe.setTitle(bundle.getString("Studentframe.Jframe.title"));
            Jframe.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
            Jframe.setMinimumSize(new Dimension(1250, 770));
            Jframe.setPreferredSize(new Dimension(1250, 770));
            Jframe.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    StudentframeClosing(e);
                }
            });
            Container JframeContentPane = Jframe.getContentPane();

            //======== menuBar1 ========
            {

                //======== menu1 ========
                {
                    menu1.setText(bundle.getString("Studentframe.menu1.text"));
                    menu1.setFont(menu1.getFont().deriveFont(menu1.getFont().getSize() + 12f));

                    //---- menuItem1 ----
                    menuItem1.setText(bundle.getString("Studentframe.menuItem1.text"));
                    menuItem1.setFont(menuItem1.getFont().deriveFont(menuItem1.getFont().getSize() + 10f));
                    menuItem1.addActionListener(e -> SelectCourse(e));
                    menu1.add(menuItem1);

                    //---- menuItem2 ----
                    menuItem2.setText(bundle.getString("Studentframe.menuItem2.text"));
                    menuItem2.setFont(menuItem2.getFont().deriveFont(menuItem2.getFont().getSize() + 10f));
                    menuItem2.addActionListener(e -> GradeStu(e));
                    menu1.add(menuItem2);
                }
                menuBar1.add(menu1);

                //======== menu2 ========
                {
                    menu2.setText(bundle.getString("Studentframe.menu2.text"));
                    menu2.setFont(menu2.getFont().deriveFont(menu2.getFont().getSize() + 12f));

                    //---- menuItem4 ----
                    menuItem4.setText(bundle.getString("Studentframe.menuItem4.text"));
                    menuItem4.setFont(menuItem4.getFont().deriveFont(menuItem4.getFont().getSize() + 8f));
                    menuItem4.addActionListener(e -> StuBaseMess(e));
                    menu2.add(menuItem4);
                }
                menuBar1.add(menu2);

                //======== SnameMenu ========
                {
                    SnameMenu.setText(bundle.getString("Studentframe.SnameMenu.text"));
                    SnameMenu.setFont(SnameMenu.getFont().deriveFont(SnameMenu.getFont().getSize() + 12f));

                    //---- menuItem5 ----
                    menuItem5.setText(bundle.getString("Studentframe.menuItem5.text"));
                    menuItem5.setFont(menuItem5.getFont().deriveFont(menuItem5.getFont().getSize() + 8f));
                    menuItem5.addActionListener(e -> Stupassword(e));
                    SnameMenu.add(menuItem5);
                }
                menuBar1.add(SnameMenu);
            }
            Jframe.setJMenuBar(menuBar1);

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/image/\u5fae\u4fe1\u56fe\u7247_20240610201613.jpg")));

            GroupLayout JframeContentPaneLayout = new GroupLayout(JframeContentPane);
            JframeContentPane.setLayout(JframeContentPaneLayout);
            JframeContentPaneLayout.setHorizontalGroup(
                JframeContentPaneLayout.createParallelGroup()
                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
            );
            JframeContentPaneLayout.setVerticalGroup(
                JframeContentPaneLayout.createParallelGroup()
                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
            );
            Jframe.pack();
            Jframe.setLocationRelativeTo(Jframe.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    public JMenu getSnameMenu() {
        return SnameMenu;
    }
    public JFrame getJframe() {
        return Jframe;
    }// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JFrame Jframe;
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenu menu2;
    private JMenuItem menuItem4;
    private JMenu SnameMenu;
    private JMenuItem menuItem5;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args) {

        new Studentframe().Jframe.setVisible(true);
    }
}
