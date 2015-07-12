package wolf.control;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import wolf.control.HibernateBaseDAO;

import wolf.cfg.hbm.Course;
import wolf.cfg.hbm.ElUser;
import wolf.cfg.hbm.UserCourse;
import wolf.cfg.hbm.UserCourseId;
import wolf.test.HibernateUtil;


public class ElUserCourseDAO extends HibernateBaseDAO {

	public void createUnSelectCourse(UserCourse uc){
		this.getSession().save(uc);
	}
	
	public void modifyUserCourse(UserCourse uc){
		this.getSession().update(uc);
	}
	
	public void removeUserCourse(UserCourse uc){
		this.getSession().delete(uc);
	}
	
	
	

	
	
/*	public static void main(String[] args){
		Session session =HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		ElUserCourseDAO dao =new ElUserCourseDAO();
		UserCourse uc= new UserCourse();
		UserCourseId ucid =new UserCourseId();
		System.out.println("1");
		ucid.setElcourseId("555");
		ucid.setEluserId("666");
		uc.setId(ucid);
		tx.begin();
		dao.createUnSelectCourse(uc);
		tx.commit();
		System.out.println("2");
		
		CourseDAO dao1=new CourseDAO();
		ElUser user=new ElUser();
		user.setEluserId("5");
		List<Course> aa=dao1.loadUnSelectCourse(user);
		
		
	
	}*/
}


