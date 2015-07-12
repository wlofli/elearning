package wolf.action;



import com.opensymphony.xwork2.ActionContext;

import wolf.cfg.hbm.ElUser;
import wolf.control.ElUserDAO;

public class LoginAction {
	private ElUser user;

	public ElUser getUser() {
		return user;
	}

	public void setUser(ElUser user) {
		this.user = user;
	}
	public String execute(){
		if(user.getEluserLoginname()==null||user.getEluserLoginname().equals("")){
			ActionContext.getContext().put("error", "���������û���");
			return "login_fail";
		}
		if(user.getEluserPassword()==null||user.getEluserPassword().equals("")){
			ActionContext.getContext().put("error", "������������");
			return "login_fail";
		}
		ElUserDAO dao=new ElUserDAO();
		ElUser eluser=new ElUser();
		
		try {
			eluser= dao.loginUser(user.getEluserLoginname());
			
		} catch (Exception e) {
			ActionContext.getContext().put("error", "�û���������");
			// TODO: handle exception
		}
		if(eluser==null){
			ActionContext.getContext().put("error", "�û�������");
			return "login_fail";
		}
		
		if(!eluser.getEluserPassword().equals(user.getEluserPassword())){
			ActionContext.getContext().put("error", "�������");
			return "login_fail";
		}
		ActionContext.getContext().getSession().put("sysUser", eluser);
		if(eluser.getEluserIdentity()==1)
		{
			return "studentmain";
		}
		else if(eluser.getEluserIdentity()==2)
		{
			return "teachermain";
		}
		else {
			
			return "managemain";
		}
	}

}
