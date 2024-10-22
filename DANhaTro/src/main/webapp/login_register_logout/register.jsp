<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Register</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
	integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
	crossorigin="anonymous"></script>
<style>
.rq {
	color: red;
}
</style>
<%
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>
<link href="<%=url%>/css/register.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12 col-md-6 offset-md-3">
				<div class="form-border">
					<h1 class="text-center">Đăng kí tài khoản</h1>
					<form class="form" action="${pageContext.request.contextPath}/register" method="post">
						<div class="row">
							<div class="col-3"></div>
							<div class="col-6">
								<div class="mb-3">
									<label for="user" class="form-label">Username<span
										class="rq">*</span></label> <input type="text" class="form-control"
										id="user" name="user" required="required">
								</div>
								<div class="mb-3">
									<label for="password" class="form-label">Password<span
										class="rq">*</span></label> <input type="password"
										class="form-control" id="password" name="password"
										required="required">
								</div>
								<div class="mb-3">
									<label for="repassword" class="form-label">Re-entry
										Password <span class="rq" id="msg">*</span>
									</label> <input type="password" class="form-control" id="repassword"
										name="repassword" required="required"
										onkeyup="kiemTraMatKhau()">
								</div>
								<div class="mb-3">
									<label for="dongYNhanMail" class="form-label">Accept
										Mail</label> <input type="checkbox" class="form-check-input"
										id="dongYNhanMail" name="dongYNhanMail">
								</div>
								<div class="mb-3">
									<label for="remember" class="form-label">Remember me<span
										id="red">*</span>
									</label> <input type="checkbox" class="form-check-input" id="remember"
										name="remember" required="required" onchange="xuLyGhiNho()">
								</div>
								<input class="btn btn-primary form-control" type="submit"
									name="submit" id="submit"
									style="visibility: hidden;" />
							</div>
							<a href="../index.jsp" class="text-center">Back to Index</a>
							<p class="mt-5 mb-3 text-center">&copy; Hoài Phong 94</p>
							<div class="col-3"></div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

<script>
	function kiemTraMatKhau() {
		password = document.getElementById("password").value;
		repassword = document.getElementById("repassword").value;
		if (password != repassword) {
			document.getElementById("msg").innerHTML = " Mật khẩu không khớp!";
			return false;
		} else {
			document.getElementById("msg").innerHTML = "";
			return true;
		}
	}

	function xuLyGhiNho() {
		remember = document.getElementById("remember");
		if (remember.checked == true) {
			document.getElementById("submit").style.visibility = "visible";
		} else {
			document.getElementById("submit").style.visibility = "hidden";
		}
	}
</script>
</html>