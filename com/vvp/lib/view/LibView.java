package com.vvp.lib.view;
import java.util.*;
import com.vvp.lib.model.*;
import com.vvp.lib.controller.*;
public class LibView 
{
	public static void main(String args[])
	throws Exception
	{
		DAO D=new DAO();
		D.getData();
		Transaction t=new Transaction();
		String name,message,branch,author,title,post;
		int userId,isbnNo,bal,sem,size,availablity,pageNo,salary;
		Scanner keybord=new Scanner(System.in);
		System.out.println("\n*** Libary Management System ***");
		while(true)
		{
			try{
			System.out.println();
			System.out.println("1. Add new Student");
			System.out.println("2. Add new Staff");
			System.out.println("3. Add new HardMedia");
			System.out.println("4. Add new SoftMedia");
			System.out.println("5. Issue Book");
			System.out.println("6. Return Book");
			System.out.println("7. Search Book");
			System.out.println("8. Check Book Balance");
			System.out.println("9. Status of Student");
			System.out.println("10.Show Student Details");
			System.out.println("11.Show Staff Details ");
			System.out.println("12.Show HardMedia Details");
			System.out.println("13.Show SoftMedia Details");
			System.out.println("14.Exit");
			System.out.print("Enter the Chice : ");
			int c=keybord.nextInt();
			switch(c)
			{
				case 1: System.out.print("Enter the userId : ");
						userId=keybord.nextInt();
						System.out.print("Enter the name : ");
						name=keybord.next();
						System.out.print("Enter the sem : ");
						sem=keybord.nextInt();
						System.out.print("Enter the branch : ");
						branch=keybord.next();
						DAO.student.put(userId,new Student(userId,name,sem,4,branch));
						System.out.println("Student is Successfully Registered");
						break;

				case 2: System.out.print("Enter the userId : ");
						userId=keybord.nextInt();
						System.out.print("Enter the name : ");
						name=keybord.next();
						System.out.print("Enter the salary : ");
						salary=keybord.nextInt();
						System.out.print("Enter the Post : ");
						post=keybord.next();
						DAO.staff.put(userId,new Staff(userId,name,salary,post));
						System.out.println("Staff is Successfully Registered");
						break;
				
				case 3:	System.out.print("Enter the ");
						System.out.print("Enter the isbnNo : ");
						isbnNo=keybord.nextInt();
						System.out.print("Enter the title : ");
						title=keybord.next();
						System.out.print("Enter the author : ");
						author=keybord.next();
						System.out.print("Enter the availablity : ");
						availablity=keybord.nextInt();
						System.out.print("Enter the pageNo : ");
						pageNo=keybord.nextInt();
						DAO.hardmedia.put(isbnNo,new HardMedia(isbnNo,title,author,availablity,pageNo));
						System.out.println("HardMedia is Successfully Registered");
						break;

				case 4: System.out.print("Enter the isbnNo : ");
						isbnNo=keybord.nextInt();
						System.out.print("Enter the title : ");
						title=keybord.next();
						System.out.print("Enter the author : ");
						author=keybord.next();
						System.out.print("Enter the availablity : ");
						availablity=keybord.nextInt();
						System.out.print("Enter the size : ");
						size=keybord.nextInt();
						DAO.softmedia.put(isbnNo,new SoftMedia(isbnNo,title,author,availablity,size));
						System.out.println("SoftMedia is Successfully Registered");
						break;

				case 5: System.out.print("Enter the userId : ");
						userId=keybord.nextInt();
						System.out.print("Enter the isbnNo : ");
						isbnNo=keybord.nextInt();
						message=t.issueBook(userId,isbnNo);
						System.out.println();
						System.out.println(message);
						break;

				case 6: System.out.print("Enter the userId : ");
						userId=keybord.nextInt();
						System.out.print("Enter the isbnNo : ");
						isbnNo=keybord.nextInt();
						message=t.returnBook(userId,isbnNo);
						System.out.println();
						System.out.println(message);
						break;
			
				case 7: System.out.print("Enter the Name of Book : ");
						name=keybord.next();
						message=t.searchBook(name);
						System.out.println(message);
						break;
		
				case 8: System.out.print("Enter the userId : ");
						userId=keybord.nextInt();
						bal=t.checkBal(userId);
						if(bal==-1)
							System.out.println("Wrong UserId");
						else
							System.out.println("Current BookBalance : "+ bal);
						break;
			
				/*case 9: System.out.print("Enter the UserId : ");
						userId=keybord.nextInt();
						message=t.status(userId);
						System.out.println(message);
						break;
				*/
				case 10: for(int i:DAO.student.keySet())
						 	System.out.println(t.showStudent(i));
						 break;

				case 11: for(int i:DAO.staff.keySet())
						 	System.out.println(t.showStaff(i));
						 break;

				case 12: for(int i:DAO.hardmedia.keySet())
						 	System.out.println(t.showHardMedia(i));
						 break;

				case 13: for(int i:DAO.softmedia.keySet())
						 	System.out.println(t.showSoftMedia(i));
						 break;
				
				case 14: System.out.println();
						 D.putData();
						 System.out.println("Thanking for Uisng Libary System ....");
						 System.out.println();
						 System.exit(0);
						 break;

				default:System.out.println("Wrong Choce !!\nPlease try Again .");
						break;
			}
			}
			catch(UserNotFoundException unfe)
			{
				System.out.println("Exception : "+unfe);
			}
			catch(BookNotAvailableException bnae)
			{                                                      
				System.out.println("Exception : "+bnae);
			}
			catch(InsufficentBookBalanceException ibbe)
			{
				System.out.println("Exception : "+ibbe);
			}
			catch(BookNotFoundException bnfe)
			{
				System.out.println("Exception : "+bnfe);
			}
			catch(InputMismatchException ime)
			{
				System.out.print(ime);
			}
			catch(Exception e)
			{
				System.out.println("Exception : "+e);
			}
			System.out.println();
		}
	}
}