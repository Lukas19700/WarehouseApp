package com.example.warehouseapp.services;

import com.example.warehouseapp.models.ItemModel;
import com.example.warehouseapp.repositories.ItemRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

  private ItemRepo itemRepo;
  private ItemModel itemModel;

  @Autowired
  public ItemService(ItemRepo itemRepo) {
    this.itemRepo = itemRepo;
  }

  public List<ItemModel> getAllItems() {
    return itemRepo.findAll();
  }

  public void createItem(ItemModel itemModel) {
    itemRepo.save(itemModel);
  }

  public void deleteItem(Long ID) {
    itemRepo.deleteById(ID);
  }

  public ItemModel findByID(Long ID) {
    return itemRepo.findByID(ID);
  }

  public void updateItem(Long ID, ItemModel updatedItem) {
    ItemModel existingItem = itemRepo.findByID(ID);
    if (existingItem != null) {
      existingItem.setName(updatedItem.getName());
      existingItem.setDescription(updatedItem.getDescription());
      existingItem.setAmount(updatedItem.getAmount());
      existingItem.setPrice(updatedItem.getPrice());
      itemRepo.save(existingItem);
    }
  }
}
