package com.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Orders;
import com.entity.Product;
import com.repository.OrdersRepository;

@Service
public class OrdersService {

	@Autowired
	OrdersRepository orderRepository;
	
	@Autowired
	ProductService productService;
	
	public String placeOrder(Orders order) {
		order.setOdateandtime(LocalDateTime.now());   // set system date and time 
		//orderRepository.save(order);
		Product productFromDb = productService.findProduct(order.getPid());
		if(productFromDb==null) {
			return "Product not present";
		}else {
			if(productFromDb.getQty() >=order.getQty()) {
				productFromDb.setQty(productFromDb.getQty()-order.getQty());
				productService.updateProduct(productFromDb);
				
				order.setTotalprice(order.getQty()*productFromDb.getPrice());
				orderRepository.save(order);
				return "Order placed successfully";
				
			}else {
				return "InSuccficient qty, you can't place the order";
			}
		}
	}
	
	public List<Orders> findAllOrdersDetails() {
		return orderRepository.findAll();
	}
}
