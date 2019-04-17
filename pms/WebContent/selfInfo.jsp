<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/data/css/normalize.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/data/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/data/css/demo.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/data/css/component.css" />
<link rel="stylesheet" href="<%=path%>/layui/css/layui.css">
<script type="text/javascript" src="<%=path%>/layui/layui.all.js"></script>
<script type="text/javascript">
function closethis(){
	var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	parent.layer.close(index); //再执行关闭
	parent.layer.msg("检测到您的信息发生改变,请重新登录", { icon: 4, time: 1500 });
}
</script>
<title>Insert title here</title>
</head>
<body class="bgcolor-4">
	<form class="layui-form" action="User_password" method="post">
		<input name="userId" value="${sessionScope.user.userId }"
			hidden="hidden" />
		<div class="container">
			<section class="content bgcolor-4">
				<h2>Your Information</h2>
				<div class="layui-form-item">
					<span class="input input--minoru"> <input
						lay-verify="required" class="input__field input__field--minoru"
						type="text" id="input-13" name="userName"
						value="${sessionScope.user.userName }" /> <label
						class="input__label input__label--minoru" for="input-13">
							<span class="input__label-content input__label-content--minoru">Your
								Name</span>
					</label>
					</span>
				</div>
				<div class="layui-form-item">
					<span class="input input--minoru"> <input lay-verify="required" 
						class="input__field input__field--minoru" type="password"
						id="input-14" name="password"
						value="${sessionScope.user.password}" /> <label
						class="input__label input__label--minoru" for="input-14">
							<span class="input__label-content input__label-content--minoru">Your
								Password</span>
					</label>
						 <div class="div-btns">
            <input type="submit" id="btn1" value="修改" class="layui-btn layui-btn-fluid" onclick="closethis()"/>
        </div>
					</span>
				</div>
			</section>
		</div>
	</form>
</body>
</html>