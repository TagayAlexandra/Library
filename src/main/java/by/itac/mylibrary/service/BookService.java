package by.itac.mylibrary.service;

import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.exception.ServiceException;
import by.itac.mylibrary.service.exception.ValidationException;

import java.util.List;

public interface BookService {
    void  save(Book book) throws ServiceException;
    Book findById(int id) throws ServiceException, ValidationException;
    List<Book> findByAuthor(String author) throws ServiceException;
    List<Book> findByYearOfPublishing(int year) throws ServiceException;

}
