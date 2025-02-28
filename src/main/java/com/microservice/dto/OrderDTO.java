package com.microservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @Builder
public class OrderDTO {


    private Integer orderId;
    private List<FoodItemDTO> foodItemsList;
    private Restaurant restaurant;
    private UserDTO userDTO;
	public OrderDTO(Integer orderId, List<FoodItemDTO> foodItemsList, Restaurant restaurant, UserDTO userDTO) {
		super();
		this.orderId = orderId;
		this.foodItemsList = foodItemsList;
		this.restaurant = restaurant;
		this.userDTO = userDTO;
	}
    
    
}
