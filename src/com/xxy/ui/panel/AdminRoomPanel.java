package com.xxy.ui.panel;

import af.swing.LayoutBox;
import com.xxy.bean.Room;
import com.xxy.ui.dialog.AdminCinemaDialog;
import com.xxy.ui.dialog.AdminRoomDialog;
import com.xxy.ui.view.ActionButtonView;
import com.xxy.util.TestDataUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;

public class AdminRoomPanel extends LayoutBox {
    // 影院放映厅
    private JTable tbRoom = new JTable();
    private DefaultTableModel tmRoom = new DefaultTableModel();

    ArrayList<Room> listRoom = new ArrayList<>();

    ActionButtonView actionPanel = new ActionButtonView();

    private int cinemaId = -1;

    public AdminRoomPanel() {
        layout(new BorderLayout());

        // 表格 初始化
        tbRoom.setFillsViewportHeight(true);
        // 整行选择
        tbRoom.setRowSelectionAllowed(true);
        // 行高
        tbRoom.setRowHeight(26);
        // 数据
        tbRoom.setModel(this.tmRoom);

        tmRoom.addColumn("编号");
        tmRoom.addColumn("名称");
        tmRoom.addColumn("座位");

        // 滚动条支持
        JScrollPane scrollPane = new JScrollPane(tbRoom);
        add(scrollPane, BorderLayout.CENTER);

        LayoutBox rightPanel = new LayoutBox().layout(new BorderLayout());
        rightPanel.setPreferredSize(new Dimension(200, 0));
        add(rightPanel, BorderLayout.EAST);

        actionPanel.setOnClickListener(onClickListener);
        rightPanel.add(actionPanel, BorderLayout.SOUTH);
    }

    public void refreshData(int cinemaId) {
        System.out.println("刷新放映厅数据 cinemaId = " + cinemaId);

        this.cinemaId = cinemaId;

        tbRoom.removeAll();
        listRoom.clear();
        tmRoom.setRowCount(0);

        listRoom = TestDataUtil.getRoomList();

        for (Room room : listRoom) {
            if (room.cinemaId == cinemaId) {
                addRoomRow(room);
            }
        }

        if (tmRoom.getRowCount() > 0) {
            tbRoom.setRowSelectionInterval(0, 0);
        }
    }

    private void addRoomRow(Room item) {
        Vector<Object> rowData = new Vector<>();
        rowData.add(item.id);
        rowData.add(item.name);
        rowData.add(item.seat);
        tmRoom.addRow(rowData); // 添加一行
    }

    /**
     * 操作Panel的按钮事件
     */
    private ActionButtonView.OnClickListener onClickListener = new ActionButtonView.OnClickListener() {
        @Override
        public void onButtonTap(ActionEvent event, int type) {
            switch (type) {
                case ActionButtonView.ActionType.ADD:
                    System.out.println("添加放映厅 ===================");
                    AdminRoomDialog addDialog = new AdminRoomDialog("添加放映厅", cinemaId);
                    addDialog.setVisible(true);
                    break;
                case ActionButtonView.ActionType.EDIT:
                    System.out.println("编辑放映厅 ===================");
                    int selectedRow = tbRoom.getSelectedRow();
                    Room room = listRoom.get(selectedRow);
                    AdminRoomDialog editDialog = new AdminRoomDialog("编辑放映厅", room);
                    editDialog.setVisible(true);
                    break;
                case ActionButtonView.ActionType.DELETE:
                    System.out.println("删除放映厅 ===================");
                    break;
            }
        }
    };
}
