package wolf.control;

import java.util.List;

import org.hibernate.Query;

import wolf.cfg.hbm.Chat;
import wolf.cfg.hbm.ChatDetail;
import wolf.cfg.hbm.Course;


public class ChatDetailDAO  extends HibernateBaseDAO {
	
	public ChatDetail loadChatDetail(String elchdId){
		return (ChatDetail)this.getSession().get(ChatDetail.class, elchdId);
	}
	public List<ChatDetail>  loadAllChatDetail(){
		return   (List<ChatDetail>) this.qry("from ChatDetail order by elchdId");
	}
	
	public List<ChatDetail>  loadcourseChatDetail(Chat chat){
		return 	(List<ChatDetail>) this.qry("from ChatDetail where elchId='"+chat.getElchId()+"' "); 
	}
	
	public List<ChatDetail>  loadPageChatDetail(Chat chat,int pagesize,int page){
		Query qry =this.getSession().createQuery("from ChatDetail where elchId='"+chat.getElchId()+"'");
		qry.setFirstResult((page-1)*pagesize);  //(page-1)*pagesize
		qry.setMaxResults(pagesize);
		return qry.list();
	}
	
	public int CountChatDetail(Chat chat,int pagesize){
		Query qry = this.getSession().createQuery("select count(*) from ChatDetail where elchId='"+chat.getElchId()+"'");
		int i=(int) qry.uniqueResult();
		int y=pagesize;
		int z=i%y;
		if(z!=0){
			return i/y+1;
		}
		else{
			return i/y;
		}
		
	}
	public int CountAllChatDetail(Chat chat){
		Query qry = this.getSession().createQuery("select count(*) from ChatDetail where elchId='"+chat.getElchId()+"'");
		return (int) qry.uniqueResult();		
	}
	
	public void createChatDetail(ChatDetail chd){
		this.getSession().save(chd);
	}
	
	public void modifyChatDetail(ChatDetail chd){
		this.getSession().update(chd);
	}
	
	public void removeChatDetail(ChatDetail chd){
		this.getSession().delete(chd);
	}

	
	public static void main(String[] args){
		
		
		ChatDetailDAO dao = new ChatDetailDAO();
		Chat chat =new Chat();
		chat.setElchId("53cd568b775042649dfbf08509a66702");
		
		
		int i =dao.CountAllChatDetail(chat);
		System.out.println(i);
		
		
		
	}
}
