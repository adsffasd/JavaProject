<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search thuê phòng</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
	 <div class="mt-3">
	  <div class="row">
	    <div class="col">
	      <a href="${pageContext.request.contextPath}/showkt" class="btn btn-outline-info"> Khách trọ </a>
	    </div>
	    <div class="col">
	      <a href="${pageContext.request.contextPath}/showlp" class="btn btn-outline-info"> Loại phòng </a>
	    </div>
	    <div class="col">
	      <a href="${pageContext.request.contextPath}/showpt" class="btn btn-outline-info"> Phòng trọ </a>
	    </div>
	    <div class="col">
	      <a href="${pageContext.request.contextPath}/showdv" class="btn btn-outline-info"> Dịch vụ </a>
	    </div>
	    <div class="col">
	      <a href="${pageContext.request.contextPath}/showdn" class="btn btn-outline-info"> Tiền điện nước </a>
	    </div>
	    <div class="col">
	    	<nav class="navbar navbar-expand-lg bg-light">
			    <div class="container-fluid">
			       <div class="collapse navbar-collapse" id="navbarSupportedContent">
			           <form class="d-flex ml-auto" role="search" action="${pageContext.request.contextPath}/searchtp" method="post">
			               <input class="form-control me-2" type="text" placeholder="Search" aria-label="Search" name="mathue">
			               <button class="btn btn-outline-success" type="submit">Tìm</button>
			           </form>
			       </div>
			   </div>
			</nav>
	    </div>
	  </div>
	  </div>
	  </div>
	<table class="table table-striped">
		<tr>
			<th>Mã thuê</th>
			<th>Khách</th>
			<th>Phòng</th>
			<th>Giá phòng</th>
			<th>Tiền đặt cọc</th>
			<th>Ngày thuê</th>
			<th>Ngày trả phòng</th>
			<th>Thanh toán</th>
			<th>Hành động</th>
		</tr>
		<c:forEach items="${tpP}" var="x">
			<tr>
				<td>${x.mathue}</td>
				<td>${x.khachthue.hoten}</td>
				<td>${x.phong.tenphong}</td>
				<td>${x.giaphong}</td>
				<td>${x.tiendatcoc}</td>
				<td>${x.ngaythue}</td>
				<td>${x.ngaytraphong}</td>
				<td>${x.thanhtoan}</td>
				<td>
					<a href="${pageContext.request.contextPath}/updatetp?mathue=${x.mathue}" class="edit-icon" style="color:black; text-decoration:none;">
					  <i class="fas fa-edit"></i> Sửa
					</a>
					<a href="${pageContext.request.contextPath}/deletetp?mathue=${x.mathue}" class="delete-icon" style="color:black; text-decoration:none;">
					  <i class="fas fa-trash-alt"></i> Xóa
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/addtp">Thêm thuê phòng</a>
	<a href="index.jsp">Back to index</a>
</body>
</html>