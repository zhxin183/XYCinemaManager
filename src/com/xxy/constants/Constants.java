package com.xxy.constants;

import java.awt.*;

public class Constants {
    public class Key {
        public static final String KEY_USER_ID = "KEY_USER_ID";
        public static final String KEY_USERNAME = "KEY_USERNAME";
        public static final String KYE_LOGIN_TIME = "KYE_LOGIN_TIME";
    }

    public static final int UI_ROOT_PADDING = 10;

    public static final int UI_COLOR_BG = 0xFCFCFC;

    public static final int UI_FONT_SIZE_TITLE_MAIN = 16;

    public static final int UI_FRAME_WIDTH = 800;
    public static final int UI_FRAME_HEIGHT = 600;

    public static Font getTableTitleFont() {
        return new Font("宋体", Font.BOLD, 16);
    }
}
