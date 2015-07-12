package wolf.action;

import com.opensymphony.xwork2.ActionContext;

import wolf.cfg.hbm.Course;
import wolf.cfg.hbm.Data;
import wolf.control.CourseDAO;
import wolf.control.DataDAO;

public class StuCourseAction {
	private Course coursedata;
	private Data dataurl;
	public Course getCoursedata() {
		return coursedata;
	} 
	public void setCoursedata(Course coursedata) {
		this.coursedata = coursedata;
	}
	public Data getDataurl() {
		return dataurl;
	}
	public void setDataurl(Data dataurl) {
		this.dataurl = dataurl;
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
	 
}
