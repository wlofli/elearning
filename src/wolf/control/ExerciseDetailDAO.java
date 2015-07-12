package wolf.control;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import wolf.cfg.hbm.Course;
import wolf.cfg.hbm.ElUser;
import wolf.cfg.hbm.Exercise;
import wolf.cfg.hbm.ExerciseDetail;
import wolf.test.HibernateUtil;



public class ExerciseDetailDAO  extends HibernateBaseDAO{
	public ExerciseDetail loadExerciseDetail(String elexdId){
		return (ExerciseDetail)this.getSession().get(ExerciseDetail.class, elexdId);
	}
	
	public ExerciseDetail loadExerciseDetail(Exercise ex,ElUser u){
		Query qry =this.getSession().createQuery("from ExerciseDetail where eluserId='"+u.getEluserId()+"' and  elexId='"+ex.getElexId()+"' and elexdDelete= 0");
		return (ExerciseDetail)qry.uniqueResult();
	}
	
	public List<ExerciseDetail>  loadAllExercise(){
		return   (List<ExerciseDetail>) this.qry("from ExerciseDetail order by elexdId");
	}
	
	public List<ExerciseDetail>  loadlistexercisedetail(Exercise ex){
		return 	(List<ExerciseDetail>) this.qry("from ExerciseDetail where elexId='"+ex.getElexId()+"' and elexdDelete = 0"); 
	}
	
	
	
	public void createExerciseDetail(ExerciseDetail exercisedetail){
		this.getSession().save(exercisedetail);
	}
	
	public void modifyExerciseDetail(ExerciseDetail exercisedetail){
		this.getSession().update(exercisedetail);
	}
	
	public void removeExerciseDetail(ExerciseDetail exercisedetail){
		this.getSession().delete(exercisedetail);
	}
	
	
		public static void main(String[] args){
				
				
				
				Session session =HibernateUtil.getSession();
				Transaction tx=session.beginTransaction();
			
				
				Exercise exercise=new Exercise();
				exercise.setElexId("e473d2276da54c78be816605be12a05b");
				ElUser user=new ElUser();
				user.setEluserId("2b15a0e4adf34bfb9105bd14b3b02f76");
				
				ExerciseDetail eDetail=new ExerciseDetail();
				ExerciseDetailDAO dao=new ExerciseDetailDAO();
				List<ExerciseDetail> eDetails=dao.loadlistexercisedetail(exercise);
				System.out.println(eDetails.get(0).getElexdUsername());
				System.out.println(dao.loadlistexercisedetail(exercise));
		}
}
