package ve.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ve.dao.ProductDao;
import ve.model.Product;
@Repository
/*@Transactional*/
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addProduct(Product product){
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(product);
		session.flush();
	}
	
	public List<Product> getAllProducts() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product");
		@SuppressWarnings("unchecked")
		List<Product> product = query.list();
		return product;
	}
}
