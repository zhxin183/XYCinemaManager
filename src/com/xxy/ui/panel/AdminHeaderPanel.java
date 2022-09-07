package com.xxy.ui.panel;

import af.swing.LayoutBox;
import com.xxy.manager.LoginManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.xxy.constants.Constants.UI_ROOT_PADDING;

public class AdminHeaderPanel extends LayoutBox {
    JLabel lbTitle = new JLabel("欢迎您，XX");

    JButton btnLoginOut = new JButton("退出登陆");

    JButton btnFilm = new JButton("电影管理");

    JButton btnCinema = new JButton("影院管理");

    public enum HeaderType {
        FILM, CINEMA, LOGIN_OUT;
    }

    private HeaderType headerType;

    public interface HeaderActionListener {
        void onHeaderButtonTapped(HeaderType type);
    }

    private HeaderActionListener listener;

    public void setListener(HeaderActionListener listener) {
        this.listener = listener;
    }

    public AdminHeaderPanel(HeaderType type) {
        this.headerType = type;

        layout(new BorderLayout());

        padding(UI_ROOT_PADDING, UI_ROOT_PADDING, UI_ROOT_PADDING, UI_ROOT_PADDING);

        FlowLayout titleLayout = new FlowLayout(FlowLayout.LEFT);

        FlowLayout btnLayout = new FlowLayout(FlowLayout.RIGHT);
        LayoutBox btnBox = new LayoutBox().layout(btnLayout);

        Font font = new Font("宋体", Font.BOLD, 18);
        lbTitle.setFont(font);
        add(lbTitle, BorderLayout.WEST);

        btnBox.add(btnFilm);
        btnBox.add(btnCinema);
        btnBox.add(btnLoginOut);

        btnFilm.addActionListener(actionListener);
        btnCinema.addActionListener(actionListener);
        btnLoginOut.addActionListener(actionListener);

        add(btnBox, BorderLayout.EAST);

        switch (type) {
            case FILM:
                btnCinema.setVisible(false);
                break;
            case CINEMA:
                btnFilm.setVisible(false);
                break;
        }
    }

    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (listener == null) return;

            if (e.getSource() == btnLoginOut) {
                listener.onHeaderButtonTapped(HeaderType.LOGIN_OUT);
            } else {
                listener.onHeaderButtonTapped(headerType);
            }
        }
    };
}
