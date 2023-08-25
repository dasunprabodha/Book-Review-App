package lk.ijse.dep10.Review.app.service;

import lk.ijse.dep10.Review.app.dao.BookDao;
import lk.ijse.dep10.Review.app.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
   private BookDao bookDao;

    public ResponseEntity<List<Book>> getAllBooks() {
        try {

            List<Book> books = bookDao.findAll();
            return new ResponseEntity<>(books, HttpStatus.OK);        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public ResponseEntity<Book> getBookById(Integer id) {
        try {
            Optional<Book> optionalBook = bookDao.findById(id);

            if (optionalBook.isPresent()) {
                return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Book> getBookByIsbn(String isbn) {
        try {
            Optional<Book> optionalBook = bookDao.findByIsbn(isbn);

            if (optionalBook.isPresent()) {
                return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    }

