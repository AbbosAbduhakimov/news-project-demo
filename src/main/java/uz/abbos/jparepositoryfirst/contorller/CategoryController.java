package uz.abbos.jparepositoryfirst.contorller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.abbos.jparepositoryfirst.entity.Category;
import uz.abbos.jparepositoryfirst.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCatgeory(@PathVariable("id") Integer id){
        Category result = categoryService.getCategory(id);
        return ResponseEntity.ok(result);
    }


    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        Category result = categoryService.createCategory(category);
        return ResponseEntity.ok(result);
    }


    @PutMapping("{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Integer id,
                                            @RequestBody Category category){
        boolean result = categoryService.updateCategory(id,category);
        return ResponseEntity.ok(result);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCetegory(@PathVariable Integer id){
        boolean result = categoryService.deleteCategory(id);
        return ResponseEntity.ok(result);
    }


}
