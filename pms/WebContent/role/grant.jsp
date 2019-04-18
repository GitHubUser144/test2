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
<%-- <link rel="stylesheet" href="<%=path %>/layui/tntreebox.css">
<script type="text/javascript" src="<%=path %>/layui/tntreebox.js"></script>
<script type="text/javascript" src="http://aso.39gs.com/js/jquery-2.0.3.min.js"></script> --%>
<link rel="stylesheet" href="<%=path %>/layui/css/layui.css">
<script type="text/javascript" src="<%=path %>/layui/layui.js"></script>
<script type="text/javascript" src="<%=path %>/layui/layui-xtree.js"></script>
 <script type="text/javascript" src="<%=path %>/layui/jquery-3.3.1.js"></script>
<title>Insert title here</title>
</head>
<body>
		<%--授权树 --%>
	<div id="tree">

		<form class="layui-form">
			<div id="xtree1" class="xtree_contianer"></div>
		</form>
	</div>
	 <div class="div-btns">
            <input type="button" id="btn1" value="确定" class="layui-btn layui-btn-fluid" />
        </div>
	
	<script type="text/javascript">
	function child(d) {
		layui.use(['table','form'],function() {
			var table = layui.table; //表格
			var form = layui.form;
	        //1、最基础的用法 - 直接绑定json
	        var xtree1 = new layuiXtree({
	            elem: 'xtree1', 
	            form: form ,     
	            data: 'Role_GentrateTree?roleId='+d 
	        });
	        //获取全部[选中的][末级节点]原checkbox DOM对象，返回Array
	        $('#btn1').click(function () {
	            var oCks = xtree1.GetChecked(); //这是方法
	            var str="";
	            for (var i = 0; i < oCks.length; i++) {
	            	str+=oCks[i].value+",";
	            }
	            $.ajax({
					type : "post",
					dataType : "text",
					url : "Role_grant",
					data : {
						"operations" : str,
						"roleId": d
					},
					success : function(result) {
						/* var roleId=${loginRole.roleId};
						if(roleId==d){
							parent.layer.alert("检测到您的权限发生改变,系统已自动退出");
							//layer.close(this)
					}
							else */
							parent.layer.msg("授权成功");
						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
						parent.layer.close(index); //再执行关闭
						xtree1.render();
					}
				});
	        });
		});
	    }
	</script>
</body>
</html>