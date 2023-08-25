package lk.ijse.dep10.Review.app.controller;

import lk.ijse.dep10.Review.app.dao.ReviewDao;
import lk.ijse.dep10.Review.app.model.Review;
import lk.ijse.dep10.Review.app.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ReviewDao reviewDao;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        try {

            Review savedReview = reviewDao.save(review);

            return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
