package com.vvp.lib.controller;
public class UserNotFoundException extends Exception
{
	public String toString()
	{
		return "com.vvp.lib.controller.UserNotFoundException : User Not Registered in Library ";
	}
}