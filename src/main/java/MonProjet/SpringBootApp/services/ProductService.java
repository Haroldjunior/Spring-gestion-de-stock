package MonProjet.SpringBootApp.services;

import MonProjet.SpringBootApp.entities.Category;
import MonProjet.SpringBootApp.entities.Product;
import MonProjet.SpringBootApp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    public Product create(Product product){

        Category category=product.getCategory();
        if (category!=null){
            if (category.getProducts()==null){
                category.setProducts(new HashSet<>());
            }
            category.getProducts().add(product);
        }

        return productRepository.save(product);
    }


    public List< Product > read(){

        return productRepository.findAll();
    }


    public Product findById(long id){
        return productRepository.findById(id).orElse(null);
    }


    public void delete(Long id){
        productRepository.deleteById(id);
    }




}
