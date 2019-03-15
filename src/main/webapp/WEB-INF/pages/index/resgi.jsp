<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../common/common.jsp" %>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册界面</title>

  </head>
  
  <body>
    <form action="${basePath}/index/resig" method="post">
  		用户名：<input type="text" name="username"/><br>
  		密&nbsp;码：<input type="password" name="password"/><br>
  		<input type="submit">
  	</form>
  </body>
</html>
