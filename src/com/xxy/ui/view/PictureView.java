package com.xxy.ui.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PictureView extends JPanel
{
	// 要显示的图片，默认为 null
	private Image image; 
	
	// 背景色，默认为 null
	private Color bgColor;
	
	public PictureView()
	{		
	}
	
	public void setBackgroundColor( Color color)
	{
		this.bgColor = color;
		this.repaint(); // 重新绘制这个控件
	}
	
	public void setImage (Image image)
	{
		this.image = image;
		this.repaint(); // 重新绘制这个控件
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		// 设置白色背景
		int width = getWidth();
		int height = getHeight();
		
		if( bgColor != null) 
		{
			g.setColor( bgColor );
			g.fillRect(0, 0, width, height);
		}

		if( image != null)
		{
			// 获取图像的大小
			int imgW = image.getWidth( null );
			int imgH = image.getHeight( null );
			
			// ( fitW, fitH ) : 要求保持长宽比，并且在目标矩形之内
			// 1：图像不能超出控制范围
			// 2：图像比较按原始比例显示
			
			// 先尝试以窗口之宽度作为图片宽度，按比例绘制图片
			int fitW = width;
			int fitH = width * imgH / imgW;
			if( fitH > height )
			{
				// 若图片高度fitH超出宽度高度，就以窗口高度为图片高度，按比例绘制图片
				fitH = height;
				fitW = height * imgW / imgH;
			}
			
			// 绘制图片
			int fitX = (width - fitW ) /2;
			int fitY = (height - fitH ) /2;
			
			g.drawImage(image, fitX, fitY, fitW, fitH, null);
		}
		

	}

	
	
}
