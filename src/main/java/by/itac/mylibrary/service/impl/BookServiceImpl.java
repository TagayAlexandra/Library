package by.itac.mylibrary.service.impl;

import by.itac.mylibrary.dao.CRUDBookDAO;
import by.itac.mylibrary.dao.DAOProvider;
import by.itac.mylibrary.dao.FindBookDAO;
import by.itac.mylibrary.dao.exсeption.DAOException;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.exception.ServiceException;
import by.itac.mylibrary.service.exception.ValidationException;


import java.util.List;

public class BookServiceImpl implements BookService {
    private final Validation validation = new Validation();
    private boolean dateValidation;


    @Override
    public void save(Book book) throws ServiceException, ValidationException {
        dateValidation = validation.validBook(book);
        if (dateValidation) {
            DAOProvider provider = DAOProvider.getInstance();
            CRUDBookDAO dao = provider.getBookDAO();
            try {
                dao.save(book);
            } catch (DAOException ex) {
                throw new ServiceException(ex);
            }
        } else {
            throw new ValidationException("ValidBook");
        }


    }

    @Override
    public Book findById(int id) throws ServiceException, ValidationException {
        dateValidation = validation.validId(id);
        if (dateValidation) {
            DAOProvider provider = DAOProvider.getInstance();
            FindBookDAO dao = provider.getFindBookDAO();
            try {
                return dao.findById(id);
            } catch (DAOException ex) {
                throw new ServiceException(ex);
            }
        } else {
            throw new ValidationException("validId");
        }
    }

    @Override
    public List<Book> findByAuthor(String author) throws ServiceException, ValidationException {
        dateValidation = validation.validNull(author);
        if (dateValidation) {
            DAOProvider provider = DAOProvider.getInstance();
            FindBookDAO dao = provider.getFindBookDAO();
            try {
                return dao.findBookByAuthor(author);
            } catch (DAOException ex) {
                throw new ServiceException(ex);
            }
        } else {
            throw new ValidationException("validAuthor");
        }

    }

    @Override
    public List<Book> findByYearOfPublishing(int year) throws ServiceException, ValidationException {
        dateValidation = validation.validYearPublish(year);
        if (dateValidation) {
            DAOProvider provider = DAOProvider.getInstance();
            FindBookDAO dao = provider.getFindBookDAO();
            try {
                return dao.findBookByYearOfPublishing(year);
            } catch (DAOException ex) {
                throw new ServiceException(ex);
            }
        } else {
            throw new ValidationException("validYear");
        }
    }
}