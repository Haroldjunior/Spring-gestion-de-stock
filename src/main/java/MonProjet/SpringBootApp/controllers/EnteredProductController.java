package MonProjet.SpringBootApp.controllers;


import MonProjet.SpringBootApp.entities.EnteredProduct;
import MonProjet.SpringBootApp.services.EnteredProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enteredProduct")
public class EnteredProductController {

    @Autowired
    public EnteredProductService enteredProductService;


    @PostMapping("/create")
    public EnteredProduct getEnteredProduct(@RequestBody EnteredProduct enteredProduct){
        return enteredProductService.create(enteredProduct);

    }

    @GetMapping("/read")
    public List <EnteredProduct> getEnteredProduct(){
        return enteredProductService.read();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnteredProduct> updateEnteredProduct(@RequestBody EnteredProduct enteredProduct, @PathVariable Long id){
        if (id !=null){
            EnteredProduct updatedEnteredProduct= enteredProductService.create(enteredProduct);
            return ResponseEntity.ok(updatedEnteredProduct);
        }
        return ResponseEntity.badRequest().build();
    }
}
