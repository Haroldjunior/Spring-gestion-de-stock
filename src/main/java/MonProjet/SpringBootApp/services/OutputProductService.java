package MonProjet.SpringBootApp.services;


import MonProjet.SpringBootApp.entities.OutputProduct;
import MonProjet.SpringBootApp.entities.Product;
import MonProjet.SpringBootApp.entities.Stock;
import MonProjet.SpringBootApp.repositories.OutputProductRepository;
import MonProjet.SpringBootApp.repositories.ProductRepository;
import MonProjet.SpringBootApp.repositories.StockRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OutputProductService {

    @Autowired
    public OutputProductRepository outputProductRepository;

    @Autowired
    public StockRepository stockRepository;

    @Autowired
    public ProductRepository productRepository;

    public OutputProduct create(OutputProduct outputProduct){
        Product product=outputProduct.getProduct();
        Product existingProduct= productRepository.findById(product.getId()).orElseThrow(()-> new EntityNotFoundException("Produit non disponible"));
        Stock existingStock =stockRepository.findByIdProduct(existingProduct.getId());
        if (existingStock!=null){
           Integer newProductStockNumber = existingStock.getProductStockNumber()-outputProduct.getNumberOutputProduct();
           if (newProductStockNumber>=0){
               existingStock.setProductStockNumber(newProductStockNumber);
               stockRepository.save(existingStock);
               return outputProductRepository.save(outputProduct);
           }
           return null;

        }

        return null;
    }

    public List<OutputProduct> read(){
        return outputProductRepository.findAll();
    }

    public OutputProduct findById(Long id){
        return outputProductRepository.findById(id).orElse(null);
    }

    public void delete(Long id){
        outputProductRepository.deleteById(id);
    }
}
