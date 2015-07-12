package wolf.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import wolf.cfg.hbm.Data;
import wolf.control.DataDAO;

import bsh.This;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class DownloadAction  extends ActionSupport{
	private String fileName="test.doc" ; //服务器文件名
	private String downloadFileName;//downloadfilename 下载文件名
	private String fileid;
	private  Data downloaddata;
	public Data getDownloaddata() {
		return downloaddata;
	}

	public void setDownloaddata(Data downloaddata) {
		this.downloaddata = downloaddata;
	}

	public String getFileid() {
		return fileid;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
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

	/*public String getFileName(){ 
	   return this.fileName; 
	}*/

	public InputStream getDownloadFile() throws Exception {		
		return new  FileInputStream("e:/test/data/"+fileName);    
	} 

	public String getDownloadFileName() {
		return downloadFileName;
	}

	@Override 
	public String execute() throws Exception { 
	   DataDAO dao= new DataDAO();
	   Data data =new Data();  
	   data=dao.loadData(downloaddata.getEldtId()); 
	   this.setDownloadFileName(data.getEldtName());
	   fileName=new String(data.getEldtName()+data.getEldtId());	  
	   return "success"; 
	} 
	
	
	
}
