package com.xxy.ui;

import com.xxy.util.SwingUtil;

import javax.swing.*;

import static com.xxy.constants.Constants.UI_FRAME_HEIGHT;
import static com.xxy.constants.Constants.UI_FRAME_WIDTH;

public class FrameHelper {

    public enum FrameType {
        LOGIN,
        REGISTER,
        ADMIN_CINEMA,
        ADMIN_FILM
    }

    public static void showNewFrame(FrameType frameType, JFrame parent) {

        JFrame newFrame = null;
        int fw = UI_FRAME_WIDTH;
        int fh = UI_FRAME_HEIGHT;
        switch (frameType) {
            case LOGIN:
                newFrame = new LoginFrame("用户登陆");
                fw = 360;
                fh = 240;
                break;
            case REGISTER:
                newFrame = new RegisterFrame();
                fw = 360;
                fh = 340;
                break;
            case ADMIN_FILM:
                newFrame = new AdminFilmFrame();
                break;
            case ADMIN_CINEMA:
                newFrame = new AdminCinemaFrame();
                break;
        }
        if (newFrame != null) {
            newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            newFrame.setSize(fw, fh);

            // 显示在屏幕中央
            SwingUtil.centerInScreen(newFrame);

            newFrame.setVisible(true);

            if (parent != null) {
                parent.setVisible(false);
            }
        }
    }

}
