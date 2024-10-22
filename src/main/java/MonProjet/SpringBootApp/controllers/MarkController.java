package MonProjet.SpringBootApp.controllers;


import MonProjet.SpringBootApp.entities.Mark;

import MonProjet.SpringBootApp.services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mark")
public class MarkController {

    @Autowired
    private MarkService markService;

    @PostMapping ("/create")
    public Mark createMark (@RequestBody Mark mark){
        return markService.create(mark);
    }

    @GetMapping("/read")
    public List <Mark> readMark(){
        return markService.read();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Mark> updateMark(@RequestBody Mark mark, @PathVariable Long id){
        if (id!=null){
            Mark updatedMark=markService.create(mark);
            return ResponseEntity.ok(updatedMark);
        }
        return ResponseEntity.badRequest().build();

    }

    @GetMapping("/{id}")
    public Mark getById(@PathVariable Long id){
        return markService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        markService.deleteById(id);
    }

}
