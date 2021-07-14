package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Book;
import repo.BookRepo;

@RestController
public class LiabraryController {

    @Autowired
    BookRepo bookRepo;
    
    @GetMapping("/getBooks")
    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    @PostMapping("/saveBook")
    public Book saveBook(@RequestBody Book bookDetails){
        return bookRepo.save(bookDetails);
    }

    @PostMapping("/editBook")
    public Book editBook(@RequestParam("bookId") String bookId, @RequestBody Book bookDetails){
        Book updateBook = bookRepo.findById(bookId).orElseThrow();
        updateBook.setBookName(bookDetails.getBookName());
        updateBook.setGenre(bookDetails.getGenre());
        updateBook.setQuantity(bookDetails.getQuantity());

        return bookRepo.save(updateBook);
    }

    @PostMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookId") String id){
        Book deleteBook = bookRepo.findById(id).orElseThrow();
        bookRepo.delete(deleteBook);
        return "Deleted Successfully";
    }

    @PostMapping("/getByType")
    public List<Book> getByType(@RequestParam("id") String genre){
        return bookRepo.getByType(genre);
    }
    
}
