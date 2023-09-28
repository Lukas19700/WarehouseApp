package com.example.warehouseapp.repositories;

import com.example.warehouseapp.models.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<ItemModel, Long> {
ItemModel findByID(Long ID);
}
