package MonProjet.SpringBootApp.entities;


import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class EnteredProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnteredProduct;

    private Double priceEnteredProduct;

    private Date dateEnteredProduct;

    private Integer numberEnteredProduct;

    @OneToMany(mappedBy = "enteredProduct")
    private Set<Stock> stocks= new HashSet<>();

    @ManyToOne
    private Product product;


    public EnteredProduct() {
    }

    public Long getIdEnteredProduct() {
        return idEnteredProduct;
    }

    public void setIdEnteredProduct(Long idEnteredProduct) {
        this.idEnteredProduct = idEnteredProduct;
    }

    public Double getPriceEnteredProduct() {
        return priceEnteredProduct;
    }

    public void setPriceEnteredProduct(Double priceEnteredProduct) {
        this.priceEnteredProduct = priceEnteredProduct;
    }

    public Date getDateEnteredProduct() {
        return dateEnteredProduct;
    }

    public void setDateEnteredProduct(Date dateEnteredProduct) {
        this.dateEnteredProduct = dateEnteredProduct;
    }

    public Integer getNumberEnteredProduct() {
        return numberEnteredProduct;
    }

    public void setNumberEnteredProduct(Integer numberEnteredProduct) {
        this.numberEnteredProduct = numberEnteredProduct;
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
