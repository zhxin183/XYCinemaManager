package com.xxy.ui;

import af.swing.LayoutBox;
import af.swing.layout.VLayout;
import com.xxy.bean.Cinema;
import com.xxy.util.UiUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.xxy.constants.Constants.UI_COLOR_BG;
import static com.xxy.constants.Constants.UI_ROOT_PADDING;

public class AdminCinemaPanel extends LayoutBox implements ActionListener {

    JTextField tfName = new JTextField();
    JTextArea taAddress = new JTextArea("", 3, 20);
    JTextField tfTag = new JTextField();
    JTextField tfScore = new JTextField();

    JButton btnAdd = new JButton("添加");
    JButton btnEdit = new JButton("编辑");
    JButton btnDelete = new JButton("删除");
    JButton btnRoom = new JButton("放映室");

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

        VLayout vLayout = new VLayout();
        LayoutBox boxButtons = new LayoutBox().layout(vLayout);
        boxButtons.add(btnAdd);
        boxButtons.add(btnEdit);
        boxButtons.add(btnDelete);
        boxButtons.padding(UI_ROOT_PADDING * 2);
        boxButtons.setPreferredSize(new Dimension(200, 130));
        rightPanel.add(boxButtons, BorderLayout.SOUTH);

        btnAdd.addActionListener(this);
        btnEdit.addActionListener(this);
        btnDelete.addActionListener(this);
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

    /**
     * 按钮事件监听
     * @param e 事件
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            System.out.println("添加 ===================");
            new AdminCinemaDialog(new JFrame(), true, "添加影院", null);
        } else if (e.getSource() == btnEdit) {
            System.out.println("编辑 ===================");
            if (cinema == null) {
                JOptionPane.showMessageDialog(new JFrame(), "请在左边列表选择需要编辑的影院。");
                return;
            } else {
                new AdminCinemaDialog(new JFrame(), true, "编辑影院", cinema);
            }
        } else if (e.getSource() == btnDelete) {
            System.out.println("删除 ===================");
        } else if (e.getSource() == btnRoom) {
            System.out.println("放映室 ===================");
        }
    }
}
