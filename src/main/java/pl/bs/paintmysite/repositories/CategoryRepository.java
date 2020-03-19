package pl.bs.paintmysite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bs.paintmysite.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
