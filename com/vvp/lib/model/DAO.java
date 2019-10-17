package com.vvp.lib.model;
import java.util.*;
import java.io.*;
public class DAO
{
	public static HashMap <Integer,Student>  student=new <Integer,Student> HashMap();
	public static HashMap <Integer,Staff> staff=new <Integer,Staff>  HashMap();
	public static HashMap <Integer,SoftMedia>  softmedia=new <Integer,SoftMedia>  HashMap();
	public static HashMap <Integer,HardMedia> hardmedia=new <Integer,HardMedia>  HashMap();
	public static void getData()
	throws Exception
	{
		File f1=new File("G:\\Java\\com\\vvp\\lib\\model\\StudentInfo.csv");
		File f2=new File("G:\\Java\\com\\vvp\\lib\\model\\StaffInfo.csv");
		File f3=new File("G:\\Java\\com\\vvp\\lib\\model\\HardMediaInfo.csv");
		File f4=new File("G:\\Java\\com\\vvp\\lib\\model\\SoftMediaInfo.csv");
		BufferedReader studentReader=new BufferedReader(new FileReader(f1));
		BufferedReader staffReader=new BufferedReader(new FileReader(f2));
		BufferedReader hardMediaReader=new BufferedReader(new FileReader(f3));
		BufferedReader softMediaReader=new BufferedReader(new FileReader(f4));
		try{
		String records;
		if(f1.length()!=0)
		{
			records=studentReader.readLine();
			String part[]=records.split(";");
			for(int i=0;i<part.length;i++)
			{
				String element[]=part[i].split(",");
				student.put(Integer.parseInt(element[0]),new Student(Integer.parseInt(element[0]),element[1],Integer.parseInt(element[2]),Integer.parseInt(element[3]),element[4]));
			}	
		}
		if(f2.length()!=0)
		{
			records=staffReader.readLine();
			String part[]=records.split(";");
			for(int i=0;i<part.length;i++)
			{
				String element[]=part[i].split(",");
				staff.put(Integer.parseInt(element[0]),new Staff(Integer.parseInt(element[0]),element[1],Integer.parseInt(element[2]),element[3]));		
			}
		}
		if(f4.length()!=0)
		{
			records=softMediaReader.readLine();
			String part[]=records.split(";");
			for(int i=0;i<part.length;i++)
			{
				String element[]=part[i].split(",");
				softmedia.put(Integer.parseInt(element[0]),new SoftMedia(Integer.parseInt(element[0]),element[1],element[2],Integer.parseInt(element[3]),Integer.parseInt(element[4])));		
			}
		}
		if(f3.length()!=0)
		{
			records=hardMediaReader.readLine();
			String part[]=records.split(";");
			for(int i=0;i<part.length;i++)
			{
				String element[]=part[i].split(",");
				hardmedia.put(Integer.parseInt(element[0]),new HardMedia(Integer.parseInt(element[0]),element[1],element[2],Integer.parseInt(element[3]),Integer.parseInt(element[4])));		
			}
		}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			studentReader.close();
			staffReader.close();
			hardMediaReader.close();
			softMediaReader.close();
		}
	}
	public static void putData()
	throws Exception
	{
		File f1=new File("G:\\Java\\com\\vvp\\lib\\model\\StudentInfo.csv");
		File f2=new File("G:\\Java\\com\\vvp\\lib\\model\\StaffInfo.csv");
		File f3=new File("G:\\Java\\com\\vvp\\lib\\model\\HardMediaInfo.csv");
		File f4=new File("G:\\Java\\com\\vvp\\lib\\model\\SoftMediaInfo.csv");
		BufferedWriter studentWriter=new BufferedWriter(new FileWriter(f1));
		BufferedWriter staffWriter=new BufferedWriter(new FileWriter(f2));
		BufferedWriter hardMediaWriter=new BufferedWriter(new FileWriter(f3));
		BufferedWriter softMediaWriter=new BufferedWriter(new FileWriter(f4));
		try
		{
		String records;
		for(int i:student.keySet())
		{
			records=student.get(i).userId+","+
					student.get(i).name+","+
					student.get(i).sem+","+
					student.get(i).bookBal+","+
					student.get(i).branch+";";
			studentWriter.write(records.toCharArray());
		}
		for(int i:staff.keySet())
		{
			records=staff.get(i).userId+","+
					staff.get(i).name+","+
					staff.get(i).salary+","+
					staff.get(i).post+";";
			staffWriter.write(records.toCharArray());
		}
		for(int i:hardmedia.keySet())
		{
			records=hardmedia.get(i).isbnNo+","+
					hardmedia.get(i).title+","+
					hardmedia.get(i).author+","+
					hardmedia.get(i).availablity+","+
					hardmedia.get(i).pageNo+";";
			hardMediaWriter.write(records.toCharArray());
		}
		for(int i:softmedia.keySet())
		{
			records=softmedia.get(i).isbnNo+","+
					softmedia.get(i).title+","+
					softmedia.get(i).author+","+
					softmedia.get(i).availablity+","+
					softmedia.get(i).size+";";
			softMediaWriter.write(records.toCharArray());
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			studentWriter.close();
			staffWriter.close();
			hardMediaWriter.close();
			softMediaWriter.close();	
		}
	}
}