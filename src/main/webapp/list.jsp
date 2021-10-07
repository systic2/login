<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="model.vo.BoardVO"%>

<!doctype html>
<html lang="ko-kr">
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Bootstrap -->
	<link href="./css/bootstrap.min.css" rel="stylesheet">
	<link href="./css/custom2.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<table class="table">
			<thead>
				<tr class="active">
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<%
			ArrayList<BoardVO> lists = 
				(ArrayList<BoardVO>)request.getAttribute("lists");
				for(int i=0 ; i < lists.size() ; i++) {
					BoardVO board = lists.get(i);
			%>
			<tr class="success">
				<td><%= board.getSeq() %></td>
				<td><a href=""><%= board.getTitle() %></a></td>
				<td><%= board.getWriter() %></td>
				<td><%= board.getRegdate() %></td>
				<td><%= board.getCnt() %></td>
			</tr>
			<%
				}
			%>
		</table>

		<div align="right">
			<button class="btn btn-primary btn-sm" data-toggle="modal"
				data-target="#myModal">글쓰기</button>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">글쓰기</h4>
					</div>

					<div class="modal-body">
						<p>BBS 입력화면</p>
						<form 	class="form-horizontal" 
								role="form"
								action="insert.jnu"
								method="post">
						
							<div class="form-group">
								<label for="Name" class="col-xs-2 col-lg-2 control-label">제목</label>
								<div class="col-xs-10 col-lg-10">
									<input type="text" name="title" class="form-control" placeholder="제목을 입력하세요">
								</div>
							</div>
							<div class="form-group">
								<label for="emailaddress" class="col-xs-2 col-lg-2 control-label">작성자</label>
								<div class="col-xs-10 col-lg-10">
									<input type="text" name="writer" class="form-control" placeholder="작성자">
								</div>
							</div>
							<div class="form-group">
								<label for="emailaddress" class="col-xs-2 col-lg-2 control-label">내용</label>
								<div class="col-xs-10 col-lg-10">
									<textarea rows="5" class="form-control" name="content"></textarea>            
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-offset-2 col-xs-10 col-lg-offset-2 col-lg-10 ">
									<button type="submit">확인</button>
								</div>
							</div>

						</form>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					</div>

				</div>
				<!-- 모달 콘텐츠 -->
			</div>
			<!-- 모달 다이얼로그 -->
		</div>
		<!-- 모달 전체 윈도우 -->

	</div>
	<!-- div contanier -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="./js/bootstrap.min.js"></script>

</body>
</html>









