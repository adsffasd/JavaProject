<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update tiền điện</title>
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
          <h2 class="card-title text-center mb-4">Sửa chi tiết tiền điện</h2>
          <form action="${pageContext.request.contextPath}/updatedn" method="post">
            <div class="mb-3">
              <label for="matiendien" class="form-label">Mã tiền điện</label>
              <input value="${dnN.matiendien}" type="text" class="form-control" id="matiendien" name="matiendien" readonly="readonly">
            </div>
            
            <div class="mb-3">
              <label for="thue" class="form-label">Thuê phòng</label>
              	<select name="thue" id="thue">
					<c:forEach items="${thuephonglist}" var="x">
						<option value="${x.getMathue()}">${x.getMathue()}</option>
					</c:forEach>
				</select>
            </div>
            
            <div class="mb-3">
              <label for="dichvu" class="form-label">Dịch vụ</label>
              <select name="dichvu" id="dichvu">
					<c:forEach items="${dichvulist}" var="x">
						<option value="${x.getMadichvu()}">${x.getTendichvu()}</option>
					</c:forEach>
				</select>
            </div>
            
            <div class="mb-3">
              <label for="tungay" class="form-label">Từ ngày</label>
              <input value="${dnN.tungay}" type="date" class="form-control" id="tungay" name="tungay">
            </div>
            
            <div class="mb-3">
              <label for="toingay" class="form-label">Tới ngày</label>
              <input value="${dnN.toingay}" type="date" class="form-control" id="toingay" name="toingay">
            </div>
            
            <div class="mb-3">
              <label for="sodien" class="form-label">Số điện</label>
              <input value="${dnN.sodien}" type="text" class="form-control" id="sodien" name="sodien">
            </div>
            <div class="mb-3">
              <label for="dongia" class="form-label">Đơn giá</label>
              <input value="${dnN.dongia}" type="text" class="form-control" id="dongia" name="dongia">
            </div>
            
            
            
            <div class="mb-3">
              <label for="dathanhtoan" class="form-label">Đã thanh toán</label>
              <input value="${dnN.dathanhtoan}" type="text" class="form-control" id="dathanhtoan" name="dathanhtoan">
            </div>
            
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
              <button type="submit" class="btn btn-outline-secondary me-md-2"><i class="fas fa-edit"></i> Sửa</button>
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