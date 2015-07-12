package wolf.action;

import java.util.UUID;

import com.opensymphony.xwork2.ActionContext;

import wolf.cfg.hbm.Course;
import wolf.cfg.hbm.Data;
import wolf.control.CourseDAO;
import wolf.control.DataDAO;

public class TeachCourseAction {
	private Course coursedata;
	private Data dataurl;
	

	public Data getDataurl() {
		return dataurl;
	}

	public void setDataurl(Data dataurl) {
		this.dataurl = dataurl;
	}

	public Course getCoursedata() {
		return coursedata;
	}

	public void setCoursedata(Course coursedata) {
		this.coursedata = coursedata;
	}
	
	public String turnCourseInfo(){
		System.out.println("turncourseinfo");
		CourseDAO dao =new CourseDAO();
		
		coursedata=dao.loadCourse(coursedata.getElcourseId());
		return"turncourseinfo";
	}
	
	public String turnUrllist(){
		System.out.println("turnurl");
		CourseDAO dao =new CourseDAO();	
		coursedata=dao.loadCourse(coursedata.getElcourseId());
		DataDAO dao1=new DataDAO();
		dao1.getSession().clear();
		ActionContext.getContext().put("urllist", dao1.loadcourseurl(coursedata));
		return"turnurl";
		
	}
	
	public String turnUpdateUrl(){
		System.out.println("turnupdateurl");
		DataDAO dao=new DataDAO();
		CourseDAO dao1 =new CourseDAO();	 
		coursedata=dao1.loadCourse(coursedata.getElcourseId());
		dataurl=dao.loadData(dataurl.getEldtId());
		return"turnupdateurl";
	}
	public String turnAddUrl(){
		System.out.println("turnaddurl");
		CourseDAO dao1 =new CourseDAO();	 
		coursedata=dao1.loadCourse(coursedata.getElcourseId());
		return"turnaddurl"; 
	}
	
	
	public String addDataUrl(){
		Data dt=new Data();
		DataDAO dao =new DataDAO();
		dt.setEldtId(UUID.randomUUID().toString().replaceAll("-", ""));
		dt.setElcourseId(coursedata.getElcourseId());
		dt.setEldtUrl(dataurl.getEldtUrl());
		dt.setEldtName(dataurl.getEldtName());
		try {
			dao.getSession().clear();
			dao.beginThransaction();
			dao.createData(dt);
			dao.commitThransaction();			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("add url fail");
			dao.rollbackThransaction();
		}
		
		return turnUrllist();
	}
	
	public String updateDataUrl(){
		System.out.println("updateurl");
		DataDAO dao =new DataDAO();
		dao.getSession().clear();
		try {	
			dao.beginThransaction();
			dao.modifyData(dataurl);
			dao.commitThransaction();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("url modify fail");
			dao.rollbackThransaction();
		}	
		return turnUrllist();
	}
	
	public String deleteDataUrl(){
		System.out.println("deleteurl");
		DataDAO dao =new DataDAO();
		dao.getSession().clear();
		try {	
			dao.beginThransaction();
			dao.removeData(dataurl);
			dao.commitThransaction();			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("url modify fail");
			dao.rollbackThransaction();
		}		
		return turnUrllist();
	}

}
