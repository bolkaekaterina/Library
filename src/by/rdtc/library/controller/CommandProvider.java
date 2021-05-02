package by.rdtc.library.controller;

import java.util.HashMap;
import java.util.Map;

import by.rdtc.library.controller.command.Command;
import by.rdtc.library.controller.command.impl.AddBook;
import by.rdtc.library.controller.command.impl.FindBookByAuthor;
import by.rdtc.library.controller.command.impl.DeleteBookByID;
import by.rdtc.library.controller.command.impl.Register;
import by.rdtc.library.controller.command.impl.SignIn;
import by.rdtc.library.controller.command.impl.WrongRequest;

final class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();

	CommandProvider() {
		repository.put(CommandName.SIGN_IN, new SignIn());
		repository.put(CommandName.REGISTRATION, new Register());
		repository.put(CommandName.ADD_BOOK, new AddBook());
		repository.put(CommandName.FIND_BOOK_BY_AUTHOR, new FindBookByAuthor());
		repository.put(CommandName.DELETE_BOOK_BY_ID, new DeleteBookByID());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
	}

	Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;
		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			// TODO write log
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}

}
