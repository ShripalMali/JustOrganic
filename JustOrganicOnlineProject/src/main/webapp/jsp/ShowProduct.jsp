<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,in.jo.pojo.*"%>
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

List<Product>plist=(List<Product>)session.getAttribute("plist");
if(msg!=null){%>
<p class="text-danger text-center h1 m-5"><%= msg %></p>
<%} %>
<% String utype=(String)session.getAttribute("utype");
%>

<div class="container mt-5 pt-5">
<div class="row">
<c:forEach var="p" items="${plist}">
<div class="col-4 mb-5">
<div class="card" style="width: 18rem;transition: all 0.3s ease;">
 <img src="/JustOrganicOnlineProject/pic?productid=${p.getProductid()}"width="80" height="175" class="card-img-top">
<div class="card-header text-center" >
<h5>${p.getProductname()}</h5>
</div>
<div class="card-body">
<p class="card-text"> 1Kg -&#8377;${p.getProductprice()}/- </p>
Qty:  <input type="text" name="quantity" placeholder=" Quantity" value="1">
 </div>
 <%if(utype!=null && utype.equals("admin")) {%>
  <div class="card-footer text-center">
  <a href="/JustOrganicOnlineProject/pc?action=edit&pid=${p.getProductid()}" class="btn btn-success">update</a>
  <a href="/JustOrganicOnlineProject/pc?action=deleteProduct&pid=${p.getProductid()}" class="btn btn-danger">delete</a>
 </div>
 <%} %>
  <%if(utype==null || utype.equals("customer")) {%>
<div class="card-footer text-center">
<a href="/JustOrganicOnlineProject/cartc?action=addtocart&pid=${p.getProductid()}" class="btn btn-primary">Add to Cart</a>
  </div>
<%} %>

 </div>
</div>
</c:forEach>
</div>


</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
</body>
</html>