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

	<div class="container-narrow">

		<div class="masthead">
			<h3 class="muted">用户注册</h3>
		</div>

		<hr>

		<form class="form-horizontal" action="<c:url value="/register"/>" method="post">
			<c:if test="${not empty param.error}">
				<div class="alert alert-error">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>警告!</strong> 用户已存在
				</div>
			</c:if>
			<div class="control-group">
				<label class="control-label" for="inputEmail">登录名:</label>
				<div class="controls">
					<input type="text" name="name" placeholder="登录名">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPassword">密码:</label>
				<div class="controls">
					<input type="password" name="password" placeholder="密码">
				</div>
			</div>
			<div class="form-actions">
				<button type="submit" class="btn btn-primary">注册</button>
				<button type="button" class="btn" id="return">返回</button>
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
			$('#return').click(function() {
				window.location = ctx + '/login';
			});
		});
	</script>
</body>
</html>
