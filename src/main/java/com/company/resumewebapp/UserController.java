/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.company.resumewebapp;

import com.company.dao.impl.UserDaoImpl;
import com.company.entity.User;
import com.mycompany.dao.inter.UserDaoInter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {
UserDaoInter userDao=new UserDaoImpl();

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
      String name=request.getParameter("name");
      String surname=request.getParameter("surname");
        System.out.println("name"+name);
        System.out.println("surname"+surname);
      int id=Integer.parseInt(request.getParameter("id"));
      User user=userDao.getById(id);
      user.setName(name);
      user.setSurname(surname);
      userDao.updateUser(user);
//      response.sendRedirect("users.jsp");
response.getOutputStream().println("Succesfull");
response.getOutputStream().close();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
