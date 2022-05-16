package by.itac.mylibrary.controller.impl;

import by.itac.mylibrary.controller.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.serviceException.ServiceException;

import java.io.IOException;
import java.util.List;

public class FindBookByYearOfPublising implements Command {
    @Override
    public String execute(String request) {
        String response;
        String date = request.substring(request.indexOf(' ')+ 1);
        int yearOfPublishing = Integer.parseInt(date);
        ServiceProvider provider = ServiceProvider.getInstance();
        BookService service = provider.getBookService();
        try {
            List<Book> bookByYear =  service.findByYearOfPublishing(yearOfPublishing);
            response = (bookByYear.isEmpty()) ? "Not book" : bookByYear.toString();
        }catch (ServiceException ex){
            response = "error";
        }


        return response;
    }
}
