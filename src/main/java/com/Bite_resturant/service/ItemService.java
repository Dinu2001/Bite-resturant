package com.Bite_resturant.service;

import com.Bite_resturant.dto.ItemDto;
import com.Bite_resturant.entity.Item;
import com.Bite_resturant.repo.ItemRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepo itemRepo;


    public String saveItems(ItemDto itemDto) {
        try{
            Item item = new Item(
                    itemDto.getItemCode(),itemDto.getItemName(),itemDto.getDescription(),itemDto.getPrice(),
                    itemDto.getImagePath(), itemDto.getType(),itemDto.isStatus()
            );
            Item saveditem = itemRepo.save(item);
            if(saveditem==null){
                return null;
            }else{
                return "save successfully";
            }
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public List<ItemDto> getAllItems() {
        try{
            List<ItemDto> itemDtoList = new ArrayList<>();
            List<Item> itemList = itemRepo.findAll();
            if(itemList.isEmpty()){
                return null;
            }else{
                for(Item item:itemList){
                    ItemDto itemDto = new ItemDto(
                            item.getItemCode(),item.getItemName(),item.getDescription(),item.getPrice(),
                            item.getImagePath(),item.getType(),item.isStatus()
                    );

                    itemDtoList.add(itemDto);
                }
                return itemDtoList;
            }
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }

    }

    public ItemDto getByItemCode(String code) {
        try{
            Optional<Item> item = itemRepo.findByItemCode(code);
            if(item.isEmpty()){
                return null;
            }else{
                ItemDto itemDto = new ItemDto(
                        item.get().getItemCode(),item.get().getItemName(),item.get().getDescription(),
                        item.get().getPrice(),item.get().getImagePath(),item.get().getType(),item.get().isStatus()
                );
                return itemDto;
            }

        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    public String updateItem(String code, ItemDto itemDto) {
        try{
            Optional<Item> item = itemRepo.findByItemCode(itemDto.getItemCode());
            if(item.isEmpty()){
                return null;
            }else{
                Item updatedeItem = new Item(
                        itemDto.getItemCode(),itemDto.getItemName(),itemDto.getDescription(),itemDto.getPrice(),
                        itemDto.getImagePath(), itemDto.getType(),itemDto.isStatus()
                );
                Item saveditem = itemRepo.save(updatedeItem);
                if(saveditem==null){
                    return null;
                }else{
                    return "updated successfully";
                }
            }
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Transactional
    public String deleteItem(String code) {
        try{
            System.out.println(code);
            Optional<Item> item = itemRepo.findByItemCode(code);
            if(item.isEmpty()){
                return null;
            }else{
                itemRepo.deleteByItemCode(code);
                return "delete item";
            }

        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }


    public List<ItemDto> getByItemName(String name) {
        try{
            List<ItemDto> itemDtoList = new ArrayList<>();
            List<Item> itemList = itemRepo.findAllByItemNameStartingWithIgnoreCase(name);
            if(itemList.isEmpty()){
                return null;
            }else{
                for(Item item:itemList){
                    ItemDto itemDto = new ItemDto(
                            item.getItemCode(),item.getItemName(),item.getDescription(),item.getPrice(),
                            item.getImagePath(),item.getType(),item.isStatus()
                    );

                    itemDtoList.add(itemDto);
                }
                return itemDtoList;
            }
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
    }
}
