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
		<h3>请填写学生信息</h3>
	<hr width="700" align="left">
	<s:form action="addXs" method="post" enctype="multipart/form-data">
		<table border="0" cellspacing="0" cellpadding="1">
			<tr>
				<td><s:textfield name="xs.xh" label="学号" value=""></s:textfield>
				</td>
			</tr>
			<tr>
				<td><s:textfield name="xs.xm" label="姓名" value=""></s:textfield>
				</td>
			</tr>
			<tr>
				<td><s:radio name="xs.xb" value="1" list="#{1:'男',0:'女'}"
						label="性别" /></td>
			</tr>
			<tr>
				<s:select name="xs.zyb.id" list="list" listKey="id" listValue="zym"
					headerKey="0" headerValue="--请选择专业--" label="专业"></s:select>
			</tr>
			<tr>
				<s:textfield name="xs.cssj" label="出生时间" value=""></s:textfield>
			</tr>
			<tr>
				<td><s:textfield name="xs.zxf" label="总学分" value=""></s:textfield>
				</td>
			</tr>
			<tr>
				<td><s:textfield name="xs.bz" label="备注" value=""></s:textfield>
				</td>
			</tr>
			<tr>
				<td><s:file name="zpFile" label="照片" value=""></s:file></td>
			</tr>
		</table>
		<p>
			<input type="submit" value="添加"> <input type="reset"
				value="重置">
		</p>
	</s:form>
</body>
</html>