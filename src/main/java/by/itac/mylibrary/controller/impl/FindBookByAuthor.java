package by.itac.mylibrary.controller.impl;

import by.itac.mylibrary.controller.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.serviceException.ServiceException;

import java.util.Arrays;
import java.util.List;

public class FindBookByAuthor implements Command {
    @Override
    public String execute(String request) {
        ServiceProvider provider = ServiceProvider.getInstance();
        BookService service = provider.getBookService();
        try {
            request = request.substring(request.indexOf(' ') + 1);
          List<Book> bookByAuthor =  service.findByAuthor(request);
          return  (bookByAuthor.isEmpty()) ? "Not book" : bookByAuthor.toString();
        }catch (ServiceException ex){
            return  "error";
        }
    }
}
