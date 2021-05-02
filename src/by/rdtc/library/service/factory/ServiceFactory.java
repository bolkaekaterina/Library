package by.rdtc.library.service.factory;

import by.rdtc.library.service.BookService;
import by.rdtc.library.service.UserService;
import by.rdtc.library.service.impl.BookServiceImpl;
import by.rdtc.library.service.impl.UserServiceImpl;

public class ServiceFactory {
	
	private static final ServiceFactory instance = new ServiceFactory();
	private final UserService userService = new UserServiceImpl();
	private final BookService bookService = new BookServiceImpl();

	
	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public BookService getBookService() {
		return bookService;
	}
}
