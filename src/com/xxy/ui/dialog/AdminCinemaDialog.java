package com.xxy.ui.dialog;

import af.swing.LayoutBox;
import af.swing.layout.VLayout;
import com.xxy.bean.Cinema;
import com.xxy.constants.Constants;
import com.xxy.util.SwingUtil;
import com.xxy.util.UiUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.xxy.constants.Constants.UI_ROOT_PADDING;

/**
 * 添加和编辑影院时，使用的弹窗
 */
public class AdminCinemaDialog extends AdminBaseDialog {

    LayoutBox root;

    JTextField tfName = new JTextField();
    JTextArea taAddress = new JTextArea("", 3, 20);
    JTextField tfTag = new JTextField();
    JTextField tfScore = new JTextField();

    private Cinema cinema;

    public AdminCinemaDialog(boolean isNewAction, String title, Cinema cinema) {
        super(new JFrame(), true, isNewAction);

        this.cinema = cinema;

        setSize(380, 480);
        setResizable(false);
        SwingUtil.centerInScreen(this);

        setTitle(title);

        root = new LayoutBox().layout(new BorderLayout());
        this.setContentPane(root);

        root.add(initCenter(), BorderLayout.CENTER);
        root.add(initBottom(), BorderLayout.SOUTH);

        refreshData();

        this.setVisible(true);
    }

    private JComponent initCenter() {
        LayoutBox dataPanel = new LayoutBox().layout(new VLayout());
        dataPanel.padding(UI_ROOT_PADDING, UI_ROOT_PADDING, UI_ROOT_PADDING, UI_ROOT_PADDING);
        dataPanel.bgColor(new Color(Constants.UI_COLOR_BG));

        dataPanel.add( UiUtil.initFormImageLine("图片", 180,"res/1.jpg"));
        dataPanel.add( UiUtil.initFormLine("名称", tfName) );
        dataPanel.add( UiUtil.initFormLine("标签", tfTag) );
        dataPanel.add( UiUtil.initFormLine("评分", tfScore) );
        dataPanel.add( UiUtil.initFormTextAreaLine("地址", taAddress) );
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
        if (cinema != null) {
            tfName.setText(cinema.getName());
            taAddress.setText(cinema.getAddress());
            tfTag.setText(cinema.getTag());
            tfScore.setText(String.valueOf(cinema.getScore()));
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
