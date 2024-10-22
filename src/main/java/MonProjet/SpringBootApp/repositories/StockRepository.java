package MonProjet.SpringBootApp.repositories;

import MonProjet.SpringBootApp.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock findByIdProduct(Long idProduct);

}
