package pl.bs.paintmysite.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.bs.paintmysite.controllers.msg.CategoryMsg;
import pl.bs.paintmysite.models.Category;
import pl.bs.paintmysite.models.User;
import pl.bs.paintmysite.repositories.CategoryRepository;

import java.util.Collections;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }


    public void create(CategoryMsg categoryMsg) {
        ModelMapper modelMapper = new ModelMapper();
        Category category = modelMapper.map(categoryMsg, Category.class);
        category.setProjects(Collections.emptyList());
        categoryRepository.save(category);
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Such category does not exist"));
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    public void update(Long id, CategoryMsg categoryMsg) {
        ModelMapper modelMapper = new ModelMapper();
        Category category = modelMapper.map(categoryMsg, Category.class);
        category.setProjects(categoryRepository.findById(id).get().getProjects());
        category.setId(id);
        categoryRepository.save(category);
    }
}
