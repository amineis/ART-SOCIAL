<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="dao.PostDao" %>
    <%@page import="model.Post" %>
    <%@page import="helper.ConnectionProvider" %>
    <%@page import="java.util.ArrayList"%>
    <%@page import="model.User"%>
    <%
    User user = (User)session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Anime Template">
    <meta name="keywords" content="Anime, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Logged</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
    rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/plyr.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Header Section Begin -->
    <header class="header">
        <div class="container">
            <div class="row">
                <div class="col-lg-2">
                    <div class="header__logo">
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="header__nav">
                        <nav class="header__menu mobile-menu">
                            <ul>
                                <li class="active"><a href="./index.jsp">Homepage</a></li>
                                <li><a href="./categories.jsp">Categories <span class="arrow_carrot-down"></span></a>
                                    <ul class="dropdown">
                                        <li><a href="#">Drawings</a></li>
                                        <li><a href="#">Ai Art</a></li>
                                        <li><a href="./art.jsp">Paintings</a></li>
                                        <li><a href="#">Photography</a></li>
                                        <li><a href="#">3D</a></li>
                                        <li><a href="#">Digital Art</a></li>
                                    </ul>
                                </li>
                                <li><a href="post.jsp">Post</a></li>
                                <li><a href="about.jsp">About</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <div class="col-lg-2">
                    <div class="header_nav">
                        <nav class="header__menu mobile-menu">
                            <ul>
                                <li><a href="./profile.jsp"><img style="width:25px;height:25px;" src="img/profile.png"><span class="arrow_carrot-down"></span></a>
                                    <ul class="dropdown">
                                        <li><a href="./viewprofile.jsp">View Profile</a></li>
                                        <li><a href="./editprofile.jsp">Edit Profile</a></li>
                                        <li><a href="./favorits.jsp">Favorits</a></li>
                                        <li><a href="LogoutServlet">Log Out</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
            <div id="mobile-menu-wrap"></div>
        </div>
    </header>
    <!-- Header End -->

    <!-- Hero Section Begin -->
    <section class="hero">
        <div class="container">
            <div class="hero__slider owl-carousel">
                <div class="hero__items set-bg" data-setbg="img/showcase.jpg">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="hero__text">
                                <h2 style="color:purple"><b>Showcase Your</b></h2>
                                <h2 style="color:blue"><b>Art.</b></h2>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
        </div>
    </section>
    <!-- Hero Section End -->
    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="trending__product">
                        <div class="row">
                            <div class="col-lg-8 col-md-8 col-sm-8">
                                <div class="section-title">
                                    <h4>Topics</h4>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                        
                            <div class="col-lg-4 col-md-6 col-sm-6">
                                <div class="product__item">
                                    <div class="product__item__pic set-bg" data-setbg="img/anime/details.jpg">
                                    </div>
                                    <div class="product__item__text">
                                        <h5><a href="DetailServlet">Title1</a></h5>
                                    </div>
                                </div>
                            	</div>
                            	<div class="col-lg-4 col-md-6 col-sm-6">
                                <div class="product__item">
                                    <div class="product__item__pic set-bg" data-setbg="img/1.jpg">
                                    </div>
                                    <div class="product__item__text">
                                        <h5><a href="#">Title2</a></h5>
                                    </div>
                                </div>
                            	</div>
                            	<div class="col-lg-4 col-md-6 col-sm-6">
                                <div class="product__item">
                                    <div class="product__item__pic set-bg" data-setbg="img/2.jpg">
                                    </div>
                                    <div class="product__item__text">
                                        <h5><a href="#">Title3</a></h5>
                                    </div>
                                </div>
                            	</div>
                            	<div class="col-lg-4 col-md-6 col-sm-6">
                                <div class="product__item">
                                    <div class="product__item__pic set-bg" data-setbg="img/3.jpg">
                                    </div>
                                    <div class="product__item__text">
                                        <h5><a href="#">Title4</a></h5>
                                    </div>
                                </div>
                            	</div>
                            	<div class="col-lg-4 col-md-6 col-sm-6">
                                <div class="product__item">
                                    <div class="product__item__pic set-bg" data-setbg="img/4.png">
                                    </div>
                                    <div class="product__item__text">
                                        <h5><a href="#">Title5</a></h5>
                                    </div>
                                </div>
                            	</div>
                            	<div class="col-lg-4 col-md-6 col-sm-6">
                                <div class="product__item">
                                    <div class="product__item__pic set-bg" data-setbg="img/5.jpg">
                                    </div>
                                    <div class="product__item__text">
                                        <h5><a href="#">Title6</a></h5>
                                    </div>
                                </div>
                            	</div>
                            	<div class="col-lg-4 col-md-6 col-sm-6">
                                <div class="product__item">
                                    <div class="product__item__pic set-bg" data-setbg="img/6.jpg">
                                    </div>
                                    <div class="product__item__text">
                                        <h5><a href="#">Title7</a></h5>
                                    </div>
                                </div>
                            	</div>
                            	<div class="col-lg-4 col-md-6 col-sm-6">
                                <div class="product__item">
                                    <div class="product__item__pic set-bg" data-setbg="img/7.jpg">
                                    </div>
                                    <div class="product__item__text">
                                        <h5><a href="#">Title8</a></h5>
                                    </div>
                                </div>
                            	</div>
                            	<div class="col-lg-4 col-md-6 col-sm-6">
                                <div class="product__item">
                                    <div class="product__item__pic set-bg" data-setbg="img/8.jpg">
                                    </div>
                                    <div class="product__item__text">
                                        <h5><a href="#">Title9</a></h5>
                                    </div>
                                </div>
                            	</div>
                            
                            </div>
                        </div>
                    </div>
                  </div>
                 
                
</div>

</section>
<!-- Product Section End -->

<!-- Footer Section Begin -->
<footer class="footer">
    <div class="page-up">
        <a href="#" id="scrollToTopButton"><span class="arrow_carrot-up"></span></a>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="footer__logo">
                </div>
            </div>
            <div class="col-lg-6">
                <div class="footer__nav">
                    <ul>
                        <li class="active"><a href="./index.html">Homepage</a></li>
                        <li><a href="./categories.html">Categories</a></li>
                        <li><a href="./blog.html">Our Blog</a></li>
                        <li><a href="#">About</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-3">
                <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>

              </div>
          </div>
      </div>
  </footer>
  <!-- Footer Section End -->

  <!-- Search model Begin -->
  <div class="search-model">
    <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="search-close-switch"><i class="icon_close"></i></div>
        <form class="search-model-form">
            <input type="text" id="search-input" placeholder="Search here.....">
        </form>
    </div>
</div>
<!-- Search model end -->

<!-- Js Plugins -->
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/player.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/mixitup.min.js"></script>
<script src="js/jquery.slicknav.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/main.js"></script>

</body>

</html>