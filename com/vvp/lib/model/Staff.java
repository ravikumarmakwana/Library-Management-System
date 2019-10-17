package com.vvp.lib.model;
import java.io.*;
import java.util.*;
public class Staff extends User
{
	public int salary;
	public String post;
	public Staff(int userId,String name,int salary,String post)
	{
		super(userId,name);
		this.salary=salary;
		this.post=post;
	}
} 