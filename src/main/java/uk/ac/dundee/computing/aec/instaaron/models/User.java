/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.computing.aec.instaaron.models;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;//required for email set
import java.util.HashMap;//required for address map
import uk.ac.dundee.computing.aec.instaaron.lib.AeSimpleSHA1;
import uk.ac.dundee.computing.aec.instaaron.stores.Pic; //unused import?

/**
 *
 * @author Administrator
 */
public class User {
    Cluster cluster;
    public User(){
        
    }
    
    public boolean RegisterUser(
            String username,
            String Password,
            String firstname,
            String lastname,
            String email, 
            String houseno,
            String street,
            String city 
                    ){
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
        
        HashSet<String> emails = new HashSet(); //use a java HashSet to get email into db
        emails.add(email);  //add value of email to HashSet
       /*
        HashSet<String> addrset = new HashSet();
        addrset.add(street); //need values from register as before
        addrset.add(city);
        //addrset.add(zip);
        
        HashMap<String, addrset> = new HashMap();
        //Woah, Tricky one! A hashmap of string, hashset?
        */
        
        try {
            EncodedPassword= sha1handler.SHA1(Password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
            System.out.println("Can't check your password");
            return false;
        }
        
        //add profile pic unused pic import?
        //
        Session session = cluster.connect("instagrim");
        
        //CHANGED Values(?,?,?,?)
        PreparedStatement ps = session.prepare("insert into userprofiles (login, Password, first_name, last_name, email) values(?,?,?,?,?);");
       
        BoundStatement boundStatement = new BoundStatement(ps);
        session.execute(boundStatement.bind(username,EncodedPassword,firstname,lastname,emails));
        //We are assuming this always works.  Also a transaction would be good here !
        
        return true;
    }
    
    /**
     * 
     * @param username
     * @return 
     * 
     * @author Aaron
     */
    public void getProfileInfo(String username){
        
        Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("select username, first_name, last_name from userprofiles where username = ?");
        ResultSet rs = null;
        
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute(boundStatement.bind(username));
        
        if (rs.isExhausted()) {
            System.out.println("No user profile info returned");
            //
        } else {
            //get values from resultset and place them in LoggedIn 
           
        }
        session.close();
        //return rs; //return the ResultSet
    }
    
    public boolean IsValidUser(String username, String Password){
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
        try {
            EncodedPassword= sha1handler.SHA1(Password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
            System.out.println("Can't check your password");
            return false;
        }
        Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("select password from userprofiles where login =?");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username));
        if (rs.isExhausted()) {
            System.out.println("No Images returned");
            return false;
        } else {
            for (Row row : rs) {
               
                String StoredPass = row.getString("password");
                if (StoredPass.compareTo(EncodedPassword) == 0)
                    return true;
            }
        }
   
    
    return false;  
    }
       public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }

    
}
