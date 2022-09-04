package com.xxy.ui;

import com.xxy.util.SwingUtil;

import javax.swing.*;

public class Main {

    public static void main(String[] args)
    {
//        JFrame frame = new LoginFrame("用户登陆"); // 300x200
        JFrame frameAdminHome = new AdminCinemaFrame();
//        MyFrame myFrame = new MyFrame("表格");
        frameAdminHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAdminHome.setSize(800, 600);

        // 显示在屏幕中央
        SwingUtil.centerInScreen(frameAdminHome);

        frameAdminHome.setVisible(true);
    }
}
