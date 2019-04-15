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
<link rel="stylesheet" href="<%=path %>/layui/css/layui.css">
<script type="text/javascript" src="<%=path %>/layui/layui.js"></script>
</head>
<body>
<form class="layui-form" action="Role_add" onsubmit="return checkForm(this)">
<br />
<div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">角色名</label>
      <div class="layui-input-inline">
        <input type="text" value="" name="roleName" lay-verify="title" autocomplete="off" placeholder="请输入角色名" class="layui-input">
      </div>
    </div>
  </div>

<div class="layui-form-item">
	<label class="layui-form-label">备注</label>
	<div class="layui-input-block">
	<textarea  value="" id="demo" style="display: none;" name="roleDescription"></textarea>
<script>
layui.use('layedit', function(){
var layedit = layui.layedit;
layedit.build('demo'); //建立编辑器
});
function checkForm(form){
	if (form.roleName.value == "") {
		layer.msg("角色名不能为空哦", { icon: 2, time: 1000 });
		return false;
	}

	var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(index); //再执行关闭
    parent.layer.msg("添加成功");
    return true;
}
</script>
	</div>
</div>
 <div class="layui-form-item">
    <div class="layui-input-block">
      <input type="submit" class="layui-btn" value="添加" lay-filter="demo"/>
      <input type="reset" class="layui-btn layui-btn-primary" value="重置"/>
    </div>
  </div>
</form>
</body>
</html>