<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="<%=path %>/layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
  <script type="text/javascript" src="<%=path %>/layui/jquery-3.3.1.js"></script>
<style>
body 
{
background-image:url('data/BG.jpg');
background-repeat:no-repeat;
background-size: 100% 100%;
background-attachment:fixed;
}
</style>
</head>
<body>
 
<table class="layui-hide" id="test" lay-filter="test"></table>
 
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
<c:choose>
	<c:when test="${fn:contains(loginRole.operationIds,'10006')}">
   		<button class="layui-btn layui-btn-sm" lay-event="addRole">添加角色</button>
	</c:when>
	<c:otherwise>
		<button class="layui-btn layui-btn-sm" layui-btn-disabled">添加角色</button>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${fn:contains(loginRole.operationIds,'10008')}">
    	<button class="layui-btn layui-btn-sm" lay-event="deleteRole">删除角色</button>
	</c:when>
	<c:otherwise>
		<button class="layui-btn layui-btn-sm" layui-btn-disabled">删除角色</button>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${fn:contains(loginRole.operationIds,'10007')}">
    	<button class="layui-btn layui-btn-sm" lay-event="editRole">编辑角色</button>
	</c:when>
	<c:otherwise>
		<button class="layui-btn layui-btn-sm" layui-btn-disabled">编辑角色</button>
	</c:otherwise>
</c:choose>	
</div>

</script>              
   <script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="grant">授权</a>
</script>       
<script type="text/javascript" src="<%=path %>/layui/layui.all.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 --> 
 
<script>
layui.use('table', function(){
  var table = layui.table;
  table.render({
    elem: '#test'
    ,url:'RoleJson'
    ,toolbar: '#toolbarDemo'
    ,title: '角色数据表'
    ,cols: [[
        {type: 'checkbox',align:'center', fixed: 'left'}
        ,{field:'roleId',align:'center', title:'角色编号', width:180,sort: true}
        ,{field:'roleName',align:'center', title:'角色名称名', width:180}
        ,{field:'roleDescription',align:'center', title:'备注'}
        <c:if test="${fn:contains(loginRole.operationIds,'10009')}">
        ,{fixed: 'right', title:'操作', align:"center", toolbar: '#barDemo', width:100}
      	</c:if>
        ]]
    ,page: true
  });
  
  //头工具栏事件
  table.on('toolbar(test)', function(obj){
	  var checkStatus = table.checkStatus(obj.config.id)
	    ,data = checkStatus.data; //获取选中的数据
    switch(obj.event){
      case 'addRole':
          layer.open({
              type: 2,
              skin: 'layui-layer-molv', //样式类名
              title: '添加角色',
              closeBtn: 1, //不显示关闭按钮
              anim: 2,
              area: ['893px', '600px'],
              shadeClose: true, //开启遮罩关闭
              content: '<%=path %>/role/addRole.jsp'
            	  ,end:function(){
                	  layui.table.reload('test',{page:{curr:1}});
                  }
          });

      break;
      case 'deleteRole': 
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
                	  var ids=data[0].menuId;  
                	  for (var i = 1; i < data.length; i++)
                	  {ids=ids+","+data[i].menuId}
                          $.post("Role_delete", {menuIds:ids}, function (result) {
                              if (result=="1") {//删除成功，刷新当前页表格
                                  // obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                                  layer.msg("删除成功", { icon: 1, time: 1500 });
                                  // layer.close(index);
                                	  layui.table.reload('test',{page:{curr:1}});
                              }else  if(result== "-1"){  //删除失败
                                  layer.alert("删除失败", { icon: 2},function () {
                                      return false;
                                  });
                              }
                          });
                  }
                  ,btn2:function(){
                      layer.msg('好的,暂时不给您删除。',{ icon: 1, time: 1500 });
                  }
              });
          }
          break;
      break;
      case 'editRole':
    	  if(data.length === 1){
    		  var jsonData=JSON.stringify(data);
    		  sessionStorage.setItem("jsonData",jsonData);
    		layer.open({
                  type: 2,
                  skin: 'layui-layer-molv', //样式类名
                  title: '编辑角色',
                  closeBtn: 1, //不显示关闭按钮
                  anim: 2,
                  area: ['893px', '600px'],
                  shadeClose: true, //开启遮罩关闭
                  content: '<%=path%>/role/updateRole.jsp'
                  ,end:function(){
                	  layui.table.reload('test',{page:{curr:1}});
                  }
              });
    		  
    	  }else if(data.length === 0){
    		  layer.msg("请选择一个哦", { icon: 2, time: 1000 });
    	  }else{
    		  layer.msg("最多选择一个", { icon: 2, time: 1000 });
    	  }
      break;
    };
  });
  table.on('tool(test)', function(obj){
	    var data = obj.data;
	    //解析选中的数据
	    var json=JSON.parse(JSON.stringify(data));
	    var roleId=json.roleId;
	   if(obj.event === 'grant'){
		   layer.open({
               type: 2,
               skin: 'layui-layer-molv', //样式类名
               title: '角色授权',
               closeBtn: 1, //不显示关闭按钮
               anim: 1,
               area: ['893px', '600px'],
               shadeClose: true, //开启遮罩关闭
               content: '<%=path%>/role/grant.jsp'
               ,end:function(){//关闭之后执行操作
             	  
               },
               success : function(layero, index) {
					// 获取子页面的iframe
                   var iframe = window['layui-layer-iframe' + index];
                   // 向子页面的全局函数child传参
                   iframe.child(roleId);
				}
           });
	    }
	  });
  //监听行工具事件
});
</script>

</body>
</html>