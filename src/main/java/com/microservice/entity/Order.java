package com.microservice.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.microservice.dto.FoodItemDTO;
import com.microservice.dto.Restaurant;
import com.microservice.dto.UserDTO;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data @NoArgsConstructor @Document("order")
public class Order {

	private Integer orderId;
	private List<FoodItemDTO> foodItemLists;
	private Restaurant restaurant;
	private UserDTO userDTO;
	public Order(Integer orderId, List<FoodItemDTO> foodItemLists, Restaurant restaurant, UserDTO userDTO) {
		super();
		this.orderId = orderId;
		this.foodItemLists = foodItemLists;
		this.restaurant = restaurant;
		this.userDTO = userDTO;
	}
	
	
	
}
