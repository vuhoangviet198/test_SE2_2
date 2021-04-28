<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%@ include file="/WEB-INF/views/common/check.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tài khoản nhân viên</title>

<!-- HEAD -->
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
<!-- END -->

<!-- CSS -->
<link rel="stylesheet"
	href='<c:url value="/assets/css/menu.css"></c:url>'>
<link rel="stylesheet"
	href='<c:url value="/assets/css/style.css"></c:url>'>
<link rel="stylesheet"
	href='<c:url value="/assets/css/employee.css"></c:url>'>
<!-- END -->

<!-- JAVASCRIPT -->
<!-- END -->
<body>
	<!-- MENU HOME -->
	<jsp:include page="/WEB-INF/views/common/menu/employee-menu.jsp"></jsp:include>
	<!-- END -->

	<!-- LIST CUISINE -->
	<div class="container demo">
		<c:url value="/employee-create" var="create"></c:url>
		<form:form id="contact-form" action="${create }"
			modelAttribute="employeeDto" method="post"
			enctype="multipart/form-data">
			<div class="controls">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Tài khoản</label>
							<form:input path="username" cssClass="form-control"
								cssErrorClass="form-control is-invalid" placeholder="Tài khoản*" />
							<div class="invalid-feedback">
								<form:errors path="username" />
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Mật khẩu</label>
							<form:password path="password" cssClass="form-control"
								cssErrorClass="form-control is-invalid" placeholder="Mật khẩu*" />
							<div class="invalid-feedback">
								<form:errors path="password" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Mã tài khoản</label>
							<form:input path="code" cssClass="form-control"
								cssErrorClass="form-control is-invalid"
								placeholder="Mã tài khoản*" />
							<div class="invalid-feedback">
								<form:errors path="code" />
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Giới tính</label>
							<form:select path="gender" cssClass="form-control">
								<form:option value="MALE">Nam</form:option>
								<form:option value="FEMALE">Nữ</form:option>
							</form:select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Ngày sinh</label>
							<form:input type="date" path="birthday" cssClass="form-control"
								cssErrorClass="form-control is-invalid" placeholder="Ngày sinh*" />
							<div class="invalid-feedback">
								<form:errors path="birthday" />
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Tên đầy đủ</label>
							<form:input path="fullname" cssClass="form-control"
								cssErrorClass="form-control is-invalid"
								placeholder="Tên đầy đủ*" />
							<div class="invalid-feedback">
								<form:errors path="fullname" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Quê quán</label>
							<form:input path="hometown" cssClass="form-control"
								cssErrorClass="form-control is-invalid" placeholder="Quê quán*" />
							<div class="invalid-feedback">
								<form:errors path="hometown" />
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Lương cơ bản</label>
							<form:input path="baseSalary" cssClass="form-control"
								cssErrorClass="form-control is-invalid"
								placeholder="Lương cơ bản*" />
							<div class="invalid-feedback">
								<form:errors path="baseSalary" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Công việc</label>
							<form:select path="job" cssClass="form-control">
								<form:option value="CHEF">Đầu bếp</form:option>
								<form:option value="WAITER">Bồi bàn</form:option>
								<form:option value="SECURITY">Bảo vệ</form:option>
								<form:option value="CASHIER">Thu ngân</form:option>
								<form:option value="SHIPER">Giao hàng</form:option>
								<form:option value="MANAGER">Quản lý</form:option>
							</form:select>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Kiểu tài khoản</label>
							<form:select path="type" cssClass="form-control">
								<form:option value="EMPLOYEE">Nhân viên</form:option>
								<form:option value="ADMIN">Quản lý</form:option>
							</form:select>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- 					<div class="col-md-6"> -->
					<!-- 						<div class="form-group"> -->
					<!-- 							<label>Ngày nghỉ việc</label> -->
					<%-- 							<form:input type="date" path="dateOut" cssClass="form-control" --%>
					<%-- 								cssErrorClass="form-control is-invalid" --%>
					<%-- 								placeholder="Ngày nghỉ việc*" /> --%>
					<!-- 							<div class="invalid-feedback"> -->
					<%-- 								<form:errors path="dateOut" /> --%>
					<!-- 							</div> -->
					<!-- 						</div> -->
					<!-- 					</div> -->
					<div class="col-md-6">
						<div class="form-group">
							<button class="btn btn-success">Lưu</button>
							<a href='<c:url value="/employee"></c:url>'
								class="btn btn-primary">Quay lại</a>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<div class="input-group">
								<span class="btn btn-secondary btn-file">Hình ảnh<input
									type="file" name="file" id="imgInp"></span> <input
									Class="form-control" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group"></div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<img id='img-upload' />
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<!--/.container.demo -->
	<!-- END -->

	<!-- FOOTER -->
	<jsp:include page="/WEB-INF/views/common/foot.jsp"></jsp:include>
	<script src='<c:url value="/assets/js/employee.js"></c:url>'></script>
	<!-- END -->
</body>
</html>