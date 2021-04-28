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
<!-- END -->

<!-- JAVASCRIPT -->
<!-- END -->
<body>
	<!-- MENU HOME -->
	<jsp:include page="/WEB-INF/views/common/menu/employee-menu.jsp"></jsp:include>
	<!-- END -->

	<!-- LIST CUISINE -->
	<div class="container demo">
		<!-- CREATE -->
		<a href='<c:url value="/employee-create"></c:url>'
			class="btn btn-success space">Tạo Mới</a>
		<!-- END -->
		<table class="datatable table table-striped table-bordered">
			<thead>
				<tr>
					<th>STT</th>
					<th>Hình ảnh</th>
					<th>Tên</th>
					<th>Công việc</th>
					<th>Tài khoản</th>
					<th>Mã</th>
					<th>Giới tính</th>
					<th>Trạng thái</th>
					<th>Cập nhật</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="list" varStatus="loop">
					<tr>
						<td>${loop.index + 1 }</td>
						<td><img alt=""
							src='<c:url value="/assets/images/${list.image}"></c:url>'
							width="100px;"></td>
						<td>${list.fullname}</td>
						<td><c:if test="${list.job eq 'CHEF' }">
								Đầu bếp
							</c:if> <c:if test="${list.job eq 'WAITER' }">
								Bồi bàn
							</c:if> <c:if test="${list.job eq 'SECURITY' }">
								Bảo vệ
							</c:if> <c:if test="${list.job eq 'CASHIER' }">
								Thu ngân
							</c:if> <c:if test="${list.job eq 'SHIPER' }">
								Giao hàng
							</c:if> <c:if test="${list.job eq 'MANAGER' }">
								Quản lý
							</c:if></td>
						<td>${list.username }</td>
						<td>${list.code }</td>
						<td><c:if test="${list.gender eq 'MALE' }">
								Nam
							</c:if> <c:if test="${list.gender eq 'FEMALE' }">
								Nữ
							</c:if></td>
						<td><c:if test="${list.blockStatus == false }">
							Mở
						</c:if> <c:if test="${list.blockStatus == true }">
							Khóa
						</c:if></td>
						<td><a
							href='<c:url value="/employee-update/${list.id}/${list.code}"></c:url>'
							class="btn btn-warning">Cập nhật</a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>STT</th>
					<th>Hình ảnh</th>
					<th>Tên</th>
					<th>Công việc</th>
					<th>Tài khoản</th>
					<th>Mã</th>
					<th>Giới tính</th>
					<th>Trạng thái</th>
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