package by.rdtc.library.dao;

import by.rdtc.library.bean.User;
import by.rdtc.library.bean.UserRole;
import by.rdtc.library.dao.exception.DAOException;

public interface UserDAO {
	
	public UserRole signIn(String login, String password) throws DAOException;
	public void registration(User user);

}
 