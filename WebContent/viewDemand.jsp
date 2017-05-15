<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import = "java.text.*, java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>显示当前时间</title>
</head>
<body>
	<p>现在服务器时间是</p>
	<% 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		out.println(format.format(new Date()));
	%>
	
	<table border=1>
		<tr>
			<td>序号</td>
			<td>变更编号</td>
			<td>系统名称</td>
			<td>变更类型</td>
			<td>负责人</td>
			<td>组别</td>
			<td>月份</td>
			<td>提出日期</td>
			<td>提出人</td>
			<td>变更提出部门</td>
			<td>变更涉及部门</td>
			<td>变更描述</td>
			<td>变更状态</td>
			<td>计划完成日期</td>
			<td>实际完成日期</td>
			<td>发布日期</td>
			<td>归档日期</td>
			<td>备注</td>
		</tr>
		<%
			Context cxt = new InitialContext();
			DataSource ds = (DataSource)cxt.lookup("java:/comp/env/jdbc/webdemo");
		
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from demand_info");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
		%>
			<tr>
				<td><%= rs.getString("sid")%></td>
				<td><%= rs.getString("dem_num")%></td>
				<td><%= rs.getString("sys_name")%></td>
				<td><%= rs.getString("dem_type")%></td>
				<td><%= rs.getString("dem_manager")%></td>
				<td><%= rs.getString("group_name")%></td>
				<td><%= rs.getString("dem_month")%></td>
				<td><%= rs.getString("pf_dt")%></td>
				<td><%= rs.getString("pf_person")%></td>
				<td><%= rs.getString("pf_dept")%></td>
				<td><%= rs.getString("pf_involve_dept")%></td>
				<td><%= rs.getString("dem_description")%></td>
				<td><%= rs.getString("dem_state")%></td>
				<td><%= rs.getString("dem_plan_dt")%></td>
				<td><%= rs.getString("dem_update_dt")%></td>
				<td><%= rs.getString("update_num")%></td>
				<td><%= rs.getString("file_dt")%></td>
				<td><%= rs.getString("postscript")%></td>
			</tr>
		<% 
			}
		%>
	</table>
	
</body>
</html>