package uz.abbos.jparepositoryfirst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.abbos.jparepositoryfirst.entity.Category;
import uz.abbos.jparepositoryfirst.exception.BadRequestException;
import uz.abbos.jparepositoryfirst.repository.CategoryRepository;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public Category getCategory(Integer id) {
        Optional<Category> optional = categoryRepository.findById(id);
        if (optional.isEmpty()){
            throw new BadRequestException("category not found");
        }
        return optional.get();
    }

    public Category createCategory(Category category) {
        categoryRepository.save(category);
        return category;
    }

    public boolean updateCategory(Integer id,Category category) {
        Category c = getCategory(id);
        c.setName(category.getName());
        return true;
    }

    public boolean deleteCategory(Integer id) {
        Category category = getCategory(id);
        categoryRepository.delete(category);
        return true;

    }
}
