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
	<h3>请录入学生成绩</h3>
	<hr>
	<s:form action="addorupdateXscj" method="post">
		<table border="1" cellspacing="1" cellpadding="8" width="400">
			<tr>
				<td width="100">学生:</td>
				<td><select name="cj.id.xsb.xh">
						<s:iterator id="xs" value="#request.list1">
							<option value="<s:property value = "#xs.xh"/>">
								<s:property value="#xs.xm" /></option>
						</s:iterator>
				</select></td>
			</tr>
			<tr>
				<td width="100">课程:</td>
				<td width="100"><select name="cj.id.kcb.kch">
						<s:iterator id="kc" value="#request.list2">
							<option value="<s:property value ="#kc.kch"/>">
								<s:property value="#kc.kcm" />
						</s:iterator>
				</select></td>
			</tr>
			<tr>
				<s:textfield label="成绩" name="cj.cj" size="15"></s:textfield>
			</tr>
		</table>
		<input type="submit" value="确定" />
		<input type="reset" value="重置" />
	</s:form>
</body>
</html>
