<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/userinfo" method="post">
		<table border="1" style="width: 400">
			<tr>
				<td colspan="2" align="center">
					<b>회원 수정 정보 입력</b>
				</td>
			</tr>
			<tr>
				<td align="right">이름</td>
				<td>
					<input class="cls1" type="text" name="name" value="" />
				</td>
			</tr>
			<tr>
				<td align="right">아이디</td>
				<td>
					<input class="cls1" type="text" name="id" value="" />
				</td>
			</tr>
			<tr>
				<td align="right">비밀번호</td>
				<td>
					<input class="cls1" type="password" name="pass" value="" />
				</td>
			</tr>
			<tr>
				<td align="right">비밀번호 확인</td>
				<td>
					<input class="cls1" type="password" name="rePass" value="" />
				</td>
			</tr>

			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정"> <input type="button" value="취소">
				</td>
			</tr>
		</table>
	</form>

	<jsp:include page="layout/footer.jsp" />
</body>
</html>