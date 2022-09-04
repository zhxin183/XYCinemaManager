package com.xxy.bean;

public class Student
{
	public int id;	// 学号
	public String name;	// 姓名
	public boolean sex;	// 性别
	public String phone;	// 手机号
	
	public Student()
	{		
	}
	
	public Student(int id, String name, boolean sex, String phone)
	{
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
	}

	@Override
	public String toString()
	{
		String str = this.name;
		str += " (" ;
		if(this.sex)
			str += "男" ;
		else
			str += "女" ;
		str += ")" ;
		return str;
	}
	
	
}
