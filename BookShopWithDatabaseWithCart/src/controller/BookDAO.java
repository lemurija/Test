package controller;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Book;

public class BookDAO {
	
	public List<Book> getAllBooks(){
		List<Book> booklist=new ArrayList<>();
		Session session= HybernateUtil.getSessionFactory().openSession();
		
		try{
			Query<Book> query=session.createQuery("from Book");
			booklist=query.list();
		}catch(HibernateException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return booklist;
	}
	
	public void insertBook(Book book){
		Session session= HybernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		
		try {
			tx=	session.beginTransaction();
			Integer id =(Integer)session.save(book);
			tx.commit();
		}catch(HibernateException e) {
			if(tx !=null)
				tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}				
	}
	
	public void delete(int id){
		Session session= HybernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		
		try {
			tx=	session.beginTransaction();
			Book book=session.get(Book.class, id);
			session.delete(book);
			tx.commit();
		}catch(HibernateException e) {
			if(tx !=null)
				tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public Book updateForm(int id){
		Session session= HybernateUtil.getSessionFactory().openSession();
		Book book=session.get(Book.class, id);		
		session.close();		
		return book;
	}
	
	public void update(Book book){
		Session session= HybernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		
		try {
			tx=	session.beginTransaction();
			session.update(book);
			tx.commit();
		}catch(HibernateException e) {
			if(tx !=null)
				tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public List<Book> search(String info, String choise) {
		Query<Book> query;
	    List<Book> booklist=new ArrayList<>();
		Session session= HybernateUtil.getSessionFactory().openSession();
		
		try{
			if(choise.equals("title"))
				query=session.createQuery("from Book where title like '%"+info+"%'");
			else
				query=session.createQuery("from Book where author like '%"+info+"%'");				
			booklist=query.list();
		}catch(HibernateException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}	
		
		return booklist;
	}
}
