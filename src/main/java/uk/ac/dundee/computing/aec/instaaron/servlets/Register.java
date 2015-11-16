/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.computing.aec.instaaron.servlets;

import com.datastax.driver.core.Cluster;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.dundee.computing.aec.instaaron.lib.CassandraHosts;
import uk.ac.dundee.computing.aec.instaaron.models.User;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {
    Cluster cluster=null;
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        cluster = CassandraHosts.getCluster();
    }




    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        String email=request.getParameter("email");
        String houseno=request.getParameter("houseno");
        String street=request.getParameter("street");
        String city=request.getParameter("city");
        //int zip=request.getParameter("zip"); // fix for Integer?
        
        User us=new User();
        us.setCluster(cluster);
        //send to RegisterUser method in User
        //added firstname, lastname, still to add email and profile pic
        us.RegisterUser(username, password, firstname, lastname, email, houseno, street, city);
        
	response.sendRedirect("/InstAaron"); //redirect to index.jsp
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
