package wolf.action;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import wolf.cfg.hbm.Exercise;
import wolf.cfg.hbm.ExerciseDetail;
import wolf.control.ExerciseDAO;
import wolf.control.ExerciseDetailDAO;

public class ExerciseDetailDownloadAction {
	private String fileName="test.doc" ; //服务器文件名
	private String downloadFileName;//downloadfilename 下载文件名
	private ExerciseDetail edetail;
	

	public ExerciseDetail getEdetail() {
		return edetail;
	}

	public void setEdetail(ExerciseDetail edetail) {
		this.edetail = edetail;
	}

	public String getFileName() {
		return fileName;
	}

	public void setDownloadFileName(String downloadFileName) {
		try {
			this.downloadFileName = new String(downloadFileName.getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setFileName(String fileName){ 
	   this.fileName = fileName; 
	}
	
	public InputStream getDownloadFile() throws Exception {		
		return new  FileInputStream("e:/test/exercisedetail/"+fileName);    
	} 
	
	public String getDownloadFileName() {
		return downloadFileName;
	}
	
	public String execute() throws Exception { 
		System.out.println("exercisedetaildownload");		
	    ExerciseDetailDAO dao =new ExerciseDetailDAO();
	    ExerciseDetail exdtl= new ExerciseDetail();	   
	    exdtl=dao.loadExerciseDetail(edetail.getElexdId()); 
	    this.setDownloadFileName(exdtl.getElexdName());
	    System.out.println(downloadFileName);
	    fileName=new String(exdtl.getElexdName()+exdtl.getElexdId());	  
	    return "success"; 
	}

}
