package by.rdtc.library.dao.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import by.rdtc.library.bean.User;
import by.rdtc.library.dao.UserDAO;
import by.rdtc.library.dao.exception.DAOException;

public class FileUserDAO implements UserDAO {

	private static String FILE_PATH = "resources/Users.txt";

	@Override
	public void signIn(String login, String password) {

		List<String> users = null;
		boolean userExist = false;

		try {
			users = Files.readAllLines(Paths.get(FILE_PATH));
			for (String user : users) {
				String[] userFields = user.split(";");
				if (login.equals(userFields[0]) && password.equals(userFields[1])) {
					userExist = true;
				}
			}

			if (!userExist) {
				throw new DAOException("User doesn't exist");
			}

		} catch (IOException | DAOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void registration(User user) {

	}

}
