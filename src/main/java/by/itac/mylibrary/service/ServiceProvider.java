package by.itac.mylibrary.service;

import by.itac.mylibrary.service.impl.*;

public final class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();

    private final BookService bookService = new BookServiceImpl();
    private final StatusBookService statusBookService = new StatusBookServiceImpl();

    private ServiceProvider() {
    }

    public static ServiceProvider getInstance() {
        return instance;
    }

    public BookService getBookService() {
        return bookService;
    }

    public StatusBookService getStatusBookService() {
        return statusBookService;
    }
}
