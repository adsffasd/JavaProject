<%@page import="model.Login_Register"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang admin cho thuê phòng trọ</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>
<%
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>
<link href="<%=url%>/css/index.css" rel="stylesheet">
</head>
<body>
	<!-- Header -->
	<header class="header">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<!-- Logo -->
				<div class="col-1">
					<a class="navbar-brand" href="#"> <img src="img/logo.png"
						alt="" height="50" class="d-inline-block align-text-top">
					</a>
				</div>

				<div class="col-2">
					<%
					Object obj = session.getAttribute("login");
					Login_Register lg = null;
					if (obj != null) {
						lg = (Login_Register) obj;
					}
					if (lg == null) {
					%>
					<a href="login_register_logout/register.jsp" class="register"
						id="register">Đăng ký</a> <a
						href="login_register_logout/login.jsp" class="login" id="login">Đăng
						nhập</a>
					<%
					} else {
					%>
					<div class="dropdown">
						<button class="btn btn-secondary dropdown-toggle" type="button"
							id="dropdownMenuButton1" data-bs-toggle="dropdown"
							aria-expanded="false">
							Admin: <b><%=lg.getUser()%></b>
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<hr>
							<li><a href="${pageContext.request.contextPath}/logout"
								id="logout"
								class="dropdown-item text-center text-decoration-none d-block">
									<b>Đăng xuất</b>
							</a></li>
						</ul>
					</div>
					<%
					}
					%>
				</div>
			</div>
		</nav>
	</header>

	<%
	if (obj != null) {
		lg = (Login_Register) obj;
	}
		if (lg == null) {
	%>
<div class="container mt-4">
		<div class="row">
			<div class="col-lg-2">
				<div class="list-group ">
					<a href="login_register_logout/login.jsp" class="list-group-item list-group-item-action">
						Admin </a> <a href="#"
						class="list-group-item list-group-item-action">User</a>
				</div>
			</div>
			<div class="col-lg-10">
				<div id="carouselExampleIndicators" class="carousel slide mb-4"
					data-bs-ride="true">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="0" class="active" aria-current="true"
							aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="1" aria-label="Slide 2"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="img/slider/1.jpg" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="img/slider/2.jpg" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="img/slider/3.jpg" class="d-block w-100" alt="...">
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
			</div>
		</div>
	</div>
	<%
	} else {
	%>
	<!-- page content -->
	<div class="container mt-4">
	  <div class="row mb-4"> <!-- Add margin bottom to create space between rows -->
	    <div class="col-md-4 mb-3"> <!-- Add margin bottom to create space between cards if they wrap -->
	      <div class="card">
		  <div class="card-body">
		    <h5 class="card-title">Trang chủ khách trọ</h5>
		   <a href="${pageContext.request.contextPath}/showkt" class="btn btn-primary"> Khách trọ </a>
		  </div>
		</div>
	    </div>
	    <div class="col-md-4 mb-3">
	       <div class="card">
			  <div class="card-body">
			    <h5 class="card-title">Trang chủ phòng trọ</h5>
			    <a href="${pageContext.request.contextPath}/showpt" class="btn btn-primary"> Phòng trọ </a>
			  </div>
			</div>
	    </div>
	    <div class="col-md-4 mb-3">
	       <div class="card">
			  <div class="card-body">
			    <h5 class="card-title">Trang chủ loại phòng</h5>
			    <a href="${pageContext.request.contextPath}/showlp" class="btn btn-primary"> Loại phòng </a>
			  </div>
			</div>
	    </div>
	  </div>
	  <div class="row">
	    <div class="col-md-4 mb-3">
	       <div class="card">
			  <div class="card-body">
			    <h5 class="card-title">Trang chủ thuê phòng</h5>
			    <a href="${pageContext.request.contextPath}/showtp" class="btn btn-primary"> Thuê phòng </a>
			  </div>
			</div>
	    </div>
	    <div class="col-md-4 mb-3">
	      <div class="card">
			  <div class="card-body">
			    <h5 class="card-title">Trang chủ dịch vụ</h5>
			    <a href="${pageContext.request.contextPath}/showdv" class="btn btn-primary"> Dịch vụ </a>
			  </div>
			</div>
	    </div>
	    <div class="col-md-4 mb-3">
	       <div class="card">
			  <div class="card-body">
			    <h5 class="card-title">Trang chủ tiền điện nước</h5>
			    <a href="${pageContext.request.contextPath}/showdn" class="btn btn-primary"> Tiền điện nước </a>
			  </div>
			</div>
	    </div>
	  </div>
	</div>
	<%
	}
	%>
</body>
</html>