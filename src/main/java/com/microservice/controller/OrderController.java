package com.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.dto.OrderDTO;
import com.microservice.dto.OrderDTOFromFE;
import com.microservice.entity.Order;
import com.microservice.service.OrderService;


@RestController @RequestMapping("/order")
 @CrossOrigin(origins = "*")

public class OrderController {
	
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/save")
	public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDTOFromFE){
		OrderDTO orderDTO = orderService.saveOrderInDb(orderDTOFromFE);
		return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public List<Order> getAll(){
		return orderService.getOrders();
	}
	
	@GetMapping("/msg")
	public String hi() {
		return "iuhfjksd sdfsdk";
	}

}
