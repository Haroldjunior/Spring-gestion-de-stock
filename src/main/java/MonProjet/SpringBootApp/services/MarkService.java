package MonProjet.SpringBootApp.services;

import MonProjet.SpringBootApp.entities.Category;
import MonProjet.SpringBootApp.entities.Mark;
import MonProjet.SpringBootApp.repositories.CategoryRepository;
import MonProjet.SpringBootApp.repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MarkService {

    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Mark> read() {
        return markRepository.findAll();
    }

    public Mark create(Mark mark){
        Set<Category> categories=mark.getCategories();
        if (!categories.isEmpty()){
            categories.forEach(category -> {
                if (category.getIdCategory()==null){
                    categoryRepository.save(category);
                }
            });
            mark.setCategories(categories);
        }
        return markRepository.save(mark);
    }



    public Mark findById(Long id){
        return markRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        markRepository.deleteById(id);
    }
}
