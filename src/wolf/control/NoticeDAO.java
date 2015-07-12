package wolf.control;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bsh.This;

import wolf.cfg.hbm.Notice;
import wolf.test.HibernateUtil;



public class NoticeDAO extends HibernateBaseDAO{
	
	public Notice loadNotice(String ntcId){
		return (Notice)this.getSession().get(Notice.class, ntcId);
	}
	public List<Notice>  loadAllNotice(){
		return   (List<Notice>) this.qry("from Notice  where ntcDelete = 0  order by ntcDate desc ");
	}
	
	
	public List<Notice>  loadCourseNotice(String courseid){
		return   (List<Notice>) this.qry("from Notice  where ntcCourseid ='"+courseid+"' and ntcDelete = 3 order by ntcDate desc");
	}
	
	public void createNotice(Notice notice){
		this.getSession().save(notice);
	}
	
	public void modifyNotice(Notice notice){
		this.getSession().update(notice);
	}
	
	public void removeNotice(Notice notice){
		this.getSession().delete(notice);
	}
	
	public static void main(String[] args){
		
		
		NoticeDAO dao =new NoticeDAO();
		/*Notice ntc =new Notice();
		ntc.setNtcId("11");
		ntc=dao.loadNotice(ntc.getNtcId());
		System.out.println(ntc.getNtcDelete());*/
		
		List<Notice> list =dao.loadAllNotice();
		System.out.println(list.get(0).getNtcId());
		System.out.println(list.get(1).getNtcId());
		System.out.println(list.get(2).getNtcId());
		System.out.println(list.get(3).getNtcId());
		
		
	}

}
