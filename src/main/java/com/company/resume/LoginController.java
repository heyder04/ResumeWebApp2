/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.company.resume;

import com.company.dao.impl.UserDaoImpl;
import com.company.entity.User;
import com.company.resume.util.ControllerUtil;
import com.mycompany.dao.inter.UserDaoInter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author HP
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
  private UserDaoInter userDao=new UserDaoImpl();
    @Override
    protected void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request,response);

        }

    @Override
    protected void  doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try{
       String email =request.getParameter("email");
       String password =request.getParameter("password");
       User user=userDao.findByEmailAndPassword(email,password);
       if(user==null){
           throw new IllegalArgumentException("Email or password is incorrect ");
       }
       request.getSession().setAttribute("loggedInUser",user);
       response.sendRedirect("users");
        }catch(Exception e){
          ControllerUtil.errorPage(response,e);
      }}
}
