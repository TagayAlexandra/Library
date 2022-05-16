package by.itac.mylibrary.entity;

import java.util.Objects;

public class Book {
    private int id;
    private String author;
    private String bookName;
    private int yearOfPublishing;
    private String status;

    public Book(int id, String author, String bookName, int yearOfPublishing, String status) {
        this.id = id;
        this.author = author;
        this.bookName = bookName;
        this.yearOfPublishing = yearOfPublishing;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && yearOfPublishing == book.yearOfPublishing && Objects.equals(author, book.author) && Objects.equals(bookName, book.bookName) && Objects.equals(status, book.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, bookName, yearOfPublishing, status);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", bookName='" + bookName + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                ", status='" + status + '\'' +
                '}';
    }
}
