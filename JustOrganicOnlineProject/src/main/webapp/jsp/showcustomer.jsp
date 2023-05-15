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
<jsp:include page="header.jsp"/>
<%
List<Customer> clist=(List<Customer>)session.getAttribute("clist");
if(!clist.isEmpty()){
%>


<p class="text-primary text-center h2 m-3">Customer List </p>
<table class="table table-hover table-striped">


<tr class="table-primary">

<th>Customer Id</th>

<th>Customer Name</th>

<th>Customer Email</th>

<th>Customer Contact</th>

<th>Customer Address</th>

<th>Customer Pass</th>

<th colspan=2>Operations</th>

</tr>

<c:forEach var="c" items="${clist }">

<tr>

<td>${c.getCustomerid()}</td>

<td>${c.getCustomername() }</td>

<td>${c.getCustomeremail()}</td>

<td>${c.getCustomercontact() }</td>

<td>${c.getCustomeraddress() }</td>

<td>${c.getCustomerpass() }</td>

<td><a href="/JustOrganicOnlineProject/cr?action=edit&cid=${c.getCustomerid() }" class="btn btn-success">Update</a></td>
<td><a href="/JustOrganicOnlineProject/cr?action=delete&cid=${c.getCustomerid() }" class="btn btn-danger">Delete</a></td>

</tr>
</c:forEach>
</table>
<%
String msg=(String)request.getAttribute("msg");
if(msg!=null){
%>
<script>
alert("<%=msg%>");
</script>
<%} %>
<%} else{ %>
<p  class="text-primary text-center h2 m-3">List is not availabe </p>
<%} %>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>