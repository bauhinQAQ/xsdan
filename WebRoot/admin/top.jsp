<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>

<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<STYLE type=text/css> 
	*{
		FONT-SIZE: 12px; COLOR: white
	}
	*{ font-family:Microsoft Yahei; } /* 所有字体统统的事微软雅黑 */ 
	#logo {
		COLOR: white
	}
	#logo A {
		COLOR: white
	}
	FORM {
		MARGIN: 0px
	}
	</STYLE>
	<SCRIPT src="<%=path %>/js/Clock.js" type=text/javascript></SCRIPT>
    <script type="text/javascript">
       function out()
       {
           window.parent.location.href="<%=path %>/login.jsp";
       }
    </script>
  </head>
  
  <BODY leftmargin="0" topmargin="0">
                  <!-- 改这个 -->
        <DIV style="BACKGROUND-IMAGE: url(<%=path %>/img/ltby.jpg); HEIGHT: 142px">
	       <TABLE cellSpacing=0 cellPadding=0 width="100%">
	          <TR>
	            <TD align=left width="40%">
	               	<div style="font-size: 30px;color: white;font-weight: bolder;margin-top: 50px;margin-left: 60px;">
	               	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学生成长信息管理系统
	               	</div>
	            </TD>
	            <TD align=right width="40%">
		             <div style="margin-top: 50px;margin-right: 10px;">
		                 <font style="font-size: 15px;">
		                 <c:if test="${sessionScope.userType==0}">
						      欢迎您：管理员
						 </c:if>
						 <c:if test="${sessionScope.userType==2}">
						      欢迎您：${sessionScope.xuesheng.xingming }
						 </c:if>
						 </font>
			             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			             <SPAN id=clock style="font-size: 15px;"></SPAN>
			             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			             <a href="#" onclick="out()" style="text-decoration: none" style="font-size: 15px;">退出系统</A> 
			         </div>
	            </TD>
	            <TD align=right width="20%">
		             &nbsp;
	            </TD>
	          </TR>
	       </TABLE>
        <DIV>
	    <SCRIPT type=text/javascript>
	       var clock = new Clock();clock.display(document.getElementById("clock"));
	    </SCRIPT>
</BODY>
</html>
