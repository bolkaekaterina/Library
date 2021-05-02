package by.rdtc.library.dao.factory;

import by.rdtc.library.dao.BookDAO;
import by.rdtc.library.dao.UserDAO;
import by.rdtc.library.dao.impl.FileBookDAO;
import by.rdtc.library.dao.impl.FileUserDAO;

public final class DAOFactory {
	private static final DAOFactory instsnce = new DAOFactory();
	
	private final BookDAO fileBookImpl = new FileBookDAO();
	private final UserDAO fileUserImpl = new FileUserDAO();
	
	private DAOFactory() {}
	
	public static DAOFactory getInstance() {
		return instsnce;
	}
	
	public BookDAO getBookDAO() {
		return fileBookImpl;
	}
	
	public UserDAO getUserDAO() {
		return fileUserImpl;
	}

}
