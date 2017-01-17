package vestore.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue
	@Column(name = "user_id", unique = true)
	private int userId;
	private String username;
	private String password;
	private String emailAddress;
	private String code;
	private boolean enabled = true;
	private String role = "ROLE_USER";

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@OneToOne()
	@JoinColumn(name = "cart", nullable = true)
    @Cascade(value = { CascadeType.DELETE })
	private Order cart = null;
	
	@OneToMany(mappedBy = "user")
    @Cascade(value = { CascadeType.DELETE })
	private Set<Order> orders = new HashSet<>(0);

	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	public Order getCart() {
		return cart;
	}
	public void setCart(Order cart) {
		this.cart = cart;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
