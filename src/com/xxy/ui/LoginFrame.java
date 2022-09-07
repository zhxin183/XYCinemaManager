package com.xxy.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ref.WeakReference;

import javax.swing.*;

import af.swing.LayoutBox;
import af.swing.layout.VLayout;
import com.xxy.manager.LoginManager;
import com.xxy.util.UiUtil;

import static com.xxy.constants.Constants.UI_ROOT_PADDING;


public class LoginFrame extends JFrame {

    WeakReference<LoginFrame> weakSelf;
    // 顶部
    JLabel lbTitle = new JLabel("欢迎使用XX影院管理系统");

    // 底部，工具栏按钮
    JButton btnLogin = new JButton("登陆");
    JButton btnRegister = new JButton("注册");

    // 中央，编辑字段
    JTextField tfUsername = new JTextField();
    JPasswordField tfPassword = new JPasswordField();
    JComboBox<String> sexField = new JComboBox<>();
    JTextField phoneField = new JTextField();

    public LoginFrame(String title) {
        super(title);

        weakSelf = new WeakReference<>(this);

        LayoutBox root = new LayoutBox().layout(new BorderLayout());
        this.setContentPane(root);

        root.add(initTop(), BorderLayout.NORTH);
        root.add(initCenter(), BorderLayout.CENTER);
        root.add(initBottom(), BorderLayout.SOUTH);
    }

    private JComponent initTop() {
        LayoutBox panel = new LayoutBox().layout(new BorderLayout());

        Font font = new Font("宋体", Font.BOLD, 18);
        lbTitle.setFont(font);
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(lbTitle, BorderLayout.CENTER);

        panel.setPreferredSize(new Dimension(320, 60));

        return panel;
    }

    // 底部，初始化
    private JComponent initBottom() {
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        LayoutBox panel = new LayoutBox().layout(flowLayout);
        // 添加一条边线
        //panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0xA0A0A0)));
        panel.preferredHeight(50).padding(10, 5, 10, 5);

        panel.add(btnLogin);
        panel.add(btnRegister);

        btnLogin.addActionListener(btnActionListener);
        btnRegister.addActionListener(btnActionListener);

        return panel;
    }

    // 中央初始化
    private JComponent initCenter() {
        LayoutBox panel = new LayoutBox().layout(new VLayout());
        panel.padding(UI_ROOT_PADDING, UI_ROOT_PADDING, UI_ROOT_PADDING, UI_ROOT_PADDING);
        panel.bgColor(new Color(0xFCFCFC));

        panel.add(UiUtil.initFormLine("用户名", tfUsername));
        panel.add(UiUtil.initFormLine("密码", tfPassword));
        // panel.add( initFormLine("性别", sexField) );
        // panel.add( initFormLine("手机", phoneField) );

        // 性别，下拉列表，添加选项
        // sexField.addItem("女");
        // sexField.addItem("男");
        // sexField.setSelectedIndex(1); // 默认选择'男'

        return panel;
    }

    private ActionListener btnActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnLogin) {
                if (tfUsername.getText().equals("") || tfPassword.getText().equals("")) {
                    JOptionPane.showMessageDialog(weakSelf.get(), "请输入用户名和密码", "提示", JOptionPane.WARNING_MESSAGE);
                } else {
                    boolean result = LoginManager.checkLoginResult(tfUsername.getText(), tfPassword.getText());
                    if (result) {
                        FrameHelper.showNewFrame(FrameHelper.FrameType.ADMIN_CINEMA, weakSelf.get());
                    } else {
                        JOptionPane.showMessageDialog(weakSelf.get(), "密码错误", "提示", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } else if (e.getSource() == btnRegister) {
                FrameHelper.showNewFrame(FrameHelper.FrameType.REGISTER, weakSelf.get());
            }
        }
    };
}
