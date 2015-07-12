package wolf.action;


import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;
import wolf.cfg.hbm.ElUser;
import wolf.cfg.hbm.UserCourse;
import wolf.cfg.hbm.UserCourseId;
import wolf.control.CourseDAO;
import wolf.control.ElUserCourseDAO;
import wolf.control.ElUserDAO;

public class ElUserAction {
	//private 不能大写
	private ElUser useraction;
	private String cellvalue;
	
	private List tags;
	
	public List getTags() {
		return tags;
	}
	public void setTags(List tags) {
		this.tags = tags;
	}
	public String getCellvalue() {
		return cellvalue;
	}
	public void setCellvalue(String cellvalue) {
		this.cellvalue = cellvalue;
	}
	public ElUser getUseraction() {
		return useraction;
	}
	public void setUseraction(ElUser useraction) {
		this.useraction = useraction;
	}
	
	public String turnAddEluser(){
		return "add";
	}
	/*
	 * 转到更新界面
	 */
	public String turnUpdateEluser(){
		ElUserDAO dao=new ElUserDAO();
		dao.getSession().clear();
		useraction=dao.loadUser(useraction.getEluserId());
		return "update";
	}
	
	public String turnAddCourse(){
		CourseDAO dao1= new CourseDAO();
		ElUserDAO dao=new ElUserDAO();
		dao.getSession().clear();
		useraction=dao.loadUser(useraction.getEluserId());
		ActionContext.getContext().put("courselist", dao1.loadUnSelectCourse(useraction));	
		return "addunselectcourse";
	}
	
	public String turnDeleteCourse(){
		CourseDAO dao1= new CourseDAO();
		ElUserDAO dao=new ElUserDAO();
		dao.getSession().clear();
		useraction=dao.loadUser(useraction.getEluserId());
		ActionContext.getContext().put("courselist", dao1.loadSelectedCourse(useraction));	
		return "deleteselectedcourse";
	}
	
	
	
	public String addUserElCourse(){	
		UserCourse uc =new UserCourse();
		ElUserCourseDAO daouc=new ElUserCourseDAO();
		UserCourseId ucid =new UserCourseId();
			int i=0;
			ucid.setEluserId(useraction.getEluserId());
			if(tags!=null){
				while(i<tags.size()){			
					ucid.setElcourseId(tags.get(i).toString());
					i++;
					uc.setId(ucid);
					try {
						daouc.beginThransaction();
						daouc.getSession().clear();
						daouc.createUnSelectCourse(uc);
						daouc.commitThransaction();
					
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("add uc fail");
						daouc.rollbackThransaction();
					}
				}
			}		
		ElUserDAO dao=new ElUserDAO();
		dao.getSession().clear();
		useraction=dao.loadUser(useraction.getEluserId());
		return "update";
	}
	
	public String deleteUserElCourse(){	
		UserCourse uc =new UserCourse();
		ElUserCourseDAO daouc=new ElUserCourseDAO();
		UserCourseId ucid =new UserCourseId();
			int i=0;
			ucid.setEluserId(useraction.getEluserId());
			if(tags!=null){
				while(i<tags.size()){			
					ucid.setElcourseId(tags.get(i).toString());
					i++;
					uc.setId(ucid);
					try {
						daouc.beginThransaction();
						daouc.getSession().clear();
						daouc.removeUserCourse(uc);
						daouc.commitThransaction();					
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("add uc fail");
						daouc.rollbackThransaction();
					}
				}
			}	
		ElUserDAO dao=new ElUserDAO();
		dao.getSession().clear();
		useraction=dao.loadUser(useraction.getEluserId());
		return "update";
		
	}

	public String updateEluser(){	
		
		System.out.println("eeupdateeluser");		
		ElUserDAO dao=new ElUserDAO();
		try {
			dao.getSession().clear();
			dao.modifyUser(useraction);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("update fail");
		}
		ActionContext.getContext().put("userlist", dao.loadAllUser());
		return "grid";
	}
	
	/*
	 * undone delete
	 */
	public String deleteElUser(){
		System.out.println("deleteeluser");	
	
		ElUserDAO dao=new ElUserDAO();	
		try {
			dao.getSession().clear();
			dao.beginThransaction();
			dao.removeUser(useraction);
			dao.commitThransaction();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("del fail");
			dao.rollbackThransaction();
		}
			
		ActionContext.getContext().put("userlist", dao.loadAllUser());	
		return "grid";
	}
	
	
	public String addEluser(){
		System.out.println("addeluser");
		
		if(useraction.getEluserLoginname()==null||useraction.getEluserLoginname().equals("")){
			
			ActionContext.getContext().put("error", "必须输入用户名");
			ActionContext.getContext().getSession().clear();
			return "addfail";
		}
		if(useraction.getEluserPassword()==null||useraction.getEluserPassword().equals("")){
			ActionContext.getContext().put("error", "必须输入密码");
			return "addfail";
		}
		ElUserDAO dao=new ElUserDAO();
		if(!dao.findUser(useraction.getEluserLoginname()).isEmpty()){
			ActionContext.getContext().put("error", "添加失败，可能用户名已存在");
			return "addfail";
		}
		try {
			dao.getSession().clear();
			dao.beginThransaction();
			useraction.setEluserId(UUID.randomUUID().toString().replaceAll("-", ""));
			dao.createUser(useraction);
			dao.commitThransaction();
			System.out.println("suc add");
			
		} catch (Exception e2) {
			
			System.out.println("fail add");
			dao.rollbackThransaction();
			return "addfail";
			
			// TODO: handle exception
		}	
		ActionContext.getContext().put("userlist", dao.loadAllUser());		
		return "grid";
	}
	/*
	 * grid载入用户列表
	 */
	public String loadAllEluser() {	
		System.out.println("tloadalluser");
		
		ElUserDAO dao =new ElUserDAO();		
		try {	
			ActionContext.getContext().put("userlist", dao.loadAllUser());		
			return "grid";
		} catch (Exception e) {
			return "fail";
			// TODO: handle exception
		}
	
	
	}
}
