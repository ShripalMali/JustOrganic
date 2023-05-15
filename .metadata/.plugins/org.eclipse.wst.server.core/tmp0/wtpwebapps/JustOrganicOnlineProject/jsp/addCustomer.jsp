<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body background="/JustOrganicOnlineProject/images/a.jpg"
   style=" background-size: cover; 
   background-repeat:no-repeat;"
 >

<jsp:include page="header.jsp"></jsp:include>
 
<%
String msg=(String)request.getAttribute("msg");
if(msg!=null){
%>
<script >
alert("<%=msg%>");
</script>
<%} %>

<form action="/JustOrganicOnlineProject/cr"  method="post"  >

<div class="container mb-3 shadow-lg p-3 mb-5 bg-body rounded mt-5" style="width:400px" c >
<p class="text-primary text-center h2 m-3">Register here!!</p>
<input type="hidden" name="action" value="addCustomer">
 
  <div class="mb-3"> 
    <label for="exampleInputEmail1" class="form-label mt-2">Customer Name</label>
    <input type="text" class="form-control" name="customername" id="exampleInputEmail1" >
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label mt-2">Customer Email</label>
    <input type="email" class="form-control"  name="customeremail" id="exampleInputEmail1" >
  </div>
   <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label mt-2">Customer contact</label>
    <input type="text" class="form-control" name="customercontact" id="exampleInputEmail1" >
  </div>
   <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label mt-2">Customer Address</label>
    <input type="text" class="form-control" name="customeraddress" id="exampleInputEmail1" >
  </div>
   <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label mt-2">Customer Password</label>
    <input type="password" class="form-control" name="customerpass" id="exampleInputEmail1" >
  </div>
  
  <button type="submit"  class="btn btn-primary w-100">Register</button>
 </div> </form>
  <jsp:include page="footer.jsp"/>
   
</body>
</html>