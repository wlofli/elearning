package wolf.control;

import java.util.List;



import wolf.cfg.hbm.Course;
import wolf.cfg.hbm.Data;
import wolf.cfg.hbm.Exercise;



public class ExerciseDAO extends HibernateBaseDAO{
	public Exercise loadExercise(String elexId){
		return (Exercise)this.getSession().get(Exercise.class, elexId);
	}
	public List<Exercise>  loadAllExercise(){
		return   (List<Exercise>) this.qry("from Exercise order by elexId");
	}
	
	public List<Exercise>  loadcourseexercise(Course course){
		return 	(List<Exercise>) this.qry("from Exercise where elcourseId='"+course.getElcourseId()+"' and elexDelete = 0"); 
	}
	
	public void createExercise(Exercise exercise){
		this.getSession().save(exercise);
	}
	
	public void modifyExercise(Exercise exercise){
		this.getSession().update(exercise);
	}
	
	public void removeExercise(Exercise exercise){
		this.getSession().delete(exercise);
	}
	
}
