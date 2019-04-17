<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addUser</title>
<link rel="stylesheet" href="<%=path%>/layui/css/layui.css">
<script type="text/javascript" src="<%=path%>/layui/layui.js"></script>
</head>
<body>
	<form class="layui-form" action="User_add"
		onsubmit="return checkForm()" name="myForm" lay-filter="example">
		<br />
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">用户名</label>
				<div class="layui-input-inline">
					<input type="text" value="" name="userName" autocomplete="off"
						placeholder="请输入用户名" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">密码</label>
				<div class="layui-input-inline">
					<input type="text" value="" name="password" autocomplete="off"
						placeholder="请输入密码" class="layui-input" onkeyup="value=value.replace(/[\u4E00-\u9FA5]/g,'')">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">角色</label>
			<div class="layui-input-block">
				<select name="roleId">
					<c:forEach items="${sessionScope.roles}" var="role">
						<option value="${role.roleId }">${role.roleName }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">备注</label>
			<div class="layui-input-block">
				<textarea value="" id="demo" style="display: none;"
					name="userDescription"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<input type="submit" class="layui-btn" value="添加" /> <input
					type="reset" class="layui-btn layui-btn-primary" value="重置" />
			</div>
		</div>
	</form>
	<script>
		function checkForm() {
			
			if (document.myForm.userName.value== "") {
				layer.msg("用户名不能为空哦", { icon: 2, time: 1000 });
				return false;
			}
			if (document.myForm.password.value== "") {
				layer.msg("密码不能为空哦", { icon: 2, time: 1000 });
				return false;
			}
			var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			parent.layer.close(index); //再执行关闭
			parent.layer.msg("添加成功");
		}
		layui.use('layedit', function() {
			var layedit = layui.layedit;
			layedit.build('demo'); //建立编辑器
		});
	</script>
</body>
</html>