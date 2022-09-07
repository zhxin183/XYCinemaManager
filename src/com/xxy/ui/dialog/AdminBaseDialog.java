package com.xxy.ui.dialog;

import javax.swing.*;
import java.awt.*;

public class AdminBaseDialog extends JDialog {

    boolean isNewAction = false;

    JButton btnCancel = new JButton("取消");
    JButton btnSave = new JButton("保存");

    public AdminBaseDialog(Frame owner, boolean modal, boolean isNewAction) {
        super(owner, modal);
        this.isNewAction = isNewAction;
    }
}
