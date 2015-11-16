/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.computing.aec.instaaron.stores;

/**
 *
 * @author Administrator Modified by Aaron McEwen
 */
public class LoggedIn {
    boolean logedin=false;
    String Username=null;
    
    /*
    <li>First Name <input type="text" name="firstname"></li>
    <li>Last Name <input type="text" name="lastname"></li>
    <li>Email <input type="text" name="email"></li>
    <li>House No. <input type="text" name="address1"></li>
    <li>Street <input type="text" name="address2"></li>
    <li>City <input type="text" name="address3"></li>
    <li>Zip <input type="integer" name="address4"></li>
    */
    
    //add profile details here
    private String firstName=null;
    private String lastName=null;
    private String email=null;

    
    public void LogedIn(){
        
    }
    
    public void setUsername(String name){
        this.Username=name;
    }
    public String getUsername(){
        return Username;
    }
    public void setLogedin(){
        logedin=true;
    }
    public void setLogedout(){
        logedin=false;
    }
    
    public void setLoginState(boolean logedin){
        this.logedin=logedin;
    }
    public boolean getlogedin(){
        return logedin;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
