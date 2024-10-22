package MonProjet.SpringBootApp.entities;


import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class OutputProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOutputProduct;

    private Double priceOutputProduct;

    private Date dateOutputProduct;

    private Integer numberOutputProduct;


    @OneToMany(mappedBy = "outputProduct")
    private Set<Stock> stocks= new HashSet<>();

    @ManyToOne
    private Product product;


    public OutputProduct() {
    }

    public Long getIdOutputProduct() {
        return idOutputProduct;
    }

    public void setIdOutputProduct(Long idOutputProduct) {
        this.idOutputProduct = idOutputProduct;
    }

    public Double getPriceOutputProduct() {
        return priceOutputProduct;
    }

    public void setPriceOutputProduct(Double priceOutputProduct) {
        this.priceOutputProduct = priceOutputProduct;
    }

    public Date getDateOutputProduct() {
        return dateOutputProduct;
    }

    public void setDateOutputProduct(Date dateOutputProduct) {
        this.dateOutputProduct = dateOutputProduct;
    }

    public int getNumberOutputProduct() {
        return numberOutputProduct;
    }

    public void setNumberOutputProduct(Integer numberOutputProduct) {
        this.numberOutputProduct = numberOutputProduct;
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
