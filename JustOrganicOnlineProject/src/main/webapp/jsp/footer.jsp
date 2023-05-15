<%@ page language="java" contentType="text/html; charset=UTF-8"

pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>


<meta charset="UTF-8">

<title>Contact Page</title>

<style type="text/css">

.social-icons {

font-size: 36px;

cursor: pointer;

}

.fa-facebook:hover,.fa-instagram:hover,.fa-twitter:hover,.fa-linkedin:hover, .fa-twitch:hover {

color: #008000;

}

.fab {

color: #000000;

}

/* footer styling */

#footer {

background-color: #808080;

text-align: center;

}

</style>

</head>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<body>

<section id="contact">

<div class="container mt-3 contactContent">

<h1 class="text-center">Contact Us</h1>

<div class="row mt-4">

<div class="col-lg-6">

<div style="text-decoration:none; overflow:hidden;max-width:100%;width:500px;height:500px;"><div id="display-google-map" style="height:100%; width:100%;max-width:100%;"><iframe style="height:100%;width:100%;border:0;" frameborder="0" src="https://www.google.com/maps/embed/v1/place?q=QUASTECH+-+Software+Testing+Course,+Python+Development,+Java+Development+course,+python+data+science,+Full+Stack+Development,+Swami+Vivekananda+Road,+Mhatre+Wadi,+Borivali+West,+Mumbai,+Maharashtra,+India&key=AIzaSyBFw0Qbyq9zTFTd-tUY6dZWTgaQzuU17R8"></iframe></div><a class="embed-ded-maphtml" href="https://www.bootstrapskins.com/themes" id="get-map-data">premium bootstrap themes</a><style>#display-google-map img.text-marker{max-width:none!important;background:none!important;}img{max-width:none}</style></div> </div>

<div class="col-lg-6">

<!-- form fields -->

<form>

<input type="text" class="form-control form-control-lg" placeholder="Name">

<input type="email" class="form-control mt-3" placeholder="Email">

<input type="text" class="form-control mt-3" placeholder="Subject">

<div class="mb-3 mt-3">

<textarea class="form-control" rows="5" id="comment" name="text" placeholder="Project Details"></textarea>

</div>

</form>

<button type="submit" class="btn btn-success mt-3">Submit</button>

</div>

</div>

</div>

</section>

<footer id="footer">

<div class="container-fluid">

<!-- social media icons -->

<div class="social-icons mt-4">

<a href="https://www.facebook.com/" target="_blank"><i class="fab fa-facebook"></i></a>

<a href="https://www.instagram.com/" target="_blank"><i class="fab fa-instagram"></i></a>

<a href="https://www.twitter.com/" target="_blank"><i class="fab fa-twitter"></i></a>

<a href="https://www.linkedin.com/" target="_blank"><i class="fab fa-linkedin"></i></a>

</div>

</div>

</footer>

</body>

</html>

