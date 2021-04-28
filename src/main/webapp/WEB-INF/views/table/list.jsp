<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%@ include file="/WEB-INF/views/common/check.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý đặt bàn</title>

<!-- FAVICON -->
<link rel="shortcut icon" type="image/x-icon"
	href='<c:url value="/assets/images/favicon.ico"></c:url>' />
<!-- END -->
<link rel='stylesheet'
	href='https://unpkg.com/bootstrap@4.0.0/dist/css/bootstrap.css'>
<!-- FONT AWESOME -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<!-- END -->
<!-- JQUERY -->
<script
	src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<!-- END -->
<!-- CSS -->
<link rel="stylesheet"
	href='<c:url value="/assets/css/menu.css"></c:url>'>
<link rel="stylesheet"
	href='<c:url value="/assets/css/style.css"></c:url>'>
<link rel="stylesheet"
	href='<c:url value="/assets/css/table.css"></c:url>'>
<!-- END -->

<!-- JAVASCRIPT -->
<script type="text/javascript">
	$(document).ready(
		function() {
			$('#reset').click(function() {
				$('#dateOrder').val("");
				$('#timeStart').val("");
				$('#timeOff').val("");
			});
	
			var text = "";
			var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
			var length = 20;
			for (var i = 0; i < length; i++)
				text += possible.charAt(Math.floor(Math.random()
						* possible.length));
			$('#code').attr('value', text);
			
			var startTime = $('#timeStart').val();
			$('#startTime').attr('value', startTime);
			var offTime = $('#timeOff').val();
			$('#offTime').attr('value', offTime);
			var date = $('#dateOrder').val();
			$('#date').attr('value',date);
			
		});
</script>
<!-- END -->
<body>
	<!-- MENU HOME -->
	<jsp:include page="/WEB-INF/views/common/menu/table-menu.jsp"></jsp:include>
	<!-- END -->

	<!-- LIST CUISINE -->
	<div class="container content">

		<!-- FORM-SEARCH -->
		<c:url value="/check" var="check"></c:url>
		<form:form action="${check }" modelAttribute="checkDto" method="get">
			<div class="form-row">
				<div class="form-group">
					<label>Ngày</label>
					<form:input type="date" path="dateOrder" cssClass="form-control" />
				</div>
				<div class="form-group">
					<label>Giờ bắt đầu</label>
					<form:input path="timeStart" cssClass="form-control" />
				</div>
				<div class="form-group">
					<label>Giờ kết thúc</label>
					<form:input path="timeOff" cssClass="form-control" />
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-secondary btn-search">
						<i class="fas fa-search"></i>
					</button>
				</div>
				<div class="form-group">
					<a class="btn btn-light btn-search" id="reset"> <i
						class="fas fa-sync"></i>
					</a>
				</div>
			</div>
		</form:form>
		<!-- END -->

		<c:if test="${not empty count }">
			<p class="count">Còn ${count } bàn thích hợp cho yêu cầu của bạn</p>
		</c:if>

		<div class="form-row">
			<!-- CREATE -->
			<div class="form-group">
				<a href='<c:url value="/table-create"></c:url>'
					class="btn btn-success space">Thêm bàn</a>
			</div>
			<!-- END -->
			<div class="form-group">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#myModal">Đặt bàn</button>
			</div>
		</div>

		<div class="form-row">
			<c:forEach items="${list }" var="list" varStatus="loop">
				<div class="list-table-lol">
					<div class="infor-lol">
						<p>Mã bàn: ${list.code }</p>
						<p class="number">${list.number }</p>
					</div>
					<div class="button-lol">
						<a href='<c:url value="/table-update/${list.id }"></c:url>'
							class="btn btn-info"> Update </a> <a
							href='<c:url value="/table-delete/${list.id }"></c:url>'
							class="btn btn-danger"
							onclick="return confirm('Bạn có chắc muốn xóa bàn này');">
							Delete </a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<!-- FOOTER -->
	<jsp:include page="/WEB-INF/views/common/foot.jsp"></jsp:include>
	<script src='<c:url value="/assets/js/index.js"></c:url>'></script>
	<!-- END -->

	<!-- The Modal -->
	<c:url value="/order-table-create" var="create"></c:url>
	<form:form action="${create }" modelAttribute="orderTableDto"
		method="post">
		<div class="modal" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">Đặt bàn</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<div class="form-row">
							<div class="form-group">
								<label>Mã đặt bàn</label>
								<form:input path="code" cssClass="form-control" readonly="true" />
							</div>
							<div class="form-group">
								<label>Khách hàng</label>
								<form:input path="customer" cssClass="form-control" />
							</div>
							<div class="form-group">
								<label>Danh sách bàn</label>
								<form:checkboxes items="${list }" path="idtable"
									itemLabel="code" itemValue="id" class="checkbox-inline" />
							</div>
							<form:hidden path="date" />
							<form:hidden path="startTime" />
							<form:hidden path="offTime" />
							<div class="form-group">
								<button type="submit" class="btn btn-success">Lưu</button>
							</div>
						</div>

					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
					</div>

				</div>
			</div>
		</div>
	</form:form>
</body>
</html>