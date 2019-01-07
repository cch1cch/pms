<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<link href="../res/lecheng/css/admin.css" rel="stylesheet" type="text/css"/>
<link href="../res/common/css/theme.css" rel="stylesheet" type="text/css"/>
<link href="../res/common/css/jquery.validate.css" rel="stylesheet" type="text/css"/>
<link href="../res/common/css/jquery.treeview.css" rel="stylesheet" type="text/css"/>
<link href="../res/common/css/jquery.ui.css" rel="stylesheet" type="text/css"/>

<!-- <script src="/thirdparty/ckeditor/ckeditor.js" type="text/javascript"></script> -->
<!-- <script src="/thirdparty/My97DatePicker/WdatePicker.js" type="text/javascript"></script> -->
<script type="text/javascript" src="../res/fckeditor/fckeditor.js"></script>
<script src="../res/common/js/jquery.js" type="text/javascript"></script>
<script src="../res/common/js/jquery.ext.js" type="text/javascript"></script>
<script src="../res/common/js/jquery.form.js" type="text/javascript"></script>
<script src="../res/common/js/lecheng.js" type="text/javascript"></script>
<script src="../res/lecheng/js/admin.js" type="text/javascript"></script>

<link rel="stylesheet" href="../res/css/style.css" />






<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>user-list</title>
<script type="text/javascript" src="../js/jquery-1.11.0.min.js" language="javascript"></script>

<script type="text/javascript">

function del(){
	   var msg="您确定删除吗？";
	   if(confirm(msg)==true){
	   return true;
     }else{
	   return false;
 }
}
$(function() {
	$("#btn").click(function() {
		//定义一个数组
		var ids=new Array();
		var msg="您确定删除吗？";
		if (confirm(msg)==true) {
			$("input[type=checkbox]:checked").each(function() {
				//给数组赋值
				ids.push($(this).val());
			});
			if (ids.length==0) {
				alert("至少选择一条数据")
				//重新加载当前页面  无参数默认False 从浏览器加载
				location.reload();
			}else {
				//通过地址传Ids数组
				location.href="userdelect.do?ids="+ids;
			
			}
		}else {
			return false;
		}
	});
});

</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 用户管理 - 列表</div>
		<form class="ropt">
		<input class="add" type="button" value="添加" onclick="javascript:window.location.href='toadd.do'"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<input type="hidden" name="pageNo" value=""/>
<form action="list.do" method="post" style="padding-top: 5px">
		登录名：<input  type="text" name="loginname" value="${query.loginname }"/>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
		<select name="isenabled">
			<!-- 可用 -->
			<c:if test="${query.isenabled==1 }">
				<option value="0">请选择</option>
				<option value="1" selected="selected">可用</option>
				<option value="-1">不可用</option>
			</c:if>
			<!-- 不可用 -->
			<c:if test="${query.isenabled==-1 }">
				<option value="0">请选择</option>
				<option value="1" >可用</option>
				<option value="-1"selected="selected">不可用</option>
			</c:if>
			<!-- 默认 -->
			<c:if test="${query.isenabled==0 }">
				<option value="0"selected="selected">请选择</option>
				<option value="1" >可用</option>
				<option value="-1">不可用</option>
			</c:if>
		</select>
		<input type="submit" class="query" value="查询" />
	</form>



<form method="post" id="tableForm"  action="deletes.do">
<input type="hidden" value="" name="pageNo"/>
<input type="hidden" value="" name="queryName"/>
<table cellspacing="1" cellpadding="0" border="0" width="100%" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" onclick="Pn.checkbox('ids',this.checked)"/></th>
			<th>用户编号</th>
			<th>用户名</th>
			<th>头像</th>
			<th>性别</th>
			<th>部门</th>
			<th>出生年月</th>
			<th>是否可用</th>		
			<th>可操作项</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
		<c:forEach items="${list }" var="user">
		<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
			<td><input type="checkbox" name="ids" value="${user.id }"/></td>
			<td align="center">${user.id }</td>
			<td align="center">${user.loginname }</td>
			<td align="center"><img src="../upload/${user.pic }" width="90px" height="90px" /></td>
			<td align="center">${user.sex }</td>
			<td align="center">${user.dept.dname }</td>
			<td align="center">${user.birthdayTxt }</td>
			<td align="center">${user.enabledTxt }</td>
			<td align="center">
				<a href="toupdate.do?id=${user.id } " class="pn-opt">修改</a>
				<a  href="delete.do?id=${user.id }" onclick="javascript:return del()" class="pn-opt">删除</a>
			</td>		
		</tr>

	</c:forEach>
		
	</tbody>
</table>
	<input 	class="del-button" type="submit" value="删除" />
</form>
	
<div class="page_pb15">	
	<form action="list.do?isenabled=${query.isenabled }&loginname=${query.loginname}">
		<span class="r inb_a page_b">
			<!-- [当前页/尾页] -->
			[当前为第${page }页/共${pagecount }页]
			<a href="list.do?isenabled=${query.isenabled }&loginname=${query.loginname}">首页</a>
				<c:if test="${page-1>0 }">
					<a href="list.do?page=${page-1 }&isenabled=${query.isenabled }&loginname=${query.loginname}">上一页</a>
				</c:if>			
					<input type="text"  name="page" style="width: 40px"/>
					<input  type="submit" value="跳转"/>
			
				<c:if test="${page+1<=pagecount }">
					<a href="list.do?page=${page+1 }&isenabled=${query.isenabled }&loginname=${query.loginname}">下一页</a>
				</c:if>
			<a href="list.do?page=${pagecount }&isenabled=${query.isenabled }&loginname=${query.loginname}">尾页</a>
		</span>
	</form>
</div>
</div>
</body>
</html>