package com.xxy.ui;

import javax.swing.*;
import java.awt.*;

public class XyFilmCell extends JPanel {

    private JLabel lbTitle;

    public XyFilmCell() {
        lbTitle = new JLabel("测试");
        lbTitle.setSize(200, 200);
        lbTitle.setBackground(Color.blue);
        lbTitle.setLocation(20, 30);

        add(lbTitle);
    }
}
