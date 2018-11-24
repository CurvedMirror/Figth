<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
   		<h1>航班查询</h1>
   		<form action="FightServlet?opr=list" method="post">
   			日期：<input type="text" name="fightDate" value="${fightDate }"> 
   			城市:从<input type="text" name="tokeoffAirportName" value="${tokeoffAirportId }">
   			 到<input type="text" name="landingAirportName" value="${landingAirportId }">
   			 <input type="submit" value="搜索">
   		</form>
   		
   		<table border="1">
   			<tr>
   				<td>航空公司/航班机型</td><td>起降时间</td><td>机场</td><td>飞行时长</td><td>经停</td><td>参考报价</td>
   			</tr>
   			<c:if test="${page.list==null }">
   				<c:redirect url="FightServlet?opr=list"></c:redirect>
   			</c:if>
   			
   			<c:if test="${page.list!=null }">
   				
   				<c:forEach items="${page.list }" var="list">
   					<tr>
	   					<td>${list.airLine}<br/>(${list.type })</td>
	   					<td>${list.takeoffTime }<br/>${list.landingTime }</td>
	   					<td>${list.landingAirportName }<br/>${list.tokeoffAirportName }</td>
	   					<td>${list.fightTime }</td>
	   					<td>${list.stopAirport }</td>
	   					<td>${list.referencePrice }<br/><input type="button" value="查询航班" onclick="toDetail(${list.id})"></td>
   					</tr>
   				</c:forEach>
   			</c:if>
   		</table>
   		
   		<c:if test="${fn:length(page.list)==0 }">
   				<h2>没有找到任何航班信息</h2>
   		</c:if>
   		
   		<a href="add.jsp">新增航班信息</a>
   		
   		<select id="toPage" onchange="toPage();">
	   		<c:forEach begin="1" end="${page.totalPageCount}" var="i">
	   				<option <c:if test="${page.currentPage==i}">selected</c:if>>${i}</option>
	   		</c:forEach>
   		</select>
   		
   		<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
   		<script type="text/javascript">
   			function toPage() {
   				var fightDate = $("[name=fightDate]").val();
   				var tokeoffAirportName = $("[name=tokeoffAirportName]").val();
   				var landingAirportName = $("[name=landingAirportName]").val();
   				var date = "&fightDate="+fightDate+"&tokeoffAirportName="+tokeoffAirportName+"&landingAirportName="+landingAirportName;
				var currentPage = $("#toPage").val();
				location.href='FightServlet?opr=list&currentPage='+currentPage+date;
		    }
			function toDetail(id){
					location.href='FightServlet?opr=detail&id='+id;
			}
   		</script>
  </body>
</html>
