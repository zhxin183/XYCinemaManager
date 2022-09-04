package com.xxy.ui.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class XyImage extends JPanel
{

	@Override
	protected void paintComponent(Graphics g)
	{
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		// 设置白色背景
		int width = getWidth();
		int height = getHeight();
		g.setColor( Color.WHITE );
		g.fillRect(0, 0, width, height);
		
		try
		{
			// 图片文件的路径，使用相对路径
			File file = new File("data/1.jpg");
			
			// 加载文件，得到一个 Image 类型 ( BufferedImage是Image的子类实现 )
			BufferedImage image = ImageIO.read(file);
			
			// 绘制图片
			g.drawImage(image, 0, 0, width, height, null);
			
		} catch (IOException e)
		{
			
			e.printStackTrace();
		}
		
		
	}

	
	
}
