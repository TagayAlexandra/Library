package by.itac.mylibrary.controller.impl;

import by.itac.mylibrary.controller.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;

public class FindBookByID implements Command {
    private final char paramDelimeter = ' ';
    @Override
    public String execute(String request) {
        String response;
         String date = request.substring(request.indexOf(paramDelimeter)+ 1);
        int id = Integer.parseInt(date);
         ServiceProvider provider = ServiceProvider.getInstance();
         BookService service = provider.getBookService();
        try {
         Book book = service.findById(id);
         response =  (book == null) ? "Not book" : book.toString();
        }
        catch (ServiceException ex) {
            response =  "fail";
        }
        return response;
    }
}
