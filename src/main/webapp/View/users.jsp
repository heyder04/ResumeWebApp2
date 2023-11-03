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
        <link rel="stylesheet" href="../assets/css/users.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
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
       <div class="container " >
       <div  class="col-4">
        <form class="form-group" action="users.jsp" value="GET">

        <label for="name">Name:</label>
        <input class="form-control" type="text" name="name" value="">
        <br>
        <label for="surname">Surname:</label>
        <input class="form-control" type="text" name="surname" value="">
        <br>
        <input class="btn btn-primary" type="submit" value="search" name="search">
       
        </form>
       </div>

    <div>
        <table class="table">
            <thead>
            <tr>
                <th>name</th>
                <th>surname</th>
                <th>nationality</th>
                <th></th>
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
                    <button class="btn btn-danger" type="submit" value="delete" name="action">

                        <i class="fa-solid fa-trash"></i>
                    </button>
                    <button class="btn btn-primary" type="submit" value="update" name="action">
                        <i class="fa-solid fa-pen-to-square"></i>

                    </button>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
       </div>
    </body>
</html>
