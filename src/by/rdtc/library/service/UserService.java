package by.rdtc.library.service;

import by.rdtc.library.bean.User;
import by.rdtc.library.service.exception.ServiceException;

public interface UserService {
	
	void signIn(String login, String password) throws ServiceException;
	void singOut(String login) throws ServiceException;
	void registration(User user) throws ServiceException;
	

}
