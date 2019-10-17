package com.vvp.lib.model;

public class Media
{
	public String title,author;
	public int isbnNo,availablity;
	public Media(int isbnNo,String title,String author,int availablity)
	{
		this.title=title;
		this.author=author;
		this.isbnNo=isbnNo;
		this.availablity=availablity;
	}
}