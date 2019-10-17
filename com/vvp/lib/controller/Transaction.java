package com.vvp.lib.controller;
import com.vvp.lib.model.*;
public class Transaction
{
	public String issueBook(int userId,int isbnNo)
	throws 
	UserNotFoundException,
	BookNotFoundException,
	InsufficentBookBalanceException,
	BookNotAvailableException
	{
		System.out.println(showSoftMedia(isbnNo));
		if(!(DAO.student.containsKey(userId)))
			throw new UserNotFoundException();
		
		if(!(DAO.softmedia.containsKey(isbnNo)) && !(DAO.hardmedia.containsKey(isbnNo)))
			throw new BookNotFoundException();

		if(DAO.student.get(isbnNo).bookBal==0)
			throw new InsufficentBookBalanceException();
		
		if(DAO.softmedia.containsKey(isbnNo))
		{
			if(DAO.softmedia.get(isbnNo).availablity==0)
				throw new BookNotAvailableException();
			
			String title,author;
			int No,availablity,size;
			title=DAO.softmedia.get(isbnNo).title;
			author=DAO.softmedia.get(isbnNo).author;
			No=DAO.softmedia.get(isbnNo).isbnNo;
			availablity=DAO.softmedia.get(isbnNo).availablity;
			size=DAO.softmedia.get(isbnNo).size;
			System.out.println(showSoftMedia(isbnNo));
			DAO.softmedia.remove(isbnNo);
			DAO.softmedia.put(No,new SoftMedia(No,title,author,availablity-1,size));
			int Id, sem,bookBal;
			String name,branch;
			Id=DAO.student.get(userId).userId;
			sem=DAO.student.get(userId).sem;
			bookBal=DAO.student.get(userId).bookBal;
			name=DAO.student.get(userId).name;
			branch=DAO.student.get(userId).branch;
			DAO.student.remove(userId);
			DAO.student.put(Id,new Student(Id,name,sem,bookBal-1,branch));
			return "Book Issue Successfully ";
		}
		else
		{
			if(DAO.hardmedia.get(isbnNo).availablity==0)
				throw new BookNotAvailableException();
			System.out.println(showHardMedia(isbnNo));
			String title,author;
			int No,availablity,pageNo;
			title=DAO.hardmedia.get(isbnNo).title;
			author=DAO.hardmedia.get(isbnNo).author;
			No=DAO.hardmedia.get(isbnNo).isbnNo;
			availablity=DAO.hardmedia.get(isbnNo).availablity;
			pageNo=DAO.hardmedia.get(isbnNo).pageNo;
			System.out.println(showHardMedia(isbnNo));
			DAO.hardmedia.remove(isbnNo);
			DAO.hardmedia.put(No,new HardMedia(No,title,author,availablity-1,pageNo));
			int Id, sem,bookBal;
			String name,branch;
			Id=DAO.student.get(userId).userId;
			sem=DAO.student.get(userId).sem;
			bookBal=DAO.student.get(userId).bookBal;
			name=DAO.student.get(userId).name;
			branch=DAO.student.get(userId).branch;
			DAO.student.remove(userId);
			DAO.student.put(Id,new Student(Id,name,sem,bookBal-1,branch));
			return "Book Issue Successfully ";
		}
	}

	public String returnBook(int userId,int isbnNo)
	throws 
	UserNotFoundException,
	BookNotFoundException
	{
		if(!(DAO.student.containsKey(userId)))
			throw new UserNotFoundException();
		
		if(!(DAO.softmedia.containsKey(isbnNo)) && !(DAO.hardmedia.containsKey(isbnNo)))
			throw new BookNotFoundException();
		
		if(DAO.student.get(userId).bookBal==4)
			return "User Not Issued any Book form Library !!";
		
		if(DAO.softmedia.get(isbnNo)!=null)
		{
			String title,author;
			int No,availablity,size;
			title=DAO.softmedia.get(isbnNo).title;
			author=DAO.softmedia.get(isbnNo).author;
			No=DAO.softmedia.get(isbnNo).isbnNo;
			availablity=DAO.softmedia.get(isbnNo).availablity;
			size=DAO.softmedia.get(isbnNo).size;
			DAO.softmedia.remove(isbnNo);
			DAO.softmedia.put(isbnNo,new SoftMedia(isbnNo,title,author,availablity+1,size));
			int Id, sem,bookBal;
			String name,branch;
			Id=DAO.student.get(userId).userId;
			sem=DAO.student.get(userId).sem;
			bookBal=DAO.student.get(userId).bookBal;
			name=DAO.student.get(userId).name;
			branch=DAO.student.get(userId).branch;
			DAO.student.remove(userId);
			DAO.student.put(userId,new Student(userId,name,sem,bookBal+1,branch));
			return "Successfully Book is Return";
		}
		else
		{
			String title,author;
			int No,availablity,pageNo;
			title=DAO.hardmedia.get(isbnNo).title;
			author=DAO.hardmedia.get(isbnNo).author;
			No=DAO.hardmedia.get(isbnNo).isbnNo;
			availablity=DAO.hardmedia.get(isbnNo).availablity;
			pageNo=DAO.hardmedia.get(isbnNo).pageNo;
			DAO.hardmedia.remove(isbnNo);
			DAO.hardmedia.put(isbnNo,new HardMedia(isbnNo,title,author,availablity+1,pageNo));
			int Id, sem,bookBal;
			String name,branch;
			Id=DAO.student.get(userId).userId;
			sem=DAO.student.get(userId).sem;
			bookBal=DAO.student.get(userId).bookBal;
			name=DAO.student.get(userId).name;
			branch=DAO.student.get(userId).branch;
			DAO.student.remove(userId);
			DAO.student.put(userId,new Student(userId,name,sem,bookBal+1,branch));
			return "Successfully Book is Return";
		}
	}

	public int checkBal(int userId)
	{
		if(!DAO.student.containsKey(userId))
			return -1;
		else
			return DAO.student.get(userId).bookBal;
	}
	
	public String searchBook(String name)
	throws BookNotFoundException
	{
		String message="";
		String temp;
		for(int i:DAO.softmedia.keySet())
		{
			temp=DAO.softmedia.get(i).title;
			if(temp.indexOf(name)!=-1)
				message+=temp+"\n";
		}
		for(int i:DAO.hardmedia.keySet())
		{
			temp=DAO.hardmedia.get(i).title;
			if(temp.indexOf(name)!=-1)
				message+=temp+"\n";
		}
		
		if(message.length()==0)
			throw new BookNotFoundException();
		else
			return "\nBook is Found \n"+message;
	}
	public String showStudent(int i)
	{
		return DAO.student.get(i).userId+" "+
			   DAO.student.get(i).name+" "+
			   DAO.student.get(i).bookBal+" "+
			   DAO.student.get(i).branch+" "+
			   DAO.student.get(i).sem;
	}
	public String showStaff(int i)
	{
		return DAO.staff.get(i).userId+" "+
			   DAO.staff.get(i).name+" "+
			   DAO.staff.get(i).salary+" "+
			   DAO.staff.get(i).post;
	} 
	public String showHardMedia(int i)
	{
		return DAO.hardmedia.get(i).isbnNo+" "+
			   DAO.hardmedia.get(i).title+" "+
			   DAO.hardmedia.get(i).author+" "+
			   DAO.hardmedia.get(i).pageNo;
	}
	public String showSoftMedia(int i)
	{
		return DAO.softmedia.get(i).isbnNo+" "+
			   DAO.softmedia.get(i).title+" "+
			   DAO.softmedia.get(i).author+" "+
			   DAO.softmedia.get(i).size;
	}
}