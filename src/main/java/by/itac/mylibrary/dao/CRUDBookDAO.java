package by.itac.mylibrary.dao;

import by.itac.mylibrary.dao.excaptionDao.DAOException;
import by.itac.mylibrary.entity.Book;

import java.io.IOException;

public interface CRUDBookDAO {
    void save(Book book) throws DAOException;
    void  delete(Book book) throws DAOException;
    void delete(int id) throws DAOException;
}
