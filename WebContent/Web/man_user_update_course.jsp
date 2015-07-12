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
</head>
<body >
<h6 class="position">位置:用户管理&gt;用户修改&gt;添加课程</h6> 
<h1 class="h1"><s:property value="useraction.eluserLoginname"/></h1>
<s:form action="ElUser" method="POST" theme="simple">
<s:hidden     name="useraction.eluserId"></s:hidden>
<script language="javascript">
	function oppositeselected(){
	   var allsel=document.getElementsByName("tags");
	   for(var i=0;i<allsel.length;i++){
	  	 allsel[i].checked=!allsel[i].checked;
	   }
	}
	function selectAll(){
		 var checklist = document.getElementsByName ("tags");
		   if(document.getElementById("selall").checked){
		   		for(var i=0;i<checklist.length;i++){
		      		checklist[i].checked = 1;
		   		} 
		   }else{
		  		for(var j=0;j<checklist.length;j++){
		     		checklist[j].checked = 0;
		  		}
			}
	}
</script>
	<table width="800"  cellspacing="0" class="table table-hover">
			<thead> 
				<tr class="success">
					<td width=100>课程名称</td>
					<td width=100>课程组</td>
					<td width=100>课程信息</td>
					<td width=100>操作: 全选<input type="checkbox"   name="selall"  id="selall" onclick="javascript:selectAll()"/>  
									         反选<input type="checkbox"   name="oppositeselect"       id="oppositeselect"  onclick="javascript:oppositeselected()"/>
					</td>
				</tr>
			</thead>
			<s:iterator value="courselist" id="obj">
			<tr> 
				<td><s:property value="#obj.elcourseName"></s:property></td>
				<td><s:property value="#obj.elcourseGroup"></s:property></td>
				<td><s:property value="#obj.elcourseInfo"></s:property></td>	
				<td><input type="checkbox" name="tags" value="<s:property value='#obj.elcourseId'/>"></td>
			</tr>
			</s:iterator>
	</table>
		<div id="p4"><s:submit name="addcourse"    method="addUserElCourse"    value="增加"></s:submit>
		<s:submit name="turnUpdateEluser"    method="turnUpdateEluser"    value="返回"></s:submit></div>
</s:form>
</body>
</html>