<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%@ include file="/WEB-INF/views/common/check.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thông tin khách hàng</title>

<!-- HEAD -->
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
<!-- END -->

<!-- CSS -->
<link rel="stylesheet"
	href='<c:url value="/assets/css/menu.css"></c:url>'>
<link rel="stylesheet"
	href='<c:url value="/assets/css/style.css"></c:url>'>
<style type="text/css">
.block {
	margin-left: 10px;
}
</style>
<!-- END -->

<!-- JAVASCRIPT -->
<!-- END -->
<body>
	<!-- MENU HOME -->
	<jsp:include page="/WEB-INF/views/common/menu/customer-menu.jsp"></jsp:include>
	<!-- END -->

	<!-- LIST CUISINE -->
	<div class="container demo">
		<table class="datatable table table-striped table-bordered">
			<thead>
				<tr>
					<th>STT</th>
					<th>Tài khoản</th>
					<th>Email</th>
					<th>Trạng thái</th>
					<th>Ngày tạo</th>
					<th>Cập nhật</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="list" varStatus="loop">
					<tr>
						<td>${loop.index + 1 }</td>
						<td>${list.username }</td>
						<td>${list.email }</td>
						<td><c:if test="${list.blockStatus == false }">
							Mở
						</c:if> <c:if test="${list.blockStatus == true }">
							Khóa
						</c:if></td>
						<td>${list.insDate }</td>
						<td><a
							href='<c:url value="/customer-open-block/${list.id}"></c:url>'
							class="btn btn-info block"><i class="fas fa-lock-open"></i></a><a
							href='<c:url value="/customer-block/${list.id}"></c:url>'
							class="btn btn-danger block"><i class="fas fa-lock"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>STT</th>
					<th>Tài khoản</th>
					<th>Email</th>
					<th>Trạng thái</th>
					<th>Ngày tạo</th>
					<th>Cập nhật</th>
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