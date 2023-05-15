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
<body>
<jsp:include page="header.jsp"></jsp:include>

<%
String msg=(String)request.getAttribute("msg");
List<Cart> clist=(List<Cart>)session.getAttribute("clist");
OrderDao odao=new OrderDao();
String email=(String)session.getAttribute("uname");
if(clist.isEmpty()){
%>
<p class="text-danger text-center h1 m-5"><%= "Your Cart is empty" %></p>
<%} else { %>


<table class="table table-hover table-striped">
<h1 class="text-center">My Cart</h1>

<tr class="table-primary">



<th>Product Image</th>

<th>Product Name</th>

<th>Product Category</th>

<th>Product Weight</th>

<th>Product Price</th>
<th>Product Quantity</th>


<th colspan=2>Operations</th>

</tr>

<c:forEach var="c" items="${clist }">

<tr>

<td><img src="/JustOrganicOnlineProject/pic?productid=${c.getProduct().getProductid() }" width="80" height="100"></td>

<td>${c.getProduct().getProductname() }</td>

<td>${c.getProduct().getProductcategory()}</td>

<td>${c.getProduct().getProductweight() }</td>

<td>${c.getProduct().getProductprice() }</td>

<td>${c.getQuantity() }</td>

<td><a href="/JustOrganicOnlineProject/cartc?action=delete&pid=${c.getCartid()}"  class="btn btn-danger">delete</a></td>

</tr>
</c:forEach>
<tr>

<td colspan=5>Total</td>
<td><%=odao.getTotal(email) %></td>
<td><a href="/JustOrganicOnlineProject/orderc?action=placeorder" class="btn btn-success">Order</a>
</td>
</tr>
</table>
<%} %>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>