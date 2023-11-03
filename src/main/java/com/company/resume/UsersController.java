package com.company.resume;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.company.dao.impl.UserDaoImpl;
import com.company.entity.User;
import com.mycompany.dao.inter.UserDaoInter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author HP
 */
@WebServlet(name = "UserController", urlPatterns = {"/userdetail"})
public class UsersController extends HttpServlet {
UserDaoInter userDao=new UserDaoImpl();

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String action=request.getParameter("action");
        if(action.equals("update")){
      String name=request.getParameter("name");
      String surname=request.getParameter("surname");
      User user=userDao.getById(id);
      user.setName(name);
      user.setSurname(surname);
      userDao.updateUser(user);
      response.sendRedirect("users");}
        else if (action.equals("delete")){
    userDao.removeUser(id);
    response.sendRedirect("users");
        }

    }



    @Override
    protected void  doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        String userIdStr=request.getParameter("id");
        if(userIdStr==null ||  userIdStr.trim().isEmpty()){
            throw new IllegalArgumentException("id not specified");
        }
        Integer userId=Integer.parseInt(request.getParameter("id"));
        UserDaoInter userDao=new UserDaoImpl();
       User  u=userDao.getById(userId);
        if(u==null){
            throw new Exception("There is no user with this id");
        }
//        request.setAttribute("owner",true);
         request.setAttribute("user",u);
        request.getRequestDispatcher("userdetail.jsp").forward(request,response);
        }catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error?msg="+e.getMessage());
        }}

        @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
