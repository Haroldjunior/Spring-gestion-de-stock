package MonProjet.SpringBootApp.controllers;


import MonProjet.SpringBootApp.entities.Stock;
import MonProjet.SpringBootApp.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/create")
    public Stock createStock(@RequestBody Stock stock){
        return stockService.create(stock);
    }

    @GetMapping("/read")
    public List<Stock> readStock(){
        return stockService.read();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@RequestBody Stock stock, @PathVariable Long id){
        if (id!=null){
            Stock updatedStock= stockService.create(stock);
            return ResponseEntity.ok(updatedStock);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public Stock findById(@PathVariable Long id){
        return stockService.findById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id){
        stockService.delete(id);
    }
}
