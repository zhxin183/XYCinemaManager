package com.xxy.ui.panel;

import af.swing.LayoutBox;
import af.swing.layout.VLayout;
import com.xxy.bean.Cinema;
import com.xxy.ui.view.ActionButtonView;
import com.xxy.ui.dialog.AdminCinemaDialog;
import com.xxy.util.UiUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static com.xxy.constants.Constants.UI_COLOR_BG;
import static com.xxy.constants.Constants.UI_ROOT_PADDING;

public class AdminCinemaPanel extends LayoutBox {

    JTextField tfName = new JTextField();
    JTextArea taAddress = new JTextArea("", 3, 20);
    JTextField tfTag = new JTextField();
    JTextField tfScore = new JTextField();

    ActionButtonView actionPanel = new ActionButtonView();

    private Cinema cinema;

    public AdminCinemaPanel() {
        layout(new BorderLayout());

        setBackground(new Color(UI_COLOR_BG));

        LayoutBox linePanel = new LayoutBox().layout(new VLayout());
        linePanel.setBackground(new Color(UI_COLOR_BG));
        linePanel.padding(UI_ROOT_PADDING, UI_ROOT_PADDING, UI_ROOT_PADDING, UI_ROOT_PADDING);

        linePanel.add( UiUtil.initFormImageLine("图片", 120,"res/1.jpg"));
        linePanel.add( UiUtil.initFormLine("名称", tfName) );
        linePanel.add( UiUtil.initFormLine("标签", tfTag) );
        linePanel.add( UiUtil.initFormLine("评分", tfScore) );
        linePanel.add( UiUtil.initFormTextAreaLine("地址", taAddress) );

        add(linePanel, BorderLayout.CENTER);

        LayoutBox rightPanel = new LayoutBox().layout(new BorderLayout());
        rightPanel.setPreferredSize(new Dimension(200, 0));
        add(rightPanel, BorderLayout.EAST);

        actionPanel.setOnClickListener(onClickListener);
        rightPanel.add(actionPanel, BorderLayout.SOUTH);
    }

    /**
     * 刷新界面右边影院数据
     */
    public void refreshData(Cinema cinema) {
        this.cinema = cinema;

        tfName.setText(cinema.getName());
        taAddress.setText(cinema.getAddress());
        tfTag.setText(cinema.getTag());
        tfScore.setText(String.valueOf(cinema.getScore()));

//        tabPanelRoom.refreshRoomData(cinema.getId());
//        tabPanelArrange.refreshArrangeData(cinema.getId());
    }

    private ActionButtonView.OnClickListener onClickListener = new ActionButtonView.OnClickListener() {
        @Override
        public void onButtonTap(ActionEvent event, int type) {
            switch (type) {
                case ActionButtonView.ActionType.ADD:
                    System.out.println("添加 ===================");
                    new AdminCinemaDialog(true,"添加影院", null);
                    break;
                case ActionButtonView.ActionType.EDIT:
                    System.out.println("编辑 ===================");
                    if (cinema == null) {
                        JOptionPane.showMessageDialog(new JFrame(), "请在左边列表选择需要编辑的影院。");
                        return;
                    } else {
                        new AdminCinemaDialog(false,"编辑影院", cinema);
                    }
                    break;
                case ActionButtonView.ActionType.DELETE:
                    System.out.println("删除 ===================");
                    break;
            }
        }
    };
}
