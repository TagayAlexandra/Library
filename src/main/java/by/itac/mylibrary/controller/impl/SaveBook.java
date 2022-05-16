package by.itac.mylibrary.controller.impl;

import by.itac.mylibrary.controller.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.serviceException.ServiceException;

public class SaveBook implements Command {


    @Override
    public String execute(String request) {
        String response;
        String[] dateBook = request.split(" ");
        Book book = new Book(Integer.parseInt(dateBook[1]), dateBook[2], dateBook[3], Integer.parseInt(dateBook[4]), dateBook[5]);
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        BookService bookService = serviceProvider.getBookService();
        try {
            bookService.save(book);
            response = "Book save";
        } catch (ServiceException e) {
            response = "Book not save";
        }
        return response;
    }
}
