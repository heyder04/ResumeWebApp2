//package com.company.resume;
//
//import com.company.dao.impl.UserDaoImpl;
//import com.company.entity.User;
//import com.mycompany.dao.inter.UserDaoInter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class UserRequestUtil {
//public static void checkRequest(HttpServletRequest request, HttpServletResponse response)throws Exception{
//   //    UserDaoInter userDao=new UserDaoImpl();
//    String userIdStr=request.getParameter("id");
//    if(userIdStr==null ||  userIdStr.trim().isEmpty()){
////        request.setAttribute("msg","specify id");
//        throw new Exception("id not specified");
//    }
//
//}
//public static User processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
//    User u=null;
//
//        UserRequestUtil.checkRequest(request,response);
//
//
//        Integer userId=Integer.parseInt(request.getParameter("id"));
//        UserDaoInter userDao=new UserDaoImpl();
//
//        u=userDao.getById(userId);
//        if(u==null){
//            throw new Exception("There is no user with this id");
//        }
//        return u;
//    }
//
//}
