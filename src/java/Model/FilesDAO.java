package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Files;
import java.util.List;
/*
 * @author Alroy
 */
public class FilesDAO extends BaseDAO{
    Connection connection;
    PreparedStatement stmt = null;
    Statement s = null;
    ResultSet rs = null;
    
    public void createFile(Files f) throws SQLException
    {
        connection = getConnection();
	String sql="insert into basement_login.files values(?, ?, ?, ?, ?)";
        String filename = f.getFilename();
        String path = f.getPath();
        String owner_id= f.getOwner();
        //String share_id = f.getShare();
        float size = f.getSize();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, filename);
            stmt.setString(2, owner_id);
            stmt.setString(3, "");
            stmt.setString(4, path);
            stmt.setFloat(5,size);
         
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
    
     public void shareFile(Files f, String shareid)
    {
        connection = getConnection();
	String sql="insert into basement_login.files values(?, ?, ?, ?, ?)";
        String filename = f.getFilename();
        String path = f.getPath();
        String owner_id= f.getOwner();
        String share_id = shareid;
        float size = f.getSize();

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, filename);
            stmt.setString(4, path);
            stmt.setString(2, owner_id);
            stmt.setString(3, share_id);
            stmt.setFloat(5, size);
         
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
     
    public void removeFile(String filename, String owner_id) {
        connection = getConnection();

        try {
             s=connection.createStatement();

            int count= s.executeUpdate("delete from basement_login.files where filename like '" + filename + "' and owner_id like '" + owner_id + "'");

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
    
    public List getFiles(String owner_id){
        ArrayList<Files> addlist = new ArrayList<Files>();
        Files f;
        int count=0;
        try{
            connection = getConnection();
            s = connection.createStatement();
            
            rs = s.executeQuery("select * from basement_login.files where owner_id="+owner_id);
            System.out.println("Out of while loop");
            
            while(rs.next()){
                f = new Files();
                f.setFilename(rs.getString("filename"));
                f.setOwner(rs.getString(2));
                f.setShare(rs.getString(3));
                f.setPath(rs.getString(4));
                f.setSize(rs.getFloat(5));
                addlist.add(f);
                //System.out.println(f.getFilename());
                //System.out.println();
                //System.out.println("in loop:"+addlist.get(count).getFilename());
                count++;
                
            }
            for(int i = 0; i < addlist.size(); i++){
                    System.out.println("test:"+addlist.get(i).getFilename());

            }
            rs.close();
            s.close();
            connection.close();
            return addlist;
        }
        catch(SQLException ex){
            Logger.getLogger(FilesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return addlist;
    }
    
    
    
    public List getFileDetails(String filename){
        ArrayList<Files> addlist = new ArrayList<Files>();
        Files f;
        int count=0;
        try{
            connection = getConnection();
            s = connection.createStatement();
            
            rs = s.executeQuery("select * from basement_login.files where filename='"+filename+"'");
            System.out.println("Out of while loop");
            
            while(rs.next()){
                f = new Files();
                f.setFilename(rs.getString("filename"));
                f.setOwner(rs.getString(2));
                f.setShare(rs.getString(3));
                f.setPath(rs.getString(4));
                f.setSize(rs.getFloat(5));
                addlist.add(f);
                //System.out.println(f.getFilename());
                //System.out.println();
                //System.out.println("in loop:"+addlist.get(count).getFilename());
                count++;
                
            }
            for(int i = 0; i < addlist.size(); i++){
                    System.out.println("test:"+addlist.get(i).getFilename());

            }
            rs.close();
            s.close();
            connection.close();
            return addlist;
        }
        catch(SQLException ex){
            Logger.getLogger(FilesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return addlist;
    }
    
    public List getShareFiles(String share_id){
        ArrayList<Files> addlist = new ArrayList<Files>();
        Files f;
        int count=0;
        try{
            connection = getConnection();
            s = connection.createStatement();
            
            rs = s.executeQuery("select * from basement_login.files where share_id="+share_id);
            System.out.println("Out of while loop");
            
            while(rs.next()){
                f = new Files();
                f.setFilename(rs.getString("filename"));
                f.setOwner(rs.getString(2));
                f.setShare(rs.getString(3));
                f.setPath(rs.getString(4));
                f.setSize(rs.getFloat(5));
                addlist.add(f);
                //System.out.println(f.getFilename());
                //System.out.println();
                //System.out.println("in loop:"+addlist.get(count).getFilename());
                count++;
                
            }
            for(int i = 0; i < addlist.size(); i++){
                    System.out.println("test:"+addlist.get(i).getFilename());

            }
            rs.close();
            s.close();
            connection.close();
            return addlist;
        }
        catch(SQLException ex){
            Logger.getLogger(FilesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return addlist;
    }
}
