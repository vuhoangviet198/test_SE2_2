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
<!-- END -->

<!-- JAVASCRIPT -->
<!-- END -->
<body>
	<!-- MENU HOME -->
	<jsp:include page="/WEB-INF/views/common/menu/category-menu.jsp"></jsp:include>
	<!-- END -->

	<!-- ALERT DELETE -->
	<c:if test="${not empty message }">
		<script type="text/javascript">
			swal({
				title : "${message }",
				icon : "warning",
				buttons : true,
				dangerMode : true,
			})
		</script>
	</c:if>
	<!-- END -->

	<!-- LIST CUISINE -->
	<div class="container demo">
		<!-- CREATE -->
		<a href='<c:url value="/category-create"></c:url>'
			class="btn btn-success space">Tạo Mới</a>
		<!-- END -->
		<table class="datatable table table-striped table-bordered">
			<thead>
				<tr>
					<th>STT</th>
					<th>Mã</th>
					<th>Tên</th>
					<th>Cập nhật</th>
					<th>Xóa</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="list" varStatus="loop">
					<tr>
						<td>${loop.index + 1 }</td>
						<td>${list.code }</td>
						<td>${list.name }</td>

						<td><a
							href='<c:url value="/category-update/${list.id}"></c:url>'
							class="btn btn-info">Cập nhật</a></td>
						<td><a
							href='<c:url value="/category-delete/${list.id}"></c:url>'
							class="btn btn-danger"
							onclick="return confirm('Bạn có chắc muốn xóa danh mục món ăn này?');">Xóa</a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>STT</th>
					<th>Mã</th>
					<th>Tên</th>
					<th>Cập nhật</th>
					<th>Xóa</th>
				</tr>
			</tfoot>
		</table>
	</div>
	<!--/.container.demo -->
	<!-- END -->

	<!-- FOOTER -->
	<jsp:include page="/WEB-INF/views/common/foot.jsp"></jsp:include>
	<script src='<c:url value="/assets/js/index.js"></c:url>'></script>
	<!-- END -->
</body>
</html>