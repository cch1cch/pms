<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="../res/lecheng/css/admin.css" rel="stylesheet" type="text/css"/>
<link href="../res/common/css/theme.css" rel="stylesheet" type="text/css"/>
<link href="../res/common/css/jquery.validate.css" rel="stylesheet" type="text/css"/>
<link href="../res/common/css/jquery.treeview.css" rel="stylesheet" type="text/css"/>
<link href="../res/common/css/jquery.ui.css" rel="stylesheet" type="text/css"/>

<!-- <script src="/thirdparty/ckeditor/ckeditor.js" type="text/javascript"></script> -->
<!-- <script src="/thirdparty/My97DatePicker/WdatePicker.js" type="text/javascript"></script> -->
<script type="text/javascript" src="res/fckeditor/fckeditor.js"></script>
<script src="../res/common/js/jquery.js" type="text/javascript"></script>
<script src="../res/common/js/jquery.ext.js" type="text/javascript"></script>
<script src="../res/common/js/jquery.form.js" type="text/javascript"></script>
<script src="../res/common/js/lecheng.js" type="text/javascript"></script>
<script src="../res/lecheng/js/admin.js" type="text/javascript"></script>

<link rel="stylesheet" href="res/css/style.css" />
<title>fastreport-add</title>

<!-- 引入	jQuery -->
<script type="text/javascript" language="javascript" src="../js/jquery-1.11.0.min.js"></script>
<!-- 引入日期控件 -->
<script type="text/javascript" language="javascript" src="../js/DatePicker/WdatePicker.js"></script>

<script type="text/javascript">


//作者姓名验证：必须两个字以上
var CHKCMAN="^[\u4e00-\u9fa5]{2,}$";
//标题非空
var CHKTITLE="^[\s\S]*.*[^\s][\s\S]*$";

function chkTitle(){
	//var title=document.getElementById("title").value;
	var reg=RegExp(CHKTITLE);
	//var spanEle=document.getElementById("resulttitle");
	var title=$("#title").val();
	if (reg.test(title)) {
		//spanEle.innerHTML="√";
		//spanEle.style.color="green";
		$("#resulttitle").html("√");
		$("#resulttitle").css("color","green");
		return true;
	}else {
		//spanEle.innerHTML="标题不能为空";
		//spanEle.style.color="red";
		$("#resulttitle").html("标题不能为空");
		$("#resulttitle").css("color","red");
		return false;
	}
}

//验证作者至少2个汉字
function chkCman(){
	//var cman=document.getElementById("cman").value;
	//定义匹作者姓名的正则表达式
	//var reg=/CHKLOGINNAME/;
	var reg=RegExp(CHKCMAN);
	//获取提示文本元素
	//var spanEle=document.getElementById("resultcman")
	var cman=$("#cman").val();
	if (reg.test(cman)) {
		//spanEle.innerHTML="√";
		//spanEle.style.color="green";
		$("#resultcman").html("√");
		$("#resultcman").css("color","green");
		return true;
	}else {
		//spanEle.innerHTML="姓名不少于两个汉子";
		//spanEle.style.color="red";
		$("#resultcman").html("姓名不少于两个汉子");
		$("#resultcman").css("color","red");
		return false;
	}
}

function chkAll(){
	return chkTitle()&&chkCman();
}

</script>


</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 快报管理 - 添加</div>
	<form class="ropt">
		<input type="submit" onclick="this.form.action='../fastreportlist.do';" value="返回列表" class="return-button"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box" style="float:right">
	<form id="jvForm" action="../fastreportadd.do" method="post" onsubmit="return chkAll()">
		<table cellspacing="1" cellpadding="2" width="100%" border="0" class="pn-ftable">
			<tbody>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						标题:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="title" id="title" onblur="chkTitle()" maxlength="100"/>
						<span id="resulttitle"></span>	
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						内容:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="content" maxlength="100"/>
					</td>
				</tr>		
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						创建时间:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="Wdate" onclick="WdatePicker()" name="ctime" maxlength="100"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						公告人:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="cman" id="cman" onblur="chkCman()" maxlength="80"/>
						<span id="resultcman"></span>	
					</td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td class="pn-fbutton" colspan="2">
						<input type="submit" class="submit" value="提交"/> &nbsp; <input type="reset" class="reset" value="重置"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>