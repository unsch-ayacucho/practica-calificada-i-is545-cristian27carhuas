package pe.edu.unsch.entities;
// Generated 16/07/2019 01:54:40 PM by Hibernate Tools 5.1.10.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ordersdetail generated by hbm2java
 */
@Entity
@Table(name = "ordersdetail", catalog = "divisimabd")
public class Ordersdetail implements java.io.Serializable {

	private Integer idordersdetail;
	private Orders orders;
	private Product product;
	private BigDecimal price;
	private int quantity;

	public Ordersdetail() {
	}

	public Ordersdetail(Orders orders, Product product, BigDecimal price, int quantity) {
		this.orders = orders;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idordersdetail", unique = true, nullable = false)
	public Integer getIdordersdetail() {
		return this.idordersdetail;
	}

	public void setIdordersdetail(Integer idordersdetail) {
		this.idordersdetail = idordersdetail;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idorders", nullable = false)
	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idproduct", nullable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "price", nullable = false, precision = 18)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
