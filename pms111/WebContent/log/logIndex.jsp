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
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="<%=path %>/layui/css/layui.css" media="all">
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
<script type="text/javascript" src="<%=path %>/layui/jquery-3.3.1.js"></script>
</head>
<body>

	<table class="layui-hide" id="test" lay-filter="test"></table>

<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="deleteLog">删除日志</button>
  </div>
</script>

<script type="text/javascript" src="<%=path %>/layui/layui.all.js"></script>
	
<script>
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#test'
    ,url:'LogJson'
    ,toolbar: '#toolbarDemo'
    ,title: '日志数据表'
    ,cols: [[
        {type: 'checkbox', fixed: 'left'}
        ,{field:'logId', title:'日志编号', width:100,sort: true}
        ,{field:'userName', title:'用户名', width:100}
        ,{field:'createTime', title:'时间', width:280,sort:true}
        ,{field:'operation', title:'操作', width:80}
        ,{field:'content', title:'内容', width:280}
        ,{field:'ip', title:'IP地址', width:280}
        ,{field:'module', title:'所属模块'}
      ]]
    ,page: true
  });
  //头工具栏事件
  table.on('toolbar(test)', function(obj){
	  var checkStatus = table.checkStatus(obj.config.id)
	    ,data = checkStatus.data; //获取选中的数据
    switch(obj.event){
      case 'deleteLog': 
          if(data.length === 0){
              layer.msg('请至少选择1行', { icon: 2, time: 1500 });
          }else {
              layer.alert('您确认要删除'+data.length+'条数据吗？', {
                  skin: 'layui-layer-molv' //样式类名layui-layer-lan或layui-layer-molv  自定义样式
                  ,closeBtn: 1    // 是否显示关闭按钮
                  ,anim: 1 //动画类型
                  ,btn: ['确定','取消'] //按钮
                  ,icon: 2    // icon
                  ,yes:function(){
                      // layer.msg('确定', { icon: 1, time: 1500 });
                      for (var i=0;i<data.length;i++){
                          //发送请求到后台
                          $.post("Log_delete", {logId: data[i].logId }, function (result) {
                              if (result=="1") {//删除成功，刷新当前页表格
                                   //obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                                  layer.msg("删除成功", { icon: 1, time: 1500 });
                                	  layui.table.reload('test',{page:{curr:1}});
                              }else  if(result== "-1"){  //删除失败
                                  layer.alert("删除失败", { icon: 2},function () {
                                      return ;
                                  });
                              }
                          });
                      }
                  }
                  ,btn2:function(){
                      layer.msg('好的,暂时不给您删除。',{ icon: 1, time: 1500 });
                  }
              });
          }
          break;
    };
  });
  
});
</script>
</body>
</html>