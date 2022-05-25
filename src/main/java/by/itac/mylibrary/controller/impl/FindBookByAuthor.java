package by.itac.mylibrary.controller.impl;

import by.itac.mylibrary.controller.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;
import by.itac.mylibrary.service.exception.ValidationException;

import java.util.List;

public class FindBookByAuthor implements Command {
    private final char paramDelimeter = ' ';
    @Override
    public String execute(String request) {
        String response;
        ServiceProvider provider = ServiceProvider.getInstance();
        BookService service = provider.getBookService();
        try {
            request = request.substring(request.indexOf(paramDelimeter) + 1);
          List<Book> bookByAuthor =  service.findByAuthor(request);
          response = (bookByAuthor.isEmpty()) ? "Not book" : bookByAuthor.toString();
        }catch (ServiceException ex){
            // log
           response =  "error";
        } catch (ValidationException e) {
            response = "wrong date";
        }
        return response;
    }
}
