<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%@ include file="/WEB-INF/views/common/check.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đơn đặt bàn</title>

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
	<jsp:include page="/WEB-INF/views/common/menu/table-order-menu.jsp"></jsp:include>
	<!-- END -->

	<!-- LIST CUISINE -->
	<div class="container demo">
		<table class="datatable table table-striped table-bordered">
			<thead>
				<tr>
					<th>STT</th>
					<th>Mã</th>
					<th>Khách hàng</th>
					<th>Số bàn</th>
					<th>Ngày đặt</th>
					<th>Giờ bắt đầu</th>
					<th>Giờ kết thúc</th>
					<th>Trạng thái</th>
					<th>Cập nhật</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="list" varStatus="loop">
					<tr>
						<td>${loop.index + 1 }</td>
						<td>${list.code }</td>
						<td>${list.customer }</td>
						<td>${list.quantityTable }</td>
						<td>${list.date }</td>
						<td>${list.timeStart }</td>
						<td>${list.timeOff }</td>
						<td><c:if test="${list.status eq 'WAIT' }">
							Đợi
						</c:if> <c:if test="${list.status eq 'EATING' }">
							Đang ăn
						</c:if> <c:if test="${list.status eq 'END' }">
							Kết thúc
						</c:if></td>
						<td><a
							href='<c:url value="/table-order-waiting/${list.id}"></c:url>'
							class="btn btn-warning block"><i class="far fa-stop-circle"></i></a> <a
							href='<c:url value="/table-order-eating/${list.id}"></c:url>'
							class="btn btn-info block"><i class="fas fa-utensils"></i></a><a
							href='<c:url value="/table-order-end/${list.id}"></c:url>'
							class="btn btn-danger block"><i class="fas fa-ban"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>STT</th>
					<th>Mã</th>
					<th>Khách hàng</th>
					<th>Số bàn</th>
					<th>Ngày đặt</th>
					<th>Giờ bắt đầu</th>
					<th>Giờ kết thúc</th>
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