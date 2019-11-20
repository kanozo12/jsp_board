<%@page import="model.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>

<body>

	<jsp:include page="layout/header.jsp" />

	<h2 align="center">
		<b>전체 게시글 보기</b>
	</h2>

	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">작성자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="dto">
						<tr>
							<td>${dto.no}</td>
							<td>
								<a href="contentView?no=${dto.no}">${dto.title}</a>
							</td>
							<td>${dto.writer}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:if test="${not empty id}">
				<a href="write" class="btn btn-primary">글쓰기</a>
			</c:if>
		</div>
	</div>

	<jsp:include page="layout/footer.jsp" />

</body>

</html>