<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
		*{ font-family:Microsoft Yahei; font-size: 14px;} 
		#menuTree A {
			COLOR: #566984; TEXT-DECORATION: none;font-family:Microsoft Yahei;
		}
		</STYLE>

		<SCRIPT src="<%=path%>/js/TreeNode.js" type=text/javascript></SCRIPT>
		<SCRIPT src="<%=path%>/js/Tree.js" type=text/javascript></SCRIPT>
	</head>

	<BODY topmargin="7" rightmargin="0" leftmargin="0">
		<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%">
				<TR>
					<TD width=10 height=29>
						<IMG src="<%=path %>/img/bg_left_tl.gif">
					</TD>
					<TD
						style="FONT-SIZE: 18px; BACKGROUND-IMAGE: url(<%=path %>/img/bg_left_tc.gif); COLOR: white; FONT-FAMILY: system">
						Main Menu
					</TD>
					<TD width=10>
						<IMG src="<%=path %>/img/bg_left_tr.gif">
					</TD>
				</TR>
				<TR>
					<TD style="BACKGROUND-IMAGE: url(<%=path %>/img/bg_left_ls.gif)"></TD>
					<TD id=menuTree style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; PADDING-TOP: 10px; HEIGHT: 100%; BACKGROUND-COLOR: white" vAlign=top></TD>
					<TD style="BACKGROUND-IMAGE: url(<%=path %>/img/bg_left_rs.gif)"></TD>
				</TR>
		</TABLE>
		<SCRIPT type=text/javascript>
                var tree = null;
	            var root = new TreeNode('系统菜单');
	           
	            
	            <c:if test="${sessionScope.userType==0}">
	            var fun2 = new TreeNode('修改登陆密码');
	            var fun21 = new TreeNode('修改登陆密码', '<%=path %>/admin/userinfo/userPw.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
	            fun2.add(fun21);
	            root.add(fun2);
	            
	            
	            var fun3 = new TreeNode('课程信息管理');
	            var fun31 = new TreeNode('课程信息管理', '<%=path %>/kecheng?type=kechengMana', 'tree_node.gif', null, 'tree_node.gif', null);
	            var fun32 = new TreeNode('添加课程信息', '<%=path %>/admin/kecheng/kechengAdd.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
	            fun3.add(fun31);
	            fun3.add(fun32);
	            root.add(fun3);
	            
	            
	           
	            
	            var fun5 = new TreeNode('学生信息管理');
	            var fun51 = new TreeNode('学生信息管理', '<%=path %>/xuesheng?type=xueshengMana', 'tree_node.gif', null, 'tree_node.gif', null);
	            var fun52 = new TreeNode('添加学生信息', '<%=path %>/admin/xuesheng/xueshengAdd.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
	            fun5.add(fun51);
	            fun5.add(fun52);
	            root.add(fun5);
	            
	            
	            
	            var fun6 = new TreeNode('奖惩信息管理');
	            var fun61 = new TreeNode('奖惩信息管理', '<%=path %>/jiangcheng?type=jiangchengMana', 'tree_node.gif', null, 'tree_node.gif', null);
	            var fun62 = new TreeNode('添加奖惩信息', '<%=path %>/admin/jiangcheng/jiangchengAdd.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
	            fun6.add(fun61);
	            fun6.add(fun62);
	            root.add(fun6);
	            
	            
	            var fun7 = new TreeNode('成绩信息管理');
	            var fun71 = new TreeNode('成绩信息管理', '<%=path %>/chengji?type=chengjiMana', 'tree_node.gif', null, 'tree_node.gif', null);
	            var fun72 = new TreeNode('添加成绩信息', '<%=path %>/admin/chengji/chengjiAdd.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
	            fun7.add(fun71);
	            fun7.add(fun72);
	            root.add(fun7);
	            
	            
	            
	            
	            var fun8 = new TreeNode('留言信息管理');
	            var fun81 = new TreeNode('留言信息管理', '<%=path %>/liuyan?type=liuyanMana', 'tree_node.gif', null, 'tree_node.gif', null);
	            fun8.add(fun81);
	            root.add(fun8);
	            
	            
	            
	            
	            </c:if>
	            
	            
	            
	            
	            <c:if test="${sessionScope.userType==2}">
	            
	            
	            var fun3 = new TreeNode('修改我的信息');
	            var fun31 = new TreeNode('修改我的信息', '<%=path %>/admin/userinfo/xueshenginfo.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
	            fun3.add(fun31);
	            root.add(fun3);   
	            
	            
	            var fun4 = new TreeNode('我的奖惩信息');
	            var fun41 = new TreeNode('我的奖惩信息', '<%=path %>/jiangcheng?type=jiangchengMine', 'tree_node.gif', null, 'tree_node.gif', null);
	            fun4.add(fun41);
	            root.add(fun4);   
	            
	            
	            
	            var fun5 = new TreeNode('我的成绩信息');
	            var fun51 = new TreeNode('我的成绩信息', '<%=path %>/chengji?type=chengjiMine', 'tree_node.gif', null, 'tree_node.gif', null);
	            fun5.add(fun51);
	            root.add(fun5);   
	            
	            
	            var fun8 = new TreeNode('留言信息模块');
	            var fun81 = new TreeNode('留言信息模块', '<%=path %>/liuyan?type=liuyanAll', 'tree_node.gif', null, 'tree_node.gif', null);
	            fun8.add(fun81);
	            root.add(fun8);
	            
	            
	            </c:if>
	            
	            tree = new Tree(root);
	            tree.show('menuTree')
        </SCRIPT>
	</BODY>
</html>
