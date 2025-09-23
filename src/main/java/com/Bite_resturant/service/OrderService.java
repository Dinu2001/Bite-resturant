package com.Bite_resturant.service;

import com.Bite_resturant.dto.request.ListItemDto;
import com.Bite_resturant.dto.request.OrderDetailsUpdateDto;
import com.Bite_resturant.dto.request.OrderRequestDto;
import com.Bite_resturant.dto.response.OrderResponseDto;
import com.Bite_resturant.entity.Item;
import com.Bite_resturant.entity.OrderItem;
import com.Bite_resturant.entity.Orders;
import com.Bite_resturant.entity.User;
import com.Bite_resturant.repo.ItemRepo;
import com.Bite_resturant.repo.OrderItemRepo;
import com.Bite_resturant.repo.OrderRepo;
import com.Bite_resturant.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderItemRepo orderItemRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ItemRepo itemRepo;

    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }


    public String saveOrder(OrderRequestDto orderRequestDto) {
        try {
            // 1️⃣ Find the user by email
            User user = userRepo.findById(orderRequestDto.getUserEmail())
                    .orElse(null);
            if (user == null) {
                return null; // or throw exception: user not found
            }

            // 2️⃣ Create the Orders entity
            Orders orders = new Orders();
            orders.setUser(user);
            orders.setAmount(orderRequestDto.getAmount());
            orders.setOrderStatus(orderRequestDto.getStatus());


            //set current date to the orders(optional item)
            Date sqlDate = Date.valueOf(getCurrentDate());
            orders.setOrderDate(sqlDate);


            // 3️⃣ Save the order first (so we have orderId for OrderItems)
            Orders savedOrder = orderRepo.save(orders);

            // 4️⃣ Create OrderItems and link them
            List<OrderItem> orderItems = new ArrayList<>();
            for (ListItemDto itemDto : orderRequestDto.getItemDtoList()) {
                Item item = itemRepo.findById(itemDto.getItemCode())
                        .orElse(null);
                if (item != null) {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setOrders(savedOrder);
                    orderItem.setItem(item);
                    orderItem.setQuantity(itemDto.getQuantity());
                    orderItems.add(orderItem);
                }
            }

            // 5️⃣ Save all OrderItems (cascade can also do this if set)
            orderItemRepo.saveAll(orderItems);

            return "Order saved successfully with ID: " + savedOrder.getOrderId();
        } catch (Exception e) {
            System.out.println("Error saving order: " + e.getMessage());
            return null;
        }
    }


    public List<OrderResponseDto> getOrderDetails() {
        try {
            List<OrderResponseDto> orderResponseDtos = new ArrayList<>();

            // 1️⃣ Fetch all orders
            List<Orders> ordersList = orderRepo.findAll();

            // 2️⃣ Convert each order into OrderResponseDto
            for (Orders order : ordersList) {
                OrderResponseDto dto = new OrderResponseDto();
                dto.setId(order.getOrderId());
                dto.setEmail(order.getUser().getEmail());
                dto.setFirstName(order.getUser().getFirstName());
                dto.setLastName(order.getUser().getLastName());
                dto.setAmount(order.getAmount());
                dto.setOrderStatus(order.getOrderStatus());
                dto.setDate(order.getOrderDate());

                // 3️⃣ Convert OrderItems into ListItemDto
                List<ListItemDto> itemDtos = new ArrayList<>();
                for (OrderItem orderItem : order.getOrderItems()) {
                    ListItemDto itemDto = new ListItemDto();
                    itemDto.setItemCode(orderItem.getItem().getItemCode());
                    itemDto.setQuantity(orderItem.getQuantity());
                    itemDtos.add(itemDto);
                }

                dto.setItemDtoList(itemDtos);
                orderResponseDtos.add(dto);
            }

            return orderResponseDtos;

        } catch (Exception e) {
            System.out.println("Error fetching order details: " + e.getMessage());
            return null;
        }
    }

    public List<OrderResponseDto> getOrderDetailsByEmail(String email) {
        try {
            List<OrderResponseDto> orderResponseDtos = new ArrayList<>();
            User user = userRepo.findByEmail(email);

            if(user==null){
                return null;
            }else{
                // 1️⃣ Fetch all orders
                List<Orders> ordersList = orderRepo.findAllByUserEmail(email);
                // 2️⃣ Convert each order into OrderResponseDto
                for (Orders order : ordersList) {
                    OrderResponseDto dto = new OrderResponseDto();
                    dto.setId(order.getOrderId());
                    dto.setEmail(order.getUser().getEmail());
                    dto.setFirstName(order.getUser().getFirstName());
                    dto.setLastName(order.getUser().getLastName());
                    dto.setAmount(order.getAmount());
                    dto.setOrderStatus(order.getOrderStatus());
                    dto.setDate(order.getOrderDate());

                    // 3️⃣ Convert OrderItems into ListItemDto
                    List<ListItemDto> itemDtos = new ArrayList<>();
                    for (OrderItem orderItem : order.getOrderItems()) {
                        ListItemDto itemDto = new ListItemDto();
                        itemDto.setItemCode(orderItem.getItem().getItemCode());
                        itemDto.setQuantity(orderItem.getQuantity());
                        itemDtos.add(itemDto);
                    }

                    dto.setItemDtoList(itemDtos);
                    orderResponseDtos.add(dto);
                }

                return orderResponseDtos;
            }


        } catch (Exception e) {
            System.out.println("Error fetching order details: " + e.getMessage());
            return null;
        }

    }

    public List<OrderResponseDto> getOrderByDate(java.util.Date date) {
        try {
            List<OrderResponseDto> orderResponseDtos = new ArrayList<>();

            if(date==null){
                return null;
            }else{
                // 1️⃣ Fetch all orders
                List<Orders> ordersList = orderRepo.findAllByOrderDate(date);
                // 2️⃣ Convert each order into OrderResponseDto
                for (Orders order : ordersList) {
                    OrderResponseDto dto = new OrderResponseDto();
                    dto.setId(order.getOrderId());
                    dto.setEmail(order.getUser().getEmail());
                    dto.setFirstName(order.getUser().getFirstName());
                    dto.setLastName(order.getUser().getLastName());
                    dto.setAmount(order.getAmount());
                    dto.setOrderStatus(order.getOrderStatus());
                    dto.setDate(order.getOrderDate());

                    // 3️⃣ Convert OrderItems into ListItemDto
                    List<ListItemDto> itemDtos = new ArrayList<>();
                    for (OrderItem orderItem : order.getOrderItems()) {
                        ListItemDto itemDto = new ListItemDto();
                        itemDto.setItemCode(orderItem.getItem().getItemCode());
                        itemDto.setQuantity(orderItem.getQuantity());
                        itemDtos.add(itemDto);
                    }

                    dto.setItemDtoList(itemDtos);
                    orderResponseDtos.add(dto);
                }

                return orderResponseDtos;
            }


        } catch (Exception e) {
            System.out.println("Error fetching order details: " + e.getMessage());
            return null;
        }
    }

    public String updateOrderDetails(int id, OrderDetailsUpdateDto orderDetailsUpdateDto) {
        try {
            Optional<Orders> optionalOrder = orderRepo.findByOrderId(id);
            if (optionalOrder.isEmpty()) {
                return null;
            }

            Orders order = optionalOrder.get();
            order.setOrderStatus(orderDetailsUpdateDto.getOrderStatus()); // update status
            orderRepo.save(order);

            return "Order updated successfully";
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
