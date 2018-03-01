<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生成绩管理系统</title>
</head>
<body bgcolor="D9DFAA">
	<s:set name="dl" value="#session.dl" />
	学号
	<s:property value="#dl.xsb.xh" />
	登录成功!欢迎使用学生成绩管理系统.
</body>
</html>