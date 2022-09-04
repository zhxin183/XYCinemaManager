package com.xxy.util;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;

public class SwingUtil
{
	// 显示在原窗口的中央
	public static void centerInOwner(Window win, Window owner)
	{
		// 获取原窗口的位置
		Rectangle ownerRect = owner.getBounds();
		
		// 显示在原窗口的中央
		int width = win.getWidth();
		int height = win.getHeight();		
		int x = ownerRect.x + (ownerRect.width - width)/2;
		int y = ownerRect.y + (ownerRect.height - height)/2;
		win.setBounds(x,y, width, height);
	}
	
	// 让窗口显示在屏幕中央
	public static void centerInScreen(Window win)
	{
		// 获取屏幕大小
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
		
		// 显示在屏幕的中央
		int x = ( screenSize.width - win.getWidth())/2;
		int y = ( screenSize.height - win.getHeight())/2;
		win.setLocation(x,  y);
	}
}
