<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>

<!-- HEAD -->
<link rel="shortcut icon" type="image/x-icon"
	href='<c:url value="/assets/images/favicon.ico"></c:url>' />
<link rel='stylesheet'
	href='https://bootswatch.com/4/lumen/bootstrap.min.css'>
<!-- END -->

<!-- CSS -->
<link rel="stylesheet"
	href='<c:url value="/assets/css/login.css"></c:url>'>
<!-- END -->
<body>
	<!-- LIST CUISINE -->
	<div class="container mt-5 pt-5">
		<div class="card mx-auto border-0">
			<div class="card-header border-bottom-0 bg-transparent">
				<ul class="nav nav-tabs justify-content-center pt-4" id="pills-tab"
					role="tablist">
					<li class="nav-item"><a class="nav-link active text-primary"
						id="pills-login-tab" data-toggle="pill" href="#pills-login"
						role="tab" aria-controls="pills-login" aria-selected="true">Đăng
							nhập</a></li>
				</ul>
			</div>

			<div class="card-body pb-4">
				<div class="tab-content" id="pills-tabContent">
					<div class="tab-pane fade show active" id="pills-login"
						role="tabpanel" aria-labelledby="pills-login-tab">
						<c:if test="${message != null }">
							<span style="color: red">${message }</span>
						</c:if>
						<c:url value="/loginProcess" var="login"></c:url>
						<form:form action="${login }" modelAttribute="employeeDto"
							method="post">
							<div class="form-group">
								<form:input path="username" class="form-control"
									placeholder="Tài khoản" />
							</div>
							<div class="form-group">
								<form:password path="password" class="form-control"
									placeholder="Mật khẩu" />
							</div>
							<div class="custom-control custom-checkbox">
								<input class="custom-control-input" id="customCheck1" checked=""
									type="checkbox"> <label class="custom-control-label"
									for="customCheck1">Ghi nhớ tôi</label>
							</div>

							<div class="text-center pt-4">
								<button type="submit" class="btn btn-primary">Đăng nhập</button>
							</div>

							<div class="text-center pt-2">
								<a class="btn btn-link text-primary" href="#">Quên mật khẩu?</a>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- END -->
	<script src='https://use.fontawesome.com/releases/v5.2.0/js/all.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/popper.min.js'></script>
	<script
		src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js'></script>
</body>
</html>