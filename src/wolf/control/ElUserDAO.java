package wolf.control;

import java.util.Iterator;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import wolf.control.HibernateBaseDAO;
import wolf.cfg.hbm.Course;
import wolf.cfg.hbm.ElUser;
import wolf.test.HibernateUtil;


public class ElUserDAO extends HibernateBaseDAO{
	public ElUser loadUser(String eluserId){
		return (ElUser)this.getSession().get(ElUser.class, eluserId);
	}
	
	public List<ElUser>  findUser(String eluserLoginname){
		return   (List<ElUser>) this.qry("from ElUser where eluserLoginname='"+eluserLoginname+"'");
	}
	public List<ElUser>  loadAllUser(){
		return   (List<ElUser>) this.qry("from ElUser order by eluserId");
	}
	public ElUser loginUser(String eluserLoginname){
		
		 Query qry= this.getSession().createQuery("from ElUser where eluserLoginname='"+eluserLoginname+"'");
		 return (ElUser) qry.uniqueResult(); 
	}

	public void createUser(ElUser user){
		this.getSession().save(user);
	}
	
	public void modifyUser(ElUser user){
		this.getSession().update(user);
	}
	
	public void removeUser(ElUser user){
		this.getSession().delete(user);
	}
	
	public List<ElUser>  loadUnselectUser(Course course){
		return   (List<ElUser>) this.qry("from ElUser where eluserId not in " +
				"(select id.eluserId from UserCourse where id.elcourseId ='"+course.getElcourseId()+"' )");
	}
	public List<ElUser>  loadselectedUser(Course course){
		return   (List<ElUser>) this.qry("from ElUser where eluserId  in " +
				"(select id.eluserId from UserCourse where id.elcourseId ='"+course.getElcourseId()+"') ");
	}
	


	/*public static void main(String[] args){
		
		
		
		Session session =HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		
		
		ElUserDAO testElUserDAO=new ElUserDAO();
		
		System.out.println(testElUserDAO.loginUser("31001335"));
		if(testElUserDAO.loginUser("31001335s")){
			System.out.println("no");
			
		}
			
		
		
		
	}
		*/

}
