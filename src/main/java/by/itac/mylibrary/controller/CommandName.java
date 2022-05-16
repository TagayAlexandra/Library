package by.itac.mylibrary.controller;

public enum CommandName {
    SAVE_BOOK,
    FIND_BOOK_BY_ID,
    FIND_BOOK_BY_AUTHOR,
    FIND_BOOK_BY_YEAR_OF_PUBLISHING,
    WRONG_REQUEST,
    ;

    public String commandName;


    @Override
    public String toString() {
        return "CommandName{" +
                "commandName='" + commandName + '\'' +
                '}';
    }
}
