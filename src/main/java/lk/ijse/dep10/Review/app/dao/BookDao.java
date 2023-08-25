package lk.ijse.dep10.Review.app.dao;

import lk.ijse.dep10.Review.app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

}
