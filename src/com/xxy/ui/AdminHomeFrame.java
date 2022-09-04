package com.xxy.ui;

import af.swing.LayoutBox;
import af.swing.layout.FreeLayout;
import af.swing.layout.HLayout;

import javax.swing.*;
import java.awt.*;

import static com.xxy.constants.Constants.UI_ROOT_PADDING;

public class AdminHomeFrame extends JFrame {

    JButton btnLoginOut = new JButton("退出登陆");
    JLabel lbTitle = new JLabel("欢迎您，XX");

//    LayoutBox lb


    public AdminHomeFrame() {
        this.setTitle("管理员首页");

        LayoutBox root = new LayoutBox().layout(new BorderLayout());
        this.setContentPane(root);

        root.add(initTop(), BorderLayout.NORTH);
    }

    private JComponent initTop() {
        LayoutBox panel = new LayoutBox().layout(new BorderLayout());
        panel.add(lbTitle, BorderLayout.WEST);
        panel.add(btnLoginOut, BorderLayout.EAST);
        panel.padding(UI_ROOT_PADDING, UI_ROOT_PADDING, UI_ROOT_PADDING, UI_ROOT_PADDING);
        return panel;
    }
}
