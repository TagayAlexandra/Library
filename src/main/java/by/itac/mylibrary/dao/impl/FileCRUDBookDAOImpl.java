package by.itac.mylibrary.dao.impl;

import by.itac.mylibrary.dao.CRUDBookDAO;
import by.itac.mylibrary.dao.exсeption.DAOException;
import by.itac.mylibrary.entity.Book;

import java.io.IOException;
import java.util.List;

public class FileCRUDBookDAOImpl implements CRUDBookDAO {

    private final LibraryHost libraryHost = LibraryHost.getInstance();
    private  List<Book> library;

    @Override
    public void save(Book book) throws DAOException {
        try {
            library = libraryHost.getLibrary();
            library.add(book);
            libraryHost.updateDateInFile(book);
        } catch (IOException e) {
            throw new DAOException(e);
        }

    }

    @Override
    public void delete(Book book) throws DAOException {
        try {
            library = libraryHost.getLibrary();
            library.remove(book);
            libraryHost.writeListToFile();
        } catch (IOException e) {
            throw new DAOException(e);
        }

    }

    @Override
    public void delete(int id) throws DAOException {
        try {
            library =  libraryHost.getLibrary();
            library.removeIf(book -> book.getId() == id);
            libraryHost.writeListToFile();
        } catch (IOException e) {
            throw new DAOException(e);
        }

    }

}
