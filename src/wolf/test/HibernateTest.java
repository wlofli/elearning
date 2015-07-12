package wolf.test;



import java.util.Iterator;
import java.util.List;


import org.hibernate.*;

import org.hibernate.cfg.Configuration;


import wolf.cfg.hbm.*;


public class HibernateTest {
	private static SessionFactory sf =null;
	private static Session getSession(){
		if(sf==null){
			Configuration config	=new Configuration();
			config.configure();
			sf=config.buildSessionFactory();
		}
	return sf.openSession();
		
	}
	public static void main(String[] args){
		Session session=HibernateTest.getSession();
		try {
			if(!session.connection().isClosed())
				System.out.println("suc database!");
			else {
				System.out.println("fail database!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	/*	System.out.println("case1");
		String hql ="from ElUser";
		System.out.println("case2");
		Query qry =session.createQuery(hql);
		System.out.println("case3");
		List<ElUser> result =qry.list();
		Iterator<ElUser> it =result.iterator();
		while(it.hasNext())
		{
			ElUser user =it.next();
			System.out.println(user.getEluserId());
		}*/
		session.close();
	}

}
