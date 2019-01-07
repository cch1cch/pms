<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="../res/lecheng/css/admin.css" rel="stylesheet" type="text/css" />
<link href="../res/common/css/theme.css" rel="stylesheet" type="text/css" />
<link href="../res/common/css/jquery.validate.css" rel="stylesheet"
	type="text/css" />
<link href="../res/common/css/jquery.treeview.css" rel="stylesheet"
	type="text/css" />
<link href="../res/common/css/jquery.ui.css" rel="stylesheet"
	type="text/css" />

<!-- <script src="/thirdparty/ckeditor/ckeditor.js" type="text/javascript"></script> -->
<!-- <script src="/thirdparty/My97DatePicker/WdatePicker.js" type="text/javascript"></script> -->
<script type="text/javascript" src="res/fckeditor/fckeditor.js"></script>
<script src="../res/common/js/jquery.js" type="text/javascript"></script>
<script src="../res/common/js/jquery.ext.js" type="text/javascript"></script>
<script src="../res/common/js/jquery.form.js" type="text/javascript"></script>
<script src="../res/common/js/lecheng.js" type="text/javascript"></script>
<script src="../res/lecheng/js/admin.js" type="text/javascript"></script>

<link rel="stylesheet" href="res/css/style.css" />
<title>user-add</title>
<!-- 引入	jQuery -->
<script type="text/javascript" language="javascript"
	src="js/jquery-1.11.0.min.js"></script>
<!-- 引入日期控件 -->
<script type="text/javascript" language="javascript"
	src="../js/DatePicker/WdatePicker.js"></script>
<!-- 添加表单验证 -->
<script type="text/javascript">

	//用户名验证：用户名必须包含数字和字母，且必须是6-16位之间，且结束前不能全是数字
	var CHKLOGINNAME="^(?![0-9]+$)[a-zA-Z0-9]{6,16}$";
	//密码验证：必须包含数字和字母，且必须是6-16位之间，且结束前不能全是数字也不能全是字母
	var CHKPASSWORD="^(?![0-9]+$)(?![a-zA-Z]+$)[a-zA-Z0-9]{6,16}$";
	//真实姓名验证：必须两个字以上
	var CHKREALNAME="^[\u4e00-\u9fa5]{2,}$";
	//日期验证：   yyyy-MM-dd
	var CHKDATE="^[0-9]{4}-(0?[1-9]|1[0-2])-(0?[1-9]|[1-2][0-9]|3[0-1]$)";
	//邮箱验证：xxxxx@xxx.com,可以包含_下划线，          企业邮箱：   qweqweq@huawei.com.cn
	var CHKEMAIL="^[a-zA-Z0-9_]+@[a-z0-9]{2,5}(\\.[a-z]{2,3}){1,2}$";
	
	//验证用户名
	function chkloginname(){
		//获取用户名
		var loginname=$("#loginname").val();
		//定义匹配用户名的正则表达式
		//var reg=/CHKLOGINNAME/;
		var reg=new RegExp(CHKLOGINNAME);
		if(reg.test(loginname)){//表示匹配成功		
			if (chkExistLoginname(loginname)==true) {
				return true;
			}else {
				return false;
			}		
		}else{
			$("#resultName").html("用户名必须包含数字与字母，且在6-16位之间");
			$("#resultName").css("color","red");
			return false;
		}
	}
	
	
	
	//验证密码
	function chkpassword(){
		//获取密码
		//var password=document.getElementById("password").value;
		//定义匹配密码的正则表达式
		//var reg=/CHKLOGINNAME/;
		var reg=new RegExp(CHKPASSWORD);
		//获取密码是否输入成功的元素对象
		//var spanEle=document.getElementById("resultPassword");
		
		var password=$("#password").val();
		
		if(reg.test(password)){
			//表示匹配成功
			//spanEle.innerHTML="√";
			//spanEle.style.color="green";
			$("#resultPassword").html("√");
			$("#resultPassword").css("color","green");
			return true;
		}else{
			//spanEle.innerHTML="密码必须包含数字和字母，且必须是6-16位之间，且结束前不能全是数字也不能全是字母";
			//spanEle.style.color="red";
			$("#resultPassword").html("密码必须包含数字和字母，且必须是6-16位之间，且结束前不能全是数字也不能全是字母");
			$("#resultPassword").css("color","red");
			return false;
		}
	}	
	//验证真实姓名	
	function chkrealname(){
		//获取真实姓名
		var realname=document.getElementById("realname").value;
		//定义匹配真实姓名的正则表达式
		//var reg=/CHKLOGINNAME/;
		var reg=new RegExp(CHKREALNAME);
		//获取真实姓名是否输入成功的元素对象
		var spanEle=document.getElementById("resultRealname");
		if(reg.test(realname)){//表示匹配成功
			spanEle.innerHTML="√";
			spanEle.style.color="green";
			return true;
		}else{
			spanEle.innerHTML="真实姓名必须在两个字以上";
			spanEle.style.color="red";
	
			return false;
		}
	}
	
	//验证邮箱
	function chkemail(){
		//获取真实姓名
		//var email=document.getElementById("email").value;
		//定义匹配真实姓名的正则表达式
		//var reg=/CHKLOGINNAME/;
		var reg=new RegExp(CHKEMAIL);
		//获取真实姓名是否输入成功的元素对象
		//var spanEle=document.getElementById("resultEmail");
		var email=$("#email").val();
		if(reg.test(email)){//表示匹配成功
			//spanEle.innerHTML="√";
			//spanEle.style.color="green";	
			if (chkExistEmail(email)==true) {
				return true;
			}else {
				return false;
			}		
		}else{
			//spanEle.innerHTML="邮箱格式应为：字母+数字,可以包含_下划线,.cn";
			//spanEle.style.color="red";
			$("#resultEmail").html("邮箱格式应为：字母+数字,可以包含_下划线,.cn");
			$("#resultEmail").css("color","red");
			return false;
		}	
	}
	
	//验证用户名重复
	function chkExistLoginname(loginname){
		var flags=false;
		$.ajax({
			url:'chkExit.do',
			type:'post',
			data:'type=1&loginname='+loginname,		
			dataType:'text',
			async:false,
			success:function(flag){
				if (flag=='true') {
					$("#resultName").html("√");
					$("#resultName").css("color","green");
					flags=true;
				}else {
					$("#resultName").html("此用户名已存在");
					$("#resultName").css("color","red");
					flags=false;
				}
				
			},
			error:function(){
				alert("请求失败");
			}
		});
		return flags;
	}
	
	
	//验证邮箱重复
	function chkExistEmail(email){
		var flags=false;
		$.ajax({
			url:'chkExit.do',
			type:'post',
			data:'type=2&email='+email,
			dataType:'text',
			async:false,
			success:function(flag){
				if (flag=='true') {
					$("#resultEmail").html("√");
					$("#resultEmail").css("color","green");
					flags=true;
				}else {
					$("#resultEmail").html("此用邮箱已存在");
					$("#resultEmail").css("color","red");
					flags=false;
				}
				
			},
			error:function(){
				alert("请求失败");
			}
		});
		return flags;
	}
	
	//验证密码是否一致
	function chkRePwd(){
		//获取两次输入的密码
		//var pwd=document.getElementById("password").value;
		//var repwd=document.getElementById("repwd").value;
		//获取提示文本元素
		//var spanEle=document.getElementById("resultRePwd");
		var pwd=$("#password").val();
		var repwd=$("#repwd").val();
		if (pwd==repwd) {
			//spanEle.innerHTML="√";
			//spanEle.style.color="green";
			$("#resultRePwd").html("√");
			$("#resultRePwd").css("color","green");
			return ture;
		}else {
			//spanEle.innerHTML="两次密码不一致,请重新输入";
			//spanEle.style.color="red";
			$("#resultRePwd").html("两次密码不一致,请重新输入");
			$("#resultRePwd").css("color","red");
			return false;
		}
	}

	function chkAll(){
		return chkloginname()&&chkpassword()&&chkRePwd()&&chkemail()&&chkrealname();
	}
	
	
	function upload(){
		/*
			ajax 提交
		*/
		var args={
				url:"../commupload.do",
				datetype:"string",
				type:"post",
				success:function(result){
					//设置图片属性
					$("#img1").attr("src","../upload/"+result);
					$("#pic").val(result);
				}
		};
		//ajax提交
		$("#jvForm").ajaxSubmit(args);
	}
	//就绪事件
$(function(){
			$.post(
				//url
				"getdept.do",
				//参数
				{pid:1},
				//回调方法
				function(result){
					//循环数组
					$(result).each(
					function(){
						$("#dept2").append("<option value='"+this.id+"'>"+this.dname+"</option>")
						}		
					)
				},
				//返回值类型
				"json"
			);
				
			
		
		
		
		$("#dept1").change(
			//匿名方法
			function(){
				//清空第二下拉框			
				$("#dept2").empty();
				$.post(
					//url
					"getdept.do",
					//参数
					{pid:this.value},
					//回调方法
					function(result){
						//循环数组
					
						$(result).each(
							function(){
							
								$("#dept2").append("<option value='"+this.id+"'>"+this.dname+"</option>")
							}		
						)
					},
					//返回值类型
					"json"
				);
			}
		
		);
		
	});
	
</script>









</head>
<body>
	<div class="box-positon">
		<div class="rpos">当前位置: 用户管理 - 添加</div>
		<form class="ropt">
			<input type="submit" onclick="this.form.action='list.do';"
				value="返回列表" class="return-button" />
		</form>
		<div class="clear"></div>
	</div>
	<div class="body-box" style="float: right">
		<form id="jvForm" action="add.do" method="post" enctype="multipart/from-data"
			>
			<!--onsubmit="return chkAll()"  -->
			<table cellspacing="1" cellpadding="2" width="100%" border="0"
				class="pn-ftable">
				<tbody>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired"></span> <span class="pn-frequired">${msg}</span>
						</td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired">*</span> 用户名:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							class="required" name="loginname" id="loginname" maxlength="100"
							onblur="" /> <span id="resultName"></span></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired">*</span> 密码:</td>
						<td width="80%" class="pn-fcontent"><input type="password"
							class="required" name="password" id="password" maxlength="100"
							onblur="" /> <span id="resultPassword"></span></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired">*</span> 确认密码:</td>
						<td width="80%" class="pn-fcontent"><input type="password"
							class="required" name="rpwd" maxlength="100" id="repwd"
							onblur="" /> <span id="resultRePwd"></span></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired">*</span> 真实姓名:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							class="required" name="realname" id="realname"
							onblur="" maxlength="100" /> <span
							id="resultRealname"></span></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">性别:</td>
						<td width="80%" class="pn-fcontent"><input type="radio"
							name="sex" value="男" checked="checked" />男 <input type="radio"
							name="sex" value="女" />女</td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">出生日期:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							class="Wdate" onclick="WdatePicker()" name="birthday"
							id="birthday" maxlength="80" /></td>
					</tr>
		
				 	<tr >
						<td width="20%" class="pn-flabel pn-flabel-h">邮箱:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							class="required" name="email" id="email" onblur=""
							maxlength="80" /> <span id="resultEmail"></span></td>
					</tr> 
					
					<tr >
						<td width="20%" class="pn-flabel pn-flabel-h">
							部门:
						</td>
						<td width="80%" class="pn-fcontent">
							<select id="dept1" name="dept1">
									<c:forEach items="${dlist }" var="dept1">
										<option value="${dept1.id }">${dept1.dname }</option>
									</c:forEach>
							</select>
							<select	id="dept2" name="dept.id">
								
							</select>
							 <span id="resultEmail"></span>
						</td>
					</tr> 
					
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">头像:</td>
						<td width="80%" class="pn-fcontent">
						<input type="file"class="required" name="file" onchange="upload()"  /> 
							<img id="img1" width="80px" height="80px"/>
							<input type="hidden" id="pic" name="pic" />
						</td>
					</tr>
				</tbody>
				<tbody>
					<tr>
						<td class="pn-fbutton" colspan="2"><input type="submit"
							class="submit" value="提交" /> &nbsp; <input type="reset"
							class="reset" value="重置" /></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>