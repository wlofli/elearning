package wolf.control;

import java.util.List;


import wolf.cfg.hbm.Course;
import wolf.cfg.hbm.Data;

public class DataDAO extends HibernateBaseDAO{
	
	
	public Data loadData(String eldtId){
		return (Data)this.getSession().get(Data.class, eldtId);
	}
	public List<Data>  loadAllData(){
		return   (List<Data>) this.qry("from Data order by eldtId");
	}
	
	public List<Data>  loadcoursedata(Course course){
		return 	(List<Data>) this.qry("from Data where elcourseId='"+course.getElcourseId()+"' and eldtUrl = NULL and eldtDelete= 0" ); 
	}
	
	public List<Data>  loadcourseurl(Course course){
		return 	(List<Data>) this.qry("from Data where elcourseId='"+course.getElcourseId()+"' and eldtUrl <> NULL" ); 
	}
	
	public void createData(Data data){
		this.getSession().save(data);
	}
	
	public void modifyData(Data data){
		this.getSession().update(data);
	}
	
	public void removeData(Data data){
		this.getSession().delete(data);
	}
	
	public static void main(String[] args){
		DataDAO dao=new DataDAO();
		Course course =new Course();
		course.setElcourseId("0cf3f168693341a79ff4558d635fb633");
		List<Data> dtlist = dao.loadcoursedata(course);
		System.out.println(dtlist.get(0).getEldtId());
		
	}
	

}
