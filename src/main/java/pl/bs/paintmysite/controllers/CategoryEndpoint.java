package pl.bs.paintmysite.controllers;

import org.springframework.web.bind.annotation.*;
import pl.bs.paintmysite.controllers.msg.CategoryMsg;
import pl.bs.paintmysite.models.Category;
import pl.bs.paintmysite.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryEndpoint {

    private final CategoryService categoryService;

    public CategoryEndpoint(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable("id") Long id) {
        return categoryService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody CategoryMsg categoryMsg) {
        categoryService.create(categoryMsg);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody CategoryMsg categoryMsg) {
        categoryService.update(id, categoryMsg);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        categoryService.delete(id);
    }



}
