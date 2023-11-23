package com.company.resume.util;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.http.HttpServletResponse;

public class ControllerUtil {
    public static void errorPage(HttpServletResponse resp, Exception ex){
        try {
            ex.printStackTrace();

            resp.sendRedirect("error?msg="+ex.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
