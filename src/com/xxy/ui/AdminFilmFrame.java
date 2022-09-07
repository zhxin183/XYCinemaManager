package com.xxy.ui;

import af.swing.LayoutBox;
import af.swing.layout.VLayout;
import com.xxy.bean.Cinema;
import com.xxy.bean.Film;
import com.xxy.manager.LoginManager;
import com.xxy.ui.panel.AdminHeaderPanel;
import com.xxy.ui.panel.FilmListPanel;
import com.xxy.ui.view.FilmView;

import javax.swing.*;
import java.awt.*;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

import static com.xxy.constants.Constants.UI_ROOT_PADDING;

public class AdminFilmFrame extends JFrame {

    public static WeakReference<AdminFilmFrame> weakSelf;

    LayoutBox boxRoot;

    AdminHeaderPanel adminHeaderPanel = new AdminHeaderPanel(AdminHeaderPanel.HeaderType.CINEMA);

    ArrayList<Cinema> listFilm = new ArrayList<>();

    public AdminFilmFrame() {
        super();

        weakSelf = new WeakReference<>(this);

        setTitle("电影管理");

        boxRoot = new LayoutBox().layout(new BorderLayout());
        setContentPane(boxRoot);

        boxRoot.add(initTop(), BorderLayout.NORTH);
        boxRoot.add(initCenter(), BorderLayout.CENTER);
        boxRoot.add(iniRight(), BorderLayout.EAST);
    }

    private JComponent initCenter() {
        FilmListPanel filmPanel = new FilmListPanel(440, 300, 3);
        return filmPanel;
    }

    private JComponent iniRight() {
        LayoutBox box = new LayoutBox().layout(new VLayout());
        box.setPreferredSize(new Dimension(360, 600));
        return box;
    }

    /**
     * 初始化顶部页面
     * @return JComponent
     */
    private JComponent initTop() {
        adminHeaderPanel.setListener(headerActionListener);
        return adminHeaderPanel;
    }

    /**
     * 顶部条的按钮事件监听
     */
    private AdminHeaderPanel.HeaderActionListener headerActionListener = new AdminHeaderPanel.HeaderActionListener() {
        @Override
        public void onHeaderButtonTapped(AdminHeaderPanel.HeaderType type) {
            switch (type) {
                case LOGIN_OUT:
                    System.out.println("退出登陆 ======");
                    LoginManager.loginOut(weakSelf.get());
                    break;
                case CINEMA:
                    System.out.println("影院管理 ======");
                    FrameHelper.showNewFrame(FrameHelper.FrameType.ADMIN_CINEMA, weakSelf.get());
                    break;
            }
        }
    };
}
