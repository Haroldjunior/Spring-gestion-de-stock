package MonProjet.SpringBootApp.entities;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private Double price;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<EnteredProduct> enteredProducts=new HashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<OutputProduct> outputProducts=new HashSet<>();


    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<EnteredProduct> getEnteredProducts() {
        return enteredProducts;
    }

    public void setEnteredProducts(Set<EnteredProduct> enteredProducts) {
        this.enteredProducts = enteredProducts;
    }

    public Set<OutputProduct> getOutputProducts() {
        return outputProducts;
    }

    public void setOutputProducts(Set<OutputProduct> outputProducts) {
        this.outputProducts = outputProducts;
    }
}
