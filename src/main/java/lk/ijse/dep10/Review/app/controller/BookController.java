package lk.ijse.dep10.Review.app.controller;

import lk.ijse.dep10.Review.app.dao.BookDao;
import lk.ijse.dep10.Review.app.model.Book;
import lk.ijse.dep10.Review.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/books")
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    BookDao bookDao;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return bookService.getAllBooks();
    }
     @GetMapping("{id}")
     public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id) {
         return bookService.getBookById(id);
     }


}
