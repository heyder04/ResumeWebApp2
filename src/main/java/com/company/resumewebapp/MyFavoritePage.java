/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.company.resumewebapp;

import com.company.dao.impl.SkillDaoImpl;
import com.company.dao.impl.UserDaoImpl;
import com.company.entity.Skill;
import com.company.entity.User;
import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.dao.inter.UserDaoInter;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "MyFavoritePage", urlPatterns = {"/MyFavoritePage"})
public class MyFavoritePage extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        int id=Integer.parseInt(request.getParameter("id"));
//        User users=userDao.getById(id);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyFavoritePage</title>");            
            out.println("</head>");
            out.println("<body>");
//                out.println(users+"</br>");
       
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private UserDaoInter userDao=new UserDaoImpl();
    private SkillDaoInter skillDao=new SkillDaoImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       String requestStr=getAllDataFromRequest(request);
//         System.out.println(requestStr);
         String name =String.valueOf(request.getParameter("name"));
         skillDao.insertSkill(new Skill(0,name));
           response.setContentType("text/html;charset=UTF-8");
//        String name=String.valueOf(request.getAttribute("name"));
//        String surname=String.valueOf(request.getAttribute("surname"));
//        User u=new User(0,name,surname,null,null,null,null,null,null);
//        boolean users=userDao.addUser(u);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyFavoritePage</title>");            
            out.println("</head>");
            out.println("<body>");
           
                out.println("inserted skills"+skillDao.getAll()+"</br>");
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }


 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
