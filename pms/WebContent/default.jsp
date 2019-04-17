<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body 
{
background-image:url('data/BG.jpg');
background-repeat:no-repeat;
background-size: 100% 100%;
background-attachment:fixed;
}
p{
color: aqua;
}
.ddd{
color: aqua;
}

</style>
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend style="color: aqua;">更新日志</legend>
</fieldset>
<ul class="layui-timeline">
  <li class="layui-timeline-item">
    <i class="layui-icon layui-timeline-axis"></i>
    <div class="layui-timeline-content layui-text">
      <h3 class="layui-timeline-title">2019-04-15</h3>
      <p>
        	权限管理系统 2.0 的一切准备工作似乎都已到位。发布之弦，一触即发。
        <br>不枉近百个日日夜夜与之为伴。因小而大，因弱而强。
        <br>无论它能走多远，抑或如何支撑？至少我曾倾注全心，无怨无悔 !
      </p>
    </div>
  </li>
  <li class="layui-timeline-item">
    <i class="layui-icon layui-timeline-axis"></i>
    <div class="layui-timeline-content layui-text">
      <h3 class="layui-timeline-title">2018-12-21</h3>
      <p>权限管理系统迎来首次更新  修复和优化如下:</p>
      <ul>
        <li class="ddd">优化了全局UI风格</li>
        <li class="ddd">修复了选项卡多次点击无法正常加载的问题</li>
        <li class="ddd">修复了用户头像显示异常的问题</li>
        <li class="ddd">...</li>
      </ul>
    </div>
  </li>
  <li class="layui-timeline-item">
    <i class="layui-icon layui-timeline-axis"></i>
    <div class="layui-timeline-content layui-text">
      <h3 class="layui-timeline-title">2018-08-01</h3>
      <p>
       权限管理系统正式上线!
        <br>感谢后台管理员日以继夜的付出
        <br>铭记、感恩
        <br>所有为该系统付出的英雄将士
        <br>永垂不朽
      </p>
    </div>
  </li>
  <li class="layui-timeline-item">
    <i class="layui-icon layui-timeline-axis"></i>
    <div class="layui-timeline-content layui-text">
      <div class="layui-timeline-title">过去</div>
    </div>
  </li>
</ul>  
 
</body>
</html>