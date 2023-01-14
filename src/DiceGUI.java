import cn.hutool.core.util.RandomUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DiceGUI
{
    private JPanel panel;
    private JTextField left_first;
    private JTextField left_second;
    private JTextField right_first;
    private JTextField right_second;
    private JTextField left_sum;
    private JTextField left_name;
    private JButton left_login;
    private JButton left_start;
    private JButton left_show_history;
    private JTextField right_sum;
    private JTextField right_name;
    private JButton right_login;
    private JButton right_start;
    private JButton right_show_history;
    private JTextField result;
    private JTextArea left_history;
    private JTextArea right_history;
    private JButton left_logout;
    private JButton right_logout;

    public DiceGUI()
    {
        left_start.addActionListener(new ActionListener()
        {
            Random_roll left_roll = new Random_roll(left_first, left_second, left_sum, left_start, right_start, result, left_sum, right_sum, left_name, right_name);

            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource() == left_start)
                {
                    Thread left_roll_thread = new Thread(left_roll);
                    left_roll_thread.start();
                }
            }
        });
        right_start.addActionListener(new ActionListener()
        {
            Random_roll right_roll = new Random_roll(right_first, right_second, right_sum, right_start, left_start, result, left_sum, right_sum, left_name, right_name);

            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource() == right_start)
                {
                    Thread right_roll_thread = new Thread(right_roll);
                    right_roll_thread.start();
                }
            }
        });
        left_login.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource() == left_login)
                {
                    Login left_login_process = new Login(left_name, left_login, left_start, left_show_history, panel);
                    Thread left_login_thread = new Thread(left_login_process);
                    left_login_thread.start();
                }
            }
        });
        right_login.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource() == right_login)
                {
                    Login right_login_process = new Login(right_name, right_login, right_start, right_show_history, panel);
                    Thread right_login_thread = new Thread(right_login_process);
                    right_login_thread.start();
                }
            }
        });
        left_logout.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource() == left_logout)
                {
                    left_first.setText("");
                    left_second.setText("");
                    left_sum.setText("");
                    left_name.setText("");
                    left_history.setText("");
                    left_name.setEnabled(true);
                    left_login.setEnabled(true);
                    left_start.setEnabled(false);
                    left_show_history.setEnabled(false);
                }
            }
        });
        right_logout.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource() == right_logout)
                {
                    right_first.setText("");
                    right_second.setText("");
                    right_sum.setText("");
                    right_name.setText("");
                    right_history.setText("");
                    right_name.setEnabled(true);
                    right_login.setEnabled(true);
                    right_start.setEnabled(false);
                    right_show_history.setEnabled(false);
                }
            }
        });
        left_show_history.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource() == left_show_history)
                {
                    History history = new History(left_name, left_history);
                    Thread history_thread = new Thread(history);
                    history_thread.start();
                }
            }
        });
        right_show_history.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource() == right_show_history)
                {
                    History history = new History(right_name, right_history);
                    Thread history_thread = new Thread(history);
                    history_thread.start();
                }
            }
        });
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("双人骰子游戏");
        frame.setContentPane(new DiceGUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBounds(500, 300, 1000, 400);
        frame.setVisible(true);
        //初始化数据库连接，方便后续操作
        try
        {
            List<Entity> users = Db.use().findAll(Entity.create("user").set("username", "admin"));
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$()
    {
        panel = new JPanel();
        panel.setLayout(new GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), -1, -1));
        final Spacer spacer1 = new Spacer();
        panel.add(spacer1, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel.add(panel1, new GridConstraints(0, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("本次结果：");
        panel1.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        result = new JTextField();
        result.setEditable(false);
        result.setEnabled(true);
        result.setHorizontalAlignment(0);
        result.setText("");
        panel1.add(result, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(5, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel.add(panel2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        panel2.add(panel3, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        left_first = new JTextField();
        left_first.setEditable(false);
        left_first.setHorizontalAlignment(0);
        panel3.add(left_first, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, -1), null, 0, false));
        left_second = new JTextField();
        left_second.setEditable(false);
        left_second.setHorizontalAlignment(0);
        panel3.add(left_second, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("第一颗");
        panel3.add(label2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("第二颗");
        panel3.add(label3, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel2.add(panel4, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("点数：");
        panel4.add(label4, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        left_sum = new JTextField();
        left_sum.setEditable(false);
        left_sum.setHorizontalAlignment(0);
        panel4.add(left_sum, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        panel2.add(panel5, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("玩家名：");
        panel5.add(label5, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        left_name = new JTextField();
        left_name.setText("");
        panel5.add(left_name, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        left_login = new JButton();
        left_login.setText("登陆");
        panel5.add(left_login, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        left_logout = new JButton();
        left_logout.setText("注销");
        panel5.add(left_logout, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel2.add(panel6, new GridConstraints(3, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        left_start = new JButton();
        left_start.setEnabled(false);
        left_start.setText("开始");
        panel6.add(left_start, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        left_show_history = new JButton();
        left_show_history.setEnabled(false);
        left_show_history.setText("查看历史");
        panel6.add(left_show_history, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("历史胜负");
        panel2.add(label6, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        panel2.add(scrollPane1, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        left_history = new JTextArea();
        scrollPane1.setViewportView(left_history);
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new GridLayoutManager(5, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel.add(panel7, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel8 = new JPanel();
        panel8.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        panel7.add(panel8, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        right_first = new JTextField();
        right_first.setEditable(false);
        right_first.setHorizontalAlignment(0);
        panel8.add(right_first, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        right_second = new JTextField();
        right_second.setEditable(false);
        right_second.setHorizontalAlignment(0);
        panel8.add(right_second, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("第一颗");
        panel8.add(label7, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("第二颗");
        panel8.add(label8, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel9 = new JPanel();
        panel9.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel7.add(panel9, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("点数：");
        panel9.add(label9, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        right_sum = new JTextField();
        right_sum.setEditable(false);
        right_sum.setHorizontalAlignment(0);
        panel9.add(right_sum, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel10 = new JPanel();
        panel10.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        panel7.add(panel10, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("玩家名：");
        panel10.add(label10, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        right_name = new JTextField();
        right_name.setText("");
        panel10.add(right_name, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        right_login = new JButton();
        right_login.setText("登陆");
        panel10.add(right_login, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        right_logout = new JButton();
        right_logout.setText("注销");
        panel10.add(right_logout, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel11 = new JPanel();
        panel11.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel7.add(panel11, new GridConstraints(3, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        right_start = new JButton();
        right_start.setEnabled(false);
        right_start.setText("开始");
        panel11.add(right_start, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        right_show_history = new JButton();
        right_show_history.setEnabled(false);
        right_show_history.setText("查看历史");
        panel11.add(right_show_history, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setText("历史胜负");
        panel7.add(label11, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane2 = new JScrollPane();
        panel7.add(scrollPane2, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        right_history = new JTextArea();
        right_history.setText("");
        scrollPane2.setViewportView(right_history);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return panel;
    }


}

class Random_roll implements Runnable
{
    String[] dice_str = {"⚀", "⚁", "⚂", "⚃", "⚄", "⚅"};
    private JTextField first_dice;
    private JTextField second_dice;
    private JTextField sum_field;
    private JButton my_button;
    private JButton other_button;

    private JTextField result;
    private JTextField left_sum;
    private JTextField right_sum;
    private JTextField left_name;
    private JTextField right_name;

    private int first_number = 0;
    private int second_number = 0;
    private int sum_number = 0;

    public Random_roll(JTextField first_dice, JTextField second_dice, JTextField sum_field, JButton my_button, JButton other_button, JTextField result, JTextField left_sum, JTextField right_sum, JTextField left_name, JTextField right_name)
    {
        this.first_dice = first_dice;
        this.second_dice = second_dice;
        this.sum_field = sum_field;
        this.my_button = my_button;
        this.other_button = other_button;
        this.result = result;
        this.left_sum = left_sum;
        this.right_sum = right_sum;
        this.left_name = left_name;
        this.right_name = right_name;
    }


    public void run()
    {
        my_button.setEnabled(false);
        for(int i = 0; i < 500; i++)
        {
            first_number = RandomUtil.randomInt(0,6);
            second_number = RandomUtil.randomInt(0,6);
            first_dice.setText(dice_str[first_number]);
            second_dice.setText(dice_str[second_number]);
            try
            {
                Thread.sleep(2);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        sum_number = first_number + second_number + 2;
        sum_field.setText(String.valueOf(sum_number));
        if(!left_sum.getText().equals("") && !right_sum.getText().equals(""))
        {
            Judge judge = new Judge(result, left_sum, right_sum, left_name, right_name, my_button, other_button);
            Thread judge_thread = new Thread(judge);
            judge_thread.start();
        }
    }
}

class Judge implements Runnable
{
    private JTextField result;
    private JTextField left_sum;
    private JTextField right_sum;
    private JTextField left_name;
    private JTextField right_name;
    private JButton first_button;
    private JButton second_button;

    public Judge(JTextField result, JTextField left_sum, JTextField right_sum, JTextField left_name, JTextField right_name, JButton first_button, JButton second_button)
    {
        this.result = result;
        this.left_sum = left_sum;
        this.right_sum = right_sum;
        this.left_name = left_name;
        this.right_name = right_name;
        this.first_button = first_button;
        this.second_button = second_button;
    }


    public void run()
    {
        int left = Integer.parseInt(left_sum.getText());
        int right = Integer.parseInt(right_sum.getText());
        String left_username = left_name.getText();
        String right_username = right_name.getText();
        String winner_name = (left > right) ? left_username : ((left == right) ? "" : right_username);

        if(winner_name.equals(""))
        {
            result.setText("It's a tie!");
        }
        else
        {
            result.setText(winner_name + " win!");
        }
        try
        {
            Db.use().insert(Entity.create("dice_history")
                    .set("left_username", left_username)
                    .set("left_sum", left)
                    .set("right_username", right_username)
                    .set("right_sum", right)
                    .set("winner", winner_name));
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        left_sum.setText("");
        right_sum.setText("");
        result.setText("");
        first_button.setEnabled(true);
        second_button.setEnabled(true);
    }
}

class Login implements Runnable
{
    private JTextField username_field;
    private JButton login;
    private JButton start;
    private JButton show_history;
    private JPanel panel;

    public Login(JTextField username, JButton login, JButton start, JButton show_history, JPanel panel)
    {
        this.username_field = username;
        this.login = login;
        this.start = start;
        this.show_history = show_history;
        this.panel = panel;
    }

    public void run()
    {
        String username = username_field.getText();
        if(username.equals(""))
        {
            JOptionPane.showMessageDialog(panel, "请输入一个有效的用户名！");
        }
        else
        {
            try
            {
                List<Entity> users = Db.use().findAll(Entity.create("user").set("username", username));
                if(users.isEmpty())
                {
                    JOptionPane.showMessageDialog(panel, "用户名不存在，已自动帮您创建账号，账号名：" + username);
                    Db.use().insert(Entity.create("user").set("id", null).set("username", username));
                }
                else
                {
                    JOptionPane.showMessageDialog(panel, "登录成功，账号名：" + username);
                }
                username_field.setEnabled(false);
                start.setEnabled(true);
                show_history.setEnabled(true);
                login.setEnabled(false);

            } catch (SQLException e)
            {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}

class History implements Runnable
{
    private JTextField username_field;
    private JTextArea history_field;

    public History(JTextField username, JTextArea history)
    {
        this.username_field = username;
        this.history_field = history;
    }

    public void run()
    {
        String username = username_field.getText();
        try
        {
            List<Entity> history = Db.use().query("select * from dice_history where left_username = ? or right_username = ?", username, username);
            if(history.isEmpty())
            {
                history_field.setText("您尚未和任何玩家对决");
                return;
            }
            else
            {
                List<Entity> win_count = Db.use().query("select count(*) win from dice_history where winner = ?", username);
                List<Entity> lose_count = Db.use().query("select count(*) lose from dice_history where (left_username = ? or right_username = ?) and winner <> ? and winner is not null", username, username, username);
                List<Entity> tie_count = Db.use().query("select count(*) tie from dice_history where (left_username = ? or right_username = ?) and winner is null", username, username);
                long win = (Long) win_count.get(0).get("win");
                long lose =(Long) lose_count.get(0).get("lose");
                long tie = (Long) tie_count.get(0).get("tie");
                long sum = win + lose + tie;
                StringBuffer history_buffer = new StringBuffer();
                history_buffer.append("你与其他玩家对决了");
                history_buffer.append(sum);
                history_buffer.append("次\n其中赢");
                history_buffer.append(win);
                history_buffer.append("次，输");
                history_buffer.append(lose);
                history_buffer.append("次，平局");
                history_buffer.append(tie);
                history_buffer.append("次。\n以下是对决历史：\n");

                Iterator<Entity> history_it = history.iterator();
                while(history_it.hasNext())
                {
                    Entity temp = history_it.next();
                    String enemy = "";
                    int my_score = 0;
                    int enemy_score = 0;
                    String result = "";
                    if(((String)temp.get("left_username")).equals(username))
                    {
                        enemy = (String)temp.get("right_username");
                        my_score = (Integer) temp.get("left_sum");
                        enemy_score = (Integer) temp.get("right_sum");
                    }
                    else
                    {
                        enemy = (String)temp.get("left_username");
                        my_score = (Integer) temp.get("right_sum");
                        enemy_score = (Integer) temp.get("left_sum");
                    }
                    result = (my_score > enemy_score) ? "赢" : ((my_score == enemy_score) ? "平局" : "输");
                    Date dice_date = (Date) temp.get("time");
                    history_buffer.append(dice_date);
                    history_buffer.append(" 与");
                    history_buffer.append(enemy);
                    history_buffer.append("对决，比分");
                    history_buffer.append(my_score);
                    history_buffer.append(":");
                    history_buffer.append(enemy_score);
                    history_buffer.append(",");
                    history_buffer.append(result);
                    history_buffer.append("\n");
                }
                history_field.setText(history_buffer.toString());
            }

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }


    }
}