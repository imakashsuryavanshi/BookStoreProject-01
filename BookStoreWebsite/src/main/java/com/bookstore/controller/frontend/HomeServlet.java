package com.bookstore.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.dao.BookDAO;
import com.bookstore.entity.Book;

@WebServlet("")
public class HomeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BookDAO bookDAO = new BookDAO();
		
		List<Book> listNewBooks = bookDAO.listNewBooks();
		List<Book> listBestSellingBooks = bookDAO.listBestSellingBooks();
		List<Book> listFavoredBooks = bookDAO.listMostFavoredBooks();
		
		request.setAttribute("listNewBooks", listNewBooks);
		request.setAttribute("listBestSellingBooks", listBestSellingBooks);
		request.setAttribute("listFavoredBooks", listFavoredBooks);
		
		String homePage = "frontend/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(homePage);
		dispatcher.forward(request, response);
	}

}
