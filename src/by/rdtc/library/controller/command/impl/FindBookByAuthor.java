package by.rdtc.library.controller.command.impl;

import java.util.List;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.BookService;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.factory.ServiceFactory;

public class FindBookByAuthor implements Command {

	@Override
	public String execute(String request) {

		String author = null;
		List<String> response = null;

		String[] parameters = null;

		try {
			parameters = request.split(" ");
			author = parameters[1];
		} catch (NumberFormatException nfe) {
			System.out.println("NumberFormatException: " + nfe.getMessage());
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BookService bookService = serviceFactory.getBookService();

		try {
			response = bookService.findBookByAuthor(author);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		if (response.isEmpty() || response == null) {
			return "Book was not found";
		} else {
			return response.toString();
		}
	}
}
