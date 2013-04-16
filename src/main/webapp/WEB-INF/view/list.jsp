<%@page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript">
	var ctx = '${pageContext.servletContext.contextPath}';
</script>
<meta charset="utf-8">
<title>Template &middot; Bootstrap</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="<c:url value="/bootstrap/css/bootstrap.css"/>" rel="stylesheet">
<style type="text/css">
body {
	padding-bottom: 40px;
}

/* Custom container */
.container-narrow {
	margin: 0 auto;
	max-width: 700px;
}

.container-narrow>hr {
	margin: 30px 0;
}

/* Main marketing message and sign up button */
.jumbotron {
	margin: 60px 0;
	text-align: center;
}

.jumbotron h1 {
	font-size: 72px;
	line-height: 1;
}

.jumbotron .btn {
	font-size: 21px;
	padding: 14px 24px;
}

/* Supporting marketing content */
.marketing {
	margin: 60px 0;
}

.marketing p+h4 {
	margin-top: 28px;
}
</style>
<link href="<c:url value="/bootstrap/css/bootstrap-responsive.css"/>" rel="stylesheet">
</head>

<body>
	<div class="navbar">
		<div class="navbar-inner">
			<a class="brand" href="#">蛋糕订单管理系统</a>
			<ul class="nav pull-right">
				<li class="active"><a href="#">${sessionScope.user.name}</a></li>
				<li><a href="<c:url value="/logout"/>">[ 登出 ]</a></li>
			</ul>
		</div>
	</div>
	<div class="container-narrow">

		<div class="masthead">
			<div class="pull-right">
				<button class="btn btn-danger" type="button" id="add">添加订单</button>
			</div>
			<h3 class="muted">订单管理</h3>
		</div>

		<hr>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>订单号</th>
					<th>客户姓名</th>
					<th>客户地址</th>
					<th>电话</th>
					<th>蛋糕名称</th>
					<th>数量</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="order" items="${orders}">
					<tr>
						<td>${order.id}</td>
						<td>${order.custName}</td>
						<td>${order.custAddr}</td>
						<td>${order.phone}</td>
						<td>${order.cakeName}</td>
						<td>${order.count}</td>
						<td><div class="btn-group">
								<button class="btn btn-danger dropdown-toggle" data-toggle="dropdown">
									操作订单 <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="<c:url value="/order/edit?id=${order.id}"/>">修改</a></li>
									<li><a href="javascript:doDelete(${order.id});">删除</a></li>
								</ul>
							</div></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr>

		<div class="footer">
			<p>&copy; 蛋糕订单管理系统 2013</p>
		</div>

	</div>
	<!-- /container -->

	<script type="text/javascript" src="<c:url value="/bootstrap/js/jquery-1.9.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.js"/>"></script>
	<script type="text/javascript">
		function doDelete(id) {
			var result = confirm('确认删除?');
			if (result) {
				window.location = ctx + '/order/delete?id=' + id;
			}
		}

		$(function() {
			$('#add').click(function() {
				window.location = ctx + "/order/create";
			});
		});
	</script>
</body>
</html>
