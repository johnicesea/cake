<%@page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript">
	var ctx = '${pageContext.servletContext.contextPath}';
</script>
<meta charset="utf-8">
<title>Sign in &middot; Twitter Bootstrap</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="<c:url value="/bootstrap/css/bootstrap.css"/>" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>
<link href="<c:url value="/bootstrap/css/bootstrap-responsive.css"/>" rel="stylesheet">
</head>

<body>
	<div class="container">
		<form class="form-signin" action="<c:url value="/login"/>" method="post">
			<h3 class="form-signin-heading">蛋糕店管理系统</h3>
			<c:if test="${not empty param.error}">
				<div class="alert alert-error">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>警告!</strong> 用户信息有误，请检查
				</div>
			</c:if>
			<c:if test="${not empty param.logout}">
				<div class="alert alert-info">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					已经退出登录
				</div>
			</c:if>
			<c:if test="${not empty param.registered}">
				<div class="alert alert-success">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					用户注册成功，请登录!
				</div>
			</c:if>
			<input type="text" class="input-block-level" name="name" placeholder="用户名"> <input type="password"
				class="input-block-level" placeholder="密码" name="password">
			<button class="btn btn-large btn-primary" type="submit" style="margin-left: 40px;">登陆</button>
			<button class="btn btn-large" type="button" style="margin-left: 50px;" id="register">注册</button>
		</form>
	</div>

	<script type="text/javascript" src="<c:url value="/bootstrap/js/jquery-1.9.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.js"/>"></script>

	<script type="text/javascript">
		$(function() {
			$('#register').click(function() {
				window.location = ctx + '/register';
			});
		});
	</script>
</body>
</html>

