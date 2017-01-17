package vestore.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.web.multipart.MultipartFile;

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
	
	@OneToMany(mappedBy = "product")
    @Cascade(value = { CascadeType.DELETE, CascadeType.SAVE_UPDATE })
	private Set<OrderEntry> entries = new HashSet<>(0);
	
	/**
	 * Not stored in database
	 */
	@Transient
	private MultipartFile productImg1;
	@Transient
	private MultipartFile productImg2;
	
	public Set<OrderEntry> getEntries() {
		return entries;
	}

	public void setEntries(Set<OrderEntry> entries) {
		this.entries = entries;
	}

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

	public MultipartFile getProductImg1() {
		return productImg1;
	}

	public void setProductImg1(MultipartFile productImg1) {
		this.productImg1 = productImg1;
	}

	public MultipartFile getProductImg2() {
		return productImg2;
	}

	public void setProductImg2(MultipartFile productImg2) {
		this.productImg2 = productImg2;
	}


	/*
	 * Auto generated serial UID 
	 */
	private static final long serialVersionUID = -2114314114524372551L;
}
