<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生成绩管理系统</title>
</head>
<body bgcolor="#D9DFAA">
	<h3>登录信息如下:</h3>
	<s:set name="dl" value="#request.dl"></s:set>
	<s:form action="dlInfo" method="post">
		<table border="0" cellpadding="5">
			<tr>
				<td>id:</td>
				<td width="100"><s:property value="#dl.id" /></td>
			<tr>
				<td>学号</td>
				<td width="100"><s:property value="#dl.xsb.xh" /></td>
			</tr>
			<tr>
				<td>口令</td>
				<td width="100"><s:property value="#dl.kl" /></td>
			</tr>
			<tr>
				<td align="right"><s:submit value="返回" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>