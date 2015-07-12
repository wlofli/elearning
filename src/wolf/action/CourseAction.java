package wolf.action;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.opensymphony.xwork2.ActionContext;

import wolf.cfg.hbm.Course;
import wolf.cfg.hbm.UserCourse;
import wolf.cfg.hbm.UserCourseId;
import wolf.control.CourseDAO;
import wolf.control.ElUserCourseDAO;
import wolf.control.ElUserDAO;

public class CourseAction {
	private Course courseform;
	private List tags;			   

	public List getTags() {
		return tags;
	}
	public void setTags(List tags) {
		this.tags = tags;
	}
	public Course getCourseform() {
		return courseform;
	}
	public void setCourseform(Course courseform) {
		this.courseform = courseform;
	}
	public  String turnAddCourse(){
		System.out.println("turnAddCourse");
		return "add";
	}
	public  String turnUpdateCourse(){
		CourseDAO dao =new CourseDAO();
		dao.getSession().clear();	
		this.setCourseform(dao.loadCourse(courseform.getElcourseId()));
		return "update";
	}
	public  String turnaddUser(){
		CourseDAO dao =new CourseDAO();
		ElUserDAO dao2 =new ElUserDAO();
		dao.getSession().clear();
		courseform=dao.loadCourse(courseform.getElcourseId());
		ActionContext.getContext().put("userlist", dao2.loadUnselectUser(courseform));
		
		return "addunselecteduser";
	}
	
	public  String turndeleteUser(){
		CourseDAO dao =new CourseDAO();
		ElUserDAO dao2 =new ElUserDAO();
		dao.getSession().clear();
		courseform=dao.loadCourse(courseform.getElcourseId());
		ActionContext.getContext().put("userlist", dao2.loadselectedUser(courseform));
		
		return "addselecteduser";
	}
	

	
	
	public String addUserElCourse(){
		UserCourse uc =new UserCourse();
		UserCourseId ucid =new UserCourseId();
		ElUserCourseDAO dao1 =new ElUserCourseDAO();
		int i =0;
		ucid.setElcourseId(courseform.getElcourseId());
		if (tags!=null){
			while(i<tags.size()){	
				ucid.setEluserId(tags.get(i).toString());
				i++;		
				uc.setId(ucid);
				try {
					dao1.beginThransaction();
					dao1.getSession().clear();
					dao1.createUnSelectCourse(uc);
					dao1.commitThransaction();
				} catch (Exception e) {
					System.out.println("add users fail");
					dao1.rollbackThransaction();
					
					// TODO: handle exception
				}
			}
		}	
		CourseDAO dao =new CourseDAO();
		dao.getSession().clear();
		this.setCourseform(dao.loadCourse(courseform.getElcourseId()));
		return "update";
	}
	
	public String deleteUserElCourse(){
		UserCourse uc =new UserCourse();
		UserCourseId ucid =new UserCourseId();
		ElUserCourseDAO dao1 =new ElUserCourseDAO();
		int i =0;
		ucid.setElcourseId(courseform.getElcourseId());
		if (tags!=null){
			while(i<tags.size())
			{
				
				ucid.setEluserId(tags.get(i).toString());
				i++;
			
				uc.setId(ucid);
				try {
					dao1.beginThransaction();
					dao1.getSession().clear();
					dao1.removeUserCourse(uc);
					dao1.commitThransaction();
				} catch (Exception e) {
					System.out.println("add users fail");
					dao1.rollbackThransaction();
					
					// TODO: handle exception
				}
			}
		}
		
		CourseDAO dao =new CourseDAO();
		dao.getSession().clear();
		this.setCourseform(dao.loadCourse(courseform.getElcourseId()));
		return "update";
	}
	
	public String addCourse(){
		System.out.println("addCourse");
		Course c=this.getCourseform();
		if(c.getElcourseName()==null||c.getElcourseName().equals("")){
			ActionContext.getContext().put("error", "请输入课程名称");
			return "addfail";
		}
		if(c.getElcourseInfo().length()>=49){
			ActionContext.getContext().put("error", "课程信息太长");
			return "addfail";
		}
		if(c.getElcoursePurport().length()>=499){
			ActionContext.getContext().put("error", "课程大纲太长");
			return "addfail";
		}
		CourseDAO dao=new CourseDAO();
		c.setElcourseId(UUID.randomUUID().toString().replaceAll("-", ""));
		try {
			dao.beginThransaction();
			c.setElcourseDate(new Date());
			dao.createCourse(c);
			dao.commitThransaction();
			return "suc";
		} catch (Exception e) {
			ActionContext.getContext().put("error", "添加失败");
			System.out.println("fail add");
		
			return "addfail";
			// TODO: handle exception
		}
		
		
	}
	
	public String loadAllCourse(){
		System.out.println("loadAllCourse");		
		CourseDAO dao=new CourseDAO();
		try {	
			ActionContext.getContext().put("courselist", dao.loadAllCourse());		
			return "grid";
		} catch (Exception e) {
			return "fail";
			// TODO: handle exception
		}	
	}
	
	
	public  String updateElCourse(){
		System.out.println("up course");//test
		CourseDAO dao=new CourseDAO();
		if(courseform.getElcourseInfo().length()>=49||courseform.getElcoursePurport().length()>=499){
			ActionContext.getContext().put("error", "课程信息或者课程大纲太长");
			return turnUpdateCourse();
		}
		if(courseform.getElcourseName()==null||courseform.getElcourseName().equals("")){
			ActionContext.getContext().put("error", "课程名称不能为空");
			return turnUpdateCourse();
		}
		
		try {
			dao.getSession().clear();
			dao.beginThransaction();
			dao.modifyCourse(courseform);
			dao.commitThransaction();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("update fail");
			dao.rollbackThransaction();
		}
	
		ActionContext.getContext().put("courselist", dao.loadAllCourse());	
		return "grid";
	}
	public  String deleteElCourse(){
	
		System.out.println("deleteCourse");//test
		CourseDAO dao=new CourseDAO();
		dao.getSession().clear();
		try {
			dao.getSession().clear();
			dao.beginThransaction();
			dao.removeCourse(courseform);
			dao.commitThransaction();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("del fail");
			dao.rollbackThransaction();
		}
		
		ActionContext.getContext().put("courselist", dao.loadAllCourse());		
		return "grid";
	}
	

}
