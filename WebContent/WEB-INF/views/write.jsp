<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>로그인</title>
</head>
<body>
	<jsp:include page="layout/header.jsp" />
	<div class="container">
		<div class="row">
			<form action="/write" method="post" enctype="multipart/form-data">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee; text-align: center;">게시판 글쓰기</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<input type="text" class="form-control" placeholder=" 글 제목" name="title" maxlength="50" />
							</td>
						</tr>
						<tr>
							<td>
								<textarea type="text" class="form-control" placeholder=" 글 내용" name="content" style="height: 350px;" maxlength="2048"></textarea>
							</td>
						</tr>
						<tr>
							<td>
								<input type="file" name="fileName" />
							</td>
						</tr>
					</tbody>
				</table>
				<a class="btn btn-primary" href="/">돌아가기</a> <input type="submit" class="btn btn-primary pull-right" value="글쓰기">
			</form>
		</div>
	</div>
</body>

<jsp:include page="layout/footer.jsp" />
</html>