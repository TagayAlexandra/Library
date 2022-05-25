package by.itac.mylibrary.service;

import by.itac.mylibrary.service.exception.ServiceException;
import by.itac.mylibrary.service.exception.ValidationException;

public interface StatusBookService {
    void changeToRead(int id) throws ServiceException, ValidationException;
}
