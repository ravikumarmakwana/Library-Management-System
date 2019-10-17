package com.vvp.lib.controller;
public class BookNotFoundException extends Exception
{
	public String toString()
	{
		return "com.vvp.lib.controller.BookNotAvailableException : Book is not Found in Library ";
	}
}
