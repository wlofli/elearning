package wolf.cfg.hbm;

// Generated 2014-2-15 20:31:44 by Hibernate Tools 3.2.2.GA

import java.util.Date;

/**
 * ChatDetail generated by hbm2java
 */
public class ChatDetail implements java.io.Serializable {

	private String elchdId;
	private String elchId;
	private String elchdName;
	private String elchdContent;
	private Integer elchdReverse1;
	private Date elchdDate;

	public ChatDetail() {
	}

	public ChatDetail(String elchdId) {
		this.elchdId = elchdId;
	}

	public ChatDetail(String elchdId, String elchId, String elchdName,
			String elchdContent, Integer elchdReverse1, Date elchdDate) {
		this.elchdId = elchdId;
		this.elchId = elchId;
		this.elchdName = elchdName;
		this.elchdContent = elchdContent;
		this.elchdReverse1 = elchdReverse1;
		this.elchdDate = elchdDate;
	}

	public String getElchdId() {
		return this.elchdId;
	}

	public void setElchdId(String elchdId) {
		this.elchdId = elchdId;
	}

	public String getElchId() {
		return this.elchId;
	}

	public void setElchId(String elchId) {
		this.elchId = elchId;
	}

	public String getElchdName() {
		return this.elchdName;
	}

	public void setElchdName(String elchdName) {
		this.elchdName = elchdName;
	}

	public String getElchdContent() {
		return this.elchdContent;
	}

	public void setElchdContent(String elchdContent) {
		this.elchdContent = elchdContent;
	}

	

	public Integer getElchdReverse1() {
		return elchdReverse1;
	}

	public void setElchdReverse1(Integer elchdReverse1) {
		this.elchdReverse1 = elchdReverse1;
	}

	public Date getElchdDate() {
		return this.elchdDate;
	}

	public void setElchdDate(Date elchdDate) {
		this.elchdDate = elchdDate;
	}

}
