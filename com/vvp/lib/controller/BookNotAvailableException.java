package com.vvp.lib.controller;
public class BookNotAvailableException extends Exception
{
	public String toString()
	{
		return "com.vvp.lib.controller.BookNotAvailableException : Book is Not Available";
	}
}