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
<title>资料列表</title>
</head>
<script>
function addchatdetail(){
	window.parent.content.location="Chat!addChatDetail?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>&chat.elchId=<s:property value="chat.elchId"/>";
}
function back(){
	window.parent.content.location="Chat!turnChatGrid?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>";
}
</script>

<body >
<div id="content">
 <h6 class="position">位置:我的课程&gt;<s:property value="coursedata.elcourseName"/>&gt;讨论版&gt;<s:property value="chat.elchName"/></h6>
 <h1 class="h1"><s:property value="coursedata.elcourseName"/></h1>
 <s:hidden name="coursedata.elcourseId"></s:hidden>
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
	<div id="chd1"><button type="button" onclick="javascript:back()" class="btn btn-primary">返回</button></div>		
	 	<s:if test="#chatdetaillist.size==0">
	 		<div class="chtdtl">还未有人留言</div><br>	
	 	</s:if>
	 	<s:else>
		 	<s:iterator value="chatdetaillist" id="obj">
			 	<div class="chtdtl">		 		
			 		<div class="lou"><s:property value="#obj.elchdReverse1"/>楼</div>		 						
					<div class="chdcontent"><s:property value="#obj.elchdContent"/></div>
					<div class="chttime"><s:property value="#obj.elchdName"></s:property>发表于&nbsp;<s:date name="#obj.elchdDate" ></s:date></div>
				</div>
			</s:iterator>
		</s:else>	
		<div class="page"> 
			<s:if test="page==1&&maxpage==1">
				
				<ul class="pagination">
		  			<li class="active"><a href="#">${page}</a></li> 
		  		</ul>			
			</s:if>
			<s:elseif  test="page==1&&maxpage>1">
				
				<ul class="pagination">
		  			<li class="active"><a href="#">${page}</a></li>
		  			<li><a href="Chat!turnChatDetailTch?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>
		  				&chat.elchId=<s:property value="#obj.elchId"/>
		  				&page=${page+1}&maxpage=${maxpage}">${page+1}</a></li> 	  
		  			<li><a href="Chat!turnChatDetailTch?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>
		  				&chat.elchId=<s:property value="#obj.elchId"/>
		  				&page=${maxpage}&maxpage=${maxpage}">&raquo;</a></li>
		  		</ul>
			</s:elseif>		
			<s:elseif test="page!=1&&page!=maxpage">		
				
				<ul class="pagination">
				 	<li><a href="Chat!turnChatDetailTch?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>
		  				&chat.elchId=<s:property value="#obj.elchId"/>
		  				&page=1&maxpage=${maxpage}">&laquo;</a></li>
		  			<li><a href="Chat!turnChatDetailTch?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>
		  				&chat.elchId=<s:property value="#obj.elchId"/>
		  				&page=${page-1}&maxpage=${maxpage}">${page-1}</a></li>
		  			<li class="active"><a href="#">${page}</a></li>
		  			<li><a href="Chat!turnChatDetailTch?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>
		  				&chat.elchId=<s:property value="#obj.elchId"/>
		  				&page=${page+1}&maxpage=${maxpage}">${page+1}</a></li> 
		  			<li><a href="Chat!turnChatDetailTch?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>
		  				&chat.elchId=<s:property value="#obj.elchId"/>
		  				&page=${maxpage}&maxpage=${maxpage}">&raquo;</a></li>
				</ul>
			</s:elseif>
			<s:elseif test="page==maxpage">
			
				<ul class="pagination">
				 	<li><a href="Chat!turnChatDetailTch?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>
		  				&chat.elchId=<s:property value="#obj.elchId"/>
		  				&page=1&maxpage=${maxpage}">&laquo;</a></li>
		  			<li><a href="Chat!turnChatDetailTch?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>
		  				&chat.elchId=<s:property value="#obj.elchId"/>
		  				&page=${page-1}&maxpage=${maxpage}">${page-1}</a></li>
		  			<li class="active"><a href="#">${page}</a></li>
	  			</ul>			
			</s:elseif>	<br>
			
		</div>
		<s:property value="chat.elchReverse1"/>
		<s:if test="chat.elchReverse1==0">
				<div id="response">
					<s:form action="Chat"  method="POST" theme="simple">
					<s:hidden name="coursedata.elcourseId"/>
					<s:hidden name="chat.elchId"/>
					<s:textarea     name="chatdetail.elchdContent" cols="69" rows="7" >留言：</s:textarea>
					<div id="p8"><s:submit name="add"    method="addChatDetail"    value="发表"></s:submit>				
					<s:submit name="back"  method="turnChatGrid" value="返回"/></div> 
					<div id="p9"><font color="red"><s:property value="error"></s:property></font></div>
					</s:form>
				</div>
		</s:if>
</div> 
</body>
</html>