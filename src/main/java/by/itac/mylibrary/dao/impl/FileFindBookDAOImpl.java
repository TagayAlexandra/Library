package by.itac.mylibrary.dao.impl;

import by.itac.mylibrary.dao.FindBookDAO;
import by.itac.mylibrary.dao.excaptionDao.DAOException;
import by.itac.mylibrary.entity.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileFindBookDAOImpl implements FindBookDAO {

    private final List<Book> library = new ArrayList<>();

    @Override
    public Book findById(int id) throws DAOException {
        readFileToList();
        for (Book book : library){
            if (book.getId() == id){
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> findBookByAuthor(String author) throws DAOException {
        readFileToList();
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
        readFileToList();
        List<Book> bookByYearOfPublishing = new ArrayList<>();
        for (Book book :library){
            if (book.getYearOfPublishing() == year){
                bookByYearOfPublishing.add(book);
            }
        }
        return bookByYearOfPublishing;
    }


    private void readFileToList() throws DAOException {
        String fileName = "myLibrary.txt";
       try (BufferedReader buffer = new BufferedReader(new FileReader(fileName))){
           String line;
           while ((line = buffer.readLine())!=null) {
               String[] dateBook = line.split("__");
               library.add(new Book(Integer.parseInt(dateBook[0]), dateBook[1], dateBook[2], Integer.parseInt(dateBook[3]), dateBook[4]));
           }
        }catch (IOException ex){
           throw new DAOException(ex);
       }

    }
}
