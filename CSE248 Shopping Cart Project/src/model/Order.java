package model;

import java.io.Serializable;
import java.util.Date;
import java.util.TreeSet;

/**
 * A copy of any items bought, this is stored in the StoreDataBase as records of who bought what items
 * @author bdabr
 *
 */
public class Order implements Comparable<Order>, Serializable {
<<<<<<< HEAD
	/**
	 * 
	 */
	private static final long serialVersionUID = -1423574175558137158L;
=======
	private static final long serialVersionUID = -1423574175558137158L;
	
>>>>>>> 4d48e3ea3182cda8bb96449ebf446dd65130e50d
	private TreeSet<Item> itemsbought;
	private int orderID;
	private Date orderDate;
	private double total;
	private double subTotal;
	private Account owner;
	
	/**
	 * Contains all information for a placed order
	 * @param total Total sale price after tax
	 * @param subTotal Sale price before tax
	 * @param owner The account that placed the order
	 */
	public Order( double total, double subTotal, Account owner) {
		itemsbought = new TreeSet<>();
		this.orderDate = new Date();
		this.total = total;
		this.subTotal = subTotal;
		this.owner = owner;
		this.orderID = 0;
	}
	
	/**
	 * Adds item to Order receipt
	 * @param itemToAdd Item being added to receipt
	 */
	public void addItemToOrder(Item itemToAdd) {
		itemsbought.add(itemToAdd);
	}
	
	/**
	 * Removes item from Order receipt
	 * @param itemToRemove item being removed
	 */
	public void removeItemFromOrder(Item itemToRemove) {
		itemsbought.remove(itemToRemove);
	}
	
	
	
	// setters and getters
	
	public TreeSet<Item> getItemsbought() {
		return itemsbought;
	}

	public void setItemsbought(TreeSet<Item> itemsbought) {
		this.itemsbought = itemsbought;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public Account getOwner() {
		return owner;
	}

	public void setOwner(Account owner) {
		this.owner = owner;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	@Override
	public String toString() {
		return orderID + " " + orderDate + " " + total + " " + subTotal + " " + owner.getUserName();
	}
	
	@Override
	public int compareTo(Order other) {
		if (this.orderID > other.orderID) {
			return 1;
		}
		if (this.orderID < other.orderID) {
			return -1;
		}
		return 0;
	}
	
	
	
}
