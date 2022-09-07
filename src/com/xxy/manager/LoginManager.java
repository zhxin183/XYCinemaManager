package com.xxy.manager;

import com.xxy.constants.Constants;
import com.xxy.ui.FrameHelper;

import javax.swing.*;

public class LoginManager {

    public static final String DEFAULT_ADMIN_USER_ID = "0";
    public static final String DEFAULT_ADMIN_USERNAME = "admin";
    public static final String DEFAULT_ADMIN_PASSWORD = "123456";

    public static boolean checkLoginStatus() {
        String loginUserId = PropertyHelper.getInstance().getProperty(Constants.Key.KEY_USER_ID);
        String loginUsername = PropertyHelper.getInstance().getProperty(Constants.Key.KEY_USERNAME);

        System.out.println("LoginManager checkLoginStatus: loginUserId = " + loginUserId);

        if (loginUserId != null && !"".equals(loginUserId)) {
            return true;
        }
        return false;
    }

    public static String getLoginUsername() {
        String loginUsername = System.getProperty(Constants.Key.KEY_USERNAME);
        return loginUsername;
    }

    public static boolean checkLoginResult(String username, String password) {
        if (username.equals(DEFAULT_ADMIN_USERNAME) && password.equals(DEFAULT_ADMIN_PASSWORD)) {
            PropertyHelper.getInstance().setProperty(Constants.Key.KEY_USER_ID, DEFAULT_ADMIN_USER_ID);
            PropertyHelper.getInstance().setProperty(Constants.Key.KEY_USERNAME, DEFAULT_ADMIN_USERNAME);

            String loginUserId = PropertyHelper.getInstance().getProperty(Constants.Key.KEY_USER_ID);
            System.out.println("LoginManager checkLoginResult: loginUserId = " + loginUserId);
            return true;
        } else {
            // 检查数据库数据
            return false;
        }
    }

    public static void loginOut(JFrame formFrame) {
        PropertyHelper.getInstance().setProperty(Constants.Key.KEY_USER_ID, "");
        PropertyHelper.getInstance().setProperty(Constants.Key.KEY_USERNAME, "");

        FrameHelper.showNewFrame(FrameHelper.FrameType.LOGIN, formFrame);
    }
}
