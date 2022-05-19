package by.itac.mylibrary.service.impl;

import by.itac.mylibrary.entity.Book;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Validation {

    public void yearValid(Book book){

    }
    public boolean yearValid(int date) throws ParseException {
        String dateFormat = "yyyy";
       try {
           DateFormat dateFormat1 = new SimpleDateFormat(dateFormat);
           dateFormat1.setLenient(false);
           dateFormat1.parse(String.valueOf(date));
           return true;
       }catch (ParseException ex) {
           return false;
       }




    }
    public void yearValid(String date){

    }

}
