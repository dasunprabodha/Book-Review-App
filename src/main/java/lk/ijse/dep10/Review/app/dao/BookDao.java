package lk.ijse.dep10.Review.app.dao;

import lk.ijse.dep10.Review.app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

    Optional<Book> findByIsbn(String isbn);
}
