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
<title>addMenu</title>
<link rel="stylesheet" href="<%=path %>/layui/css/layui.css">
<script type="text/javascript" src="<%=path %>/layui/layui.js"></script>
</head>
<body>
<form class="layui-form" action="Menu_update" onsubmit="return checkForm(this)" layui-filter="example">
<br />
<div class="layui-form-item">
    <label class="layui-form-label">菜单名</label>
    <div class="layui-input-block">
  		<input type="text" value="" name="menuName" lay-verify="title" autocomplete="off" placeholder="请输入菜单名" class="layui-input">
    </div>
  </div>
  
<div class="layui-form-item">
    <label class="layui-form-label">路径</label>
    <div class="layui-input-block">
  		<input type="text" value="" name="menuUrl" lay-verify="title" autocomplete="off" placeholder="请输入路径" class="layui-input">
    </div>
  </div>
<input type="password" hidden="hidden" name="menuId"/>		
<div class="layui-form-item">
	<label class="layui-form-label">备注</label>
	<div class="layui-input-block">
	<textarea  value="" id="demo" style="display: none;" name="menuDescription"></textarea>
<script>
layui.use(['layedit','form'], function() {
	var form=layui.form;
	var layedit = layui.layedit;
	//获取父窗口的json数据
	var jsonData=sessionStorage.getItem("jsonData");
	var json=JSON.parse(jsonData);
	//layer.alert("'"+json[0].password+"'");
	
	form.val('example', {
	    "menuName":json[0].menuName // "name": "value"
	    ,"menuId":eval(json[0].menuId)
	    ,"menuDescription":json[0].menuDescription	
	    ,"menuUrl":json[0].menuUrl
	  })
	  layedit.build('demo'); //建立编辑器
});
function checkForm(form){
	if (form.menuName.value== "") {
		layer.msg("菜单名不能为空", { icon: 2, time: 1000 });
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