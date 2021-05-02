package by.rdtc.library.service.impl;

import by.rdtc.library.bean.User;
import by.rdtc.library.dao.UserDAO;
import by.rdtc.library.dao.factory.DAOFactory;
import by.rdtc.library.service.UserService;
import by.rdtc.library.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

	@Override
	public void signIn(String login, String password) throws ServiceException {

		if (login == null || login.isEmpty()) {
			throw new ServiceException("Incorrect login");
		}

		if (password == null || password.isEmpty()) {
			throw new ServiceException("Incorrect password");
		}

		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoObjectFactory.getUserDAO();
			userDAO.signIn(login, password);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void singOut(String login) throws ServiceException {

	}

	@Override
	public void registration(User user) throws ServiceException {

	}

}
