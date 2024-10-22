package MonProjet.SpringBootApp.services;

import MonProjet.SpringBootApp.entities.Category;
import MonProjet.SpringBootApp.entities.Mark;
import MonProjet.SpringBootApp.repositories.CategoryRepository;
import MonProjet.SpringBootApp.repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class CategoryService {

    // Autowired intencifie la class CategoryRepository
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MarkRepository markRepository;

    //recupere les element de category
    public List <Category > findAll(){
        return categoryRepository.findAll();
    }
    //Sauvegarde et met a jour les elements dana Category
    public Category save(Category category){
        Set<Mark> marks= category.getMarks();
        if (!marks.isEmpty()){
            marks.forEach(mark -> {
                if (mark.getIdMark()==null){
                    markRepository.save(mark);
                }
            });
            category.setMarks(marks);
        }
        return categoryRepository.save(category);
    }

    // supprime une entite (Category) par son id
    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }

    //recupere les element de category par idCategory et retour null si elle n'existe plus
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);

    }

}
