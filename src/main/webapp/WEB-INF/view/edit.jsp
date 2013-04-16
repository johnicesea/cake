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
	padding-top: 20px;
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
			<h3 class="muted">修改订单</h3>
		</div>

		<hr>

		<form class="form-horizontal" action="<c:url value="/order/update"/>" method="post">
			<input type="hidden" name="id" value="${order.id}" />
			<div class="control-group">
				<label class="control-label" for="inputEmail">客户姓名:</label>
				<div class="controls">
					<input type="text" name="custName" placeholder="客户姓名" value="${order.custName}">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPassword">客户地址:</label>
				<div class="controls">
					<input type="text" name="custAddr" placeholder="客户地址" value="${order.custAddr}">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPassword">联系电话:</label>
				<div class="controls">
					<input type="text" name="phone" placeholder="联系电话" value="${order.phone}">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPassword">蛋糕名称:</label>
				<div class="controls">
					<input type="text" name="cakeName" placeholder="蛋糕名称" value="${order.cakeName}">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPassword">订购数量:</label>
				<div class="controls">
					<input type="text" name="count" placeholder="订购数量" value="${order.count}">
				</div>
			</div>
			<div class="form-actions">
				<button type="submit" class="btn btn-primary">创建</button>
				<button type="button" class="btn" id="cancel">取消</button>
			</div>
		</form>
		<hr>

		<div class="footer">
			<p>&copy; 蛋糕订单管理系统 2013</p>
		</div>

	</div>
	<!-- /container -->

	<script type="text/javascript" src="<c:url value="/bootstrap/js/jquery-1.9.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.js"/>"></script>
	<script type="text/javascript">
		$(function() {
			$('#cancel').click(function() {
				window.location = ctx + "/order/list";
			});
		});
	</script>
</body>
</html>
