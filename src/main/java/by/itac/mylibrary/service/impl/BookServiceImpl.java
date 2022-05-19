package by.itac.mylibrary.service.impl;

import by.itac.mylibrary.dao.CRUDBookDAO;
import by.itac.mylibrary.dao.DAOProvider;
import by.itac.mylibrary.dao.FindBookDAO;
import by.itac.mylibrary.dao.exсeption.DAOException;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.exception.ServiceException;


import java.util.List;

public class BookServiceImpl implements BookService {


    @Override
    public void save(Book book) throws  ServiceException {


        DAOProvider provider = DAOProvider.getInstance();
        CRUDBookDAO dao = provider.getBookDAO();
        try {
            dao.save(book);
        }catch (DAOException ex){
            throw new ServiceException(ex);
        }


    }

    @Override
    public Book findById(int id) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        FindBookDAO dao = provider.getFindBookDAO();
        try {
            return dao.findById(id);
        }catch (DAOException ex){
            throw new ServiceException(ex);
        }
    }

    @Override
    public List<Book> findByAuthor(String author) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        FindBookDAO dao = provider.getFindBookDAO();
        try {
            return dao.findBookByAuthor(author);
        }catch (DAOException ex){
            throw new ServiceException(ex);
        }

    }

    @Override
    public List<Book> findByYearOfPublishing(int year) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        FindBookDAO dao = provider.getFindBookDAO();
        try {
            return dao.findBookByYearOfPublishing(year);
        }catch (DAOException ex){
            throw new ServiceException(ex);
        }

    }


}

