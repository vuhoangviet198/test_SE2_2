<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%@ include file="/WEB-INF/views/common/check.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý giao hàng</title>

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
	<jsp:include page="/WEB-INF/views/common/menu/order-dish-menu.jsp"></jsp:include>
	<!-- END -->

	<!-- LIST CUISINE -->
	<div class="container demo">
		<table class="datatable table table-striped table-bordered">
			<thead>
				<tr>
					<th>STT</th>
					<th>Khách hàng</th>
					<th>Tổng tiền</th>
					<th>Ngày giao hàng</th>
					<th>Địa chỉ giao hàng</th>
					<th>Số điện thoại</th>
					<th>Trạng thái</th>
					<th>Ngày tạo yêu cầu</th>
					<th>Chi tiết</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="list" varStatus="loop">
					<tr>
						<td>${loop.index + 1 }</td>
						<td>${list.fullName}</td>
						<td>${list.totalMoney}</td>
						<td>${list.date}</td>
						<td>${list.address}</td>
						<td>${list.phone}</td>
						<td><c:if test="${list.status eq 'ACCEPT' }">
									Tạo đơn hàng
							</c:if> <c:if test="${list.status eq 'INPROGRESS' }">
								Vận chuyển
							</c:if> <c:if test="${list.status eq 'DONE' }">
								Hoàn thành
							</c:if></td>
						<td>${list.insDate }</td>
						<td><a
							href='<c:url value="/order-dish-update/${list.id}"></c:url>'
							class="btn btn-warning">Chi tiết</a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>STT</th>
					<th>Khách hàng</th>
					<th>Tổng tiền</th>
					<th>Ngày giao hàng</th>
					<th>Địa chỉ giao hàng</th>
					<th>Số điện thoại</th>
					<th>Trạng thái</th>
					<th>Ngày tạo yêu cầu</th>
					<th>Chi tiết</th>
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