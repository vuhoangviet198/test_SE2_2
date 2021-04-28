<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%@ include file="/WEB-INF/views/common/check.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách món ăn</title>

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
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var namePhoto = $('#photo').val();
						$('img')
								.attr("src",
										"<c:url value='/assets/images/"+ namePhoto +"'></c:url>");
					})
</script>
<!-- END -->
<body>
	<!-- MENU HOME -->
	<jsp:include page="/WEB-INF/views/common/menu/dish-menu.jsp"></jsp:include>
	<!-- END -->

	<!-- LIST CUISINE -->
	<div class="container demo">
		<c:url value="/dish-update" var="update"></c:url>
		<form:form id="contact-form" action="${update }"
			modelAttribute="dishDto" method="post" enctype="multipart/form-data">
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
							<label>Tên</label>
							<form:input path="name" cssClass="form-control"
								cssErrorClass="form-control is-invalid" placeholder="Tên*" />
							<div class="invalid-feedback">
								<form:errors path="name" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Giá</label>
							<form:input path="price" cssClass="form-control"
								cssErrorClass="form-control is-invalid" placeholder="Giá*" />
							<div class="invalid-feedback">
								<form:errors path="price" />
							</div>
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
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Danh mục</label>
							<form:select path="idCategoryDish" cssClass="form-control"
								cssErrorClass="form-control is-invalid">
								<form:option value="">---   Chọn danh mục  ---</form:option>
								<form:options items="${listCategory }" itemLabel="name"
									itemValue="id" />
							</form:select>
							<div class="invalid-feedback">
								<form:errors path="description" />
							</div>
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
						<div class="form-group">
							<button class="btn btn-info">Lưu</button>
							<a href='<c:url value="/category"></c:url>'
								class="btn btn-primary">Quay lại</a>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<form:hidden path="photo" />
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