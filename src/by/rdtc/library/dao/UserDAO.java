package by.rdtc.library.dao;

import by.rdtc.library.bean.User;

public interface UserDAO {
	
	public void signIn(String login, String password);
	public void registration(User user);

}
 