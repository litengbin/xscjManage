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
	<h3>课程信息如下:</h3>
	<s:set name="kc" value="#request.kc"></s:set>
	<s:form action="kcInfo" method="post">
		<table border="0" cellpadding="5">
			<tr>
				<td>课程号:</td>
				<td width="100"><s:property value="#kc.kch" /></td>
			<tr>
				<td>课程名:</td>
				<td width="100"><s:property value="#kc.kcm" /></td>
			</tr>
			<tr>
				<td>开学学期:</td>
				<td width="100"><s:if test="#kc.kxxq == 1">大一第一学期</s:if> <s:elseif
						test="#kc.kxxq == 2">大一第二学期</s:elseif> <s:elseif
						test="#kc.kxxq == 3">大二第一学期</s:elseif> <s:elseif
						test="#kc.kxxq == 4">大二第二学期</s:elseif> <s:elseif
						test="#kc.kxxq == 5">大三第一学期</s:elseif> <s:elseif
						test="#kc.kxxq == 6">大三第二学期</s:elseif> <s:elseif
						test="#kc.kxxq == 7">大四第一学期</s:elseif> <s:elseif
						test="#kc.kxxq == 8">大四第二学期</s:elseif></td>
			</tr>
			<tr>
				<td>学时:</td>
				<td width="100"><s:property value="#kc.xs" /></td>
			</tr>
			<tr>
				<td>学分:</td>
				<td width="100"><s:property value="#kc.xf" /></td>
			</tr>
			<tr>
				<td align="right"><s:submit value="返回" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>