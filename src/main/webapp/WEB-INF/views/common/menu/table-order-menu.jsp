<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<style type="text/css">
.username-logout {
	width: 100%;
	height: 50px;
	text-align: right;
	padding-top: 20px;
	position: absolute;
}
</style>
<body>
	<header>
		<ul>
			<li><a href='<c:url value="/employee"></c:url>'
				class="menu-non-click">Quản lý nhân viên</a></li>
			<li><a href='<c:url value="/customer"></c:url>'
				class="menu-non-click">Thông tin khách hàng</a></li>
			<li><a href='<c:url value="/category"></c:url>'
				class="menu-non-click">Danh mục món ăn</a></li>
			<li><a href='<c:url value="/dish"></c:url>'
				class="menu-non-click">Danh sách món ăn</a></li>
			<li><a href='<c:url value="/table"></c:url>'
				class="menu-non-click">Quản lý đặt bàn</a></li>
			<li><a href='<c:url value="/order-dish"></c:url>'
				class="menu-non-click">Quản lý giao hàng</a></li>
			<li class="click-menu"><a
				href='<c:url value="/table-order"></c:url>' class="menu-click">Đơn
					đặt bàn</a></li>
		</ul>
	</header>
	<c:if test="${usernameLogin != null }">
		<div class="row username-logout">
			<div class="col-md-9"></div>
			<div class="col-md-2">
				<div class="form-group">Xin chào: ${usernameLogin}</div>
			</div>
			<div class="col-md-1">
				<div class="form-group">
					<a href='<c:url value="/logout"></c:url>' class="link">Đăng
						xuất</a>
				</div>
			</div>
		</div>
	</c:if>
</body>
</html>