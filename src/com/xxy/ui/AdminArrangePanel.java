package com.xxy.ui;

import af.swing.LayoutBox;
import com.xxy.bean.Arrange;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class AdminArrangePanel extends LayoutBox {

    private JTable tbArrange = new JTable();
    private DefaultTableModel tmArrange = new DefaultTableModel();

    ArrayList<Arrange> listArrange = new ArrayList<>();

    public AdminArrangePanel() {
        layout(new BorderLayout());

        // 表格 初始化
        tbArrange.setFillsViewportHeight(true);
        // 整行选择
        tbArrange.setRowSelectionAllowed(true);
        // 行高
        tbArrange.setRowHeight(26);
        // 数据
        tbArrange.setModel(this.tmArrange);

        tmArrange.addColumn("编号");
        tmArrange.addColumn("放映厅");
        tmArrange.addColumn("电影");
        tmArrange.addColumn("开始时间");
        tmArrange.addColumn("结束时间");
        tmArrange.addColumn("价格");

        // 滚动条支持
        JScrollPane scrollPane = new JScrollPane(tbArrange);
        add(scrollPane, BorderLayout.CENTER);

        LayoutBox rightPanel = new LayoutBox().layout(new BorderLayout());
        rightPanel.setPreferredSize(new Dimension(200, 0));
        add(rightPanel, BorderLayout.EAST);
    }


    public void refreshData(int cinemaId) {
        tbArrange.removeAll();
        listArrange.clear();
        tmArrange.setRowCount(0);

        listArrange.add(new Arrange(1, 1, "惠州江北-中影国际影城", 1, "3D巨幕厅", 1, "猫和老鼠", 1662299098, 1662303657, 35.9f));
        listArrange.add(new Arrange(2, 1, "惠州江北-中影国际影城", 2, "2号厅", 1, "猫和老鼠", 1662299098, 1662303657, 35.9f));
        listArrange.add(new Arrange(3, 1, "惠州江北-中影国际影城", 3, "3号厅", 1, "猫和老鼠", 1662299098, 1662303657, 35.9f));

        for (Arrange arrange : listArrange) {
            if (arrange.cinemaId == cinemaId) {
                addArrangeRow(arrange);
            }
        }

        if (tmArrange.getRowCount() > 0) {
            tbArrange.setRowSelectionInterval(0, 0);
        }
    }

    private void addArrangeRow(Arrange item) {
        Vector<Object> rowData = new Vector<>();
        rowData.add(item.id);
        rowData.add(item.roomName);
        rowData.add(item.filmName);
        rowData.add(item.beginTime);
        rowData.add(item.endTime);
        rowData.add(item.price);
        tmArrange.addRow(rowData); // 添加一行
    }

}
