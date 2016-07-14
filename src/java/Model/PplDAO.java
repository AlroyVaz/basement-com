package Model;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * @author Alroy
 */
public class PplDAO extends BaseDAO{
    Connection connection;
    PreparedStatement stmt = null;
    Statement s = null;
    ResultSet rs = null;
    
    
    public boolean checkLogin(Login l) {
        String loginID=l.getLoginID();
        String password=l.getPassword();
        
        connection=getConnection();
        try {
            s = connection.createStatement();
              //rs=s.executeQuery("select * from login.people where id='"+loginID+"' and password='"+password+"'");

              rs=s.executeQuery("select * from basement_login.people where ID='"+loginID+"' and Password='"+password+"'");
              while( rs.next())
              {
              return true;}
        } catch (SQLException ex) {
            Logger.getLogger(PplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    public void createAccount(Ppl e)
    {
        connection = getConnection();
	String sql="insert into basement_login.people values(?, ?, ?, ?, ?, ?)";
        String id = e.getId();
        String password = e.getPassword();
        String firstname=e.getFirstname();
        String lastname = e.getLastname();
        String email = e.getEmail();
        int count1 = e.getCount();

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.setString(2, password);
            stmt.setString(3, firstname);
            stmt.setString(4, lastname);
            stmt.setInt(5, count1);
            stmt.setString(6, email);
         
            int count=stmt.executeUpdate();
        if(count>0)
        {
            System.out.println("Successfully inserted");
        }
        else
        {
            System.out.println("Unsuccessful insertion");
        }


        } catch (SQLException ex) {
            Logger.getLogger(PplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }//finally
    }
    
    public void removeAccount(String firstname) {
        connection = getConnection();

        try {
             s=connection.createStatement();

            int count= s.executeUpdate("delete from basement_login.people where firstname like '%" + firstname + "%'");

            if(count>0)
            {
                System.out.println("Successfully Deleted");
            }
            else
            {
                System.out.println("Unsuccessful Deletion");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                connection.close();
                s.close();
            } catch (SQLException ex) {
                Logger.getLogger(PplDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    public Ppl findPersonByID(String id)
    {
       

        Ppl e=new Ppl();
        try {
            connection = getConnection();
            //stmt=connection.prepareStatement("select * from login.people where id=?");
             rs=s.executeQuery("select * from basement_login.people where ID='"+id+"'");
            //rs = stmt.executeQuery();
            while(rs.next())
            {
             e.setId(rs.getString(1));
             e.setPassword(rs.getString(2));
             e.setFirstname(rs.getString(3));
             e.setLastname(rs.getString(4));
             e.setCount(rs.getInt(5));
             e.setEmail(rs.getString(6));
             
            }
           } catch (SQLException ex) {
            Logger.getLogger(PplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return e;
    }
    
    /*public void increamentCount(Ppl p, int size){
        
    }
    
    public int getCount(Ppl p){
        String loginID=p.getId();
        String password=p.getPassword();
        
        connection=getConnection();
        try {
            s = connection.createStatement();

              rs=s.executeQuery("select count from basement_login.people where ID='"+loginID+"' and Password='"+password+"'");
              while( rs.next())
              {
               return rs.getInt(1);
               
              }
        } catch (SQLException ex) {
            Logger.getLogger(PplDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }
    */
}
