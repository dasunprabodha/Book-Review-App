package lk.ijse.dep10.Review.app.controller;

import lk.ijse.dep10.Review.app.dao.BookDao;
import lk.ijse.dep10.Review.app.dao.ReviewDao;
import lk.ijse.dep10.Review.app.model.Book;
import lk.ijse.dep10.Review.app.model.Review;
import lk.ijse.dep10.Review.app.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ReviewDao reviewDao;

    @Autowired
    BookDao bookDao;

    @PostMapping("/{book_id}")
    public ResponseEntity<Review> createReview(@PathVariable("book_id") Integer bookId, @RequestBody Review review) {
        try {
            Optional<Book> optionalBook = bookDao.findById(bookId);

            if (!optionalBook.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Book book = optionalBook.get();
            review.setBook(book);

            Review savedReview = reviewDao.save(review);
            return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}