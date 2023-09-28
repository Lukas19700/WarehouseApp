package com.example.warehouseapp.services;

import com.example.warehouseapp.models.ItemModel;
import com.example.warehouseapp.repositories.ItemRepo;
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

  public void createItem(ItemModel itemModel) {
    itemRepo.save(itemModel);
  }

  public void deleteItem(Long ID) {
    itemRepo.deleteById(ID);
  }

  public ItemModel updateItem(Long ID) {
    ItemModel existingItem = itemRepo.findByID(ID);
    existingItem.setName(itemModel.getName());
    existingItem.setDescription(itemModel.getDescription());
    existingItem.setAmount(itemModel.getAmount());
    existingItem.setPrice(itemModel.getPrice());
    return itemRepo.save(existingItem);

  }
}
