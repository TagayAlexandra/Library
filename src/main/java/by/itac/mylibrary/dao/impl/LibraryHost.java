package by.itac.mylibrary.dao.impl;

import by.itac.mylibrary.dao.exсeption.DAOException;
import by.itac.mylibrary.entity.Book;

import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LibraryHost {

    private static LibraryHost instance = null;

    private final List<Book> library = new ArrayList<>();
    private final String paramDeliter = "__";
    private boolean flag = false;

    private LibraryHost() {
    }

    public static LibraryHost getInstance() {
        if (instance == null) {
            instance = new LibraryHost();
        }
        return instance;

    }

    public List<Book> getLibrary() throws IOException {
        if (!flag) {
            readFileToList();
            flag = true;
        }
        return library;
    }

    private String getFileName() throws IOException {
        String fileName;
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(fileInputStream);
            fileName = properties.getProperty("host");
        }
        return fileName;
    }

    private void readFileToList() throws IOException {
        int dateID = 0;
        int author = 1;
        int bookName = 2;
        int yearOfPublishing = 3;
        int status = 4;
        String fileName = getFileName();
        try (BufferedReader buffer = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                String[] dateBook = line.split(paramDeliter);
                library.add(new Book(Integer.parseInt(dateBook[dateID]),
                        dateBook[author], dateBook[bookName],
                        Integer.parseInt(dateBook[yearOfPublishing]),
                        dateBook[status]));
            }
        }
    }

    public void writeListToFile() throws IOException {
        String fileName = getFileName();
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Book book : library) {
                StringBuilder dateToWrite = new StringBuilder();
                dateToWrite.append(book.getId()).append(paramDeliter).
                        append(book.getAuthor()).append(paramDeliter).
                        append(book.getBookName()).append(paramDeliter).
                        append(book.getYearOfPublishing()).append(paramDeliter).
                        append(book.getStatus()).append(paramDeliter).append("\n");
                writer.write(dateToWrite.toString());
            }
        }
    }

    public void updateDateInFile(Book book) throws IOException {
        String fileName = getFileName();
        try (FileWriter writer = new FileWriter(fileName, true)) {
            StringBuilder dateToWrite = new StringBuilder();
            dateToWrite.append(book.getId()).append(paramDeliter).
                    append(book.getAuthor()).append(paramDeliter).
                    append(book.getBookName()).append(paramDeliter).
                    append(book.getYearOfPublishing()).append(paramDeliter).
                    append(book.getStatus()).append(paramDeliter).append("\n");
            writer.write(dateToWrite.toString());

        }
    }

}
