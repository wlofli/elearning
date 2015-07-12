package wolf.action;

import java.util.Date;
import java.util.List;
import java.util.UUID;


import bsh.Primitive;

import com.opensymphony.xwork2.ActionContext;

import wolf.cfg.hbm.Course;
import wolf.cfg.hbm.Notice;
import wolf.control.CourseDAO;
import wolf.control.NoticeDAO;

public class NoticeAction {
	private Notice notice;
	private Course coursedata;
	private String ntcisnull;
	public String getNtcisnull() {
		return ntcisnull;
	}


	public void setNtcisnull(String ntcisnull) {
		this.ntcisnull = ntcisnull;
	}
	
	
	public Course getCoursedata() {
		return coursedata;
	}


	public void setCoursedata(Course coursedata) {
		this.coursedata = coursedata;
	}


	public Notice getNotice() {
		return notice;
	}


	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	
	public String turnAddNotice(){
		System.out.println("turnaddnotice");	
		return "turnaddnotice";
	}
	
	public String turnAddCourseNotice(){
		System.out.println("turnaddcoursenotice");
		CourseDAO dao1=new CourseDAO();
		coursedata=dao1.loadCourse(coursedata.getElcourseId());
		return "turnaddcoursenotice"; 
	}
	public String turnUpdateNotice(){
		System.out.println("turnupdatenotice");
		NoticeDAO dao=new NoticeDAO();
		notice=dao.loadNotice(notice.getNtcId());		
		return"turnupdatenotice";
	} 
		
	public String turnNoticeDetail(){
		System.out.println("turnnoticedetail");
		NoticeDAO dao=new NoticeDAO();
		notice=dao.loadNotice(notice.getNtcId());		
		return"turnnoticedetail";
	}
	
	public String turnUpdateCourseNotice(){
		System.out.println("turnupdatecoursenotice");
		NoticeDAO dao=new NoticeDAO(); 
		notice=dao.loadNotice(notice.getNtcId());
		CourseDAO dao1=new CourseDAO();
		coursedata=dao1.loadCourse(coursedata.getElcourseId());
		return "turnupdatecoursenotice";
	} 
	public String turnTchCourseNoticeDetail(){
		System.out.println("turncoursenoticedetail");
		NoticeDAO dao=new NoticeDAO();
		notice=dao.loadNotice(notice.getNtcId());
		CourseDAO dao1=new CourseDAO();
		coursedata=dao1.loadCourse(coursedata.getElcourseId());
		return"turntchcoursenoticedetail"; 
	}
	
	
	public String turnCoursentc(){
		System.out.println("turn course ntc");		
		NoticeDAO dao=new NoticeDAO();
		CourseDAO dao1=new CourseDAO();
		dao.getSession().clear();
		coursedata=dao1.loadCourse(coursedata.getElcourseId());
		List<Notice> list=dao.loadCourseNotice(coursedata.getElcourseId());		
		ActionContext.getContext().put("coursenoticelist",list);
		return"turncoursentc";
	}
	
	public String turnCoursentcStu(){
		System.out.println("turn course ntc stu");
		NoticeDAO dao=new NoticeDAO();
		CourseDAO dao1=new CourseDAO();
		dao.getSession().clear();
		coursedata=dao1.loadCourse(coursedata.getElcourseId());
		List<Notice> list=dao.loadCourseNotice(coursedata.getElcourseId());		
		ActionContext.getContext().put("coursenoticelist",list);
		if(list.isEmpty()){
			this.setNtcisnull("1");
		}else{
			this.setNtcisnull("0");
		}
		return "turncoursentcstu";
	} 
	
	public String updateCourseNotice(){
		System.out.println("updatecoursenotice");
		if(notice.getNtcTitle()==null||notice.getNtcTitle().equals("")){
			ActionContext.getContext().put("error", "标题不能为空");
			return turnUpdateCourseNotice();
		}
		if(notice.getNtcContent().length()>=499)
		{
			ActionContext.getContext().put("error", "内容太长");
			return turnUpdateCourseNotice();
		}
		if(notice.getNtcContent()==null||notice.getNtcContent().equals("")){
			ActionContext.getContext().put("error", "内容不能为空");
			return turnUpdateCourseNotice();
		}
		NoticeDAO dao=new NoticeDAO();
		notice.setNtcDate(new Date());					
		notice.setNtcCourseid(coursedata.getElcourseId());
		try {
			dao.getSession().clear();
			dao.beginThransaction();
			dao.modifyNotice(notice);
			dao.commitThransaction();			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ntccse update fail");
			dao.rollbackThransaction();
		}	
		return turnCoursentc();
	}
	
	public String addTchCourseNotice(){
		System.out.println("addtchcoursenotice");
		if(notice.getNtcTitle()==null||notice.getNtcTitle().equals("")){
			ActionContext.getContext().put("error", "标题不能为空");
			return turnAddCourseNotice();	
		}
		if(notice.getNtcContent().length()>=499)
		{
			ActionContext.getContext().put("error", "内容太长");
			return turnAddCourseNotice();	
		}
		if(notice.getNtcContent()==null||notice.getNtcContent().equals("")){
			ActionContext.getContext().put("error", "内容不能为空");
			return turnAddCourseNotice();	
		}
		NoticeDAO dao=new NoticeDAO();
		Notice ntc= new Notice();
		ntc.setNtcId(UUID.randomUUID().toString().replaceAll("-", ""));
		ntc.setNtcDelete(3);
		ntc.setNtcIdentity(notice.getNtcIdentity());
		ntc.setNtcTitle(notice.getNtcTitle());
		ntc.setNtcUsername(notice.getNtcUsername());	
		ntc.setNtcContent(notice.getNtcContent());	
		ntc.setNtcCourseid(coursedata.getElcourseId());
		ntc.setNtcDate(new Date());
		try {
			dao.getSession().clear();
			dao.beginThransaction();
			dao.createNotice(ntc);
			dao.commitThransaction();			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ntccse add fail");
			dao.rollbackThransaction();
		}
		return turnCoursentc();	
	}
	
	public String deleteCourseNotice(){
		System.out.println("deletecoursenotice");
		NoticeDAO dao=new NoticeDAO();
		notice.setNtcDelete(1);
		try {
			dao.getSession().clear();
			dao.beginThransaction();
			dao.modifyNotice(notice);
			dao.commitThransaction();			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ntc delete fail");
			dao.rollbackThransaction();
		}		
		return turnCoursentc();		
	}
	public String addNotice(){
		if(notice.getNtcTitle()==null||notice.getNtcTitle().equals("")){
			ActionContext.getContext().put("error", "标题不能为空");
			return turnAddNotice();	
		}
		if(notice.getNtcContent().length()>=499)
		{
			ActionContext.getContext().put("error", "内容太长");
			return turnAddNotice();	
		}
		if(notice.getNtcContent()==null||notice.getNtcContent().equals("")){
			ActionContext.getContext().put("error", "内容不能为空");
			return turnAddNotice();	
		}
		NoticeDAO dao=new NoticeDAO();
		Notice ntc= new Notice();
		ntc.setNtcId(UUID.randomUUID().toString().replaceAll("-", ""));
		ntc.setNtcDelete(0);
		ntc.setNtcIdentity(notice.getNtcIdentity());
		ntc.setNtcTitle(notice.getNtcTitle());
		ntc.setNtcUsername(notice.getNtcUsername());	
		ntc.setNtcContent(notice.getNtcContent());		
		ntc.setNtcCourseid(null);
		ntc.setNtcDate(new Date());
		try {
			dao.getSession().clear();
			dao.beginThransaction();
			dao.createNotice(ntc);
			dao.commitThransaction();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ntc add fail");
			dao.rollbackThransaction();
		}		
		return loadAllNotice();
	}
	
	public String updateNotice(){
		if(notice.getNtcTitle()==null||notice.getNtcTitle().equals("")){
			ActionContext.getContext().put("error", "标题不能为空");
			return turnUpdateNotice();
		}
		if(notice.getNtcContent().length()>=499)
		{
			ActionContext.getContext().put("error", "内容太长");
			return turnUpdateNotice();
		}
		if(notice.getNtcContent()==null||notice.getNtcContent().equals("")){
			ActionContext.getContext().put("error", "内容不能为空");
			return turnUpdateNotice();
		}
		NoticeDAO dao=new NoticeDAO();
		notice.setNtcDate(new Date());					
		notice.setNtcCourseid(null);
		try {
			dao.getSession().clear();
			dao.beginThransaction();
			dao.modifyNotice(notice);
			dao.commitThransaction();			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ntc update fail");
			dao.rollbackThransaction();
		}	
		return loadAllNotice();
	}
	
	public String deleteNotice(){
		NoticeDAO dao=new NoticeDAO();
		notice.setNtcDelete(1);
		try {
			dao.getSession().clear();
			dao.beginThransaction();
			dao.modifyNotice(notice);
			dao.commitThransaction();			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ntc delete fail");
			dao.rollbackThransaction();
		}		
		return loadAllNotice();
	}
		
	
	public String loadAllNotice(){
		System.out.println("loadallnotice");
		NoticeDAO dao =new NoticeDAO();
		dao.getSession().clear();
		ActionContext.getContext().put("noticelist", dao.loadAllNotice());		
		return"loadallnotice";
	}
	//for stu & tch
	public String loadAllNotice2(){
		System.out.println("loadallnotice2");
		NoticeDAO dao =new NoticeDAO();
		dao.getSession().clear();
		ActionContext.getContext().put("noticelist", dao.loadAllNotice());		
		return"loadallnotice2"; 
	}
	
}
