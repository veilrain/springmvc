package vestore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "Order_Entries")
public class OrderEntry {
	@Id
	@GeneratedValue
	private int entryId;
	private int count = 1;
	
	@ManyToOne()
	@JoinColumn(name = "order_id", nullable = true)
	private Order order;
	
	@OneToOne()
	@JoinColumn(name = "product_id", nullable = true)
	private Product product;

	public OrderEntry() {}
	
	public OrderEntry(Order order, Product product) {
		this.product = product;
		this.order = order;
	}

	public int getEntryId() {
		return entryId;
	}

	public void setEntryId(int entryId) {
		this.entryId = entryId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
