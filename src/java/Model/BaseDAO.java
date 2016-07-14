/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.*;
/**
 *
 * @author User
 */
public class BaseDAO {
    Connection con;
    public Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basement_login","root","ftss5442");

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	public void closeConnection()
	{
		try
		{
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
