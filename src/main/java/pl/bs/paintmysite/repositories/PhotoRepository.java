package pl.bs.paintmysite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bs.paintmysite.models.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
