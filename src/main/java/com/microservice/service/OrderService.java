package com.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.dto.OrderDTO;
import com.microservice.dto.OrderDTOFromFE;
import com.microservice.dto.UserDTO;
import com.microservice.entity.Order;
import com.microservice.repository.OrderRepo;

@Service
public class OrderService {

	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private SequenceGenerator sequenceGenerator;
	
	
	@Autowired
	private RestTemplate restTemplate;

    public OrderDTO saveOrderInDb(OrderDTOFromFE orderDetails) {
        Integer newOrderID = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO = null; 
        Order orderToBeSaved = new Order(newOrderID, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(), userDTO );
        orderRepo.save(orderToBeSaved);
        OrderDTO orderDTO = OrderDTO.builder().foodItemsList(orderToBeSaved.getFoodItemLists()).orderId(newOrderID)
        	.restaurant(orderToBeSaved.getRestaurant()).userDTO(orderToBeSaved.getUserDTO()).build();
         return orderDTO;
    }

    private UserDTO fetchUserDetailsFromUserId(Integer userId) {
       return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userId, UserDTO.class);
    }	
	public List<Order> getOrders(){
		return orderRepo.findAll();
	}

}
