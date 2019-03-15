<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../common/common.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>登录界面</title>
  </head>
  <body>
  	<form action="${basePath}/index/logined" method="post">
  		用户名：<input type="text" name="username"/><br>
  		密&nbsp;码：<input type="password" name="password"/>
  		<input type="submit"><br><br>
  		<a href="${basePath}/index/rege">点我注册</a>
  	</form>
  </body>
</html>
