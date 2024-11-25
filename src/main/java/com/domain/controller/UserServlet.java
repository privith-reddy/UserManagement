package com.domain.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.dao.UserDAO;
import com.domain.model.AdminLogin;
import com.domain.model.User;

@WebServlet("/")
public class UserServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path = request.getServletPath();
		
		switch(path) 
		{
		case "/delete":
			deleteUser(request,response);
			break;
		case "/edit":
			displayEditPage(response,request);
			break;
		case "/insert":
			insertUser(request,response);
			break;
		case "/update":
			updateUser(request,response);
			break;
		case "/new":
			displayFormPage(request,response);
			break;
		case"/list":
			displayStartUpPage(request, response);
			break;
		case "/login":
			validateAdmin(request,response);
			break;
		default:
			displayadminPage(request, response);
			break;
		}
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
	{
		// Read the id present in url:
		int i = Integer.parseInt(request.getParameter("id"));
		
		// Call the deleteUser() present in DAO layer:
		UserDAO.deleteUser(i);
		
		try 
		{
			// After deleting the user we are redirecting admin to user-list.jsp for verification
			response.sendRedirect(request.getContextPath() + "/list");
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
		
	}


	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
	{
		String n = request.getParameter("tbName");
		String e = request.getParameter("tbEmail");
		String c = request.getParameter("tbCountry");
		int id = Integer.parseInt(request.getParameter("tbId"));
		
		// Store the above values in User object
		User u = new User(id, n, e, c);
		
		//Call the method present in DAO layer with above input:
		UserDAO.updateUser(u);
		
		try 
		{
			//Redirect User to user-list.jsp
			response.sendRedirect(request.getContextPath() + "/list");
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
	}


	private void displayEditPage(HttpServletResponse response, HttpServletRequest request) 
	{
		// Read the id value from url:
		int id = Integer.parseInt(request.getParameter("id"));
		
		// call the method present in DAO:
		User user = UserDAO.getUserById(id);
		
		// Send the above user details to the form page:
		request.setAttribute("user", user);
		
		
		try 
		{
			// Redirect to the user-form.jsp:
			RequestDispatcher rd = request.getRequestDispatcher("user-form.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
	}


	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
	{
		//Read user data:
		String n = request.getParameter("tbName");
		String e = request.getParameter("tbEmail");
		String c = request.getParameter("tbCountry");
		
		// Store the above data in User object:
		User u = new User(n, e, c);
		
		// Send the above object as a input for insertUser method in userDAO
		UserDAO.inserUser(u);
		
		
		try 
		{
			//Redirect User to user-list.jsp
			response.sendRedirect(request.getContextPath() + "/list");
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
		
	}


	private void displayFormPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			// Code for redirecting user to the startup page [user-form.jsp]
			RequestDispatcher rd = request.getRequestDispatcher("user-form.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}


	private void displayStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
		ArrayList<User> al = UserDAO.getAllUsers();
		request.setAttribute("listUser", al);
		try 
		{
			// Code for redirecting user to the startup page [user-list.jsp]
			RequestDispatcher rd = request.getRequestDispatcher("user-list.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	private void validateAdmin(HttpServletRequest request, HttpServletResponse response) 
	{
		// Read the data from control to validate:
		String e = request.getParameter("tbEmail");
		String p = request.getParameter("tbPass");
				
		ArrayList<AdminLogin> al = UserDAO.getAdminDetails();
				
		boolean login = false;
		for(AdminLogin a : al) 
		{
			if(a.getEmail().equals(e) && a.getPw().equals(p)) 
			{
				login = true;
			}	
		}
		if(login) 
		{
					
			try 
			{
				RequestDispatcher rd = request.getRequestDispatcher("user-form.jsp");
				rd.forward(request, response);
			}
			catch (ServletException e1)
			{
				e1.printStackTrace();
			}
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
					
		}
		else 
		{
		    try 
		    { 
			   RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			   rd.forward(request, response);
		    }	
		    catch (ServletException e1)
		    {
				e1.printStackTrace();
			}
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}	
		}
	}
	
	private void displayadminPage(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try 
		{
			RequestDispatcher rd = request.getRequestDispatcher("admin-login.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
