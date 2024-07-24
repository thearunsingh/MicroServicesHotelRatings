package com.icwd.user.service.exceptions;

public class ResourseNotFoundException extends RuntimeException{
	
	public ResourseNotFoundException()
	{
		super("Resourse not found on the server");
	}
	
	public ResourseNotFoundException(String message)
	{
		super(message);
	}

}
