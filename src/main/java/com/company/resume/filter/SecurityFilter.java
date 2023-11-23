package com.company.resume.filter;

import com.company.resume.util.ControllerUtil;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "JSPSecurity",urlPatterns = {"*"})
public class SecurityFilter implements Filter {
    public void doFilter(ServletRequest reqs, ServletResponse resp, FilterChain chain){
        try {

        HttpServletRequest req=(HttpServletRequest) reqs;
        HttpServletResponse res=(HttpServletResponse) resp;
            System.out.println(!req.getRequestURI().contains("/login"));
            System.out.println(req.getRequestURI());
        if(!req.getRequestURI().contains("/login")&& req.getSession().getAttribute("loggedInUser")==null){
//            ControllerUtil.errorPage(res,new IllegalArgumentException("Not found"));
            res.sendRedirect("login");
        }else {
            chain.doFilter(reqs,resp);
        }}catch (Exception e){
            e.printStackTrace();
        }
    }
}
