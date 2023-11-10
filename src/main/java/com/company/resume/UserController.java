/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.company.resume;

import com.company.dao.impl.UserDaoImpl;
import com.company.entity.User;
import com.mycompany.dao.inter.UserDaoInter;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "Users", urlPatterns = {"/users"})
public class UserController extends HttpServlet {
UserDaoInter userDao=new UserDaoImpl();

  


    @Override
    protected void  doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDaoInter userDao=new UserDaoImpl();
        String name =request.getParameter("name");
        String surname =request.getParameter("surname");
        String nationalityIdStr=request.getParameter("nid");
        Integer nationalityId=null;
        if(nationalityIdStr!=null && !nationalityIdStr.trim().isEmpty()) {
            nationalityId =Integer.parseInt(nationalityIdStr);

        }

        List<User> list=userDao.getAll(name,surname,nationalityId);
        request.setAttribute("list",list);
        request.getRequestDispatcher("users.jsp").forward(request,response);
        }


}
