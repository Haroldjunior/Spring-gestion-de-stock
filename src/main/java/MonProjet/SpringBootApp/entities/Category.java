package MonProjet.SpringBootApp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idCategory;

    private String nameCategory;

    private String description;

    @ManyToMany
    @JsonIgnore
    private Set<Mark> marks=new HashSet<>();


    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Product> products =new HashSet<>();

    public Category() {
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

