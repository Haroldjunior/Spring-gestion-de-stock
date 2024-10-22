package MonProjet.SpringBootApp.entities;


import jakarta.persistence.*;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStock;

    private Long idProduct;

    private Integer productStockNumber;



    @ManyToOne
    private EnteredProduct enteredProduct;

    @ManyToOne
    private OutputProduct outputProduct;


    public Stock() {
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Long getIdStock() {
        return idStock;
    }

    public void setIdStock(Long idStock) {
        this.idStock = idStock;
    }

    public int getProductStockNumber() {
        return productStockNumber;
    }

    public void setProductStockNumber(Integer productStockNumber) {
        this.productStockNumber = productStockNumber;
    }

    public EnteredProduct getEnteredProduct() {
        return enteredProduct;
    }

    public void setEnteredProduct(EnteredProduct enteredProduct) {
        this.enteredProduct = enteredProduct;
    }

    public OutputProduct getOutputProduct() {
        return outputProduct;
    }

    public void setOutputProduct(OutputProduct outputProduct) {
        this.outputProduct = outputProduct;
    }
}
