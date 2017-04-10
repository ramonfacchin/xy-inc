package br.com.ramonfacchin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ramonfacchin.domain.Product;
import br.com.ramonfacchin.service.ProductService;

/**
 * REST controller for products.
 * 
 * @author Ramon Facchin
 * @since Apr 9, 2017
 */
@RestController
@RequestMapping(path = "/products")
public class ProductController {
	
	@Autowired
	ProductService service;

	/**
	 * Lists all {@link Product}s
	 * @return all registered {@link Product}s
	 */
	@RequestMapping(path="/sample", method=RequestMethod.GET)
	public Product saveSampleProduct() {
		return service.createSample();
	}
	
	/**
	 * Lists all {@link Product}s
	 * @return all registered {@link Product}s
	 */
	@RequestMapping(method=RequestMethod.GET)
	public List<Product> listAll() {
		return service.listAll();
	}
	
	/**
	 * Registers a new Product
	 * @param product the {@link Product} being registered
	 * @return the registered {@link Product}
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Product registerProduct(@RequestBody Product product) {
		return service.save(product);
	}
	
	/**
	 * Deletes the Product with informed identifier
	 * @param productId the {@link Product}'s identifier
	 * @return the deleted {@link Product}
	 */
	@RequestMapping(path = "/{productId}", method=RequestMethod.DELETE)
	public Product deleteProduct(@PathVariable Long productId) {
		return service.delete(productId);
	}
	
	/**
	 * Loads the {@link Product} with informed identifier
	 * @param productId the {@link Product}'s identifier
	 * @return the {@link Product} found for the informed identifier
	 */
	@RequestMapping(path = "/{productId}", method=RequestMethod.GET)
	public Product loadProduct(@PathVariable Long productId) {
		return service.find(productId);
	}
	
	/**
	 * Changes the existing {@link Product} with the informed identifier
	 * @param product the {@link Product} being edited
	 * @return the changes made to the {@link Product}
	 */
	@RequestMapping(path = "/{productId}", method=RequestMethod.PUT)
	public Product editProduct(@PathVariable Long productId, @RequestBody Product product) {
		product.setId(productId);
		return service.save(product);
	}

}
