package by.rdtc.library.service;

import by.rdtc.library.bean.User;
import by.rdtc.library.bean.UserRole;
import by.rdtc.library.service.exception.ServiceException;

public interface UserService {
	
	UserRole signIn(String login, String password) throws ServiceException;
	void singOut(String login) throws ServiceException;
	void registration(User user) throws ServiceException;
	

}
