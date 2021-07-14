package repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,String> {
    @Query("select b from Book b where b.genre=:data")
    public List<Book> getByType(@Param("data") String genre);
}
