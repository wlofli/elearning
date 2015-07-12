package wolf.control;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import wolf.control.HibernateBaseDAO;
import wolf.cfg.hbm.Course;
import wolf.cfg.hbm.ElUser;




public class CourseDAO extends HibernateBaseDAO {
	public Course loadCourse(String elcourseId){
		return (Course)this.getSession().get(Course.class, elcourseId);
	}
	public List<Course>  loadAllCourse(){
		return   (List<Course>) this.qry("from Course order by elcourseId");
	}
	

	public void createCourse(Course course){
		this.getSession().save(course);
	}
	
	public void modifyCourse(Course course){
		this.getSession().update(course);
	}
	
	public void removeCourse(Course course){
		this.getSession().delete(course);
	}
	
	public List<Course> loadUnSelectCourse(ElUser user){
		return   (List<Course>) this.qry(" from Course where elcourseId not in" +
				"(select id.elcourseId from UserCourse where id.eluserId='"+user.getEluserId()+"')");
		
	}
	public List<Course> loadSelectedCourse(ElUser user){
		return   (List<Course>) this.qry(" from Course where elcourseId  in" +
				"(select id.elcourseId from UserCourse where id.eluserId='"+user.getEluserId()+"')");
		
	}
	
/*public static void main(String[] args){
		
		
		
		Session session =HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		ElUserDAO dao1 =new ElUserDAO();
		
		Course course =new Course();
		
		course.setElcourseId("aaa");
		System.out.println(dao1.loadUnselectUser(course));
		
			
		
}*/
	
}
