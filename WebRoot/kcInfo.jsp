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
	<h3>课程信息列表</h3>
	<table border="1" cellspacing="1" cellpadding="8" width="700">
		<tr align="center" bgcolor="silver">
			<th>课程号</th>
			<th>课程名</th>
			<th>开学学期</th>
			<th>学时</th>
			<th>学分</th>
			<th>详细信息</th>
			<th>操作</th>
			<th>操作</th>
		</tr>
		<s:iterator value="#request.list" id="kc">
			<tr>
				<td><s:property value="#kc.kch" /></td>
				<td><s:property value="#kc.kcm" /></td>
				<td><s:if test="#kc.kxxq == 1">大一第一学期</s:if> <s:elseif
						test="#kc.kxxq == 2">大一第二学期</s:elseif> <s:elseif
						test="#kc.kxxq == 3">大二第一学期</s:elseif> <s:elseif
						test="#kc.kxxq == 4">大二第二学期</s:elseif> <s:elseif
						test="#kc.kxxq == 5">大三第一学期</s:elseif> <s:elseif
						test="#kc.kxxq == 6">大三第二学期</s:elseif> <s:elseif
						test="#kc.kxxq == 7">大四第一学期</s:elseif> <s:elseif
						test="#kc.kxxq == 8">大四第二学期</s:elseif></td>
				<td><s:property value="#kc.xs" /></td>
				<td><s:property value="#kc.xf" /></td>
				<td><a
					href="findKc.action?kc.kch=<s:property value = "#kc.kch"/>">详细信息</a>
				</td>
				<td><a
					href="deleteKc.action?kc.kch=<s:property value = "#kc.kch"/>"
					onClick="if(!confirm('确定删除该课程信息吗？'))return false;else return true;">删除</a>
				</td>
				<td><a
					href="updateKcView.action?kc.kch=<s:property value = "#kc.kch"/>">修改</a>
				</td>
			</tr>
		</s:iterator>
		<tr>
			<s:set name="page" value="#request.page"></s:set>
			<s:if test="#page.hasFirst">
				<s:a href="kcInfo.action?pageNow=1">首页</s:a>
			</s:if>
			<s:if test="#page.hasPre">
				<a
					href="kcInfo.action?pageNow=<s:property value = "#page.pageNow - 1"/>">上一页</a>
			</s:if>
			<s:if test="#page.hasNext">
				<a
					href="kcInfo.action?pageNow=<s:property value = "#page.pageNow + 1"/>">下一页</a>
			</s:if>
			<s:if test="#page.hasLast">
				<a
					href="kcInfo.action?pageNow=<s:property value = "#page.totalPage"/>">尾页</a>
			</s:if>
		</tr>
	</table>
</body>
</html>