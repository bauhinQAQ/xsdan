<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 

<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		
        <script language="javascript">
           function liuyanDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/liuyan?type=liuyanDel&id="+id;
               }
           }
           
           function liuyanHuifu(id)
           {
               var strUrl = "<%=path %>/admin/liuyan/liuyanHuifu.jsp?id="+id;
               var ret = window.showModalDialog(strUrl,"","dialogWidth:700px; dialogHeight:400px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
               window.location.reload();
           }
        </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="14" background="<%=path %>/img/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">序号</td>
					<td width="20%">信息内容</td>
					<td width="8%">发布时间</td>
					<td width="8%">回复信息</td>
					<td width="8%">回复时间</td>
					<td width="8%">留言人</td>
					<td width="8%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.liuyanList}" var="liuyan" varStatus="sta">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 ${sta.index+1 }
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${liuyan.neirong }
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${liuyan.liuyanshi }
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${liuyan.huifu }
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${liuyan.huifushi }
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${liuyan.xuesheng.xingming }
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" onclick="liuyanDel(${liuyan.id })"/>
						<input type="button" value="回复" onclick="liuyanHuifu(${liuyan.id })"/>
					</td>
				</tr>
			 </c:forEach>
			</table>
	</body>
</html>
