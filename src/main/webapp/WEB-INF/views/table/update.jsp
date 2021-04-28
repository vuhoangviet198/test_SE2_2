<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%@ include file="/WEB-INF/views/common/check.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh mục món ăn</title>

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
	<jsp:include page="/WEB-INF/views/common/menu/category-menu.jsp"></jsp:include>
	<!-- END -->

	<!-- LIST CUISINE -->
	<div class="container demo">
		<c:url value="/table-update" var="update"></c:url>
		<form:form id="contact-form" action="${update }"
			modelAttribute="tableDto" method="post">
			<form:hidden path="id"/>
			<div class="controls">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Mã</label>
							<form:input path="code" cssClass="form-control"
								cssErrorClass="form-control is-invalid" placeholder="Mã*" />
							<div class="invalid-feedback">
								<form:errors path="code" />
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Số bàn</label>
							<form:input path="number" cssClass="form-control"
								cssErrorClass="form-control is-invalid" placeholder="Số bàn*" />
							<div class="invalid-feedback">
								<form:errors path="number" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<button class="btn btn-info">Lưu</button>
							<a href='<c:url value="/table"></c:url>'
								class="btn btn-primary">Quay lại</a>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Mô tả</label>
							<form:textarea path="description" cssClass="form-control"
								cssErrorClass="form-control is-invalid" placeholder="Mô tả*" />
							<div class="invalid-feedback">
								<form:errors path="description" />
							</div>
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