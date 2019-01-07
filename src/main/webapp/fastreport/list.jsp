<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<link href="res/lecheng/css/admin.css" rel="stylesheet" type="text/css"/>
<link href="res/common/css/theme.css" rel="stylesheet" type="text/css"/>
<link href="res/common/css/jquery.validate.css" rel="stylesheet" type="text/css"/>
<link href="res/common/css/jquery.treeview.css" rel="stylesheet" type="text/css"/>
<link href="res/common/css/jquery.ui.css" rel="stylesheet" type="text/css"/>

<!-- <script src="/thirdparty/ckeditor/ckeditor.js" type="text/javascript"></script> -->
<!-- <script src="/thirdparty/My97DatePicker/WdatePicker.js" type="text/javascript"></script> -->
<script type="text/javascript" src="../res/fckeditor/fckeditor.js"></script>
<script src="res/common/js/jquery.js" type="text/javascript"></script>
<script src="res/common/js/jquery.ext.js" type="text/javascript"></script>
<script src="res/common/js/jquery.form.js" type="text/javascript"></script>
<script src="res/common/js/lecheng.js" type="text/javascript"></script>
<script src="res/lecheng/js/admin.js" type="text/javascript"></script>

<link rel="stylesheet" href="../res/css/style.css" />






<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>fastreport-list</title>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 快报管理 - 列表</div>
		<form class="ropt">
		<input class="add" type="button" value="添加" onclick="javascript:window.location.href='fastreport/add.jsp'"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<input type="hidden" name="pageNo" value=""/>
<form method="post" id="tableForm" action="fastreportlist.do">
<input type="hidden" value="" name="pageNo"/>
<input type="hidden" value="" name="queryName"/>
<table cellspacing="1" cellpadding="0" border="0" width="100%" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" onclick="Pn.checkbox('ids',this.checked)"/></th>
			<th>标题</th>
			<th>内容</th>
			<th>公告时间</th>
			<th>公告人</th>	
			<th>可操作项</th>	
		</tr>
	</thead>
	<tbody class="pn-ltbody">
		<c:forEach items="${lists }" var="fr">
		<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
			<td><input type="checkbox" name="ids" value="${fr.id }"/></td>
			<td align="center">${fr.title }</td>
			<td align="center">${fr.content }</td>
			<td align="center">${fr.ctime }</td>
			<td align="center">${fr.cman }</td>			
			<td align="center">
				<a href="frgetid.do?id=${fr.id }" class="pn-opt">修改</a>
				<a href="fastreportdelete.do?id=${fr.id }" onclick="return confirm('您确定删除吗？')" class="pn-opt">删除</a>
			</td>		
		</tr>

	</c:forEach>
		
	</tbody>
</table>

<div class="page_pb15">
	<span class="r inb_a page_b">
		<!-- [当前页/尾页] -->
		[当前为第${requestScope.currentPage }页/共${requestScope.pageCount }页]
		<a href="fastreportlist.do">首页</a>
			<c:if test="${requestScope.currentPage-1>0 }">
				<a href="fastreportlist.do?currentPage=${requestScope.currentPage-1 }">上一页</a>
			</c:if>
			<input type="text"  name="pages" style="width: 40px"/>
				<input  type="submit" value="跳转"/>
			
			<c:if test="${requestScope.currentPage+1<=requestScope.pageCount }">
				<a href="fastreportlist.do?currentPage=${requestScope.currentPage+1 }">下一页</a>
			</c:if>
		<a href="fastreportlist.do?currentPage=${requestScope.pageCount }">尾页</a>
	</span>
</div>


<div style="margin-top:15px;">
<!-- 	<input class="del-button" type="button" value="取消" onclick="optCancel();"/>
	<input class="submit" type="button" value="通过" onclick="optPass();"/> -->
</div>
</form>
</div>
</body>
</html>