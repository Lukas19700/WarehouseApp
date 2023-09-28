package com.example.warehouseapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "warehouse")
public class ItemModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID;
  private String name;
  private String description;
  private Double price;
  private Integer amount;

  public ItemModel(String name, String description, Double price, Integer amount) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.amount = amount;
  }

  public ItemModel() {

  }

  public Long getID() {
    return ID;
  }

  public void setID(Long ID) {
    this.ID = ID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }
}
