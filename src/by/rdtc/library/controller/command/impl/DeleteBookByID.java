package by.rdtc.library.controller.command.impl;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.BookService;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.factory.ServiceFactory;

public class DeleteBookByID implements Command {

	@Override
	public String execute(String request) {

		long idBook = 0;
		String response = null;
		boolean success = false;

		String[] parameters = null;

		try {
			parameters = request.split(" ");
			idBook = Long.parseLong(parameters[1]);
		} catch (NumberFormatException nfe) {
			System.out.println("NumberFormatException: " + nfe.getMessage());
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BookService bookService = serviceFactory.getBookService();

		try {
			success = bookService.deleteBook(idBook);
			if(success){
				response = "Book with ID = " + idBook + " deleted ";
			} else {
				response = "Book with id=" + idBook + " was not found";
			}
			
		} catch (ServiceException e) {
			e.printStackTrace();
			response = "Error: book was not deleted4";
		}

		return response;
	}
	
	
	

}
