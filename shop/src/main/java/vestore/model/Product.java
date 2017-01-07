package vestore.model;

import java.util.Calendar;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private double price;
	private String category;
	private String description;
	@Column(name = "date_added")
	private Date dateAdded;
	@Column(name = "last_time_modified")
	private Date lastTimeModified;
	
	public Product() {
		dateAdded = new Date(Calendar.getInstance().getTime().getTime());
		lastTimeModified = new Date(dateAdded.getTime());
	}
	
	/*
	 * Auto-generated getter/setter
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public Date getLastTimeModified() {
		return lastTimeModified;
	}
	public void setLastTimeModified(Date lastTimeModified) {
		this.lastTimeModified = lastTimeModified;
	}
	
	/*
	 * Auto generated serial UID 
	 */
	private static final long serialVersionUID = -2114314114524372551L;
}
