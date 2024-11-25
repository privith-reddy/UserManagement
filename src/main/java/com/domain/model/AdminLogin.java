package com.domain.model;

public class AdminLogin 
{
	private String email;
	private String pw;
	
	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPw() 
	{
		return pw;
	}

	public void setPw(String pw)
	{
		this.pw = pw;
	}


	public AdminLogin(String email, String pw) 
	{
		super();
		this.email = email;
		this.pw = pw;
	}
	
	

}
