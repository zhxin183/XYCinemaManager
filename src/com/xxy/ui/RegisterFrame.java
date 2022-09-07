package com.xxy.ui;

import af.swing.LayoutBox;
import af.swing.layout.VLayout;
import com.xxy.manager.LoginManager;
import com.xxy.util.UiUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ref.WeakReference;

import static com.xxy.constants.Constants.UI_ROOT_PADDING;

public class RegisterFrame extends JFrame {

    WeakReference<RegisterFrame> weakSelf;

    LayoutBox root;

    JLabel lbTitle = new JLabel("用户注册");

    JButton btnSubmit = new JButton("提交");
    JButton btnCancel = new JButton("取消");

    JTextField tfUsername = new JTextField();
    JTextField tfNickName = new JTextField();
    JPasswordField tfPassword = new JPasswordField();
    JPasswordField tfRePassword = new JPasswordField();


    public RegisterFrame() {
        super();

        weakSelf = new WeakReference<>(this);

        setTitle("用户注册");

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

        panel.add(btnSubmit);
        panel.add(btnCancel);

        btnSubmit.addActionListener(btnActionListener);
        btnCancel.addActionListener(btnActionListener);

        return panel;
    }

    // 中央初始化
    private JComponent initCenter() {
        LayoutBox panel = new LayoutBox().layout(new VLayout());
        panel.padding(UI_ROOT_PADDING, UI_ROOT_PADDING, UI_ROOT_PADDING, UI_ROOT_PADDING);
        panel.bgColor(new Color(0xFCFCFC));

        panel.add(UiUtil.initFormLine("用户名", tfUsername));
        panel.add(UiUtil.initFormLine("昵称", tfNickName));
        panel.add(UiUtil.initFormLine("密码", tfPassword));
        panel.add(UiUtil.initFormLine("重复密码", tfRePassword));

        return panel;
    }

    private boolean isPasswordValid() {
        boolean valid = tfPassword.getText().equals(tfRePassword.getText());
        if (!valid)
            JOptionPane.showMessageDialog(weakSelf.get(), "两次输入的密码不一致，请重新输入", "提示", JOptionPane.WARNING_MESSAGE);
        return valid;
    }

    private boolean checkInputValid() {
        String msg = "";
        boolean valid = true;
        if (tfUsername.getText().trim().equals("")) {
            msg = "请输入用户名";
            valid = false;
        } else if (tfNickName.getText().trim().equals("")) {
            msg = "请输入昵称";
            valid = false;
        } else if (tfPassword.getText().trim().equals("")) {
            msg = "请输入密码";
            valid = false;
        } else if (tfRePassword.getText().trim().equals("")) {
            msg = "请重复输入密码";
            valid = false;
        }
        if (!valid)
            JOptionPane.showMessageDialog(weakSelf.get(), msg, "提示", JOptionPane.WARNING_MESSAGE);
        return valid;
    }

    private ActionListener btnActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnSubmit) {
                boolean inputValid = checkInputValid();
                boolean passwordValid = isPasswordValid();
                if (inputValid && passwordValid) {
                    System.out.println("到数据库检查数据，是否注册成功");
                    System.out.println("返回登陆");
                    FrameHelper.showNewFrame(FrameHelper.FrameType.LOGIN, weakSelf.get());
                }
            } else if (e.getSource() == btnCancel) {
                FrameHelper.showNewFrame(FrameHelper.FrameType.LOGIN, weakSelf.get());
            }
        }
    };
}
