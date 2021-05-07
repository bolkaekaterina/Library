package by.rdtc.library.dao.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import by.rdtc.library.bean.User;
import by.rdtc.library.bean.UserRole;
import by.rdtc.library.dao.UserDAO;
import by.rdtc.library.dao.exception.DAOException;

public class FileUserDAO implements UserDAO {

	private static String FILE_PATH = "resources/Users.txt";

	@Override
	public UserRole signIn(String login, String password) throws DAOException {

		List<String> users = null;
		boolean userExist = false;
		UserRole role = null ;

		try {
			users = Files.readAllLines(Paths.get(FILE_PATH));
			for (String user : users) {
				String[] userFields = user.split(";");
				if (login.equals(userFields[0]) && password.equals(userFields[1])) {
					userExist = true;
					role = UserRole.valueOf(userFields[6].toUpperCase());
				}
			}

			if (!userExist) {
				throw new DAOException("SignIn failed");
			}

		} catch (IOException | DAOException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return role;
	}

	@Override
	public void registration(User user) {
		//TODO	IMPLEMENT
	}

}
