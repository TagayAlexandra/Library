package by.itac.mylibrary.controller.impl;

import by.itac.mylibrary.controller.Command;
import by.itac.mylibrary.dao.excaptionDao.DAOException;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.serviceException.ServiceException;

import java.io.IOException;

public class FindBookByID implements Command {
    @Override
    public String execute(String request) {
         String date = request.substring(request.indexOf(' ')+ 1);
        int id = Integer.parseInt(date);
         ServiceProvider provider = ServiceProvider.getInstance();
         BookService service = provider.getBookService();
        try {
         Book book = service.findById(id);
         return (book == null) ? "Not book" : book.toString();
        }
        catch (ServiceException ex) {
            return "fail";
        }
    }
}
