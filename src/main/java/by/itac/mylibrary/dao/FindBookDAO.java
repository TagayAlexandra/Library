package by.itac.mylibrary.dao;

import by.itac.mylibrary.dao.exсeption.DAOException;
import by.itac.mylibrary.entity.Book;

import java.util.List;

public interface FindBookDAO {
    Book findById(int id) throws DAOException;
    List<Book> findBookByAuthor(String author) throws DAOException;
    List<Book> findBookByYearOfPublishing(int year) throws DAOException;
}
