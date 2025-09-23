package com.Bite_resturant.controller;

import com.Bite_resturant.dto.request.OrderDetailsUpdateDto;
import com.Bite_resturant.dto.request.OrderRequestDto;
import com.Bite_resturant.dto.response.OrderResponseDto;
import com.Bite_resturant.service.OrderService;
import com.Bite_resturant.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveOrder(@RequestBody OrderRequestDto orderRequestDto){
        String message = orderService.saveOrder(orderRequestDto);
        StandardResponse response=null;
        if(message==null){
            response = new StandardResponse(404,"order not save to the database",null);
        }else{
            response = new StandardResponse(200,"order save to the database",message);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/")
    public ResponseEntity<StandardResponse> getAllOrderDetails(){
        List<OrderResponseDto> orderDetails = orderService.getOrderDetails();
        StandardResponse response=null;
        if(orderDetails.isEmpty()){
            response = new StandardResponse(404,"order not save to the database",null);
        }else{
            response = new StandardResponse(200,"order save to the database",orderDetails);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/{email}")
    public ResponseEntity<StandardResponse> getOrderDetailsByEmail(@PathVariable String email){
        List<OrderResponseDto> orderDetails = orderService.getOrderDetailsByEmail(email);
        StandardResponse response=null;
        if(orderDetails == null){
            response = new StandardResponse(404,"No orders found in the database",null);
        }else{
            response = new StandardResponse(200,"order found to the database",orderDetails);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @PutMapping("/update-status/{id}")
    public ResponseEntity<StandardResponse> updateOrderDetail(@PathVariable int id, @RequestBody OrderDetailsUpdateDto orderDetailsUpdateDto){
        String message = orderService.updateOrderDetails(id,orderDetailsUpdateDto);
        StandardResponse response=null;
        if(message==null){
            response = new StandardResponse(404,"order not update to the database..",null);
        }else{
            response = new StandardResponse(200,"order update...",message);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @GetMapping("/get-by-date/{date}")
    public ResponseEntity<StandardResponse> getOrderDetailsByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date){
        List<OrderResponseDto> orderDetails = orderService.getOrderByDate(date);
        StandardResponse response=null;
        if(orderDetails == null){
            response = new StandardResponse(404,"No orders found in the database",null);
        }else{
            response = new StandardResponse(200,"order found to the database",orderDetails);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
