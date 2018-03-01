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
	<h3>请填写登录信息</h3>
	<hr width="700" align="left">
	<s:form action="addDl" method="post" enctype="multipart/form-data">
		<table border="0" cellspacing="0" cellpadding="1">
			<tr>
				<td><s:textfield name="dl.xsb.xh" label="学号" value=""></s:textfield>
				</td>
			</tr>
			<tr>
				<s:password name="dl.kl" label="口令" value=""></s:password>
			</tr>
		</table>
		<p>
			<input type="submit" value="添加"> <input type="reset"
				value="重置">
		</p>
	</s:form>
</body>
</html>