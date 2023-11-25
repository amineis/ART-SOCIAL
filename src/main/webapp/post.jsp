<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.PostDao" %>
<%@page import="dao.UserDao" %>
<%@page import="model.User" %>
<%@page import="model.Post" %>
<%@page import="helper.ConnectionProvider" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
    }
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>
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
<!-- Header Section Begin -->
    <header class="header">
        <div class="container">
            <div class="row">
                <div class="col-lg-2">
                    <div class="header__logo">
                        <a href="./index.html">
                        </a>
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
                                        <li><a href="#">Paintings</a></li>
                                        <li><a href="./art.jsp">Ai Art</a></li>
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
                    <div class="header__right">
                        <a href="./login.html"><span class="icon_profile"></span></a>
                    </div>
                </div>
            </div>
            <div id="mobile-menu-wrap"></div>
        </div>
    </header>
    <!-- Header End -->
    <section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row justify-content-center align-items-center h-100">
      <div class="col-12 col-lg-9 col-xl-7">
        <div class="card shadow-2-strong card-registration" style="border-radius: 15px; background: linear-gradient(to bottom right, rgb(23,162,184, 1), rgb(32,201,151, 1));">
          <div class="card-body p-4 p-md-5">
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Upload your Artwork here</h3>
            <form action="AddPostServlet" method="post" enctype="multipart/form-data">

              <div class="row">
                <div class="col-md-6 mb-4">

                  <div class="form-outline">
                    <input type="text" name="title" class="form-control form-control-lg" />
                    <label class="form-label" for="firstName">Title</label>
                  </div>

                </div>
              </div>
              <div class="form-outline">
                    <textarea rows="3" cols="30" name="desc" class="form-control form-control-lg" ></textarea>
                    <label class="form-label" for="lastName">Description</label>
              </div>

              <div class="row">
                <div class="col-12">

                  <select class="select form-control-lg" name="option">
                    <option value="" disabled>Choose option</option>
                    <option value="Drawing">Drawing</option>
                    <option value="Painting">Painting</option>
                    <option value="Ai">Ai Art</option>
                    <option value="Photography">Photography</option>
                  </select>
                  <label class="form-label select-label">Choose option</label>

                </div>
              </div><br>
              
              <div class="row">
              		<div class="col-12">
              			<input class="form-control form-control-lg" name="img" type="file" style="border:none;background:none" />
              		</div>
              		
              </div>

              <div class="mt-4 pt-2">
                <input class="btn btn-primary btn-lg" type="submit" value="Submit" />
              </div>

            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section><br><br><br><br><br><br>
<!-- Footer Section Begin -->
<footer class="footer">
    
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
                        <li><a href="#">Contacts</a></li>
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

</body>
</html>