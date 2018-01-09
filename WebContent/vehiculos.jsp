<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, com.empresa.model.Propietario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
      <form method="POST" action="VehiculoServlet">
            <input type="submit" value="Add" />
        </form>
 
        <hr><ol> <%
            @SuppressWarnings("unchecked") 
            List<Propietario> propietarios = (List<Propietario>)request.getAttribute("propietarios");%>
        	<li> Resgistros: <%= propietarios.size() %> </li>
        	<%
            if (propietarios != null) {
                for (Propietario propietario : propietarios) { %>
                    <li> Usr> <%= propietario.toString() %></li> <%
                }
            } else {%>
            	<li>Lista vacía</li> <%
            }%>
        </ol><hr>
 
        <!--iframe src="http://www.objectdb.com/pw.html?jee-eclipse"
            frameborder="0" scrolling="no" width="100%" height="30"> 
        </iframe -->
</body>
</html>