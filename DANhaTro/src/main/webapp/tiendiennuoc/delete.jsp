<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete tiền điện nước</title>
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
	<form action="${pageContext.request.contextPath}/deletedn" method="post">
		<table>
			<tr>
				<td>Mã tiền điện</td>
				<td><input value="${dnN.matiendien}" type="text" name="matiendien"></td>
			</tr>
			<tr>
				<td>Thuê phòng</td>
				<td><input value="${dnN.thue.getMathue()}" type="text" name="thue"></td>
			</tr>
			<tr>
				<td>Dịch vụ</td>
				<td><input value="${dnN.dichvu.getMadichvu()}" type="text" name="dichvu"></td>
			</tr>
			<tr>
				<td>Từ ngày</td>
				<td><input value="${dnN.tungay}" type="date" name="tungay"></td>
			</tr>
			<tr>
				<td>Tới ngày</td>
				<td><input value="${dnN.toingay}" type="date" name="toingay"></td>
			</tr>
			<tr>
				<td>Số điện</td>
				<td><input value="${dnN.sodien}" type="text" name="sodien"></td>
			</tr>
			<tr>
				<td>Đơn giá</td>
				<td><input value="${dnN.dongia}" type="text" name="dongia"></td>
			</tr>
			<tr>
				<td>Đã thanh toán</td>
				<td><input value="${dnN.dathanhtoan}" type="text" name="dathanhtoan"></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit">Xóa</button>
				<a href="${pageContext.request.contextPath}/showdn">Back to show</a>
				</td>
			</tr>
		</table>
	</form>

<div class="container py-5">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <div class="card shadow-sm">
        <div class="card-body">
          <h2 class="card-title text-center mb-4">Xóa tiền điện</h2>
          <form action="${pageContext.request.contextPath}/deletedn" method="post">
            <div class="mb-3">
              <label for="matiendien" class="form-label">Mã tiền điện</label>
              <input value="${dnN.matiendien}" type="text" class="form-control" id="matiendien" name="matiendien" readonly="readonly">
            </div>
            
            <div class="mb-3">
              <label for="thue" class="form-label">Thuê phòng</label>
              <input value="${dnN.thue.getMathue()}" type="text" name="thue" readonly="readonly">
            </div>
            
            <div class="mb-3">
              <label for="dichvu" class="form-label">Dịch vụ</label>
              <input value="${dnN.dichvu.getMadichvu()}" type="text" name="dichvu" readonly="readonly">
            </div>
            
            <div class="mb-3">
              <label for="tungay" class="form-label">Từ ngày</label>
              <input value="${dnN.tungay}" type="date" class="form-control" id="tungay" name="tungay" readonly="readonly">
            </div>
            
            <div class="mb-3">
              <label for="toingay" class="form-label">Tới ngày</label>
              <input value="${dnN.toingay}" type="date" class="form-control" id="toingay" name="toingay" readonly="readonly">
            </div>
            
            <div class="mb-3">
              <label for="sodien" class="form-label">Số điện</label>
              <input value="${dnN.sodien}" type="text" class="form-control" id="sodien" name="sodien" readonly="readonly">
            </div>
            <div class="mb-3">
              <label for="dongia" class="form-label">Đơn giá</label>
              <input value="${dnN.dongia}" type="text" class="form-control" id="dongia" name="dongia" readonly="readonly">
            </div>
            
            <div class="mb-3">
              <label for="dathanhtoan" class="form-label">Đã thanh toán</label>
              <input value="${dnN.dathanhtoan}" type="text" class="form-control" id="dathanhtoan" name="dathanhtoan" readonly="readonly">
            </div>
            
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
              <button type="submit" class="btn btn-outline-secondary me-md-2"><i class="fas fa-trash"></i> Xóa</button>
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