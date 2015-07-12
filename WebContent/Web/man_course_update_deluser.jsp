<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link  rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/Web/elearning.css">
<link  rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/Web/bootstrap-theme.css">
<link  rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/Web/bootstrap.css">
<title>Insert title here</title>
<script language="javascript">
function oppositeselected()
{
   var allsel=document.getElementsByName("tags");
   for(var i=0;i<allsel.length;i++)
   {
   allsel[i].checked=!allsel[i].checked;
   }
}
function selectAll(){
	 var checklist = document.getElementsByName ("tags");
	   if(document.getElementById("selall").checked)
	   {
	   for(var i=0;i<checklist.length;i++)
	   {
	      checklist[i].checked = 1;
	   } 
	 }else{
	  for(var j=0;j<checklist.length;j++)
	  {
	     checklist[j].checked = 0;
	  }
	 }
	}
</script>
</head>
<body >
<h6 class="position">位置：课程管理&gt;课程修改&gt;删除学生</h6>
<s:form action="Course" method="POST" theme="simple">
<h1 class="h1"><s:property   value="courseform.elcourseName"/></h1>
<s:hidden    name="courseform.elcourseId"></s:hidden>
		<table width="800"  cellspacing="0" class="table table-hover">
				<thead>
					<tr class="success">
						<td width=100>用户名</td>
						<td width=100>姓名</td>				
						<td width=100>班级</td>
						<td width=100>操作：全选<input type="checkbox"   name="selall"  id="selall" onclick="selectAll()"/>
										      反选<input type="checkbox"   name="oppositeselect"          id="oppositeselect"       onclick="oppositeselected()"/>
						</td>
					</tr>
				</thead>
				<s:iterator value="userlist" id="obj">
				<tr>
					<td><s:property value="#obj.eluserLoginname"></s:property></td>
					<td><s:property value="#obj.eluserName"></s:property></td>	
					<td><s:property value="#obj.eluserClass"></s:property></td>				
					<td><input type="checkbox" name="tags" value="<s:property value='#obj.eluserId'/>"></td>
				</tr>	
				</s:iterator> 
		</table>
		<div id="p4"><s:submit name="deletecourse"    method="deleteUserElCourse"    value="删除"></s:submit>
		<s:submit name="turnUpdateEluser"    method="turnUpdateCourse"    value="返回"></s:submit></div>
</s:form>
</body>
</html>