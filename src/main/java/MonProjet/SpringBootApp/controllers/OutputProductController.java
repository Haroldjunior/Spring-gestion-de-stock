package MonProjet.SpringBootApp.controllers;

import MonProjet.SpringBootApp.entities.OutputProduct;
import MonProjet.SpringBootApp.services.OutputProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outputProduct")
public class OutputProductController {

    @Autowired
    public OutputProductService outputProductService;

    @PostMapping("/create")
    public OutputProduct createOutputProduct(@RequestBody OutputProduct outputProduct){
        return outputProductService.create(outputProduct);
    }

    @GetMapping("/read")
    public List<OutputProduct> readOutputProduct(){
        return outputProductService.read();

    }

    @GetMapping("/{id}")
    public OutputProduct findById(@PathVariable Long id){
        return outputProductService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OutputProduct>updateOutputProduct(@RequestBody OutputProduct outputProduct,@PathVariable Long id){
        if (id!=null){
            OutputProduct updatedOutputProduct=outputProductService.create(outputProduct);
            return ResponseEntity.ok(updatedOutputProduct);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public void deleteOutputProduct(@PathVariable Long id){
        outputProductService.delete(id);
    }
}
