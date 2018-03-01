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
	<s:set name="dl" value="#request.dlInfo"></s:set>
	<s:form action="updateDl" method="post" enctype="multipart/form-data">
		<table border="0" cellspacing="1" cellpadding="8" width="500">
			<tr>
				<td width="80">id:</td>
				<td><input type="text" name="dl.id"
					value="<s:property value = "#dl.id"/>" readonly /></td>
			</tr>
			<tr>
				<td width="80">学号:</td>
				<td><input type="text" name="dl.xsb.xh"
					value="<s:property value = "#dl.xsb.xh"/>" readonly /></td>
			</tr>
			<tr>
				<td width="80">口令:</td>
				<td><input type="text" name="dl.kl"
					value="<s:property value = "#dl.kl"/>" /></td>
			</tr>
		</table>
		<input type="submit" value="修改" />
		<!-- 返回上一界面 -->
		<input type="button" value="返回" onClick="javascript:history.back();" />
	</s:form>
</body>
</html>
