<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<style type="text/css">
		*{margin:0; padding:0; font-size:12px;background:url(/xs/img/qqc.gif);background-repeat:no-repeat; background-size:100%;}
		img{border:0; cursor:hand;}
		td{height:40px; line-height:20px;background:url(/xs/img/qqc.gif);}
		#header{height:70px; width:100%; margin:0 auto; background:url(/xs/img/qqc.jpg) repeat-x 1px -10px;background-size:100%}
		#login{width:380px; margin:100px auto;}
		.l-t1{background:url(/xs/img/bgpic1.gif) no-repeat -12px -56px; height:10px;font-family: 微软雅黑}
		.l-main{background:url(/xs/img/login-middle.gif) repeat-y -2px; height:200px;font-family: 微软雅黑}
		.l-b1{background:url(/xs/img/main_ls.gif) no-repeat -12px -82px; height:10px;font-family: 微软雅黑}
		.l-ico{background:url(/xs/img/catheat.gif) no-repeat -250px -110px; padding-left:55px; font-size:14px; font-weight:bold;font-family: 微软雅黑}
		.l-text1{font-size:12px; padding-left:50px;font-family: 微软雅黑}
		.l-text1-input{font-family: 微软雅黑;width:172px;border:#0a8fda 1px solid;background-color:#E8F9FF;font-family:Verdana, Arial, Helvetica, sans-serif;font-size:14px;padding:5px 3px; font-weight:bold;}
		.l-text2-input{width:60px;font-size:14px;border:1px solid #84a1bd;padding:3px 3px;font-family: 微软雅黑}
		.l-btn{text-align:center;}
		#footer{height:70px; width:100%; margin:0 auto; background:url(/xsdan/images/bg.png) repeat-x bottom center;font-family: 微软雅黑}
		.copy{padding-top:50px; text-align:center; color:#999;font-family: 微软雅黑}
	</style>
	
	
	<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
        
		<script language="javascript">
		function check1()
		{                                                                                         
		     if(document.ThisForm.userName.value=="")
			 {
			 	alert("请输入用户名");
				document.ThisForm.userName.focus();
				return false;
			 }
			 if(document.ThisForm.userPw.value=="")
			 {
			 	alert("请输入密码");
				document.ThisForm.userPw.focus();
				return false;
			 }
			 
			 document.getElementById("indicator").style.display="block";
			 loginService.login(document.ThisForm.userName.value,document.ThisForm.userPw.value,document.ThisForm.userType.value,callback);
		}
		
		function callback(data)
		{
		    document.getElementById("indicator").style.display="none";
		    if(data=="no")
		    {
		        alert("用户名或密码错误");
		    }
		    if(data=="yes")
		    {
		        alert("通过验证,系统登录成功");
		        window.location.href="<%=path %>/loginSuccess.jsp";
		    }
		    
		}
		
		function zhuce()
	    {
			  var strUrl = "<%=path %>/zhuce.jsp";
	          var ret = window.showModalDialog(strUrl,"","dialogWidth:800px; dialogHeight:500px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
		}
		
	    </script>
  </head>
  
<body>
<div id="header"></div>
<div id="login">
    <div class="l-t1"></div>
    <div class="l-main">
        <form action="" name="ThisForm" method="post" >
            <table width="98%" align="center" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td colspan="3" class="l-ico">学生信息管理系统</td>
                </tr>
                <tr>
                    <td width="34%" class="l-text1">登陆账号：</td>
                    <td colspan="2"><input type="text" name="userName" class="l-text1-input" /></td>
                </tr>
                <tr>
                    <td class="l-text1">登陆密码：</td>
                    <td colspan="2"><input type="password" name="userPw" class="l-text1-input" /></td>
                </tr>
                <tr>
                    <td class="l-text1">登陆类型：</td>
                    <td colspan="2" >
                        <select style="width: 178px;" name="userType">
                            <option value="0">管理员</option>
                            <option value="2">学生</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="l-text1">&nbsp;</td>
                    <td colspan="2">
                       <input type="button" value="登陆" style="width: 80px;height: 30px;" onClick="check1()"/> 
                       <input type="reset" value="重置" style="width: 80px;height: 30px;"/>
                       <img id="indicator" src="<%=path %>/img/loading.gif" style="display:none"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div class="l-b1"></div>
</div>
</body>
</html>
