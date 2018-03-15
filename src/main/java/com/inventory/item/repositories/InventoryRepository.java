package com.inventory.item.repositories;

import com.inventory.item.model.InventoryType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by plavelle on 3/14/2018.
 */
public interface InventoryRepository extends CrudRepository<InventoryType, Long> {
    InventoryType findById(int id);
    List<InventoryType> findAll();
}
