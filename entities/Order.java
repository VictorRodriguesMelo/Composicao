package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Enums.OrderStatus;

public class Order {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date moment;
	private OrderStatus Status;
	
	private Client client;
	private List <OrderItem> items = new ArrayList<OrderItem>();

	public Order() {		
	}
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		Status = status;
		this.client = client;
	}
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	public OrderStatus getStatus() {
		return Status;
	}
	public void setStatus(OrderStatus status) {
		Status = status;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void addItem(OrderItem item) {
		items.add(item);		
	}
	public void removeItem(OrderItem item) {
		items.remove(item);		
	}
	public double total() {
		double sum = 0;
		for (OrderItem it: items ) {
			sum += it.sobTotal();
		}
		return sum;	
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(Status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
	
}
