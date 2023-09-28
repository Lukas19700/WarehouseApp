package com.example.warehouseapp.controllers;

import com.example.warehouseapp.services.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {
  private ItemService itemService;

  public ItemController(ItemService itemService) {
    this.itemService = itemService;
  }
  @GetMapping("/home")
  public String getHomePage() {
    return "home";
  }
}
