<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="carousel slide carousel-fade" data-bs-ride="carousel"
id="c1" style="z-index:-1">
        <div class="carousel-inner vh-100">
            <div class="carousel-item active">
                <img
src="https://cdn.myonlinestore.eu/9498be7f-6be1-11e9-a722-44a8421b9960/slideshow/de_DE_587330_full.jpg"
alt="1" class="d-block w-100 vh-100">
            </div>
            <div class="carousel-item" data-bs-interval="4000">
                <img src="https://wallpapercave.com/wp/wp3104819.jpg"
alt="1" class="d-block w-100 vh-100">
            </div>
            <div class="carousel-item" data-bs-interval="4000">
                <img src="https://wallpaper.dog/large/5565473.jpg"
alt="1" class="d-block w-100 vh-100">
            </div>
            <div class="carousel-item" data-bs-interval="4000">
                <img
src="https://s.abcnews.com/images/GMA/organic-produce-01-sh-iwb-220810_1660138683424_hpMain_16x9_1600.jpg"
alt="1" class="d-block w-100 vh-100">
            </div>
            <div class="carousel-item" data-bs-interval="4000">
                <img
src="https://images.thequint.com/thequint-fit%2F2022-02%2F5d000f4d-bb22-4a01-99e9-1bcb7b4d86b6%2FiStock_1081090762.jpg?auto=format%2Ccompress&fmt=webp&width=230&w=1200"
alt="1" class="d-block w-100 vh-100">
            </div>
            <div class="carousel-item" data-bs-interval="4000">
                <img
src="https://images.everydayhealth.com/images/go-green-for-better-health-00-1440x810.jpg"
alt="1" class="d-block w-100 vh-100">
            </div>
            <div class="carousel-item" data-bs-interval="4000">
                <img
src="https://media.mehrnews.com/d/2017/12/21/4/2669879.jpg" alt="1"
class="d-block w-100 vh-100">
            </div>
        </div>
    </div>

    <button class="carousel-control-prev" type="button"
data-bs-target="#c1" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    </button>
    <button class="carousel-control-next" type="button"
data-bs-target="#c1" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
    </button>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>