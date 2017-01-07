package vestore.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vestore.model.Product;

/**
 * Data access object for Table Product
 */
@Repository
/*@Transactional*/
public class ProductsDAO implements AbstractDAO<Product>{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Product entry){
		update(entry);
	}
	
	@Override
	public void update(Product entry) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(entry);
		session.flush();
	}

	@Override
	public void delete(Product entry) {
		Session session = sessionFactory.openSession();
		session.delete(entry);
		session.flush();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Product> retrieveAll() {
		return sessionFactory.openSession().createQuery("from Product").list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> retrieveBy(String attribute, String value) {
		return sessionFactory.openSession().createQuery("from Product where " + attribute + " = " + value).list();
	}

	@Override
	public List<Product> retrieveByAttributes(Map<String, String> attributes) {
		/** not needed yet **/
		return null;
	}
}
