package vestore.dao;

import java.util.List;
import java.util.Map;

public interface DataAccessor<E> {
	/* Add the given entry to the database system */
	public void add(E entry);
	
	/* Update the given entry in the database system */
	public void update(E entry);
	
	/* Delete the given entry in the database system */
	public void delete(E entry);
	
	/* Retrieve all entries from the data base */
	public List<E> retrieveAll();

	/* Retrieve by a single attribute */
	public List<E> retrieveBy(String attribute, String value);
	
	/* Retrieve all entries having given attributes */
	public List<E> retrieveByAttributes(Map<String, String> attributes);
}
