package br.com.ramonfacchin;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.ramonfacchin.domain.Product;
import br.com.ramonfacchin.web.ProductController;

/**
 * Zup Products test suite
 * 
 * @author Ramon Facchin
 * @since Apr 9, 2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ZupProductsApplicationTests {
	
	@Autowired
	ProductController controller;
	
	private final String PRODUCT_NAME = "ProductCreationTest";
	private final String PRODUCT_ALTERED_NAME = "ProductCreationTest2";

	/**
	 * Tests creation, deletion and loading
	 */
	@Test
	public void testProducts() {
		/*
		 * Storing tested product id
		 */
		Long productId = null;
		
		/*
		 * testing creation of a new product
		 */
		Product product = testRegistration();
		productId = product.getId();
		
		/*
		 * testing loading of registered product
		 */
		Product loadedProduct = testLoading(productId);
		
		Assert.assertEquals(product, loadedProduct);
		
		/*
		 * checks if the registered product is the only product in the database
		 */
		testListing(1);
		
		/*
		 * tests editing of registered product
		 */
		Product editedProduct = testEdit(productId);
		
		Assert.assertNotEquals(product, editedProduct);
		/*
		 * to ensure that no new product was created, but
		 * the existing one was changed, there must be only
		 * one product in the database
		 */
		testListing(1);
		
		/*
		 * now testing the deletion
		 */
		testDeletion(productId);
		/*
		 * after deletion there must be no products in the database
		 */
		testListing(0);
		
		/*
		 * Now testing if more than one product can be created
		 */
		Product product1 = testRegistration();
		Product product2 = testRegistration();
		
		testListing(2);
		
		testDeletion(product1.getId());
		testDeletion(product2.getId());
		
		testListing(0);
	}
	
	public Product testRegistration() {
		Product product = new Product();
		product.setName(PRODUCT_NAME);
		
		Product registerProduct = controller.registerProduct(product);
		Assert.assertNotNull(registerProduct);
		Assert.assertEquals(PRODUCT_NAME, registerProduct.getName());
		
		return registerProduct;
	}
	
	public Product testLoading(Long id) {
		Product loadProduct = controller.loadProduct(id);
		Assert.assertNotNull(id);
		return loadProduct;
	}
	
	public List<Product> testListing(int expectedSize) {
		List<Product> all = controller.listAll();
		Assert.assertNotNull(all);
		if (expectedSize > 0) {
			Assert.assertFalse(all.isEmpty());
		} else {
			Assert.assertTrue(all.isEmpty());
		}
		return all;
	}
	
	public Product testEdit(Long id) {
		Product alteredProduct = new Product();
		alteredProduct.setId(id);
		alteredProduct.setName(PRODUCT_ALTERED_NAME);
		Product editProduct = controller.editProduct(id, alteredProduct);
		
		Assert.assertNotNull(editProduct);
		Assert.assertEquals(alteredProduct, editProduct);
		return editProduct;
	}
	
	public Product testDeletion(Long id) {
		Product deleteProduct = controller.deleteProduct(id);
		
		Product loadProduct = controller.loadProduct(id);
		Assert.assertNull(loadProduct);
		
		return deleteProduct;
	}

}
