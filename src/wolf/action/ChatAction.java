package wolf.action;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import com.opensymphony.xwork2.ActionContext;

import wolf.cfg.hbm.Chat;
import wolf.cfg.hbm.ChatDetail;
import wolf.cfg.hbm.Course;
import wolf.cfg.hbm.ElUser;
import wolf.control.ChatDAO;
import wolf.control.ChatDetailDAO;
import wolf.control.CourseDAO;

public class ChatAction {
	
	private Course coursedata;
	private Chat chat;
	private	ChatDetail chatdetail;
	private int pagesize=5;
	private int page;
	private int maxpage=0;
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getMaxpage() {
		return maxpage;
	}
	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public Course getCoursedata() {
		return coursedata;
	}
	public void setCoursedata(Course coursedata) {
		this.coursedata = coursedata;
	}
	public Chat getChat() {
		return chat;
	}
	public void setChat(Chat chat) {
		this.chat = chat;
	}
	public ChatDetail getChatdetail() {
		return chatdetail;
	}
	public void setChatdetail(ChatDetail chatdetail) {
		this.chatdetail = chatdetail;
	}
	
	public String turnChatGrid(){
		System.out.println("turnchatgrid");
		CourseDAO dao= new CourseDAO();
		ChatDAO dao1=new ChatDAO();
		coursedata=dao.loadCourse(coursedata.getElcourseId());
		ActionContext.getContext().put("chatlist",dao1.loadcoursechat(coursedata) );
		return"turnchatgrid";
	}
	
	public String turnChatList(){
		System.out.println("turnchatlist");
		CourseDAO dao= new CourseDAO();
		ChatDAO dao1=new ChatDAO();
		coursedata=dao.loadCourse(coursedata.getElcourseId());
		ActionContext.getContext().put("chatlist",dao1.loadcoursechat(coursedata) );
		return"turnchatlist";
	}
	
	public String turnAddChat(){
		System.out.println("turnaddchat");
		CourseDAO dao= new CourseDAO();
		coursedata=dao.loadCourse(coursedata.getElcourseId());
		return"turnaddchat";
	}
	
	public String turnUpdateChat(){
		System.out.println("turnupdatechat");
		CourseDAO dao= new CourseDAO();
		coursedata=dao.loadCourse(coursedata.getElcourseId());
		ChatDAO dao1=new ChatDAO();
		chat=dao1.loadChat(chat.getElchId());
		return"turnupdatechat";
		
	}
	
	public String turnChatDetailStu(){
		System.out.println("turnchatdetailstu");
		ChatDetailDAO dao=new ChatDetailDAO();
		ChatDAO dao2=new ChatDAO();
		CourseDAO dao3 =new CourseDAO();
		coursedata=dao3.loadCourse(coursedata.getElcourseId());
		chat=dao2.loadChat(chat.getElchId());
		maxpage=maxpage;
		page=page; 
		if(maxpage==0){
			System.out.println("maxpage null");			
			maxpage=dao.CountChatDetail(chat,pagesize);
			System.out.println(maxpage);
		} 						
		ActionContext.getContext().put("chatdetaillist", dao.loadPageChatDetail(chat, pagesize, page));
		return"turnchatdetailstu";
	}
	
	public String turnChatDetailTch(){ 
		System.out.println("turnchatdetailtch");
		ChatDetailDAO dao=new ChatDetailDAO();
		ChatDAO dao2=new ChatDAO();
		CourseDAO dao3 =new CourseDAO();
		coursedata=dao3.loadCourse(coursedata.getElcourseId());
		chat=dao2.loadChat(chat.getElchId());
		maxpage=maxpage;
		page=page; 
		if(maxpage==0){
			System.out.println("maxpage null");			
			maxpage=dao.CountChatDetail(chat,pagesize);
			System.out.println(maxpage);
		} 						
		ActionContext.getContext().put("chatdetaillist", dao.loadPageChatDetail(chat, pagesize, page));
		return"turnchatdetailtch";
	}
	
	public String addChatDetail(){
		ChatDetail chtdl= new ChatDetail();
		ChatDetailDAO dao= new ChatDetailDAO();
		ChatDAO dao1 =new ChatDAO();
		Map session = ActionContext.getContext().getSession();
		ElUser user=(ElUser) session.get("sysUser");
		this.setPage(1);
		if(chatdetail.getElchdContent()==null||chatdetail.getElchdContent().equals("")){
			ActionContext.getContext().put("error", "留言不能为空");
			return turnChatDetailTch();
		}
		if(chatdetail.getElchdContent().length()>=499)
		{
			ActionContext.getContext().put("error", "留言过长");
			return turnChatDetailTch();
		}
		chat=dao1.loadChat(chat.getElchId());
		chtdl.setElchdId(UUID.randomUUID().toString().replaceAll("-", ""));
		chtdl.setElchdDate(new Date());
		chtdl.setElchId(chat.getElchId());					
		chtdl.setElchdName(user.getEluserName());		
		chtdl.setElchdContent(chatdetail.getElchdContent());
		chtdl.setElchdReverse1(dao.CountAllChatDetail(chat)+1);
		try {
			dao.getSession().clear();
			dao.beginThransaction();
			dao.createChatDetail(chtdl);
			dao.commitThransaction();
		} catch (Exception e) {
			// TODO: handle exception
			dao.rollbackThransaction();
		}
		if(user.getEluserIdentity()==2){
			return turnChatDetailTch();
		}else {
			return turnChatDetailStu();
		}
		
	}
	
	public String addChat(){
		System.out.println("addchat");
		Chat cht=new Chat();
		ChatDAO dao =new ChatDAO();
		if(chat.getElchName()==null||chat.getElchName().equals("")){
			System.out.println("1");
			ActionContext.getContext().put("error", "讨论名称不能为空");
			return turnAddChat();
		}
		cht.setElchId(UUID.randomUUID().toString().replaceAll("-", ""));
		cht.setElchName(chat.getElchName());
		cht.setElchReverse1(chat.getElchReverse1());
		cht.setElchReverse2("0");
		cht.setElchTime(new Date());
		cht.setElcourseId(coursedata.getElcourseId());
		try {
			dao.getSession().clear();
			dao.beginThransaction();
			dao.createChat(cht);
			dao.commitThransaction();
			
		} catch (Exception e) {
			// TODO: handle exception
			dao.rollbackThransaction();
		}
		return turnChatGrid();
	}
	
	public String updateChat(){
		System.out.println("updatechat");
		ChatDAO dao=new ChatDAO();
		if(chat.getElchName()==null||chat.getElchName().equals("")){
			System.out.println("1");
			ActionContext.getContext().put("error", "讨论名称不能为空");
			return turnUpdateChat();
		}
		try {
			dao.getSession().clear();
			dao.beginThransaction();
			dao.modifyChat(chat);
			dao.commitThransaction();
		} catch (Exception e) {
			// TODO: handle exception
			dao.rollbackThransaction();
		}		
		return turnChatGrid();		
	}
	
	public String deleteChat(){
		System.out.println("deletechat");
		ChatDAO dao=new ChatDAO();
		chat.setElchReverse2("1");
		try {
			dao.getSession().clear();
			dao.beginThransaction();
			dao.modifyChat(chat);
			dao.commitThransaction();
		} catch (Exception e) {
			// TODO: handle exception
			dao.rollbackThransaction();
		}
		return turnChatGrid();
	}
	
	

}
