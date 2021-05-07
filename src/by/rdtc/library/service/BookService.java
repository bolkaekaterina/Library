package by.rdtc.library.service;

import java.util.List;

import by.rdtc.library.bean.Book;
import by.rdtc.library.bean.UserRole;
import by.rdtc.library.service.exception.ServiceException;

public interface BookService {
	void addBook(Book book) throws ServiceException;
	boolean deleteBook(long idBook) throws ServiceException;
	List<String> findBookByAuthor(String author, UserRole role) throws ServiceException;

}
