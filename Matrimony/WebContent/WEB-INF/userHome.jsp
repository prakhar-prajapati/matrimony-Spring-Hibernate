<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@page import="java.util.ArrayList ,bean.userBean" %>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<h2 align="center"><font color="red"> Welcome ${uid}</font></h2>
<%
ArrayList<userBean> list= (ArrayList<userBean>)request.getAttribute("LIST");
 %>
 
 	  <div class="container">
	  <table class="table table-bordered">
	 <tr><th>NAME</th><th>GENDER</th><th>D.O.B</th><th>Religion</th><th>Mother-tongue</th><th>caste</th><th>Country</th><th>Mobile</th></tr>
	  <%
for(userBean rs:list)
{
%>
      <tr>
		        <td><%=rs.getName()%></td>
		        <td><%=rs.getGender()%></td>
		        <td><%=rs.getDob()%></td>
		        <td><%=rs.getReligion()%></td>
		         <td><%=rs.getMother_tongue()%></td>
		        <td><%=rs.getCaste()%></td>
		        <td><%=rs.getCountry()%></td>
		         <td><%=rs.getMobile()%></td>
		        
		       
		         </tr>
		  <%
	   }
	  %>
	  </table>
	  </div>
 
</body>
</html>