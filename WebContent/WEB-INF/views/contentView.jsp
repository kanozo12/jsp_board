<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	response.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="layout/header.jsp" />

	<form action="/contentView" method="post">

		<div class="container">
			<div class="row">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="3" style="background-color: #eeeeee; text-align: center;">게시판 글 보기</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td style="width: 20%">글 제목</td>
							<td colspan="2">${content_view.title}</td>
						</tr>
						<tr>
							<td>작성자</td>
							<td colspan="2">${content_view.writer}</td>
						</tr>
						<tr>
							<td>첨부파일</td>
							<td colspan="2">
								<a href="/file/${content_view.fileName}" download>${content_view.fileName}</a>
							</td>
						</tr>
						<tr style="height: 200px;">
							<td>내용</td>
							<td colspan="2" style="min-height: 200px; text-align: left;">${content_view.content}</td>
						</tr>
					</tbody>
				</table>
				<div class="d-flex justify-content-between">
					<a href="/board" class="btn btn-primary">목록</a>
					<c:if test="${not empty id }">
						<a href="/modify?no=${content_view.no}" class="btn btn-primary">수정</a>
						<a href="/delete?no=${content_view.no}" class="btn btn-danger">삭제</a>
					</c:if>
				</div>

			</div>
		</div>

	</form>

	<jsp:include page="layout/footer.jsp" />
</body>
</html>