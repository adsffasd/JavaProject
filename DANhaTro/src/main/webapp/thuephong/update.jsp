<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update thuê phòng</title>
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
<div class="container py-5">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <div class="card shadow-sm">
        <div class="card-body">
          <h2 class="card-title text-center mb-4">Chỉnh sửa thuê phòng</h2>
          <form action="${pageContext.request.contextPath}/updatetp" method="post">
            <div class="mb-3">
              <label for="mathue" class="form-label">Mã thuê phòng</label>
              <input value="${tpP.mathue}" type="text" class="form-control" id="mathue" name="mathue">
            </div>
            
            <div class="mb-3">
              <label for="khachthue" class="form-label">Khách</label>
              	<select name="khachthue" id="khachthue">
						<c:forEach items="${khachthuelist}" var="x">
							<option value="${x.getMakhach()}">${x.getHoten()}</option>
						</c:forEach>
				</select>
            </div>
            
            <div class="mb-3">
              <label for="phong" class="form-label">phòng</label>
              <select name="phong" id="phong">
						<c:forEach items="${phonglist}" var="x">
							<option value="${x.getMaphong()}">${x.getTenphong()}</option>
						</c:forEach>
					</select>
            </div>
            
            <div class="mb-3">
              <label for="giaphong" class="form-label">Giá phòng</label>
              <input value="${tpP.giaphong}" type="text" class="form-control" id="giaphong" name="giaphong">
            </div>
            <div class="mb-3">
              <label for="tiendatcoc" class="form-label">Tiền đặt cọc</label>
              <input value="${tpP.tiendatcoc}" type="text" class="form-control" id="tiendatcoc" name="tiendatcoc">
            </div>
            
            <div class="mb-3">
              <label for="ngaythue" class="form-label">Ngày thuê</label>
              <input value="${tpP.ngaythue}" type="date" class="form-control" id="ngaythue" name="ngaythue">
            </div>
            
            <div class="mb-3">
              <label for="ngaytraphong" class="form-label">Ngày trả phòng</label>
              <input value="${tpP.ngaytraphong}" type="date" class="form-control" id="ngaytraphong" name="ngaytraphong">
            </div>
            
            <div class="mb-3">
              <label for="thanhtoan" class="form-label">Thanh toán</label>
              <input value="${tpP.thanhtoan}" type="text" class="form-control" id="thanhtoan" name="thanhtoan">
            </div>
            
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
              <button type="submit" class="btn btn-outline-secondary me-md-2"><i class="fas fa-edit"></i> Thêm</button>
              <button type="button" class="btn btn-outline-secondary" onclick="history.back();"><i class="fas fa-arrow-left"></i> Quay lại</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>