package wolf.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionContext;


import wolf.cfg.hbm.Course;
import wolf.cfg.hbm.Data;

import wolf.cfg.hbm.ElUser;
import wolf.control.CourseDAO;
import wolf.control.DataDAO;

public class DataAction {
	
	private File photo;
	private String photoFileName;
	private String photoContentType;
	private Course coursedata;
	private String fileName ; 
	private String fileid;
	private Data data;
	private List tags;
	
	public List getTags() {
		return tags;
	}

	public void setTags(List tags) {
		this.tags = tags;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public String getFileid() {
		return fileid;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	
	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
	public Course getCoursedata() {
		return coursedata;
	}


	public void setCoursedata(Course coursedata) {
		this.coursedata = coursedata;
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


	public File getPhoto() {
		return photo;
	}


	public void setPhoto(File photo) {
		this.photo = photo;
	}
	
	public String turnUploadData(){
		System.out.println("turn uploaddata");
		CourseDAO dao=new CourseDAO();
		DataDAO dao1=new DataDAO();
		coursedata=dao.loadCourse(coursedata.getElcourseId());	
		ActionContext.getContext().put("datalist",dao1.loadcoursedata(coursedata));
		return "upload";
	}
	
	
	public String turnDataGrid(){
		System.out.println("turndatagrid");
		CourseDAO dao=new CourseDAO();
		DataDAO dao1=new DataDAO();
		coursedata=dao.loadCourse(coursedata.getElcourseId());	
		ActionContext.getContext().put("datalist",dao1.loadcoursedata(coursedata));		
		return "turndatagrid";
	}
	

	public String addData(){
		System.out.println("adddata");
		if(photo!=null){
			try {
				StringBuffer filenameBuffer=new StringBuffer();
				ElUser sysuser=(ElUser) ActionContext.getContext().getSession().get("sysUser");
				Data data=new Data();
				DataDAO dao=new DataDAO();
				data.setEldtId(UUID.randomUUID().toString().replaceAll("-", ""));
				data.setElcourseId(coursedata.getElcourseId());
				data.setEldtName(photoFileName);
				data.setEldtUptime(new Date());
				data.setEldtLoader(sysuser.getEluserName());
				data.setEldtDelete(0);
				dao.getSession().clear();
				dao.beginThransaction();
				dao.createData(data);
				dao.commitThransaction();			
				filenameBuffer.append(data.getEldtId());
				FileUtils.copyFile(photo,new File("e:/test/data/"+photoFileName+filenameBuffer));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			ActionContext.getContext().put("error", "请选择上传文件");
			return turnUploadData();
		}
		return turnUploadData();
	}
	
	public String deleteData(){
		System.out.println("del data");
		DataDAO dao=new DataDAO();
		Data dt =new Data();
		int i =0;
		if(tags!=null){
			while(i<tags.size()){
				dt=dao.loadData(tags.get(i).toString());
				dt.setEldtDelete(1);
				i++;
				try {
					dao.getSession().clear();
					dao.beginThransaction();
					dao.modifyData(dt);
					dao.commitThransaction();
					
				} catch (Exception e) {
					// TODO: handle exception
					dao.rollbackThransaction();
				}
				
			}
		}
		return turnUploadData();
		
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
