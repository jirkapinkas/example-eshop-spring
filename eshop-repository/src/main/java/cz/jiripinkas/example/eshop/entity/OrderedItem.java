package cz.jiripinkas.example.eshop.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: OrderedItem
 * 
 */
@Entity
@Table(name = "ORDERED_ITEM")
public class OrderedItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderedItemId;

	private int quantity;

	@ManyToOne
	@JoinColumn(name = "USER_ORDER_ID")
	private UserOrder userOrder;

	@ManyToOne
	@JoinColumn(name = "ITEM_ID")
	private Item item;

	public UserOrder getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getOrderedItemId() {
		return this.orderedItemId;
	}

	public void setOrderedItemId(int orderedItemId) {
		this.orderedItemId = orderedItemId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
