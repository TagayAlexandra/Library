package by.itac.mylibrary.dao.impl;

import by.itac.mylibrary.dao.FindBookDAO;
import by.itac.mylibrary.dao.exсeption.DAOException;
import by.itac.mylibrary.entity.Book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileFindBookDAOImpl implements FindBookDAO {

    private final LibraryHost libraryHost = LibraryHost.getInstance();
    private  List<Book> library;

    @Override
    public Book findById(int id) throws DAOException {
        try {
            library = libraryHost.getLibrary();
        } catch (IOException e) {
            throw new DAOException(e);
        }
        for (Book book : library){
            if (book.getId() == id){
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> findBookByAuthor(String author) throws DAOException {
        try {
            library = libraryHost.getLibrary();
        } catch (IOException e) {
            throw new DAOException(e);
        }
        List<Book> bookByAuthor = new ArrayList<>();
        for (Book book : library) {
            if (book.getAuthor().equals(author)) {
                bookByAuthor.add(book);
            }
        }
        return bookByAuthor;
    }

    @Override
    public List<Book> findBookByYearOfPublishing(int year) throws DAOException {
        try {
            library = libraryHost.getLibrary();
        } catch (IOException e) {
            throw new DAOException(e);
        }
        List<Book> bookByYearOfPublishing = new ArrayList<>();
        for (Book book :library){
            if (book.getYearOfPublishing() == year){
                bookByYearOfPublishing.add(book);
            }
        }
        return bookByYearOfPublishing;
    }
}
