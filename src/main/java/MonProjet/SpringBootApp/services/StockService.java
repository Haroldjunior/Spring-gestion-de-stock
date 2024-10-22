package MonProjet.SpringBootApp.services;


import MonProjet.SpringBootApp.entities.EnteredProduct;
import MonProjet.SpringBootApp.entities.Stock;
import MonProjet.SpringBootApp.repositories.EnteredProductRepository;
import MonProjet.SpringBootApp.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    public StockRepository stockRepository;

    @Autowired
    public EnteredProductRepository enteredProductRepository;

    public List<Stock> read(){
        return stockRepository.findAll();
    }

    public Stock create(Stock stock){

        return stockRepository.save(stock);
    }

    public Stock findById(Long id){
        return stockRepository.findById(id).orElse(null);
    }
    public void delete(Long id){
        stockRepository.deleteById(id);
    }

}
