<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ page import="model.vo.UserVO"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="euc-kr">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap Template</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>

<body>
	<div class="container">
		<div align="right">
			
    		<nav class="navbar navbar-default navbar-fixed-top" role="navigation" id="navbar-scroll">
            <div align="center">
				maven MVC Web programming
			</div>
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
            </div>
           
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-1-collapse">
              <ul class="nav navbar-nav">
              	<%
		    		UserVO user = (UserVO)session.getAttribute("loginSession");
		    		if(user == null ) {
    			%>	
                <li><a href="#loginModal" data-toggle="modal">로그인</a></li>  
                <li><a href="#joinModal"  data-toggle="modal">회원가입</a></li>
                <%
    				}else {
    			%>
					
				<li><a readOnly><%= user.getName() %>님 로그인 환영합니다.</a></li>
				<li><a href="logout.dgccei">[로그아웃]</a></li>  
				<%
    				}
    			%>  
              </ul> 
            </div>
          	</nav>
		
		</div>
		<HR />
		<!-- Modal -->
		<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">로그인</h4>
					</div>

					<div class="modal-body">
						<form class="form-horizontal" role="form" 
							action="login.kpc"
							method="post">
							<div class="form-group">
								<label for="Name" class="col-xs-2 col-lg-2 control-label">아이디</label>
								<div class="col-xs-10 col-lg-10">
									<input type="text" name="id" class="form-control"
										placeholder="아이디">
								</div>
							</div>
							<div class="form-group">
								<label for="emailaddress"
									class="col-xs-2 col-lg-2 control-label">비밀번호</label>
								<div class="col-xs-10 col-lg-10">
									<input type="text" name="pwd" class="form-control"
										placeholder="비밀번호">
								</div>
							</div>
							<div class="form-group">
								<div
									class="col-xs-offset-2 col-xs-10 col-lg-offset-2 col-lg-10 ">
									<button type="submit">로그인</button>
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
		<!-- 회원가입 Modal -->
		<div class="modal fade" id="joinModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">회원가입</h4>
					</div>

					<div class="modal-body">
						<form class="form-horizontal" role="form" 
							action="join.dgccei"
							method="post">
							<div class="form-group">
								<label for="Name" class="col-xs-2 col-lg-2 control-label">아이디</label>
								<div class="col-xs-10 col-lg-10">
									<input type="text" name="id" class="form-control"
										placeholder="아이디">
								</div>
							</div>
							<div class="form-group">
								<label for="emailaddress"
									class="col-xs-2 col-lg-2 control-label">비밀번호</label>
								<div class="col-xs-10 col-lg-10">
									<input type="text" name="pwd" class="form-control"
										placeholder="비밀번호">
								</div>
							</div>
							<div class="form-group">
								<label for="emailaddress"
									class="col-xs-2 col-lg-2 control-label">이름</label>
								<div class="col-xs-10 col-lg-10">
									<input type="text" name="name" class="form-control"
										placeholder="이름">
								</div>
							</div>
							<div class="form-group">
								<div
									class="col-xs-offset-2 col-xs-10 col-lg-offset-2 col-lg-10 ">
									<button type="submit">로그인</button>
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
</body>

</html>





