package pl.bs.paintmysite.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.bs.paintmysite.controllers.msg.ProjectMsg;
import pl.bs.paintmysite.models.Project;
import pl.bs.paintmysite.repositories.ProjectRepository;

import java.util.Collections;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public List<Project> getByCategoryId(Long categoryId) {
        return projectRepository.findAllByCategoryId(categoryId);
    }

    public Project getById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Such Project does not exist."));
    }

    public void create(ProjectMsg projectMsg) {
        Project project = new Project();
        project.setCategoryId(projectMsg.getCategoryId());
        project.setDescription(projectMsg.getDescription());
        project.setName(projectMsg.getName());
        project.setPhotos(Collections.emptyList());
        projectRepository.save(project);
    }

    public void update(Long id, ProjectMsg projectMsg) {
        Project project = new Project();
        project.setCategoryId(projectMsg.getCategoryId());
        project.setDescription(projectMsg.getDescription());
        project.setName(projectMsg.getName());
        project.setId(id);
        project.setPhotos(projectRepository.findById(id).orElseThrow(()-> new RuntimeException("Such project does not exist.")).getPhotos());
        projectRepository.save(project);
    }

    public void delete(Long id) {
        projectRepository.deleteById(id);
    }
}
