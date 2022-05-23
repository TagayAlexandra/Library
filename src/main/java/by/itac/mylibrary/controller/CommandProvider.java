package by.itac.mylibrary.controller;

import by.itac.mylibrary.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.SAVE_BOOK, new SaveBook());
        repository.put(CommandName.FIND_BOOK_BY_ID, new FindBookByID());
        repository.put(CommandName.FIND_BOOK_BY_AUTHOR, new FindBookByAuthor());
        repository.put(CommandName.FIND_BOOK_BY_YEAR_OF_PUBLISHING, new FindBookByYearOfPublising());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(String name) {
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException ex) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }

        return command;
    }

}
