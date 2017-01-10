package vestore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import vestore.model.User;

public class UserDAOImpl implements UserDAO {
	@Autowired
	protected SessionFactory sessionFactory;
	private Session session;

	public void addUser(User user) {
		update(user);
	}

	public void update(User user) {
		session = sessionFactory.openSession();
		session.saveOrUpdate(user);
		session.flush();
		session.close();
	}

}
