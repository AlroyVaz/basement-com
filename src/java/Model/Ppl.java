package Model;

/*
 * @author Alroy
 */
public class Ppl {
    private String first_name;
    private String last_name;
    private String id;
    private String password;
    private int count;
    private String email;
    
    /*Constructor*/
    public Ppl(String firstname, String lastname, String id, String password, String email){
        this.first_name = firstname;
        this.last_name = lastname;
        this.id = id;
        this.password = password;
        this.count = 0;
        this.email = email;
    }
    
    public Ppl(){
       
    }
    
    /*Getter methods*/
    public String getFirstname(){
        return this.first_name;
    }
    
    public String getLastname(){
        return this.last_name;
    }
    
    public String getId(){
        return this.id;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public int getCount(){
        return this.count;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    /*setter methods*/
    public void setFirstname(String firstname){
        this.first_name = firstname;
    }
    
    public void setLastname(String lastname){
        this.last_name = lastname;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setCount(int count){
        this.count = count;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void increamentCount(float size){
        this.count += size;
    }
}
