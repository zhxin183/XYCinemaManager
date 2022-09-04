package com.xxy.ui;

import javax.swing.*;

public class LoginForm {
    private JPanel mainPanel;
    private JLabel lbUsername;
    private JTextField tfUsername;
    private JPasswordField tfPassword;
    private JPanel panelUserForm;
    private JLabel lbTitle;
    private JPanel panelTitle;

    public static void main(String[] args) {
        JFrame frame = new JFrame("LoginForm");
        frame.setContentPane(new LoginForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
