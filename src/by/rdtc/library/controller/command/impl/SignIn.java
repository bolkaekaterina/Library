package by.rdtc.library.controller.command.impl;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.service.UserService;
import by.rdtc.library.service.exception.ServiceException;
import by.rdtc.library.service.factory.ServiceFactory;

public class SignIn implements Command{

	@Override
	public String execute(String request) {
		String login = null;
		String password = null;
		String response = null;

		// get parameters from request and initialize the variables login and password

		String[] parameters = null;
		
		try {
			parameters = request.split(" ");
			login = parameters[1];
			password = parameters[2];
		} catch (Exception e) {
			e.printStackTrace();
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();

		try {
			userService.signIn(login, password);
			response = "Welcome";
		} catch (ServiceException e) {
			e.printStackTrace();
			response = "Error during login procedure";
		}
		return response;
	}
}
