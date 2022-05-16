package by.itac.mylibrary.dao;

import by.itac.mylibrary.dao.impl.FileCRUDBookDAOImpl;
import by.itac.mylibrary.dao.impl.FileFindBookDAOImpl;

public final class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();

    private final CRUDBookDAO bookDAO = new FileCRUDBookDAOImpl();
    private final FindBookDAO findBookDAO = new FileFindBookDAOImpl();

    private DAOProvider() {
    }

    public CRUDBookDAO getBookDAO() {
        return bookDAO;
    }

    public FindBookDAO getFindBookDAO() {
        return findBookDAO;
    }

    public static DAOProvider getInstance() {
        return instance;
    }
}
