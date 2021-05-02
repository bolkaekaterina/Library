package by.rdtc.library;

import by.rdtc.library.controller.Controller;

public class main {

	public static void main(String[] args) {

		/*
		 * UserServiceImpl userService = new UserServiceImpl();
		 * userService.signIn("Adam31", "4444");
		 * 
		 * Book newBook = new Book(11, "aaaaa", "bbbbb", 555, 2222); FileBookDAO dao =
		 * new FileBookDAO(); dao.addBook(newBook); dao.deleteBook(newBook.getIdBook());
		 */

		Controller controller = new Controller();

		/*
		 * String message = "SIGN_IN Nick5 2222"; controller.executeTask(message);
		 * 
		 * String message2 = "ADD_BOOK aaa ddd 457 2000";
		 * controller.executeTask(message2);
		 */

		/*
		 * String message3 = "DELETE_BOOK_BY_ID 1619990987102";
		 * System.out.println(controller.executeTask(message3));
		 */

		
		  String message4 = "FIND_BOOK_BY_AUTHOR Эрих Мариа Ремарк";
		  System.out.println(controller.executeTask(message4));
		 
	}

}
