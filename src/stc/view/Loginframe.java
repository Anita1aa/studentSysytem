/*
 * Created by JFormDesigner on Tue Jun 11 12:37:43 CST 2024
 */

package stc.view;

import stc.dao.Userdao;
import stc.util.IDandPassword;
import stc.view.managerframe.Managerframe;
import stc.view.studentframe.Studentframe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
//import javax.swing.border.*;
//import com.jgoodies.forms.factories.*;

/**
 * @author jane
 */
public class Loginframe extends JFrame {
    public Loginframe() {
        initComponents();
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void loginbutton(ActionEvent e) {
        // TODO add your code here
        //获取账号密码权限
        String usernameText = Jusername.getText();
        String userpassword = new String(Jpassword.getPassword());
        if (!radioButton4.isSelected() && !radioButton5.isSelected()) {
            JOptionPane.showMessageDialog(Loginframe.this, "请选择身份！");
        } else {
            Userdao userdao = new Userdao();
            boolean isok = false;
            if (radioButton4.isSelected()) {
                //管理员
                isok = userdao.loginManager(usernameText, userpassword);
                //调用DAO实现登录
                if (isok) {
                    //System.out.println("登录成功");
                    //关闭当前窗口打开管理界面
                    setVisible(false);
                    new Managerframe().getMJframe().setVisible(true);
                } else {
                    //System.out.println("登录失败");
                    JOptionPane.showMessageDialog(Loginframe.this, "用户名或密码或身份有误！");
                }
            } else if (radioButton5.isSelected()) {
                //学生
                isok= userdao.loginStudent(usernameText, userpassword);
                //调用DAO实现登录
                if (isok) {
                    //System.out.println("登录成功");
                    //关闭当前窗口打开学生界面
                    setVisible(false);
                    new Studentframe().getJframe().setVisible(true);
                } else {
                    //System.out.println("登录失败");
                    JOptionPane.showMessageDialog(Loginframe.this, "用户名或密码或身份有误！");
                }
            }
        }
    }

    private void cencellogin(ActionEvent e) {
        // TODO add your code here
        System.exit(0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("stc.view.test");
        layeredPane1 = new JLayeredPane();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        label10 = new JLabel();
        panel7 = new JPanel();
        panel12 = new JPanel();
        panel8 = new JPanel();
        panel9 = new JPanel();
        panel13 = new JPanel();
        label9 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        panel14 = new JPanel();
        panel15 = new JPanel();
        panel16 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        panel17 = new JPanel();
        Jusername = new JTextField();
        Jpassword = new JPasswordField();
        panel18 = new JPanel();
        radioButton4 = new JRadioButton();
        radioButton5 = new JRadioButton();
        panel2 = new JPanel();
        label2 = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(550, 680));
        setPreferredSize(new Dimension(500, 600));
        setMaximumSize(new Dimension(550, 680));
        setAlwaysOnTop(true);
        setTitle(bundle.getString("test5.this.title"));
        setIconImage(new ImageIcon(getClass().getResource("/image/school.jpg")).getImage());
        setResizable(false);
        setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(400, 300));

        //======== layeredPane1 ========
        {
            layeredPane1.setPreferredSize(new Dimension(1000, 500));
            layeredPane1.setOpaque(true);

            //======== panel4 ========
            {
                panel4.setOpaque(false);
                panel4.setLayout(new BorderLayout(10, 10));

                //======== panel5 ========
                {
                    panel5.setOpaque(false);
                    panel5.setLayout(new FlowLayout());
                }
                panel4.add(panel5, BorderLayout.WEST);

                //======== panel6 ========
                {
                    panel6.setOpaque(false);
                    panel6.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

                    //---- label10 ----
                    label10.setText(bundle.getString("test5.label10.text"));
                    label10.setFont(label10.getFont().deriveFont(label10.getFont().getStyle() | Font.BOLD, label10.getFont().getSize() + 25f));
                    panel6.add(label10);
                }
                panel4.add(panel6, BorderLayout.NORTH);

                //======== panel7 ========
                {
                    panel7.setOpaque(false);
                    panel7.setLayout(new FlowLayout());

                    //======== panel12 ========
                    {
                        panel12.setOpaque(false);
                        panel12.setLayout(new GridLayout());
                    }
                    panel7.add(panel12);
                }
                panel4.add(panel7, BorderLayout.EAST);

                //======== panel8 ========
                {
                    panel8.setOpaque(false);
                    panel8.setLayout(new FlowLayout());
                }
                panel4.add(panel8, BorderLayout.SOUTH);

                //======== panel9 ========
                {
                    panel9.setOpaque(false);
                    panel9.setLayout(new BorderLayout());

                    //======== panel13 ========
                    {
                        panel13.setOpaque(false);
                        panel13.setLayout(new GridLayout(3, 1, 30, 30));

                        //---- label9 ----
                        label9.setText(bundle.getString("test5.label9.text"));
                        label9.setFont(label9.getFont().deriveFont(label9.getFont().getStyle() | Font.BOLD, label9.getFont().getSize() + 10f));
                        label9.setAlignmentX(500.0F);
                        label9.setAlignmentY(500.0F);
                        panel13.add(label9);

                        //---- label7 ----
                        label7.setText(bundle.getString("test5.label7.text"));
                        label7.setFont(label7.getFont().deriveFont(label7.getFont().getStyle() | Font.BOLD, label7.getFont().getSize() + 10f));
                        panel13.add(label7);

                        //---- label8 ----
                        label8.setText(bundle.getString("test5.label8.text"));
                        label8.setFont(label8.getFont().deriveFont(label8.getFont().getStyle() | Font.BOLD, label8.getFont().getSize() + 10f));
                        panel13.add(label8);
                    }
                    panel9.add(panel13, BorderLayout.WEST);

                    //======== panel14 ========
                    {
                        panel14.setOpaque(false);
                        panel14.setLayout(new FlowLayout());
                    }
                    panel9.add(panel14, BorderLayout.NORTH);

                    //======== panel15 ========
                    {
                        panel15.setOpaque(false);
                        panel15.setLayout(new FlowLayout());
                    }
                    panel9.add(panel15, BorderLayout.EAST);

                    //======== panel16 ========
                    {
                        panel16.setOpaque(false);
                        panel16.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 25));

                        //---- button1 ----
                        button1.setText(bundle.getString("test5.button1.text"));
                        button1.setOpaque(false);
                        button1.setFont(button1.getFont().deriveFont(button1.getFont().getStyle() | Font.BOLD, button1.getFont().getSize() + 12f));
                        button1.addActionListener(e -> loginbutton(e));
                        panel16.add(button1);

                        //---- button2 ----
                        button2.setText(bundle.getString("test5.button2.text"));
                        button2.setFont(button2.getFont().deriveFont(button2.getFont().getStyle() | Font.BOLD, button2.getFont().getSize() + 12f));
                        button2.setOpaque(false);
                        button2.addActionListener(e -> cencellogin(e));
                        panel16.add(button2);
                    }
                    panel9.add(panel16, BorderLayout.SOUTH);

                    //======== panel17 ========
                    {
                        panel17.setOpaque(false);
                        panel17.setLayout(new GridLayout(3, 1, 30, 30));

                        //---- Jusername ----
                        Jusername.setMinimumSize(new Dimension(40, 34));
                        Jusername.setPreferredSize(new Dimension(40, 34));
                        Jusername.setFont(Jusername.getFont().deriveFont(Jusername.getFont().getStyle() | Font.BOLD, Jusername.getFont().getSize() + 5f));
                        panel17.add(Jusername);

                        //---- Jpassword ----
                        Jpassword.setFont(Jpassword.getFont().deriveFont(Jpassword.getFont().getStyle() | Font.BOLD, Jpassword.getFont().getSize() + 5f));
                        panel17.add(Jpassword);

                        //======== panel18 ========
                        {
                            panel18.setOpaque(false);
                            panel18.setLayout(new GridLayout(1, 2));

                            //---- radioButton4 ----
                            radioButton4.setText(bundle.getString("test5.radioButton4.text"));
                            radioButton4.setFont(radioButton4.getFont().deriveFont(radioButton4.getFont().getStyle() | Font.BOLD, radioButton4.getFont().getSize() + 8f));
                            radioButton4.setOpaque(false);
                            radioButton4.setForeground(Color.white);
                            panel18.add(radioButton4);

                            //---- radioButton5 ----
                            radioButton5.setText(bundle.getString("test5.radioButton5.text"));
                            radioButton5.setFont(radioButton5.getFont().deriveFont(radioButton5.getFont().getStyle() | Font.BOLD, radioButton5.getFont().getSize() + 8f));
                            radioButton5.setOpaque(false);
                            radioButton5.setForeground(Color.white);
                            panel18.add(radioButton5);
                        }
                        panel17.add(panel18);
                    }
                    panel9.add(panel17, BorderLayout.CENTER);
                }
                panel4.add(panel9, BorderLayout.CENTER);
            }
            layeredPane1.add(panel4, JLayeredPane.DRAG_LAYER);
            panel4.setBounds(40, 105, 470, 435);

            //======== panel2 ========
            {
                panel2.setPreferredSize(null);
                panel2.setLayout(null);

                //---- label2 ----
                label2.setIcon(new ImageIcon(getClass().getResource("/image/hogwarts.jpg")));
                label2.setPreferredSize(null);
                label2.setOpaque(true);
                label2.setFocusTraversalPolicyProvider(true);
                panel2.add(label2);
                label2.setBounds(0, 0, label2.getPreferredSize().width, 665);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel2.getComponentCount(); i++) {
                        Rectangle bounds = panel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel2.setMinimumSize(preferredSize);
                    panel2.setPreferredSize(preferredSize);
                }
            }
            layeredPane1.add(panel2, JLayeredPane.DEFAULT_LAYER);
            panel2.setBounds(new Rectangle(new Point(0, 0), panel2.getPreferredSize()));
        }
        contentPane.add(layeredPane1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton4);
        buttonGroup1.add(radioButton5);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLayeredPane layeredPane1;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JLabel label10;
    private JPanel panel7;
    private JPanel panel12;
    private JPanel panel8;
    private JPanel panel9;
    private JPanel panel13;
    private JLabel label9;
    private JLabel label7;
    private JLabel label8;
    private JPanel panel14;
    private JPanel panel15;
    private JPanel panel16;
    private JButton button1;
    private JButton button2;
    private JPanel panel17;
    private JTextField Jusername;
    private JPasswordField Jpassword;
    private JPanel panel18;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JPanel panel2;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) {

        Loginframe loginframe=new Loginframe();
        loginframe.setVisible(true);
    }
}
