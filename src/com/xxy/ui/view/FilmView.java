package com.xxy.ui.view;

import af.swing.LayoutBox;
import com.xxy.bean.Film;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FilmView extends LayoutBox {

    Film film;

    LayoutBox rootBox;

    PictureView pictureView = new PictureView(PictureView.ScaleType.TILE);

    JLabel lbName = new JLabel("电影名称");
    public FilmView(Film film, int width, int height) {
        super();

        this.film = film;

        setSize(width, height);

        layout(null);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Image image = ImageIO.read(new File("res/1.jpg"));
                    pictureView.setImage(image);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        pictureView.setSize(width, height);
        pictureView.setPreferredSize(new Dimension(width, height));
        pictureView.setLocation(0, 0);

        int lbHeight = 32;
        int lbWidth = width - 20;
        lbName.setSize(lbWidth, lbHeight);
        lbName.setPreferredSize(new Dimension(lbWidth , lbHeight));
        lbName.setLocation((width - lbWidth) / 2, height - lbHeight);

        Font font = new Font("宋体", Font.BOLD, 16);
        lbName.setFont(font);
        lbName.setForeground(Color.white);

        add(lbName);
        add(pictureView);
    }

}
