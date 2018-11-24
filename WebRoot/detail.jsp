<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'detail.jsp' starting page</title>
    
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
  		<form action="index.jsp" method="post"  >
   		<h1>查看航班信息</h1>
	   		航班编号：<input type="text" value="${fights.fightCode }"><br/>
	   		航班日期：<input type="text" value="${fights.fightDate }"> yyyy-MM-dd<br/>
	   		所属航班公司：<input type="text" value="${fights.airLine }"><br/>
	   		机型：<input type="text" value="${fights.type }"><br/>
	   		起飞机场：
	   			<select >
	   				<c:forEach items="${airports }" var="airports">
	   					<option <c:if test="${fights.tokeoffAirportId==airports.id}">selected</c:if>>${airports.airportName }</option>
	   				</c:forEach>
	   			</select>
	   		<br/>
	   		
	   		降落机场：
				<select>
	   				<c:forEach items="${airports }" var="airports">
	   					<option <c:if test="${fights.landingAirportId==airports.id}">selected</c:if>>${airports.airportName }</option>
	   				</c:forEach>
	   			</select>
			<br/>
			起飞时间：<input type="text" value="${fights.takeoffTime }"><br/>
	   		降落时间：<input type="text" value="${fights.landingTime }"><br/>
	   		飞行时长：<input type="text" value="${fights.fightTime }"><br/>
	   		经停机场：<input type="text" value="${fights.stopAirport }"><br/>
	   		参考报价：<input type="text" value="${fights.referencePrice }"><br/>
	   		飞机座位图片：<input type="file"  value="${fights.seatPic }"><br/>
	   		<input type="submit" value="返回">
   		</form>
  </body>
</html>
