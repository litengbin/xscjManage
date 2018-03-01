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
	<s:set name="kc" value="#request.kcInfo"></s:set>
	<s:form action="updateKc" method="post" enctype="multipart/form-data">
		<table border="0" cellspacing="1" cellpadding="8" width="500">
			<tr>
				<td width="80">课程号:</td>
				<td><input type="text" name="kc.kch"
					value="<s:property value = "#kc.kch"/>" readonly /></td>
			</tr>
			<tr>
				<td width="80">课程名:</td>
				<td><input type="text" name="kc.kcm"
					value="<s:property value = "#kc.kcm"/>" /></td>
			</tr>
			<tr>
				<td width="80">开学学期:</td>
				<td><s:select name="kc.kxxq" list="#{1:'大一第一学期',2:'大一第二学期',3:'大二第一学期',4:'大二第二学期',5:'大三第一学期',6:'大三第二学期',7:'大四第一学期',8:'大四第二学期'}" 
						 value = "#kc.kxxq" label="开学学期"></s:select>
				</td>
			</tr>
			<tr>
				<td width="80">学时:</td>
				<td><input type="text" name="kc.xs"
					value="<s:property value = "#kc.xs"/>" /></td>
			</tr>
			<tr>
				<td width="80">学分:</td>
				<td><input type="text" name="kc.xf"
					value="<s:property value = "#kc.xf"/>" /></td>
			</tr>
		</table>
		<input type="submit" value="修改" />
		<!-- 返回上一界面 -->
		<input type="button" value="返回" onClick="javascript:history.back();" />
	</s:form>
</body>
</html>
