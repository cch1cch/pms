<%@page import="java.util.Date"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.NEW"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="images/skin.css" rel="stylesheet" type="text/css" />







<script type="text/javascript">

	function getTime(){
		var date=new Date();
		var year=date.getFullYear();
		var m=date.getMonth()+1;
		var r=date.getDay();
		var h=date.getHours();
		if (h<10) {
			h="0"+h;
		}
		var mm=date.getMinutes();
		if (mm<10) {
			mm="0"+mm;
		}
		var s=date.getSeconds();
		if (s<10) {
			s="0"+s;
		}
		document.getElementById("a").innerHTML=year+"年"+m+"月"+r+"日&nbsp"+h+":"+mm+":"+s;
	}

	//经过指定的毫秒数重复执行
	window.setInterval(getTime, 1000)

</script>









</head>
<body leftmargin="0" topmargin="0">
<table width="100%" height="64" border="0" cellpadding="0" cellspacing="0" class="admin_topbg">
  <tr>
    <td width="61%" height="64"><img src="images/logo.gif" width="262" height="64"></td>
    <td width="39%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="74%" height="38" class="admin_txt"><b>${userbean.realname }</b> &nbsp;&nbsp;&nbsp;&nbsp;你好，今天是<span id="a"></span>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatDate value="<%=new Date()%>" pattern="EEEE" />&nbsp;&nbsp;&nbsp;&nbsp;感谢登录使用！</td>
        <td width="22%"><a href="login.jsp" target="parent"><img src="images/out.gif" alt="安全退出" width="46" height="20" border="0"></a></td>
        <td width="4%">&nbsp;</td>
      </tr>
      <tr>
        <td height="19" colspan="3">&nbsp;</td>
        </tr>
    </table></td>
  </tr>
</table>
</body>
</html>

    