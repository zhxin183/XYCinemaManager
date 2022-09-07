package com.xxy.ui;

import af.swing.LayoutBox;
import com.xxy.bean.Cinema;
import com.xxy.constants.Constants;
import com.xxy.manager.LoginManager;
import com.xxy.ui.panel.AdminArrangePanel;
import com.xxy.ui.panel.AdminCinemaPanel;
import com.xxy.ui.panel.AdminHeaderPanel;
import com.xxy.ui.panel.AdminRoomPanel;
import com.xxy.util.TestDataUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Vector;

import static com.xxy.constants.Constants.UI_ROOT_PADDING;

/**
 * 影院CURD
 */
public class AdminCinemaFrame extends JFrame {

    public static WeakReference<AdminCinemaFrame> weakSelf;

    LayoutBox root;

    // 表格标题
    JLabel lbTableTitle = new JLabel("电影院管理");
    // 表格控件
    JTable tbCinema = new JTable();

    JTabbedPane tabbedPane = new JTabbedPane();// 存放选项卡的组件

    // Model
    DefaultTableModel tableModel = new DefaultTableModel();

    AdminHeaderPanel adminHeaderPanel = new AdminHeaderPanel(AdminHeaderPanel.HeaderType.FILM);

    ArrayList<Cinema> listCinema = new ArrayList<>();

    /**
     * 初始化页面
     */
    public AdminCinemaFrame() {
        super();

        weakSelf = new WeakReference<>(this);

        this.setTitle("管理员首页");

        root = new LayoutBox().layout(new BorderLayout());
        this.setContentPane(root);

        root.add(initTop(), BorderLayout.NORTH);
        root.add(initCenter(), BorderLayout.CENTER);
        root.add(initBottomTab(), BorderLayout.SOUTH);

        // 加载数据
        refreshTableData();
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
     * 初始化页面表格和表格右边界面
     * @return JComponent
     */
    private JComponent initCenter() {
        LayoutBox panel = new LayoutBox().layout(new BorderLayout());

        panel.padding(UI_ROOT_PADDING, UI_ROOT_PADDING, UI_ROOT_PADDING, UI_ROOT_PADDING);

        // 表格标题
        FlowLayout titleLayout = new FlowLayout();
        titleLayout.setAlignment(FlowLayout.LEFT);
        LayoutBox titlePanel = new LayoutBox().layout(titleLayout);
        titlePanel.padding(0, 0, UI_ROOT_PADDING / 2, 0);
        titlePanel.add(lbTableTitle);
        lbTableTitle.setFont(Constants.getTableTitleFont());

        panel.add(titlePanel, BorderLayout.NORTH);

        // 表格 初始化
        tbCinema.setFillsViewportHeight(true);
        // 整行选择
        tbCinema.setRowSelectionAllowed(true);
        // 行高
        tbCinema.setRowHeight(26);
        // 数据
        tbCinema.setModel(this.tableModel);

        // 每一列的标题
        tableModel.addColumn("编号");
        tableModel.addColumn("名称");
        tableModel.addColumn("地址");

        tbCinema.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbCinema.getColumnModel().getColumn(1).setPreferredWidth(150);
        tbCinema.getColumnModel().getColumn(2).setPreferredWidth(160);

        tbCinema.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tbCinema.addMouseListener(onMouseListener);

        // 滚动条支持
        JScrollPane scrollPane = new JScrollPane(tbCinema);
        panel.add(scrollPane, BorderLayout.CENTER);

        panel.setPreferredSize(new Dimension(1004, 160));

        return panel;
    }


    private AdminCinemaPanel tabPanelCinema = new AdminCinemaPanel();
    private AdminArrangePanel tabPanelArrange = new AdminArrangePanel();
    private AdminRoomPanel tabPanelRoom = new AdminRoomPanel();
    private JComponent initBottomTab() {
        LayoutBox panel = new LayoutBox().layout(new BorderLayout());

        tabbedPane.addTab("电影院", tabPanelCinema);

        tabbedPane.add("放映厅", tabPanelRoom);

        tabbedPane.add("排片", tabPanelArrange);

        panel.add(tabbedPane, BorderLayout.CENTER);

        panel.setPreferredSize(new Dimension(780, 360));

        return panel;
    }

    /**
     * 将数据添加到表格
     *
     * @param item 影院对象
     */
    private void addRow(Cinema item) {
        // java.util.Vector 类似于 List
        Vector<Object> rowData = new Vector<>();
        rowData.add(item.id);
        rowData.add(item.name);
        rowData.add(item.address);
        rowData.add(item.tag);
        rowData.add(item.score);
        tableModel.addRow(rowData); // 添加一行
    }

    /**
     * 刷新电影院数据
     */
    public void refreshTableData() {
        tbCinema.removeAll();
        listCinema.clear();
        tableModel.setRowCount(0);

        listCinema = TestDataUtil.getCinemaList();

        for (Cinema cinema : listCinema) {
            addRow(cinema);
        }

        if (listCinema.size() > 0) {
            tbCinema.setRowSelectionInterval(0, 0);
            Cinema cinema = getCinemaBySelectedRow(0);
            tabPanelCinema.refreshData(cinema);
            tabPanelRoom.refreshData(cinema.getId());
            tabPanelArrange.refreshData(cinema.getId());
        }
    }

    private Cinema getCinemaBySelectedRow(int selectedRow) {
        int row = tbCinema.getSelectedRow();
        Cinema cinema = listCinema.get(row);
        return cinema;
    }

    /**
     * 表格点击事件监听
     */
    private MouseListener onMouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == tbCinema) {
                Cinema cinema = getCinemaBySelectedRow(tbCinema.getSelectedRow());
                tabPanelCinema.refreshData(cinema);
                tabPanelRoom.refreshData(cinema.getId());
                tabPanelArrange.refreshData(cinema.getId());
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };

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
                case FILM:
                    System.out.println("电影管理 ======");
                    FrameHelper.showNewFrame(FrameHelper.FrameType.ADMIN_FILM, weakSelf.get());
                    break;
            }
        }
    };
}
