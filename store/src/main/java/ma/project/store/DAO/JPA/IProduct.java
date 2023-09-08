package ma.project.store.DAO.JPA;

import ma.project.store.DAO.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProduct extends JpaRepository<Product,Integer> {

//    @Override
//    List<Product> findAll();

    Page<Product> findAllByNameContains( String keyword ,Pageable pageable);

//    Page<Product> findAll(Pageable pageable);
}

