package com.vvp.lib.model;
import java.util.*;
import java.io.*;
public class Student extends User
{
	public int sem,bookBal;
	public static int bookCount=4;
	public String branch;
	public static LinkedList <Integer> statusOfStudent=new <Integer> LinkedList();	
	public Student(int userId,String name,int sem,int bookBal,String branch)
	{
		super(userId,name);
		this.sem=sem;
		this.bookBal=bookBal;
		this.branch=branch;
	}
}