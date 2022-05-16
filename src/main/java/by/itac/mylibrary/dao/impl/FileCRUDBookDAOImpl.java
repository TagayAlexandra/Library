package by.itac.mylibrary.dao.impl;

import by.itac.mylibrary.dao.CRUDBookDAO;
import by.itac.mylibrary.dao.excaptionDao.DAOException;
import by.itac.mylibrary.entity.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCRUDBookDAOImpl implements CRUDBookDAO {

    private final List<Book> library = new ArrayList<>();

    @Override
    public void save(Book book) throws DAOException {
        String fileName = "myLibrary.txt";
        try (FileWriter writer = new FileWriter(fileName,true)){
            writer.write(book.getId() + "__" +
                    book.getAuthor() + "__" +
                    book.getBookName() + "__" +
                    book.getYearOfPublishing()+ "__" +
                    book.getStatus() + "\n");

        }catch (IOException ex){
            throw new DAOException(ex);
        }
    }

    @Override
    public void delete(Book book) throws DAOException {
        readFileToList();
        library.remove(book);
        writeListToFile();
    }

    @Override
    public void delete(int id) throws DAOException {
        readFileToList();
        library.removeIf(book -> book.getId() == id);
        writeListToFile();

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

    private void writeListToFile() throws DAOException {
        String fileName = "myLibrary.txt";
        try (FileWriter writer = new FileWriter(fileName)){
            for (Book book:library){
                writer.write(book.getId() + "__" +
                        book.getAuthor() + "__" +
                        book.getBookName() + "__" +
                        book.getYearOfPublishing()+ "__" +
                        book.getStatus() + "\n");
            }
        }catch (IOException ex){
            throw new DAOException(ex);
        }
    }
}
