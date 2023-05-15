<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="in.jo.pojo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="/JustOrganicOnlineProject/images/a.jpg"
   style=" background-size: cover; 
   background-repeat:no-repeat;">
<%
Customer c=(Customer)session.getAttribute("customer");
%>
<jsp:include page="header.jsp"></jsp:include>

<form action="/JustOrganicOnlineProject/cr" method="post"  >

<div class="container mb-3 shadow-lg p-3 mb-5 bg-body rounded mt-5" style="width:400px">
<p class="text-primary text-center h2 m-3">Update Customer here!!</p>
<input type="hidden" name="action" value="updateCustomer">
 
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label mt-2">Customer id</label>
    <input type="text" class="form-control" name="customerid" value="<%=c.getCustomerid()%>"id="exampleInputEmail1"
     aria-describedby="emailHelp" readonly="readonly">
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label mt-2">Customer Name</label>
    <input type="text" class="form-control" name="customername" value="<%=c.getCustomername()%>"id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>

  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label mt-2">Customer email</label>
    <input type="email" class="form-control"  name="customeremail" value="<%=c.getCustomeremail() %>" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
   <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label mt-2">Customer contact</label>
    <input type="text" class="form-control" name="customercontact" id="exampleInputEmail1" value="<%=c.getCustomercontact()%>"aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label mt-2">Customer Address</label>
    <input type="text" class="form-control" name="customeraddress" id="exampleInputEmail1" value="<%=c.getCustomeraddress()%>"aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label mt-2">Customer Pass</label>
    <input type="password" class="form-control" name="customerpass" id="exampleInputEmail1" value="<%=c.getCustomerpass()%>"aria-describedby="emailHelp">
  </div>
 
 
  <button type="submit" class="btn btn-primary w-100">Update Customer</button>
  </form>
 </div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
