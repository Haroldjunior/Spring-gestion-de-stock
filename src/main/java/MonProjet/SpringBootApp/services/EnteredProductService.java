package MonProjet.SpringBootApp.services;

import MonProjet.SpringBootApp.entities.EnteredProduct;
import MonProjet.SpringBootApp.entities.Product;
import MonProjet.SpringBootApp.entities.Stock;
import MonProjet.SpringBootApp.repositories.EnteredProductRepository;
import MonProjet.SpringBootApp.repositories.ProductRepository;
import MonProjet.SpringBootApp.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EnteredProductService {

    @Autowired
    public EnteredProductRepository enteredProductRepository;

    @Autowired
    public StockRepository stockRepository;

    @Autowired
    public ProductRepository productRepository;


    public EnteredProduct create(EnteredProduct enteredProduct){
        Product product= enteredProduct.getProduct();
        Product existingProduct = productRepository.findById(product.getId()).get();
        if (existingProduct!=null){
            Stock existingStock = stockRepository.findByIdProduct(existingProduct.getId());
            if (existingStock!=null){
                existingStock.setProductStockNumber(existingStock.getProductStockNumber() + enteredProduct.getNumberEnteredProduct());
                stockRepository.save(existingStock);

            }else {
                Stock newStock = new Stock();
                newStock.setIdProduct(existingProduct.getId());
                newStock.setProductStockNumber(enteredProduct.getNumberEnteredProduct());
                stockRepository.save(newStock);
            }
            return enteredProductRepository.save(enteredProduct);

        }



        return null;
    }

    public List<EnteredProduct> read(){
        return enteredProductRepository.findAll();
    }

    public EnteredProduct findById(Long id){
        return enteredProductRepository.findById(id).orElse(null);
    }

    public void delete(Long id){
        enteredProductRepository.deleteById(id);
    }
}
