package wolf.action;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionContext;

import wolf.cfg.hbm.Course;
import wolf.cfg.hbm.ElUser;
import wolf.cfg.hbm.Exercise;
import wolf.cfg.hbm.ExerciseDetail;
import wolf.control.CourseDAO;
import wolf.control.ExerciseDAO;
import wolf.control.ExerciseDetailDAO;

public class ExerciseAction {
	
	private Course coursedata;
	private File photo;
	private String photoFileName;
	private String photoContentType;
	private String fileName ;
	private Exercise exercise;
	private List tags;
	public List getTags() {
		return tags;
	}

	public void setTags(List tags) {
		this.tags = tags;
	}

	public Course getCoursedata() {
		return coursedata;
	}

	public void setCoursedata(Course coursedata) {
		this.coursedata = coursedata;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	public String turnExerciseDetail(){
		System.out.println("turnexercisedetail");
		CourseDAO dao=new CourseDAO();
		ExerciseDAO dao1=new ExerciseDAO();
		coursedata = dao.loadCourse(coursedata.getElcourseId());
		exercise=dao1.loadExercise(exercise.getElexId());
		ExerciseDetailDAO dao2=new ExerciseDetailDAO();		
		ActionContext.getContext().put("exercisedetaillist", dao2.loadlistexercisedetail(exercise));		
		return "turnexercisedetail";
	}
	
	public String turnExercise()
	{	
		System.out.println("turnexercise");
		CourseDAO dao=new CourseDAO();
		ExerciseDAO dao1=new ExerciseDAO();
		coursedata = dao.loadCourse(coursedata.getElcourseId());
		ActionContext.getContext().put("exerciselist", dao1.loadcourseexercise(coursedata));
		return "turnexercise";
	}
	
	public String deleteExerciseDetail(){
		System.out.println("deletedetailexercise");
		ExerciseDetailDAO daoexdl= new ExerciseDetailDAO();
		ExerciseDetail eDetail =new ExerciseDetail();
		int i=0;
		if(tags!=null){
			while(i<tags.size()){
				eDetail=daoexdl.loadExerciseDetail(tags.get(i).toString());
				eDetail.setElexdDelete(1);
				
				i++;
				try {
					daoexdl.getSession().clear();
					daoexdl.beginThransaction();
					daoexdl.modifyExerciseDetail(eDetail);
					daoexdl.commitThransaction();
				} catch (Exception e) {
					// TODO: handle exception
					daoexdl.rollbackThransaction();
				}
			}
				
		}
		return turnExerciseDetail();
		
	}
	
	public String deleteExercise(){
		System.out.println("deleteexercise");
		ExerciseDAO dao =new ExerciseDAO();
		Exercise ex  =new Exercise();
		int i=0;
		if(tags!=null){
			while(i<tags.size()){
				ex=dao.loadExercise(tags.get(i).toString());
				ex.setElexDelete(1);
				i++;
				try {
					dao.getSession().clear();
					dao.beginThransaction();
					dao.modifyExercise(ex);
					dao.commitThransaction();
				} catch (Exception e) {
					// TODO: handle exception
					dao.rollbackThransaction();
				}
			}
		}
		return turnExercise();
	}
	
	public String addExercise(){		
		System.out.println("addexercise");
		if(photo!=null){
			try {
				StringBuffer filenameBuffer=new StringBuffer();
				ElUser sysuser=(ElUser) ActionContext.getContext().getSession().get("sysUser");
				Exercise exercise =new Exercise();
				ExerciseDAO dao =new ExerciseDAO();
				exercise.setElexId(UUID.randomUUID().toString().replaceAll("-", ""));
				exercise.setElcourseId(coursedata.getElcourseId());
				exercise.setElexName(photoFileName);
				exercise.setElexDate(new Date());
				exercise.setElexUsername(sysuser.getEluserName());
				exercise.setElexReverse1("0");
				exercise.setElexDelete(0);
				dao.getSession().clear();
				dao.beginThransaction();
				dao.createExercise(exercise);
				dao.commitThransaction();			
				filenameBuffer.append(exercise.getElexId());
				FileUtils.copyFile(photo,new File("e:/test/exercise/"+photoFileName+filenameBuffer));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("error");
			}			
			return turnExercise();
		}
		else {
			ActionContext.getContext().put("error", "未选择上传文件");
			return turnExercise();
		}		
	}
	
	public String loadAllCourse(){
		System.out.println("loadAllCourse");
		Map session =ActionContext.getContext().getSession();
		ElUser user=(ElUser) session.get("sysUser");		
		CourseDAO dao=new CourseDAO();
		ActionContext.getContext().put("courselist", dao.loadSelectedCourse(user));
		return "grid";
	}
	
	
	
}
