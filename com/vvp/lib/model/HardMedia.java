package com.vvp.lib.model;
import java.io.*;
import java.util.*;
public class HardMedia extends Media
{
	public int pageNo;
	public HardMedia(int isbnNo,String title,String author,int availablity,int pageNo)
	{
		super(isbnNo,title,author,availablity);
		this.pageNo=pageNo;
	}
}