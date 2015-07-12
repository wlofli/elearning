package wolf.control;

import java.util.List;

import wolf.cfg.hbm.Chat;
import wolf.cfg.hbm.Course;



public class ChatDAO extends HibernateBaseDAO {
	
	public Chat loadChat(String elchId){
		return (Chat)this.getSession().get(Chat.class, elchId);
	}
	public List<Chat>  loadAllChat(){
		return   (List<Chat>) this.qry("from Chat order by elchId");
	}
	
	public List<Chat>  loadcoursechat(Course course){
		return 	(List<Chat>) this.qry("from Chat where elcourseId='"+course.getElcourseId()+"' and elchReverse2= '0' order by  elchTime desc"); 
	}
	
	public void createChat(Chat chat){
		this.getSession().save(chat);
	}
	
	public void modifyChat(Chat chat){
		this.getSession().update(chat);
	}
	
	public void removeChat(Chat chat){
		this.getSession().delete(chat);
	}

}
