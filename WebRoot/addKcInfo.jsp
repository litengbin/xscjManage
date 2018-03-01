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
	<h3>请填写课程信息</h3>
	<hr width="700" align="left">
	<s:form action="addKc" method="post" enctype="multipart/form-data">
		<table border="0" cellspacing="0" cellpadding="1">
			<tr>
				<td><s:textfield name="kc.kch" label="课程号" value=""></s:textfield>
				</td>
			</tr>
			<tr>
				<td><s:textfield name="kc.kcm" label="课程名" value=""></s:textfield>
				</td>
			</tr>
			<tr>
				<td><s:select name="kc.kxxq" list="#{1:'大一第一学期',2:'大一第二学期',3:'大二第一学期',4:'大二第二学期',5:'大三第一学期',6:'大三第二学期',7:'大四第一学期',8:'大四第二学期'}" 
						 headerKey="1" headerValue="--请选择开学学期--" label="开学学期"></s:select>
				</td>
			</tr>
			<tr>
				<s:textfield name="kc.xs" label="学时" value=""></s:textfield>
			</tr>
			<tr>
				<td><s:textfield name="kc.xf" label="学分" value=""></s:textfield>
				</td>
			</tr>
		</table>
		<p>
			<input type="submit" value="添加"> <input type="reset"
				value="重置">
		</p>
	</s:form>
</body>
</html>