package MonProjet.SpringBootApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMark;

    private String markName;


    @ManyToMany(mappedBy = "marks")
    @JsonIgnore
    private Set<Category> categories = new HashSet<>();

    public Mark() {
    }

    public Long getIdMark() {
        return idMark;
    }

    public void setIdMark(Long idMark) {
        this.idMark = idMark;
    }

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }



}

