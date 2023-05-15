<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
     import="java.util.*,in.jo.pojo.*,in.jo.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
Order o=(Order)session.getAttribute("order");
%>
<table class="table table-hover table-striped">


<tr class="table-primary">


<th>Order Id</th>

<th>Order Total</th>

<th>Order Date</th>

<th>Order Status</th>



</tr>


<tr>


<td><%=o.getOrderid() %></td>

<td><%= o.getOrdertotal() %></td>

<td><%= o.getOrderdate() %></td>

<td><%= o.getOrderstaus() %></td>

</tr>
</table>
<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>