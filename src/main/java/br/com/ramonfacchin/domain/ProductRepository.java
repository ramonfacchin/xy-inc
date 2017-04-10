package br.com.ramonfacchin.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for CRUD operations with {@link Product}s
 * @author Ramon Facchin
 * @since Apr 9, 2017
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
