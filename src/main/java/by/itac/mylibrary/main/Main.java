package by.itac.mylibrary.main;

import by.itac.mylibrary.controller.CommandName;
import by.itac.mylibrary.controller.Controller;
import by.itac.mylibrary.dao.exсeption.DAOException;
import by.itac.mylibrary.dao.impl.FileCRUDBookDAOImpl;
import by.itac.mylibrary.dao.impl.FileFindBookDAOImpl;
import by.itac.mylibrary.dao.impl.LibraryHost;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.exception.ServiceException;
import by.itac.mylibrary.service.exception.ValidationException;
import by.itac.mylibrary.service.impl.BookServiceImpl;
import by.itac.mylibrary.service.impl.Validation;

import java.text.ParseException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.executeTask("FIND_BOOK_BY_ID 1");

    }
}
