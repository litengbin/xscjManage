<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生成绩管理系统</title>
</head>
<body bgcolor="#D9DFAA">
	<h3>学生成绩列表</h3>
	<table border="1" cellspacing="1" cellpadding="8" width="700">
		<tr bgcolor="silver">
			<th>学号</th>
			<th>姓名</th>
			<th>课程名</th>
			<th>成绩</th>
			<th>学分</th>
			<th>删除</th>
		</tr>
		<s:iterator value="#request.list" id="xscj">
			<tr>
				<td><a
					href="findXscj.action?cj.id.xsb.xh=<s:property value = "#xscj[0]"/>">
						<s:property value="#xscj[0]" />
				</a></td>
				<td><s:property value="#xscj[1]" /></td>
				<td><s:property value="#xscj[2]" /></td>
				<td><s:property value="#xscj[3]" /></td>
				<td><s:property value="#xscj[4]" /></td>
				<td><a
					href="deleteOneXscj.action?cj.id.xsb.xh=<s:property value = "#xscj[0]"/>&cj.id.kcb.kch=<s:property value = "#xscj[5]"/>"
					onClick="if(!confirm('确定删除该信息吗？'))return false;else return true;">删除</a>
				</td>
			</tr>
		</s:iterator>
		<tr align="left">
			<s:set name="page" value="#request.page"></s:set>
			<s:if test="#page.hasFirst">
				<s:a href="xscjInfo.action?pageNow=1">首页</s:a>
			</s:if>
			<s:if test="#page.hasPre">
				<a
					href="xscjInfo.action?pageNow=<s:property value = "#page.pageNow-1"/>">上一页</a>
			</s:if>
			<s:if test="#page.hasNext">
				<a
					href="xscjInfo.action?pageNow=<s:property value = "#page.pageNow+1"/>">下一页</a>
			</s:if>
			<s:if test="#page.hasLast">
				<a
					href="xscjInfo.action?pageNow=<s:property value = "#page.totalPage"/>">尾页</a>
			</s:if>
		</tr>
	</table>
</body>
</html>