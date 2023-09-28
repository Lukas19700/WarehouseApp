package com.example.warehouseapp.controllers;

import com.example.warehouseapp.models.ItemModel;
import com.example.warehouseapp.services.ItemService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemController {

  private ItemService itemService;

  public ItemController(ItemService itemService) {
    this.itemService = itemService;
  }

  @GetMapping("/home")
  public String getHomePage(Model model) {
    List<ItemModel> items = itemService.getAllItems();
    model.addAttribute("items", items);
    return "home";
  }

  @GetMapping("/addItem")
  public String addItem() {
    return "addItem";
  }

  @PostMapping("/addItem")
  public String addItem(ItemModel itemModel, Model model) {
    itemService.createItem(itemModel);
    model.addAttribute("item", itemModel);
    return "redirect:/home";
  }

  @GetMapping("/deleteItem/{ID}")
  public String deleteItem(@PathVariable Long ID) {
    itemService.deleteItem(ID);
    return "redirect:/home";
  }
  @GetMapping("/editItem/{ID}")
  public String getEditItem(@PathVariable(name = "ID") Long ID, Model model) {
    ItemModel item = itemService.findByID(ID);
    model.addAttribute("item", item);
    return "editItem";
  }

  @PostMapping("/editItem/{ID}")
  public String editItem(@PathVariable(name = "ID") Long ID, ItemModel updatedItem) {
    itemService.updateItem(ID, updatedItem);
    return "redirect:/home";
  }
  @PostMapping("/updateAmount/{ID}")
  public String updateItemAmount(
    @PathVariable(name = "ID") Long ID,
    @RequestParam(name = "newAmount") Integer newAmount
  ) {
    ItemModel existingItem = itemService.findByID(ID);

    if (existingItem != null) {
      existingItem.setAmount(newAmount);
      itemService.updateItem(ID,existingItem);
    }

    return "redirect:/home";
  }
}
