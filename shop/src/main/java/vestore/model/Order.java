package vestore.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "Orders")
public class Order {
	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private int orderId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
    @Cascade(value = { CascadeType.DELETE })
	private Set<OrderEntry> entries = new HashSet<>(0);

	public Order() {}
	
	public Order(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}

	public Set<OrderEntry> getEntries() {
		return entries;
	}

	public void setEntries(Set<OrderEntry> entries) {
		this.entries = entries;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}
