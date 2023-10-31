<%-- 
    Document   : Users
    Created on : Oct 1, 2023, 4:35:03 PM
    Author     : HP
--%>

<%@page import="com.company.entity.User"%>
<%@page import="com.company.dao.impl.UserDaoImpl"%>
<%@page import="com.mycompany.dao.inter.UserDaoInter"%>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="assets/css/users.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
          UserDaoInter userDao=new UserDaoImpl();
          String name =request.getParameter("name");
          String surname =request.getParameter("surname");
          String nationalityIdStr=request.getParameter("nid");
           Integer nationalityId=null;
          if(nationalityIdStr!=null && !nationalityIdStr.trim().isEmpty()) {
             nationalityId =Integer.parseInt(nationalityIdStr);

          }

          List<User> list=userDao.getAll(name,surname,nationalityId);

       %>
       <div >
       <div class="control-panel">
        <form action="users.jsp" value="GET">

        <label for="name">Name:</label>
        <input type="text" name="name" value="">
        <br>
        <label for="surname">Surname:</label>
        <input type="text" name="surname" value="">
        <br>
        <input type="submit" value="search" name="search">
       
        </form>
       </div>

    <div>
        <table>
            <thead>
            <tr>
                <th>name</th>
                <th>surname</th>
                <th>nationality</th>
                <th>operations</th>
            </tr>
            </thead>
            <tbody>
            <%
              for(User u:list){
            %>
            <tr>
                <td><%=u.getName()%></td>
                <td><%=u.getSurname()%></td>
                <td><%=u.getNationality().getName()==null?"N/A":u.getNationality().getName()%></td>
                <td>
                    <input class="btn" type="submit" value="delete" name="action"/>
                    <input class="btn" type="submit" value="update" name="action"/>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
       </div>
    </body>
</html>
