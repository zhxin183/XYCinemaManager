package com.xxy.ui;



import com.xxy.bean.Student;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class MyFrame extends JFrame
{	
	// 表格控件
	JTable table = new JTable();
	// Model
	DefaultTableModel tableModel = new DefaultTableModel();
		
	public MyFrame(String title)
	{
		super(title);
		
		JPanel root = new JPanel();
		root.setLayout(new BorderLayout());
		this.setContentPane(root);
		
		// 初始化
		table.setFillsViewportHeight(true);	
		// 整行选择
		table.setRowSelectionAllowed(true); 
		// 行高
		table.setRowHeight(24);
		// 数据
		table.setModel(this.tableModel);
		// 滚动条支持
		root.add(new JScrollPane(table), BorderLayout.CENTER);
		
		// 每一列的标题
		tableModel.addColumn ("学号");
		tableModel.addColumn ("姓名");
		tableModel.addColumn ("性别");
		tableModel.addColumn ("手机");
		
		addRow ( new Student(2001, "莫凡", true, "13810012345"));
		addRow ( new Student(2002, "穆宁雪", false, "13810012346"));
		addRow ( new Student(2003, "叶心夏", false, "13810012347"));
	}

	private void addRow(Student item)
	{
		// java.util.Vector 类似于 List
		Vector<Object> rowData = new Vector<>();
		rowData.add(item.id);
		rowData.add(item.name);
		rowData.add(item.sex);
		rowData.add(item.phone);		
		tableModel.addRow( rowData ); // 添加一行
	}
	
}
