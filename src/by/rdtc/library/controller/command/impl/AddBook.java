package by.rdtc.library.controller.command.impl;

import java.util.Date;

import by.rdtc.library.bean.Book;
import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.BookService;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.factory.ServiceFactory;

public class AddBook implements Command {

	@Override
	public String execute(String request) {
		
		long idBook = 0;
		String bookName = null;
		String author = null;
		int numberOfPages = 0; 
		int year = 0; 
		String response = null;

		String[] parameters = null;
		
		//TODO Add validation of parsed request Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
		
		try {
			parameters = request.split(" ");
			idBook = generateUniqueID();
			bookName = parameters[1];
			author = parameters[2];
			numberOfPages = Integer.parseInt(parameters[3]);
			year = Integer.parseInt(parameters[4]);

		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
			System.out.println("NumberFormatException: " + nfe.getMessage());
		}
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BookService bookService = serviceFactory.getBookService();
		
		Book newBook = new Book(idBook, bookName, author, numberOfPages, year);

		try {
			bookService.addBook(newBook);
			response = "Book added";
		} catch (ServiceException e) {
			e.printStackTrace();
			response = "Error: book was not added";
		}
		
		return response;
	}

	private long generateUniqueID() {
				
	  Date now = new Date();
	  long time = now.getTime();
	  
		
		return time;
	}

}
