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

<title>练习列表</title>
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
 <div id="content">
 <h6 class="position">位置:我的课程&gt;<s:property value="coursedata.elcourseName"/>&gt;作业&gt;<s:property value="exercise.elexName"></s:property></h6>
<s:form action="Exercise" method="POST" theme="simple"  enctype="multipart/form-data">
 <h1 class="h1"><s:property value="coursedata.elcourseName"/></h1>
 <s:hidden name="coursedata.elcourseId"></s:hidden>
 <s:hidden name="exercise.elexId"></s:hidden>
 	<div id="select">
 		<ul>
 			<li><span><a href="Notice!turnCoursentc?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>" >课程通知</a></span></li>
 			<li><span><a href="TeachCourse!turnCourseInfo?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>">课程信息</a></span></li>
 			<li><span><a href="Data!turnUploadData?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>">课程文档</a></span></li>
 			<li><span><a href="Exercise!turnExercise?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>">作业</a></span></li>
 			<li><span><a href="Chat!turnChatGrid?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>">讨论版</a></span></li>
 			<li><span><a href="TeachCourse!turnUrllist?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>">外部链接</a></span></li>
 		</ul>
	</div>
 	<table  class="table table-hover " >
		<thead>
			<tr class="success">
				<td width="40%">练习名称</td>
				<td width="20%">上传人</td>
				<td width="20%">上传日期</td>
				<td width="20%">操作：全选
					<input type="checkbox"   name="selall"  id="selall" onclick="selectAll()"/>
					反选
					<input type="checkbox"   name="oppositeselect"  id="oppositeselect" onclick="oppositeselected()"/>
				</td>
			</tr>
		</thead>
	 	<s:iterator value="exercisedetaillist" id="obj">
		<tr >
			<td><a href="ExerciseDetailDownload?edetail.elexdId=<s:property value='#obj.elexdId'/>">
				<s:property value='#obj.elexdName'></s:property>
				</a>
			</td>
			<td><s:property value='#obj.elexdUsername'/>			
			</td>		
			<td><s:date name="#obj.elexdDate" format="MM/dd/yy"></s:date></td>
			<td> <input type="checkbox" name="tags" value="<s:property value='#obj.elexdId'/>"> 
			</td>
		</tr>	
		</s:iterator> 
	</table>
<div id="p4"><s:submit name="deletedetailexercise"    method="deleteExerciseDetail"    value="删除学生作业"></s:submit>
<s:submit name="turnexercise"    method="turnExercise"    value="返回"></s:submit></div>
</s:form>
</div> 
</body>
</html>