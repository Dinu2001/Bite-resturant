package com.Bite_resturant.controller;

import com.Bite_resturant.dto.ItemDto;
import com.Bite_resturant.service.ItemService;
import com.Bite_resturant.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin("*")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemDto itemDto){
        String message = itemService.saveItems(itemDto);
        StandardResponse response=null;
        if(message==null){
            response = new StandardResponse(404,"Item not add to the database",null);
        }else{
            response = new StandardResponse(200,"Item add to the database",message);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<StandardResponse> getAllItem(){
        List<ItemDto> itemDtos = itemService.getAllItems();
        StandardResponse response=null;
        if(itemDtos==null){
            response = new StandardResponse(404,"no item found",null);
        }else{
            response = new StandardResponse(200,"Items founds",itemDtos);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/{code}")
    public ResponseEntity<StandardResponse> getAllItem(@PathVariable String code){
        ItemDto itemDto = itemService.getByItemCode(code);
        StandardResponse response=null;
        if(itemDto==null){
            response = new StandardResponse(404,"no item found",null);
        }else{
            response = new StandardResponse(200,"Items founds",itemDto);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get-by-name/{name}")
    public ResponseEntity<StandardResponse> getByItemName(@PathVariable String name){
        List<ItemDto> itemDto = itemService.getByItemName(name);
        StandardResponse response=null;
        if(itemDto==null){
            response = new StandardResponse(404,"no item found",null);
        }else{
            response = new StandardResponse(200,"Items founds",itemDto);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }







    @PutMapping("/update/{code}")
    public ResponseEntity<StandardResponse> updateItem(@RequestBody ItemDto itemDto,String code){
        String message = itemService.updateItem(code,itemDto);
        StandardResponse response=null;
        if(message==null){
            response = new StandardResponse(404,"Item not found in dataset",null);
        }else{
            response = new StandardResponse(200,"Item updated",message);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @DeleteMapping("/delete/{code}")
    public ResponseEntity<StandardResponse> deleteItem(@PathVariable String code){
        System.out.println("controller"+code);
        String message = itemService.deleteItem(code);
        StandardResponse response=null;
        if(message==null){
            response = new StandardResponse(404,"Item not found in dataset",null);
        }else{
            response = new StandardResponse(200,"Item deleted",message);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
