package ve.dao;

import java.util.List;

import ve.model.Product;

public interface ProductDao {
	void addProduct(Product MusicProduct);
	
	List<Product> getAllProducts();
}
