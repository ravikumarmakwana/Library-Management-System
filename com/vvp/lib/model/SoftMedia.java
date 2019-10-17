package com.vvp.lib.model;
import java.io.*;
import java.util.*;
public class SoftMedia extends Media
{
	public int size;
	public SoftMedia(int isbnNo,String title,String author,int availablity,int size)
	{
		super(isbnNo,title,author,availablity);
		this.size=size;
	}
} 