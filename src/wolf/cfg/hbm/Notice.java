package wolf.cfg.hbm;

import java.util.Date;

public class Notice implements java.io.Serializable  {
	private String ntcId;
	private String ntcTitle;
	private String ntcContent;
	private String ntcUsername;
	private Date ntcDate;
	private String ntcCourseid;
	private Integer ntcIdentity;
	private Integer ntcDelete;
	
	
	public Notice(){
		
	}
	public Notice(String ntcId){
		
		this.ntcId = ntcId;
	}
	public Notice(String ntcId,String ntcTitle,String ntcContent,String ntcUsername,Date ntcDate,
			String ntcCourseid,Integer ntcIdentity,Integer ntcDelete){
		this.ntcId = ntcId;
		this.ntcTitle = ntcTitle;
		this.ntcContent = ntcContent;
		this.ntcUsername = ntcUsername;
		this.ntcDate = ntcDate;
		this.ntcCourseid = ntcCourseid;
		this.ntcIdentity = ntcIdentity;
		this.ntcDelete = ntcDelete;	
	}
	
	public String getNtcId() {
		return ntcId;
	}
	public void setNtcId(String ntcId) {
		this.ntcId = ntcId;
	}
	public String getNtcTitle() {
		return ntcTitle;
	}
	public void setNtcTitle(String ntcTitle) {
		this.ntcTitle = ntcTitle;
	}
	public String getNtcContent() {
		return ntcContent;
	}
	public void setNtcContent(String ntcContent) {
		this.ntcContent = ntcContent;
	}
	public String getNtcUsername() {
		return ntcUsername;
	}
	public void setNtcUsername(String ntcUsername) {
		this.ntcUsername = ntcUsername;
	}
	public Date getNtcDate() {
		return ntcDate;
	}
	public void setNtcDate(Date ntcDate) {
		this.ntcDate = ntcDate;
	}
	public String getNtcCourseid() {
		return ntcCourseid;
	}
	public void setNtcCourseid(String ntcCourseid) {
		this.ntcCourseid = ntcCourseid;
	}
	public Integer getNtcIdentity() {
		return ntcIdentity;
	}
	public void setNtcIdentity(Integer ntcIdentity) {
		this.ntcIdentity = ntcIdentity;
	}
	public Integer getNtcDelete() {
		return ntcDelete;
	}
	public void setNtcDelete(Integer ntcDelete) {
		this.ntcDelete = ntcDelete;
	}
	

}
