package MonProjet.SpringBootApp.repositories;


import MonProjet.SpringBootApp.entities.OutputProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutputProductRepository extends JpaRepository<OutputProduct, Long> {
}
