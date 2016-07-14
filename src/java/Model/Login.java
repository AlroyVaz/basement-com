package Model;

/*
 * @author Alroy
 */
public class Login {
    private String loginID;
    private String password;

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the value of loginID
     *
     * @return the value of loginID
     */
    public String getLoginID() {
        return loginID;
    }

    /**
     * Set the value of loginID
     *
     * @param loginID new value of loginID
     */
    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }
  
}
