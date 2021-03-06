package pl.bs.paintmysite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bs.paintmysite.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User getUserById(Long id);
}
