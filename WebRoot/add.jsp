<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   		<form action="FightServlet?opr=add" method="post" enctype="multipart/form-data" >
   		<h1>查看航班信息</h1>
	   		航班编号：<input type="text" name="fightCode"><br/>
	   		航班日期：<input type="text" name="fightDate" > yyyy-MM-dd<br/>
	   		所属航班公司：<input type="text" name="airLine" ><br/>
	   		机型：<input type="text" name="type"><br/>
	   		起飞机场：
	   			<select name="tokeoffAirportId">
	   				<c:forEach items="${airports}" var="airports1">
	   					<option value="${airports1.id }">${airports1.airportName}</option>
	   				</c:forEach>
	   			</select>
	   		<br/>
	   		
	   		降落机场：
				<select name="landingAirportId" >
	   				<c:forEach items="${airports}" var="airports1">
	   					<option value="${airports1.id }">${airports1.airportName}</option>
	   				</c:forEach>
	   			</select>
			<br/>
			
	   		起飞时间：<input type="text" name=takeoffTime><br/>
	   		降落时间：<input type="text" name="landingTime"><br/>
	   		飞行时长：<input type="text" name="fightTime"><br/>
	   		经停机场：<input type="text" name="stopAirport"><br/>
	   		参考报价：<input type="text" name="referencePrice"><br/>
	   		飞机座位图片：<input type="file" name="seatPic"><br/>
	   		<input type="submit" value="发布">
	   		<input type="reset" value="重置">
   		</form>
  </body>
</html>
