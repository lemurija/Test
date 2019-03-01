package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;

@WebServlet(
		description = "Knygu sarasa isveda i tinklapi.", 
		urlPatterns = { 
				"/BookServlet", 
				"/BookShop"
		})
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	private BookDAO bookDao;
	private int place;
       
    public BookServlet() {
    	bookDao=new BookDAO();    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String action=request.getParameter("action");		
		
		if(action==null)
    		action="";
		
		switch(action){
		case "showinsertform":
			showInsertForm(request, response);
			break;
		case "insertbook":
			insertBook(request, response);
			break;
		case "delete":
			deleteBook(request, response);
			break;
		case "showupdate":
			place=Integer.parseInt(request.getParameter("bookid"));
			updateForm(request, response);
			break;
		case "update":
			updateBook(request, response);
			break;
		case "searchform":
			searchform(request, response);
			break;
		case "search":
			search(request, response);
			break;
		default:
			getAllBooks(request, response);
		}		
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choise= request.getParameter("choise");	
		String search=request.getParameter("search");
		List<Book> listOfBooks = bookDao.search(search, choise);
									
		if(listOfBooks.isEmpty()) {
			choise="";
		}
		else
			request.setAttribute("listOfBooks", listOfBooks);
		
		request.setAttribute("choise", choise);
		RequestDispatcher dispatcher=request.getRequestDispatcher("\\WEB-INF\\view\\searchForm.jsp");
		dispatcher.forward(request, response);
	}
	
	private void searchform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("\\WEB-INF\\view\\searchForm.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void getAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> listOfBooks= bookDao.getAllBooks();		
		request.setAttribute("listOfBooks", listOfBooks);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("\\WEB-INF\\view\\viewBooks.jsp");
		dispatcher.forward(request, response);
	}

	private void showInsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("\\WEB-INF\\view\\insertBook.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title= request.getParameter("title");
		String author= request.getParameter("author");
		String description= request.getParameter("description");
		BigDecimal price= new BigDecimal(request.getParameter("price"));
		
		Book book=new Book(title, author, description, price);
		
		bookDao.insertBook(book);
		response.sendRedirect("BookServlet?action=");
	}
	
	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookid=Integer.parseInt(request.getParameter("bookid"));
		
		bookDao.delete(bookid);
		response.sendRedirect("BookServlet?action=");
	}
	
	private void updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		place=Integer.parseInt(request.getParameter("bookid"));	
		
		Book book= bookDao.updateForm(place);
		request.setAttribute("book", book);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("\\WEB-INF\\view\\updateBook.jsp");
		dispatcher.forward(request, response);
	}
	
	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title= request.getParameter("title");
		String author= request.getParameter("author");
		String description= request.getParameter("description");
		BigDecimal price= new BigDecimal(request.getParameter("price"));
		
		Book book=new Book(place, title, author, description, price);
		
		bookDao.update(book);
		response.sendRedirect("BookServlet?action=");
	}
}
