package by.itac.mylibrary.service;

import by.itac.mylibrary.dao.excaptionDao.DAOException;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.serviceException.ServiceException;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void  save(Book book) throws ServiceException;
    Book findById(int id) throws ServiceException;
    List<Book> findByAuthor(String author) throws ServiceException;
    List<Book> findByYearOfPublishing(int year) throws ServiceException;

}
