package wolf.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import wolf.cfg.hbm.Course;
import wolf.cfg.hbm.Data;
import wolf.cfg.hbm.Exercise;
import wolf.cfg.hbm.ExerciseDetail;

import wolf.cfg.hbm.ElUser;
import wolf.control.CourseDAO;
import wolf.control.DataDAO;
import wolf.control.ExerciseDAO;
import wolf.control.ExerciseDetailDAO;

import com.opensymphony.xwork2.ActionContext;

public class ExerciseStuAction {
	private Course coursedata;
	private Exercise exercise;
	private File exercisedetail;
	private String exercisedetailFileName;
	private String exercisedetailContentType;
	
	

	public File getExercisedetail() {
		return exercisedetail;
	}

	public void setExercisedetail(File exercisedetail) {
		this.exercisedetail = exercisedetail;
	}

	public String getExercisedetailFileName() {
		return exercisedetailFileName;
	}

	public void setExercisedetailFileName(String exercisedetailFileName) {
		this.exercisedetailFileName = exercisedetailFileName;
	}

	public String getExercisedetailContentType() {
		return exercisedetailContentType;
	}

	public void setExercisedetailContentType(String exercisedetailContentType) {
		this.exercisedetailContentType = exercisedetailContentType;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	public Course getCoursedata() {
		return coursedata;
	}

	public void setCoursedata(Course coursedata) {
		this.coursedata = coursedata;
	}

	public String turnExercise(){
		System.out.println("turnexercise");
		CourseDAO dao=new CourseDAO();
		ExerciseDAO dao1=new ExerciseDAO();
		coursedata = dao.loadCourse(coursedata.getElcourseId());
		ActionContext.getContext().put("exerciselist", dao1.loadcourseexercise(coursedata));
		return"turnexercise";
	}
	
	public String turnUploadExercise(){
		System.out.println("turnuploadexercise");
		CourseDAO dao2 =new CourseDAO();
		coursedata =dao2.loadCourse(coursedata.getElcourseId());						
		ExerciseDAO dao=new ExerciseDAO();
		Exercise ex=new Exercise();
		exercise =dao.loadExercise(exercise.getElexId());
		ExerciseDetail exdt=new ExerciseDetail();
		ExerciseDetailDAO dao1=new ExerciseDetailDAO();
		Map session = ActionContext.getContext().getSession();
		ElUser user=(ElUser) session.get("sysUser");	
		System.out.println(1);
		exdt=dao1.loadExerciseDetail(exercise, user);		
		ActionContext.getContext().put("isupload", exdt);		
		return"turnuploadexercise";
	}
	
	public String turnDownloadData(){
		System.out.println("turn downloaddata");
		CourseDAO dao=new CourseDAO();
		DataDAO dao1=new DataDAO();
		coursedata=dao.loadCourse(coursedata.getElcourseId());	
		ActionContext.getContext().put("datalist",dao1.loadcoursedata(coursedata));
		return"turndownloaddata";
	}
	
	public String loadAllCourse(){
		System.out.println("loadAllCourse");
		Map session =ActionContext.getContext().getSession();
		ElUser user=(ElUser) session.get("sysUser");		
		CourseDAO dao=new CourseDAO();
		ActionContext.getContext().put("courselist", dao.loadSelectedCourse(user));
		return "grid";
	}
	
	
	public String addExerciseDetail(){
		System.out.println("add exdetail");
		try {
			StringBuffer filenameBuffer=new StringBuffer();
			ElUser sysuser=(ElUser) ActionContext.getContext().getSession().get("sysUser");
			ExerciseDetail eDetail=new ExerciseDetail();
			ExerciseDetailDAO dao=new ExerciseDetailDAO();
			eDetail.setElexdId(UUID.randomUUID().toString().replaceAll("-", ""));
			eDetail.setElexId(exercise.getElexId());
			eDetail.setElexdName(exercisedetailFileName);
			eDetail.setElexdUsername(sysuser.getEluserName());
			eDetail.setElexdDate(new Date());
			eDetail.setElexdDelete(0);
			eDetail.setEluserId(sysuser.getEluserId());
			dao.getSession().clear();
			dao.beginThransaction();
			dao.createExerciseDetail(eDetail);
			dao.commitThransaction();
			filenameBuffer.append(eDetail.getElexdId());
			FileUtils.copyFile(exercisedetail, new File("e:/test/exercisedetail/"+exercisedetailFileName+filenameBuffer));
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return"suc";
		
		
		
	}

}
