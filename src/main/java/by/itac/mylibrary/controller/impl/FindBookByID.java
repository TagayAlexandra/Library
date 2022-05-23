package by.itac.mylibrary.controller.impl;

import by.itac.mylibrary.controller.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;
import by.itac.mylibrary.service.exception.ValidationException;

import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Level.WARNING;

public class FindBookByID implements Command {
    private final char paramDelimeter = ' ';

    @Override
    public String execute(String request) {
        String response;
        String date = request.substring(request.indexOf(paramDelimeter) + 1);
        int id = Integer.parseInt(date);
        ServiceProvider provider = ServiceProvider.getInstance();
        BookService service = provider.getBookService();
        try {
            Book book = service.findById(id);
            response = (book == null) ? "Not book" : book.toString();
        } catch (ServiceException ex) {
            // log
            response = "service problem. Wait ";
        } catch (ValidationException e) {
            response = "wrong date ";
        }
        return response;
    }
}
