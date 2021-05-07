package by.rdtc.library.dao;

import java.util.List;

import by.rdtc.library.bean.Book;
import by.rdtc.library.bean.UserRole;
import by.rdtc.library.dao.exception.DAOException;

public interface BookDAO {

	void addBook(Book book) throws DAOException;

	boolean deleteBook(long idBook) throws DAOException;

	List<String> findBookByAuthor(String author, UserRole role) throws DAOException;

}
