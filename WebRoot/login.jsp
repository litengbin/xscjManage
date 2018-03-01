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
	<s:form action="login" method="post" theme="simple">
		<table>
			<caption>用户登录</caption>
			<tr>
				<td>学号:<s:textfield name="dl.xsb.xh" size="20"></s:textfield>
				</td>
			</tr>
			<tr>
				<td>口令:<s:password name="dl.kl" size="21"></s:password>
				</td>
			</tr>
			<tr>
				<td align="right"><s:submit value="登录"></s:submit> <s:submit
						value="重置"></s:submit></td>
			</tr>
		</table>
	</s:form>
</body>
</html>