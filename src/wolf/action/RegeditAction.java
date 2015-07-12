package wolf.action;


import java.util.UUID;



import wolf.cfg.hbm.ElUser;
import wolf.control.ElUserDAO;







public class RegeditAction  {
	private String jusername;
	private String juserpassword;
	
	public String getJusername() {
		return jusername;
	}
	public void setJusername(String jusername) {
		this.jusername = jusername;
	}
	public String getJuserpassword() {
		return juserpassword;
	}
	public void setJuserpassword(String juserpassword) {
		this.juserpassword = juserpassword;
	}
	private ElUser user;
	public ElUser getUser() {
		return user;
	}
	public void setUser(ElUser user) {
		this.user = user;
	}
	
	
	public String execute() throws Exception{
	//	System.out.println(jusername);
	//	System.out.println(juserpassword);
		ElUser u=new ElUser();
		ElUserDAO dao =new ElUserDAO();
		
		try {
			
		//	String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");  
		//	System.out.println(uuid);
			u.setEluserId(jusername);
			u.setEluserLoginname(jusername);
			u.setEluserPassword(juserpassword);
			u.setEluserClass("1");

			u.setEluserIdentity(2);
			u.setEluserIslock(1);
			u.setEluserReverse1("hha");
			u.setEluserReverse2("hha");
			System.out.println(u.getEluserLoginname());
			System.out.println("REgedittest main suc1");
			dao.beginThransaction();
			System.out.println("regedittest main suc2");
			dao.createUser(u);
			
			System.out.println("test main suc3");
			dao.commitThransaction();
			System.out.println("test main suc4");
		
			return"suc";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dao.rollbackThransaction();
			return"fail";
		}
		
		
	
		
		
	}


	/*public static void main(String args[] ){
		ElUser u1=new ElUser();
		ElUserDAO dao1 =new ElUserDAO();
		
		try {
			dao1.beginThransaction();
			String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");  
			System.out.println(uuid);
			u1.setEluserId(uuid);
			u1.setEluserLoginname("kk");
			u1.setEluserPassword("kka");
			u1.setEluserClass("1");
			u1.setEludId("2");
			u1.setEluserIdentity(2);
			u1.setEluserIslock(1);
			u1.setEluserReverse1("hha");
			u1.setEluserReverse2("hha");
			System.out.println("test main suc1");
			dao1.createUser(u1);
			dao1.commitThransaction();
			System.out.println("test main suc2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dao1.rollbackThransaction();
		}
		
		
	}*/
	
}
