package vestore.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateDAOImpl<E> implements DataAccessor<E> {
	@Autowired
	protected SessionFactory sessionFactory;
	private Session session;

	private Class<E> type;
	
	public HibernateDAOImpl(Class<E> type) {
		this.type = type;
	}
	
	@Override
	public void add(E entry){
		update(entry);
	}
	
	@Override
	public void update(E entry) {
		session = sessionFactory.openSession();
		session.saveOrUpdate(entry);
		session.flush();
		session.close();
	}

	@Override
	public void delete(E entry) {
		session = sessionFactory.openSession();
		session.delete(entry);
		session.flush();
		session.close();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<E> retrieveAll() {
		session = sessionFactory.openSession();
		List<E> retval = session.createCriteria(type).list();
		session.close();
		return retval;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<E> retrieveBy(String attribute, String value) {
		session = sessionFactory.openSession();
		List<E> retval = session.createQuery("from " + type.getName() + " where " + attribute + " = " + value).list();
		session.close();
		return retval;
	}

	@Override
	public List<E> retrieveByAttributes(Map<String, String> attributes) {
		return null;
	}
}
