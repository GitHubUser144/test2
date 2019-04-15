<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>layui</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<link rel="stylesheet" href="<%=path%>/layui/css/layui.css" media="all">
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
<script type="text/javascript" src="<%=path%>/layui/jquery-3.3.1.js"></script>
</head>
<body>
	<table class="layui-hide" id="test" lay-filter="test"></table>
	<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="addUser">添加用户</button>
    <button class="layui-btn layui-btn-sm" lay-event="deleteUser">删除用户</button>
    <button class="layui-btn layui-btn-sm" lay-event="editUser">编辑用户</button>
  </div>
<form class="layui-form">
<div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">用户名</label>
      <div class="layui-input-inline">
        <input type="text" name="uname" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">用户角色</label>
      <div class="layui-input-inline">
			<select name="roleId">
					<c:forEach items="${sessionScope.roles}" var="role">
						<option value="${role.roleId }">${role.roleName }</option>
					</c:forEach>
			</select>
      </div>
    </div>
  </div>
</form>
</script>

	<script type="text/javascript" src="<%=path%>/layui/layui.all.js"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	<script>
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#test'
    ,url:'UserJson'
    ,toolbar: '#toolbarDemo'
    ,title: '用户数据表'
    ,cols: [[
        {type: 'checkbox', fixed: 'left'}
        ,{field:'userId', title:'用户编号', width:180,sort: true}
        ,{field:'userName', title:'用户名', width:180}
        ,{field:'password', title:'密码', width:180}
        ,{field:'roleId', title:'用户角色', width:180}
        ,{field:'userDescription', title:'备注'}
      ]]
    ,page: true
  });
  //头工具栏事件
  table.on('toolbar(test)', function(obj){
	  var checkStatus = table.checkStatus(obj.config.id)
	    ,data = checkStatus.data; //获取选中的数据
    switch(obj.event){
      case 'addUser':
          layer.open({
              type: 2,
              skin: 'layui-layer-molv', //样式类名
              title: '添加用戶',
              closeBtn: 1, //不显示关闭按钮
              anim: 2,
              area: ['893px', '600px'],
              shadeClose: true, //开启遮罩关闭
              content: '<%=path%>/user/addUser.jsp'
              ,end:function(){
            	  layui.table.reload('test',{page:{curr:1}});
              }
          });

      break;
      case 'deleteUser': 
          if(data.length === 0){
              layer.msg('请至少选择1行', { icon: 2, time: 1500 });
          }else {
              layer.alert('您确认要删除'+data.length+'条数据吗？', {
                  skin: 'layui-layer-molv' //样式类名layui-layer-lan或layui-layer-molv  自定义样式
                  ,closeBtn: 1    // 是否显示关闭按钮
                  ,anim: 2 //动画类型
                  ,btn: ['确定','取消'] //按钮
                  ,icon: 3    // icon
                  ,yes:function(){
                      // layer.msg('确定', { icon: 1, time: 1500 });
                      for (var i=0;i<data.length;i++){
                          //发送请求到后台
                          $.post("User_delete", { userId: data[i].userId }, function (result) {
                              if (result=="1") {//删除成功，刷新当前页表格
                                  // obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                                  layer.msg("删除成功", { icon: 1, time: 1500 });
                                  //重载表格
                             //     layer.table.reload("test",{page:{curr:1}});
                                  // layer.close(index);
                                	  layui.table.reload('test',{page:{curr:1}});
                              }else  if(result== "-1"){  //删除失败
                                  layer.alert("删除失败", { icon: 2});
                              }
                          });
                      }
                      /*   //捉到所有被选中的，发异步进行删除
                         layer.msg('删除成功', {icon: 1});
                         $(".layui-form-checked").not('.header').parents('tr').remove();*/
                  }
                  ,btn2:function(){
                      layer.msg('好的,暂时不给您删除。',{ icon: 1, time: 1500 });
                  }
              });
          }
          break;
      case 'editUser':
    	  if(data.length === 1){
    		  var jsonData=JSON.stringify(data);
    		  sessionStorage.setItem("jsonData",jsonData);
    		layer.open({
                  type: 2,
                  skin: 'layui-layer-molv', //样式类名
                  title: '编辑用户',
                  closeBtn: 1, //不显示关闭按钮
                  anim: 2,
                  area: ['893px', '600px'],
                  shadeClose: true, //开启遮罩关闭
                  content: '<%=path%>/user/updateUser.jsp'
                  ,end:function(){
                	  layui.table.reload('test',{page:{curr:1}});
                  }
              });
    		  
    	  }else if(data.length === 0){
    		  layer.msg("请选择一个哦", { icon: 2, time: 1000 });
    	  }else{
    		  layer.msg("最多选择一个", { icon: 2, time: 1000 });
    	  }break;
    };
  });
});
</script>
</body>
</html>