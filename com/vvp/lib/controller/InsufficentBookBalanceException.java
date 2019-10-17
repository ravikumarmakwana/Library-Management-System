package com.vvp.lib.controller;
public class InsufficentBookBalanceException extends Exception
{
	public String toString()
	{
		return "com.vvp.lib.controller.InsuofficentBookBalanceException : You not able to issue Book";
	}
}