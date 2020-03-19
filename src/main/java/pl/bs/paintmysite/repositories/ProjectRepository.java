package pl.bs.paintmysite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bs.paintmysite.models.Project;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    public List<Project> findAllByCategoryId(Long categoryId);
}
