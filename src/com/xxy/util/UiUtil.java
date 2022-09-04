package com.xxy.util;

import af.swing.LayoutBox;
import af.swing.layout.HLayout;
import com.xxy.ui.view.PictureView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static com.xxy.constants.Constants.UI_COLOR_BG;

public class UiUtil {

    /**
     * 	// 中央，表单，一行
     * @param label 标题
     * @param field 文字框
     * @return JComponent
     */
    public static JComponent initFormLine(String label, JComponent field)  {
        LayoutBox box = new LayoutBox().layout(new HLayout());
        box.preferredHeight(32).padding(5);

        box.add(new JLabel(label), "50px");
        box.add(field, "1w");
        return box;
    }

    public static JComponent initFormTextAreaLine(String label, JTextArea area)  {
        LayoutBox box = new LayoutBox().layout(new HLayout());
        box.preferredHeight(64).padding(5);

        JLabel lbTitle = new JLabel(label);

        BorderLayout layout = new BorderLayout();
        LayoutBox panel = new LayoutBox().layout(layout);
        panel.add(lbTitle, BorderLayout.NORTH);

        area.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(area);    //将文本域放入滚动窗口

        box.add(panel, "53px");
        box.add(scrollPane, "1w");
        box.padding(0, 0, 0, 4);
        return box;
    }

    public static JComponent initFormImageLine(String label, int height, String src)  {
        LayoutBox box = new LayoutBox().layout(new HLayout());

        box.preferredHeight(height).padding(5);

        box.add(new JLabel(label), "50px");

        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        Panel imagePanel = new Panel(flowLayout);
        PictureView imageView = new PictureView();
        imagePanel.add(imageView);
        imageView.setPreferredSize(new Dimension(height, height));
        // 设置要显示的图片
        try
        {
            Image image = ImageIO.read( new File(src));
            imageView.setImage( image );
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        box.add(imagePanel, "1w");

        return box;
    }

}
