package br.com.ramonfacchin.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ramonfacchin.domain.Product;
import br.com.ramonfacchin.domain.ProductRepository;

/**
 * Service for common operations with {@link Product}s.
 * 
 * @author Ramon Facchin
 * @since Apr 9, 2017
 */
@Service
public class ProductService {
	
	@Autowired
	public ProductRepository repository;
	
	/**
	 * Lists all {@link Product}s
	 * @return {@link List} of all {@link Product}s.
	 */
	public List<Product> listAll() {
		List<Product> list = new ArrayList<>();
		Iterable<Product> findAll = repository.findAll();
		Iterator<Product> iterator = findAll.iterator();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		return list;
	}
	
	/**
	 * Creates a new {@link Product} or changes an existing one.
	 * @param product the {@link Product} to be created/changed
	 * @return the saved {@link Product}
	 */
	public Product save(Product product) {
		Product save = repository.save(product);
		return save;
	}
	
	/**
	 * Deletes a {@link Product}
	 * @param id {@link Product}'s identifier
	 * @return the deleted {@link Product}
	 */
	public Product delete(Long id) {
		Product findOne = repository.findOne(id);
		repository.delete(findOne);
		return findOne;
	}
	
	/**
	 * Finds the {@link Product} with the specified identifier
	 * @param id the identifier
	 * @return found {@link Product}
	 */
	public Product find(Long id) {
		return repository.findOne(id);
	}
	
	/**
	 * Creates a sample {@link Product}
	 * @return the sample {@link Product}
	 */
	public Product createSample() {
		Product sample = new Product();
		sample.setName("Sample"+System.currentTimeMillis());
		sample = repository.save(sample);
		return sample;
	}

}
