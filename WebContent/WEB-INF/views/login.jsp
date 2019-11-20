<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>로그인</title>
</head>
<body>
	<header>
		<jsp:include page="layout/header.jsp" />
	</header>

	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top: 20px">
				<form method="post" action="/login">
					<h3 style="text-align: center;">로그인 화면</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디" name="id" maxlength="20"> <input type="password" class="form-control" placeholder="비밀번호" name="pass" maxlength="20">
					</div>
					<input type="submit" class="btn-primary form-control" value="로그인" />
				</form>
			</div>
		</div>
		<div class="col-lg-4"></div>
	</div>

	<jsp:include page="layout/footer.jsp" />
</body>
</html>