package by.rdtc.library;

import by.rdtc.library.controller.Controller;

public class Main {

	public static void main(String[] args) {

		Controller controller = new Controller();
		String role = null;
		String response = null;

		String message = "SIGN_IN;Nick5;2222";
		role = controller.executeTask(message);
		System.out.println(role);

		role = "admin";
		String message2 = "ADD_BOOK;aaa;ddd;457;2000;common;" + role;
		response = controller.executeTask(message2);
		System.out.println(response);

		role = "admin";
		String message3 = "DELETE_BOOK_BY_ID;10;" + role;
		response = controller.executeTask(message3);
		System.out.println(response);

		role = "child";
		String message4 = "FIND_BOOK_BY_AUTHOR;Николай Гоголь;" + role;
		response = controller.executeTask(message4);
		System.out.println(response);
	}
}
