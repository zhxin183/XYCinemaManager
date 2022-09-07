package com.xxy.ui.view;

import af.swing.LayoutBox;
import af.swing.layout.VLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.xxy.constants.Constants.UI_ROOT_PADDING;

public class ActionButtonView extends LayoutBox implements ActionListener {

    JButton btnAdd = new JButton("添加");
    JButton btnEdit = new JButton("编辑");
    JButton btnDelete = new JButton("删除");

    public static class ActionType {
        public static final int ADD = 1;
        public static final int EDIT = 2;
        public static final int DELETE = 3;
    }

    public interface OnClickListener {
        void onButtonTap(ActionEvent event, int type);
    }

    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public ActionButtonView() {
        VLayout vLayout = new VLayout();
        layout(vLayout);
        add(btnAdd);
        add(btnEdit);
        add(btnDelete);

        btnAdd.addActionListener(this);
        btnEdit.addActionListener(this);
        btnDelete.addActionListener(this);

        padding(UI_ROOT_PADDING * 2);
        setPreferredSize(new Dimension(200, 130));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.onClickListener != null) {
            int type = ActionType.ADD;
            if (e.getSource() == btnAdd) {
                type = ActionType.ADD;
            } else if (e.getSource() == btnEdit) {
                type = ActionType.EDIT;
            } else if (e.getSource() == btnDelete) {
                type = ActionType.DELETE;
            }
            onClickListener.onButtonTap(e, type);
        }
    }
}
