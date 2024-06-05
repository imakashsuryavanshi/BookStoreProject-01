package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;
import com.bookstore.entity.OrderDetail;
import com.bookstore.entity.OrderDetailId;

public class OrderDAOTest {

	private static OrderDAO orderDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		orderDAO = new OrderDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		orderDAO.close();
	}

	@Test
	public void testCreateBookOrder() {
		BookOrder order = new BookOrder();
		Customer customer = new Customer();
		customer.setCustomerId(4);
		
		order.setCustomer(customer);
		order.setRecipientName("Pradeep S");
		order.setRecipientPhone("1234456789");
		order.setShippingAddress("Thane");
		
		Set<OrderDetail> orderDetails = new HashSet<>();
		OrderDetail orderDetail = new OrderDetail();
		
		Book book = new Book(7);
		orderDetail.setBook(book);
		orderDetail.setQuantity(2);
		orderDetail.setSubtotal(72.4f);
		orderDetail.setBookOrder(order);
		
		orderDetails.add(orderDetail);
		
		order.setOrderDetails(orderDetails);
		
		BookOrder savedOrder = orderDAO.create(order);
		assertTrue(savedOrder != null && savedOrder.getOrderDetails().size() > 0);
	}
	
	@Test
	public void testCreateBookOrder2() {
		BookOrder order = new BookOrder();
		Customer customer = new Customer();
		customer.setCustomerId(8);
		
		order.setCustomer(customer);
		order.setRecipientName("Akash S");
		order.setRecipientPhone("123456789");
		order.setShippingAddress("Thane");
		
		Set<OrderDetail> orderDetails = new HashSet<>();
		OrderDetail orderDetail1 = new OrderDetail();
		
		Book book1 = new Book(4);
		orderDetail1.setBook(book1);
		orderDetail1.setQuantity(2);
		orderDetail1.setSubtotal(77.74f);
		orderDetail1.setBookOrder(order);
		
		orderDetails.add(orderDetail1);
		
		OrderDetail orderDetail2 = new OrderDetail();
		
		Book book2 = new Book(7);
		orderDetail2.setBook(book2);
		orderDetail2.setQuantity(1);
		orderDetail2.setSubtotal(37.18f);
		orderDetail2.setBookOrder(order);
		
		orderDetails.add(orderDetail2);
		
		order.setOrderDetails(orderDetails);
		
		orderDAO.create(order);
		assertTrue(order.getOrderId() > 0 && order.getOrderDetails().size() == 2);
	}

	@Test
	public void testUpdateBookOrderShippingAddress() {
		Integer orderId = 1;
		BookOrder order = orderDAO.get(orderId);
		order.setShippingAddress("New Shipping Address");
		
		BookOrder updatedOrder = orderDAO.update(order);
		
		assertEquals(order.getShippingAddress(), updatedOrder.getShippingAddress());
	}
	
	@Test
	public void testUpdateBookOrderDetail() {
		Integer orderId = 5;
		BookOrder order = orderDAO.get(orderId);
		
		Iterator<OrderDetail> iterator = order.getOrderDetails().iterator();
		
		while(iterator.hasNext()) {
			OrderDetail orderDetail = iterator.next();
			if(orderDetail.getBook().getBookId() == 7) {
				orderDetail.setQuantity(3);
				orderDetail.setSubtotal(120);
			}
		}
		
		BookOrder updatedOrder = orderDAO.update(order);
		
		iterator = order.getOrderDetails().iterator();
		
		int expectedQuantity = 3;
		float expectedSubTotal = 120;
		int actualQuantity = 0;
		float actualSubTotal = 0.0f;
		
		while(iterator.hasNext()) {
			OrderDetail orderDetail = iterator.next();
			if(orderDetail.getBook().getBookId() == 7) {
				actualQuantity = orderDetail.getQuantity();
				actualSubTotal = orderDetail.getSubtotal();
			}
		}
		
		assertEquals(expectedQuantity, actualQuantity);
		assertEquals(expectedSubTotal, actualSubTotal, 0.0f);
	}
	

	@Test
	public void testGet() {
		Integer orderId = 1;
		BookOrder order = orderDAO.get(orderId);
		
		assertEquals(1, order.getOrderDetails().size());
	}

	@Test
	public void testDeleteObject() {
		int orderId = 5;
		orderDAO.delete(orderId);
		
		BookOrder order = orderDAO.get(orderId);
		
		assertNull(order);
	}

	@Test
	public void testListAll() {
		List<BookOrder> listOrders = orderDAO.listAll();
		
		assertTrue(listOrders.size() > 0);
	}

	@Test
	public void testCount() {
		long totalOrders = orderDAO.count();
		assertEquals(2, totalOrders);
	}

}
