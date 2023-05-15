<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    import="java.util.*,in.jo.pojo.*,in.jo.dao.*"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
<%
List<Order>orderlist=(List<Order>)session.getAttribute("orderlist");

if(orderlist.isEmpty()){
%>
<%  }else { %>


<table class="table table-hover table-striped">
<tr class="table-primary">
<th>Order Id</th>

<th>Order Email</th>

<th>Order Total</th>

<th>Order Date</th>

<th>Order Status</th>

</tr>



<c:forEach var="c" items="${orderlist }">

<tr>

<td>${c.getOrderid() } </td>

<td>${c.getCustomeremail() } </td>

<td>${c.getOrdertotal()}</td>

<td>${c.getOrderdate() }</td>

<td>${c.getOrderstaus() }</td>


</tr>
</c:forEach>
<tr>
</table>
<%} %>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>