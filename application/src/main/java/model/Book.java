package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
    
    @Id
    @Column(name = "bookId")
    private String bookId;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "genre")
    private String genre;

    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Book(){
        super();
    }

    public Book(String bookId, String quantity, String bookName, String genre) {
        this.bookId = bookId;
        this.quantity = quantity;
        this.bookName = bookName;
        this.genre = genre;
    }
}
