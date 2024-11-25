package com.domain.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.domain.model.AdminLogin;
import com.domain.model.User;

public class UserDAO 
{
	private final static String selectAllUsers = " select * from user ";
	private final static String selectAlladmin = " select * from admin_login ";
	private final static String insertUser = "insert into user(name, email,country) values(?,?,?)";
	private final static String updateUser = "update user set name = ?, email = ?, country = ? where id = ?";
	private final static String selectUserById = "select * from user where id = ?";
	private final static String deleteUser = "delete from user where id = ?";
	
	private final static String url = "jdbc:mysql://localhost:3306/usermanagement";
	private final static String username = "root";
	private final static String password = "sadhu";
	private final static String driverpath = "com.mysql.cj.jdbc.Driver";
	private static Connection cn = null;
    private static Statement stm = null;
    private static PreparedStatement ps = null;
    
    public static ArrayList<AdminLogin> getAdminDetails() 
	{
		ArrayList<AdminLogin> alAdmin = new ArrayList<AdminLogin>();
		try 
		{
			Class .forName(driverpath);
			cn = DriverManager.getConnection(url,username,password);
			stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(selectAlladmin);
			while(rs.next()) 
			{
				String e = rs.getString(1);
				String p = rs.getString(2);
				AdminLogin a = new AdminLogin(e,p);
				alAdmin.add(a);
			}
		}
		catch (ClassNotFoundException e) 
		{			
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				stm.close();
				cn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		return alAdmin;
		
	}
    
    public static void deleteUser(int id) 
    {
    	try 
		{
			Class .forName(driverpath);
			cn = DriverManager.getConnection(url,username,password);
			ps = cn.prepareStatement(deleteUser);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				ps.close();
				cn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
    }
    
    
    public static User getUserById(int id) 
    {
    	User u = null;
    	try 
		{
			Class .forName(driverpath);
			cn = DriverManager.getConnection(url,username,password);
			ps = cn.prepareStatement(selectUserById);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String n = rs.getString(2);
			String e = rs.getString(3);
			String c = rs.getString(4);
			u = new User(id,n,e,c);
			
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				stm.close();
				cn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return u;
    	
    }
    
    
    public static void updateUser(User user) 
    {
    	try 
		{
			Class .forName(driverpath);
			cn = DriverManager.getConnection(url,username,password);
			ps = cn.prepareStatement(updateUser);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getCountry());
			ps.setInt(4, user.getId());
			ps.executeUpdate();
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				ps.close();
				cn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}

    }
    
    
    public static void inserUser(User user) 
    {
		try 
		{
			Class .forName(driverpath);
			cn = DriverManager.getConnection(url,username,password);
			ps = cn.prepareStatement(insertUser);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getCountry());
			ps.executeUpdate();
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				ps.close();
				cn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
    }
    
    
	public static ArrayList<User> getAllUsers()
	{
		ArrayList<User> alU = new ArrayList<User>();
		
		try 
		{
			Class .forName(driverpath);
			cn = DriverManager.getConnection(url,username,password);
			stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(selectAllUsers);
			while(rs.next()) 
			{
				int i = rs.getInt(1);
				String n = rs.getString(2);
				String e = rs.getString(3);
				String c = rs.getString(4);
				
				User u = new User(i, n, e, c);
				alU.add(u);
				
				
			}
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				stm.close();
				cn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		return alU;
	}
	

}
