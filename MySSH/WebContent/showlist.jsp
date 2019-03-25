<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有车次</title>
</head>
<body>
	<table border="0" width="100%">
		<tr align="center" height="22">
			<td width="15%">车次路线</td>
			<td width="15%">车票日期</td>
			<td width="15%">发车时间</td>
			<td width="15%">到达时间</td>
			<td width="10%">票价</td>
			<td width="10%">车型</td>
			<td width="10%">票数</td>
			<td width="15%">操作</td>
		</tr>
		<c:forEach items="${list }" var="li">
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td bgcolor="#FFFFFF" align="center">
					${li.shifazhan}--${li.daodazhan}</td>
				<td bgcolor="#FFFFFF" align="center">${li.piaoshijian }</td>
				<td bgcolor="#FFFFFF" align="center">${li.startshijian }</td>
				<td bgcolor="#FFFFFF" align="center">${li.endshijian }</td>
				<td bgcolor="#FFFFFF" align="center">${li.piaojia }</td>
				<td bgcolor="#FFFFFF" align="center">${li.ctype }</td>
				<td bgcolor="#FFFFFF" align="center">${li.piaoshu }</td>
				<td bgcolor="#FFFFFF" align="center"><a href="#" onclick="">删除</a></td>
			</tr>
		</c:forEach>
		</table>
</body>
</html>