package model;

import java.util.Date;
import java.util.TreeSet;

public class Order implements Comparable<Order> {
	
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
		this.orderDate = new Date();
		this.total = total;
		this.subTotal = subTotal;
		this.owner = owner;
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
