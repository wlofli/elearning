package wolf.action;

import java.util.List;

import wolf.cfg.hbm.UserCourseId;

public class ElUserCourseAction {
	private List<UserCourseId> unSelectCourseList;
	private List<UserCourseId> selectedCourseList;
	public List<UserCourseId> getUnSelectCourseList() {
		return unSelectCourseList;
	}
	public void setUnSelectCourseList(List<UserCourseId> unSelectCourseList) {
		this.unSelectCourseList = unSelectCourseList;
	}
	public List<UserCourseId> getSelectedCourseList() {
		return selectedCourseList;
	}
	public void setSelectedCourseList(List<UserCourseId> selectedCourseList) {
		this.selectedCourseList = selectedCourseList;
	}
	
	
	
	

}
