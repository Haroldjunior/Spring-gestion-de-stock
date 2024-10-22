package MonProjet.SpringBootApp.controllers;


import MonProjet.SpringBootApp.entities.Category;
import MonProjet.SpringBootApp.entities.Product;
import MonProjet.SpringBootApp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    public ProductService productService;

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
        return productService.create(product);

    }


    @GetMapping("/read")
    public List<Product> readProduct(){
        return productService.read();
    }

    @PutMapping ("/update")
    public ResponseEntity <Product> updateProduct(@RequestBody Product product, @PathVariable Long id){
        if (id!=null) {
            Product updatedProduct = productService.create(product);
            return ResponseEntity.ok(updatedProduct);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findById(id);
    }


    @DeleteMapping("/{delete}")
    public void deleteProduct(@PathVariable Long id){
        productService.delete(id);

    }
}
