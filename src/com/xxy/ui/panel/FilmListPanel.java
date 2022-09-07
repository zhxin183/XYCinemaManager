package com.xxy.ui.panel;

import af.swing.LayoutBox;
import com.xxy.bean.Film;
import com.xxy.ui.view.FilmView;

import javax.swing.*;
import java.awt.*;

public class FilmListPanel extends LayoutBox {


    public FilmListPanel(int width, int height, int col) {
        layout(new BorderLayout());

        int fw = 120;
        int fh = 140;

        int fixWidth = width - 20;
        int spanning = (fixWidth - col * fw) / (col + 1);
        int count = 200;
        int row = count % col == 0 ? count / col : count / col  + 1;
        int fixHeight = fh * row + spanning * (row + 1);

        LayoutBox listBox = new LayoutBox().layout(new FlowLayout(FlowLayout.LEFT, spanning, spanning));
        listBox.setPreferredSize(new Dimension(width, fixHeight));

        System.out.println("col = " + col);

        for (int i = 0; i < count; i++) {
            FilmView filmView = new FilmView(new Film(), fw, fh);
            filmView.setPreferredSize(new Dimension(fw, fh));
            listBox.add(filmView);
        }

        JScrollPane scrollPane = new JScrollPane(listBox);
        add(scrollPane);



//        FilmView filmView = new FilmView(new Film());
//        listBox.add(filmView);
//        listBox.setPreferredSize(new Dimension(200, 200));

    }


}
