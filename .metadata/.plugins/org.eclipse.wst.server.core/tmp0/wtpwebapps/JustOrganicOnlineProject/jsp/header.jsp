<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>www.justorganic.in</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
</head>
<body>

<% 
String utype=(String)session.getAttribute("utype");
String uname=(String)session.getAttribute("uname");

%>
<!-- ============================== Navbar ========================= -->
    <nav class="navbar navbar-expand-sm sticky-top navbar-light bg-warning text-black shadow">
        <div class="container-fluid">
            <a href="#" class="navbar-brand">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQOhu-vZ4RSquyDnhpxrm3R_8zxsxf2vsAUPQ&usqp=CAU" class="rounded-circle" alt="" width="50px" height="50px">
            </a>
            <a href="#nav2" class="navbar-toggler" data-bs-toggle="collapse" aria-controls="nav2" aria-expanded="false"
                aria-label="Toggle Navigation">
                <span class="navbar-toggler-icon"></span>
            </a>
            <div class="collapse navbar-collapse justify-content-between" id="nav2">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a href="index.jsp" class="nav-link active">Home</a>
                    </li>
                   
                    <li  class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown">Products</a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="/JustOrganicOnlineProject/pc?action=search&ptype=vegetable" class="dropdown-item">Vegetables</a>
                            </li>
                            <li>
                                <a href="/JustOrganicOnlineProject/pc?action=search&ptype=fruit" class="dropdown-item">Fruits</a>
                            </li>
                             <li>
                                <a href="/JustOrganicOnlineProject/pc" class="dropdown-item">All</a>
                            </li>
                     
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">About us</a>
                    </li>
                    
                    
                    <% if(utype!=null && utype.equals("admin")) { %>
                     <li class="nav-item">
                        <a href="/JustOrganicOnlineProject/jsp/addProduct.jsp" class="nav-link">Add Product</a>
                    </li>
                    <li class="nav-item">
                        <a href="/JustOrganicOnlineProject/cr" class="nav-link">Customer List</a>
                    </li>
                    <li class="nav-item">
                        <a href="/JustOrganicOnlineProject/olist" class="nav-link">Order List</a>
                    </li>
                    <%} %>
   					<% if(utype!=null && utype.equals("customer")) { %>
                     <li class="nav-item">
                        <a href="#" class="nav-link">My Profile</a>
                    </li> 
                    <li class="nav-item">
                        <a href="/JustOrganicOnlineProject/cartc?action=mycart" class="nav-link">My cart</a>
                    </li>
                     <li class="nav-item">
                        <a href="/JustOrganicOnlineProject/orderc?action=myorder" class="nav-link">My order</a>
                    </li>
                    <%} %>
                    <li class="nav-item">
                        <a href="footer.jsp" class="nav-link">Contact US</a>
                    </li>
                    
                    <% if(utype==null){ %>
                    <li class="nav-item">
                        <a href="/JustOrganicOnlineProject/jsp/login.jsp" class="nav-link">Login</a>
                    </li>
                    <%} %>
                    <% if(utype!=null){ %>
                    <li class="nav-item">
                        <a href="/JustOrganicOnlineProject/lc" class="nav-link">Logout</a>
                    </li>
                    <%} %>
                    
                </ul>
                    <% if(uname!=null){ %>
                
                <div class="pt-3 px-4">
                    <p>Welcome <span><%=uname %></span></p>
                </div>  
                 <%} %>
            </div>
        </div>
    </nav>
</body>

</html>