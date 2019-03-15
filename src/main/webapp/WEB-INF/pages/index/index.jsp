<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>首页</title>
  </head>
  
  <body>
    	<p class="title">用户名：<span class="username">${user.username}</span>已登录</p><br>
    	<a href="${basePath}/index/logout" id="login">退出登录</a>
    	
    	<script type="text/javascript" src="${basePath}/resource/js/jquery-1.11.2.min.js"></script>
    	<script type="text/javascript">
    		var basePath = "${basePath}";
    		if(isEmpty($(".username").text())){
    			$(".title").text("未登录");
    			$("#login").attr("href",basePath+"/index/login");
    			$("#login").text("点击登陆");
    		}
    		/**
    		 * 判断非空
    		 * 
    		 * @param val
    		 * @returns {Boolean}
    		 */
    		function isEmpty(val) {
    			val = $.trim(val);
    			if (val == null)
    				return true;
    			if (val == undefined || val == 'undefined')
    				return true;
    			if (val == "")
    				return true;
    			if (val.length == 0)
    				return true;
    			if (!/[^(^\s*)|(\s*$)]/.test(val))
    				return true;
    			return false;
    		}

    	</script>
  </body>
</html>