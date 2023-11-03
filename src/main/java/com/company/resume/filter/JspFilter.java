package com.company.resume.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "JSPFileFilter",urlPatterns = {"*.jsp"})
public class JspFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain){
        HttpServletResponse res=(HttpServletResponse) resp;
        try {

            res.sendRedirect("error?msg=not found");
//            req.setAttribute("msg","not found");
//            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
