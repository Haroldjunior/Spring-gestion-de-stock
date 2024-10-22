package MonProjet.SpringBootApp.controllers;


import MonProjet.SpringBootApp.entities.Category;
import MonProjet.SpringBootApp.services.CategoryService;
import jakarta.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    //cree une nouvelle category
    public Category createCategory( @RequestBody Category category){
        return categoryService.save(category);
    }

    @GetMapping("/read")
    //recupere toute les category
    public List<Category> readCategory(){
        return categoryService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable Long id) {
        if (id != null){
           Category updatedCategory= categoryService.save(category);
           return ResponseEntity.ok(updatedCategory);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public Category getOneCategory(@PathVariable Long id){
       return categoryService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteById(id);
    }
}