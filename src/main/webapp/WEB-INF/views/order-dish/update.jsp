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
	$(document).ready(function(){
		var list = ${listObject};
		var array = [];
		for(var i = 0; i<list.length;i++){
			var total = $('#total' + [i]).val();
			var tt = parseFloat(total);
			array.push(tt);
			var sum = array.reduce((a, b) => a + b, 0);
			$('#tongtien').val(sum);
		}
	})
</script>
<!-- END -->
<body>
	<!-- MENU HOME -->
	<jsp:include page="/WEB-INF/views/common/menu/order-dish-menu.jsp"></jsp:include>
	<!-- END -->

	<!-- LIST CUISINE -->
	<div class="container demo">
		<c:url value="/order-dish-update" var="update"></c:url>
		<form:form id="contact-form" action="${update }"
			modelAttribute="orderDishDto" method="post">
			<form:hidden path="id" />
			<form:hidden path="customerId" />
			<div class="controls">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Khách hàng</label>
							<form:input path="fullName" cssClass="form-control"
								readonly="true" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Tổng tiền</label>
							<form:input path="totalMoney" cssClass="form-control"
								readonly="true" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Ngày giao hàng</label>
							<form:input path="date" cssClass="form-control" readonly="true" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Địa chỉ giao hàng</label>
							<form:input path="address" cssClass="form-control"
								readonly="true" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Số điện thoại</label>
							<form:input path="phone" cssClass="form-control" readonly="true" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Ngày tạo yêu cầu</label>
							<form:input path="insDate" cssClass="form-control"
								readonly="true" />
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
							<div class="form-group">
								<label>Trạng thái</label>
								<form:select path="status" cssClass="form-control">
									<form:option value="">---  Trạng thái   ---</form:option>
									<form:option value="ACCEPT">Tạo đơn hàng</form:option>
									<form:option value="INPROGRESS">Vận chuyển</form:option>
									<form:option value="DONE">Hoàn thành</form:option>
								</form:select>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form:form>
		<table class="datatable table table-striped table-bordered">
			<thead>
				<tr>
					<th>STT</th>
					<th>Tên</th>
					<th>Ảnh</th>
					<th>Giá</th>
					<th>Số lượng</th>
					<th>Tiền</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listDetail }" var="listDetail" varStatus="loop">
					<tr>
						<td>${loop.index + 1 }</td>
						<td>${listDetail[0] }</td>
						<td><img alt=""
							src='<c:url value="/assets/images/${listDetail[1] }"></c:url>'
							width="100px"></td>
						<td>${listDetail[2] }</td>
						<td>${listDetail[3] }</td>
						<td>${listDetail[2] * listDetail[3] }<input type="hidden"
							value="${listDetail[2] * listDetail[3] }" id="total${loop.index}">
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>STT</th>
					<th>Tên</th>
					<th>Ảnh</th>
					<th>Giá</th>
					<th>Số lượng</th>
					<th>Tiền</th>
				</tr>
			</tfoot>
		</table>
	</div>
	<!--/.container.demo -->
	<!-- END -->

	<!-- FOOTER -->
	<jsp:include page="/WEB-INF/views/common/foot.jsp"></jsp:include>
	<script src='<c:url value="/assets/js/employee.js"></c:url>'></script>
	<!-- END -->
</body>
</html>