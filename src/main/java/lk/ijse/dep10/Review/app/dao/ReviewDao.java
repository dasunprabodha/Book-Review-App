package lk.ijse.dep10.Review.app.dao;

import lk.ijse.dep10.Review.app.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewDao extends JpaRepository<Review, Integer> {
    Review save(Review review);
}
