package by.itac.mylibrary.controller.impl;

import by.itac.mylibrary.controller.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;

public class SaveBook implements Command {


    @Override
    public String execute(String request) {
        String response;
        char paramDelimeter = ' ';
        String[] dateBook = request.split(String.valueOf(paramDelimeter));
        int dateID = 1;
        int author = 2;
        int bookName = 3;
        int yearOfPublishing = 4;
        int status = 5;
        Book book = new Book(Integer.parseInt(dateBook[dateID]),
                dateBook[author],
                dateBook[bookName],
                Integer.parseInt(dateBook[yearOfPublishing]),
                dateBook[status]);
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        BookService bookService = serviceProvider.getBookService();
        try {
            bookService.save(book);
            response = "Book save";
        } catch (ServiceException e) {
            //log
            response = "Book not save";
        }
        return response;
    }
}
