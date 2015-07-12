package wolf.cfg.hbm;

// Generated 2014-2-15 20:31:44 by Hibernate Tools 3.2.2.GA

import java.util.Date;

/**
 * ExerciseDetail generated by hbm2java
 */
public class ExerciseDetail implements java.io.Serializable {

	private String elexdId;
	private String elexId;
	private String elexdUsername;
	private Integer elexdGrade;
	private Integer elexdDelete;
	private String elexdUrl;
	private String elexdContent;
	private Date elexdDate;
	private String eluserId;
	private String elexdName;
	public ExerciseDetail() {
	}

	public ExerciseDetail(String elexdId) {
		this.elexdId = elexdId;
	}

	public ExerciseDetail(String elexdId, String elexId, String elexdUsername,
			Integer elexdGrade, String elexdUrl, String elexdContent,
			Date elexdDate,String eluserId,Integer elexdDelete,String elexdName) {
		this.elexdId = elexdId;
		this.elexId = elexId;
		this.elexdUsername = elexdUsername;
		this.elexdGrade = elexdGrade;
		this.elexdUrl = elexdUrl;
		this.elexdContent = elexdContent;
		this.elexdDate = elexdDate;
		this.eluserId = eluserId;
		this.elexdDelete = elexdDelete;
		this.elexdName = elexdName;
	}

	public String getElexdName() {
		return elexdName;
	}

	public void setElexdName(String elexdName) {
		this.elexdName = elexdName;
	}

	public Integer getElexdDelete() {
		return elexdDelete;
	}

	public void setElexdDelete(Integer elexdDelete) {
		this.elexdDelete = elexdDelete;
	}

	public String getEluserId() {
		return eluserId;
	}

	public void setEluserId(String eluserId) {
		this.eluserId = eluserId;
	}

	public String getElexdId() {
		return this.elexdId;
	}

	public void setElexdId(String elexdId) {
		this.elexdId = elexdId;
	}

	public String getElexId() {
		return this.elexId;
	}

	public void setElexId(String elexId) {
		this.elexId = elexId;
	}

	public String getElexdUsername() {
		return this.elexdUsername;
	}

	public void setElexdUsername(String elexdUsername) {
		this.elexdUsername = elexdUsername;
	}

	public Integer getElexdGrade() {
		return this.elexdGrade;
	}

	public void setElexdGrade(Integer elexdGrade) {
		this.elexdGrade = elexdGrade;
	}

	public String getElexdUrl() {
		return this.elexdUrl;
	}

	public void setElexdUrl(String elexdUrl) {
		this.elexdUrl = elexdUrl;
	}

	public String getElexdContent() {
		return this.elexdContent;
	}

	public void setElexdContent(String elexdContent) {
		this.elexdContent = elexdContent;
	}

	public Date getElexdDate() {
		return this.elexdDate;
	}

	public void setElexdDate(Date elexdDate) {
		this.elexdDate = elexdDate;
	}

}