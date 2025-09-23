package com.Bite_resturant.controller;

import com.Bite_resturant.dto.ItemDto;
import com.Bite_resturant.dto.request.ReservationDto;
import com.Bite_resturant.dto.response.ReservationResponseDto;
import com.Bite_resturant.service.ReservationService;
import com.Bite_resturant.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservation")
@CrossOrigin(origins = "http://localhost:5173")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<StandardResponse> saveReservation(@RequestBody ReservationDto reservationDto){
        String message = reservationService.saveReservation(reservationDto);
        StandardResponse response;
        if(message==null){
            response = new StandardResponse(404,message,null);
        }else{
            response = new StandardResponse(200,message,null);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/")
    public ResponseEntity<StandardResponse> getAllItem(){
        List<ReservationResponseDto> reservations = reservationService.getAllReservations();
        StandardResponse response=null;
        if(reservations==null){
            response = new StandardResponse(404,"no item found",null);
        }else{
            response = new StandardResponse(200,"Items founds",reservations);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/{email}")
    public ResponseEntity<StandardResponse> getAllReservationByEmail(@PathVariable String email){
        List<ReservationResponseDto> reservations = reservationService.getAllReservationByEmail(email);
        StandardResponse response=null;
        if(reservations==null){
            response = new StandardResponse(404,"no item found",null);
        }else{
            response = new StandardResponse(200,"Items founds",reservations);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }





}
