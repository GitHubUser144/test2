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
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>权限管理</title>
  <link rel="stylesheet" href="<%=path %>/layui/css/layui.css">
  <script type="text/javascript" src="<%=path %>/layui/layui.all.js"></script>
  <script type="text/javascript" src="<%=path %>/layui/jquery-3.3.1.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo"><i class="layui-icon"></i>&nbsp;权限管理系统<em>2.0</em></div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="">控制台</a></li>
      <li class="layui-nav-item"><a href="">商品管理</a></li>
      <li class="layui-nav-item"><a href="">用户</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">其它系统</a>
        <dl class="layui-nav-child">
          <dd><a href="">邮件管理</a></dd>
          <dd><a href="">消息管理</a></dd>
          <dd><a href="">授权管理</a></dd>
        </dl>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="<%=path %>/data/selfInfo.jpg" class="layui-nav-img">
          ${user.userName}
        </a>
        <dl class="layui-nav-child">
          <dd><a href="#" id="info">基本资料</a></dd>
          <dd><a href="User_quit">安全退出</a></dd>
        </dl>
      </li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
      <c:forEach items="${menus}" var="menu">
        <li class="layui-nav-item">
        <c:if test="${menu.parentId==1 }">
          <a class="" href="#">${menu.menuName}</a>
          <c:forEach items="${menus}" var="mmenu">
          <c:if test="${mmenu.parentId==menu.menuId }">
          <dl class="layui-nav-child">
            <dd><a class="jump" href="${mmenu.menuUrl}">${mmenu.menuName}</a></dd>
          </dl>
          </c:if>
          </c:forEach>
        </c:if>
        </li>
        </c:forEach>
      </ul>
    </div>
  </div>
  
  <div class="layui-body" id="mainFrame" style="margin-top: -10px;">
    <!-- 内容主体区域 -->
     <%@include file="default.jsp" %> 
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
   <div class="copyright">
                    &copy;
                    <script>
                        document.write(new Date().getFullYear())
                    </script>, Designed by Invision. Coded by Creative Chen.More Peojects <a href="http://www.dazky.cn:8080" target="_blank" title="http://www.dazky.cn">更多</a> - 
                </div>
  </div>
</div>
<script src="<%=path %>/layui/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
});
$('.jump').on('click',function(e){
	e.preventDefault();
  	var link=$(this).attr("href");
  	if(link!==""&&link!=null){
  		$('#mainFrame').load(link,function(){
  			
  		});
  	}
  });
$('#info').on('click',function(e){
	e.preventDefault();
	layer.open({
        type: 2,
        skin: 'layui-layer-molv', //样式类名
        title: '个人资料',
        closeBtn: 0, //不显示关闭按钮
        anim: 4, //动画效果
        area: ['800px', '650px'],
        content: '<%=path%>/selfInfo.jsp'
        ,end:function(layero, index){
        	window.location.href='User_quit';
         }
    });
})
</script>
</body>
</html>