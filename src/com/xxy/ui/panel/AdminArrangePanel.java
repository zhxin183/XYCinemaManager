package com.xxy.ui.panel;

import af.swing.LayoutBox;
import com.xxy.bean.Arrange;
import com.xxy.ui.dialog.AdminArrangeDialog;
import com.xxy.ui.view.ActionButtonView;
import com.xxy.util.TestDataUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;

public class AdminArrangePanel extends LayoutBox {

    private JTable tbArrange = new JTable();
    private DefaultTableModel tmArrange = new DefaultTableModel();

    ActionButtonView actionPanel = new ActionButtonView();

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

        actionPanel.setOnClickListener(onClickListener);
        rightPanel.add(actionPanel, BorderLayout.SOUTH);
    }


    public void refreshData(int cinemaId) {
        tbArrange.removeAll();
        listArrange.clear();
        tmArrange.setRowCount(0);

        listArrange = TestDataUtil.getArrangeList();

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

    /**
     * 操作Panel的按钮事件
     */
    private ActionButtonView.OnClickListener onClickListener = new ActionButtonView.OnClickListener() {
        @Override
        public void onButtonTap(ActionEvent event, int type) {
            switch (type) {
                case ActionButtonView.ActionType.ADD:
                    System.out.println("添加排片 ===================");
                    AdminArrangeDialog addDialog = new AdminArrangeDialog("添加排片", 0);
                    addDialog.setVisible(true);
                    break;
                case ActionButtonView.ActionType.EDIT:
                    System.out.println("编辑排片 ===================");
                    break;
                case ActionButtonView.ActionType.DELETE:
                    System.out.println("删除排片 ===================");
                    break;
            }
        }
    };
}
