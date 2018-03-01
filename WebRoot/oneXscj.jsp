<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生成绩管理系统</title>
</head>
<body bgcolor="#D9DFAA">
	<h3>该学生成绩如下:</h3>
	<hr width="700" align="left">
	<table border="1" cellspacing="1" cellpadding="8" width="700">
		<tr>
			<th>课程名</th>
			<th>成绩</th>
			<th>学分</th>
		</tr>
		<s:iterator value="#request.list" id="xscj">
			<tr>
				<td><s:property value="#xscj[2]" /></td>
				<td><s:property value="#xscj[3]" /></td>
				<td><s:property value="#xscj[4]" /></td>
			</tr>
		</s:iterator>
	</table>
	<input type="button" value="返回" onClick="javaScript:history.back()" />
</body>
</html>