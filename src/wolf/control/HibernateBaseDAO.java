package wolf.control;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.Query;

import wolf.test.HibernateUtil;


public class HibernateBaseDAO {
	public 	Session getSession(){
		return HibernateUtil.getSession();
	}
	
	public void beginThransaction(){
		this.getSession().beginTransaction();
	}
	
	public void commitThransaction(){
		this.getSession().getTransaction().commit();
	}
	
	public void rollbackThransaction(){
		this.getSession().getTransaction().rollback();
	}
	
	public List<?>qry(String hql){
		Query qry =this.getSession().createQuery(hql);
		return qry.list();
	}
	
	
	
}
