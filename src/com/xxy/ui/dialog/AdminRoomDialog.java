package com.xxy.ui.dialog;

import af.swing.LayoutBox;
import af.swing.layout.VLayout;
import com.xxy.bean.Cinema;
import com.xxy.bean.Room;
import com.xxy.constants.Constants;
import com.xxy.util.SwingUtil;
import com.xxy.util.TestDataUtil;
import com.xxy.util.UiUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.xxy.constants.Constants.UI_ROOT_PADDING;

/**
 * 添加和编辑影院放映厅时，使用的弹窗
 */
public class AdminRoomDialog extends AdminBaseDialog {

    LayoutBox root;

    JComboBox<Cinema> cbCinema = new JComboBox<>();
    JTextField tfName = new JTextField();
    JTextField tfSeat = new JTextField();

    private int cinemaId;

    public AdminRoomDialog(String title, int cinemaId) {
        super(new JFrame(), true, true);
        this.cinemaId = cinemaId;

        initView(title);
    }

    public AdminRoomDialog(String title, Room room) {
        super(new JFrame(), true, false);
        this.cinemaId = room.getCinemaId();

        initView(title);

        tfName.setText(room.getName());
        tfSeat.setText(String.valueOf(room.getSeat()));
    }

    private void initView(String title) {
        setSize(380, 230);
        setResizable(false);
        SwingUtil.centerInScreen(this);

        setTitle(title);

        root = new LayoutBox().layout(new BorderLayout());
        this.setContentPane(root);

        root.add(initCenter(), BorderLayout.CENTER);
        root.add(initBottom(), BorderLayout.SOUTH);

        setCinemaComboBoxData(TestDataUtil.getCinemaList());

        cbCinema.setEnabled(isNewAction);
    }

    private JComponent initCenter() {
        LayoutBox dataPanel = new LayoutBox().layout(new VLayout());
        dataPanel.padding(UI_ROOT_PADDING, UI_ROOT_PADDING, UI_ROOT_PADDING, UI_ROOT_PADDING);
        dataPanel.bgColor(new Color(Constants.UI_COLOR_BG));

        dataPanel.add( UiUtil.initFormLine("电影院", cbCinema) );
        dataPanel.add( UiUtil.initFormLine("名称", tfName) );
        dataPanel.add( UiUtil.initFormLine("座位数", tfSeat) );
        return dataPanel;
    }

    private JComponent initBottom() {
        // 表格编辑按钮
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.RIGHT);
        LayoutBox actionPanel = new LayoutBox().layout(flowLayout);
        actionPanel.padding(UI_ROOT_PADDING, 0, UI_ROOT_PADDING, 0);
        actionPanel.add(btnCancel);
        btnCancel.addActionListener(onActionListener);
        actionPanel.add(btnSave);
        btnSave.addActionListener(onActionListener);
        actionPanel.bgColor(new Color(Constants.UI_COLOR_BG));
        return actionPanel;
    }

    /**
     * 刷新右边数据
     */
    public void refreshData() {

    }

    /**
     * 设置电影院下拉框数据
     * @param listCinema 电影院数据
     */
    public void setCinemaComboBoxData(ArrayList<Cinema> listCinema) {
        cbCinema.removeAllItems();
        int selectIndex = -1;
        for (int i = 0; i < listCinema.size(); i++) {
            Cinema data = listCinema.get(i);
            if (data.id == cinemaId) {
                selectIndex = i;
            }
            cbCinema.addItem(data);
        }
        if (selectIndex != -1) {
            cbCinema.setSelectedIndex(selectIndex);
        }
    }

    /**
     * 底部按钮事件监听
     */
    private ActionListener onActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnCancel) {
                dispose();
            } else if (e.getSource() == btnSave) {
                System.out.println("保存数据");
            }
        }
    };
}
