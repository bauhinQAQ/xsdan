<%@ page language="java" pageEncoding="UTF-8"%>
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
		
        <script language="javascript">
           function chengjiDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/chengji?type=chengjiDel&id="+id;
               }
           }
           
           function chengjiAdd()
           {
                 var url="<%=path %>/admin/chengji/chengjiAdd.jsp";
				 window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="33" background="<%=path %>/img/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
				    <td width="4%">序号</td>
				    <td width="10%">学生学号</td>
				    <td width="10%">学生姓名</td>
				    <td width="10%">课程信息</td>
				    
				    <td width="10%">考试分数</td>
					<td width="10%">考试时间</td>
		        </tr>	
				<c:forEach items="${requestScope.chengjiList}" var="chengji" varStatus="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${ss.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${chengji.xuesheng.xuehao}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${chengji.xuesheng.xingming}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${chengji.kecheng.mingcheng}
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						${chengji.fenshu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${chengji.shijian}
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
