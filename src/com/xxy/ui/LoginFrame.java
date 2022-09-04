package com.xxy.ui;



import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import af.swing.LayoutBox;
import af.swing.layout.HLayout;
import af.swing.layout.VLayout;

import static com.xxy.constants.Constants.UI_ROOT_PADDING;


public class LoginFrame extends JFrame
{
	// 顶部
	JLabel lbTitle = new JLabel("欢迎使用XX影院管理系统");

	// 底部，工具栏按钮
	JButton btnLogin = new JButton("登陆");
	JButton btnRegister = new JButton("注册");
	
	// 中央，编辑字段
	JTextField idField = new JTextField();
	JTextField nameField = new JTextField();
	JComboBox<String> sexField = new JComboBox<>();
	JTextField phoneField = new JTextField();
	
	public LoginFrame(String title)
	{
		super(title);

		LayoutBox root = new LayoutBox().layout(new BorderLayout());
		this.setContentPane(root);

		root.add(initTop(), BorderLayout.NORTH);
		root.add( initCenter(), BorderLayout.CENTER);
		root.add( initBottom(), BorderLayout.SOUTH);
	}

	private JComponent initTop() {
		LayoutBox panel = new LayoutBox().layout(new HLayout());
		panel.add(lbTitle);
		return panel;
	}

	// 底部，初始化
	private JComponent initBottom()
	{
		LayoutBox panel = new LayoutBox().layout(new HLayout());
		// 添加一条边线
		panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0xA0A0A0)));
		panel.preferredHeight(50).padding(10, 5, 10, 5);
		
		panel.add(btnLogin);
		panel.add(btnRegister);
		return panel;
	}
	
	// 中央初始化
	private JComponent initCenter()
	{
		LayoutBox panel = new LayoutBox().layout(new VLayout());
		panel.padding(UI_ROOT_PADDING, UI_ROOT_PADDING, UI_ROOT_PADDING, UI_ROOT_PADDING);
		panel.bgColor(new Color(0xFCFCFC));
		
		panel.add( initFormLine("用户名", idField) );
		panel.add( initFormLine("密码", nameField) );
		// panel.add( initFormLine("性别", sexField) );
		// panel.add( initFormLine("手机", phoneField) );
		
		// 性别，下拉列表，添加选项
		// sexField.addItem("女");
		// sexField.addItem("男");
		// sexField.setSelectedIndex(1); // 默认选择'男'
		
		return panel;
	}

	// 中央，表单，一行
	private JComponent initFormLine(String label, JComponent field)
	{
		LayoutBox box = new LayoutBox().layout(new HLayout());
		box.preferredHeight(40).padding(5);
		
		box.add(new JLabel(label), "50px");
		box.add(field, "1w");
		return box;
	}
}
