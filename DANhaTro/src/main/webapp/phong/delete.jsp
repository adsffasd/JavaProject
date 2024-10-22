<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete phòng</title>
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
          <h2 class="card-title text-center mb-4">Xóa phòng</h2>
          <form action="${pageContext.request.contextPath}/deletept" method="post">
            <div class="mb-3">
              <label for="maphong" class="form-label">Mã phòng</label>
              <input value="${pP.maphong}" type="text" class="form-control" id="maphong" name="maphong" readonly="readonly">
            </div>
            <div class="mb-3">
              <label for="tenphong" class="form-label">Tên phòng</label>
              <input value="${pP.tenphong}" type="text" class="form-control" id="tenphong" name="tenphong" readonly="readonly">
            </div>
            
            <div class="mb-3">
              <label for="loaiphong" class="form-label">Loại phòng</label>
              <input value="${pP.loaiphong.getMaloaiphong()}" type="text" class="form-control" id="loaiphong" name="loaiphong">
            </div>
            
            <div class="mb-3">
              <label for="trangthai" class="form-label">Trạng thái</label>
              <input value="${pP.trangthai}" type="text" class="form-control" id="trangthai" name="trangthai">
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