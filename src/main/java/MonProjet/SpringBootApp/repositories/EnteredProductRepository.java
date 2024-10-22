package MonProjet.SpringBootApp.repositories;

import MonProjet.SpringBootApp.entities.EnteredProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnteredProductRepository extends JpaRepository<EnteredProduct, Long> {
}
