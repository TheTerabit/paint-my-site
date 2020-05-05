package pl.bs.paintmysite.controllers;


import org.springframework.web.bind.annotation.*;
import pl.bs.paintmysite.controllers.msg.ProjectMsg;
import pl.bs.paintmysite.models.Project;
import pl.bs.paintmysite.services.ProjectService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/projects")
public class ProjectEndpoint {

    private final ProjectService projectService;

    public ProjectEndpoint(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @GetMapping("/categories/{categoryId}")
    public List<Project> getByCategoryId(@PathVariable("categoryId") Long categoryId) {
        return projectService.getByCategoryId(categoryId);
    }

    @GetMapping("/{id}")
    public Project getById(@PathVariable("id") Long id) {
        return projectService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody ProjectMsg projectMsg) {
        projectService.create(projectMsg);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody ProjectMsg projectMsg) {
        projectService.update(id, projectMsg);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        projectService.delete(id);
    }
}
