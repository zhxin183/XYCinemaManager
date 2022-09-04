package com.xxy.ui;

import af.swing.LayoutBox;
import com.xxy.bean.Room;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class AdminRoomPanel extends LayoutBox {
    // 影院放映厅
    private JTable tbRoom = new JTable();
    private DefaultTableModel tmRoom = new DefaultTableModel();

    ArrayList<Room> listRoom = new ArrayList<>();

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
    }

    public void refreshData(int cinemaId) {
        tbRoom.removeAll();
        listRoom.clear();
        tmRoom.setRowCount(0);
        listRoom.add(new Room(1, 1,"3D巨幕厅", 56));
        listRoom.add(new Room(2, 1,"2号厅", 24));
        listRoom.add(new Room(3, 1,"3号厅", 24));
        listRoom.add(new Room(4, 1,"4号厅", 36));
        listRoom.add(new Room(5, 2,"1号厅", 32));
        listRoom.add(new Room(6, 2,"2号厅", 32));
        listRoom.add(new Room(7, 2,"3号厅", 24));
        listRoom.add(new Room(8, 3,"iMax厅", 48));
        listRoom.add(new Room(9, 3,"2号厅", 32));
        listRoom.add(new Room(10, 3,"3号厅", 32));

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
}
