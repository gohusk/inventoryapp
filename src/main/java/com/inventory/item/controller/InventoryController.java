package com.inventory.item.controller;

import com.inventory.item.model.InventoryType;
import com.inventory.item.repositories.InventoryRepository;
import com.sun.org.apache.xerces.internal.util.HTTPInputSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;


@RestController
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;


    @RequestMapping(value="/api/allinventory", method = RequestMethod.GET)
    public List<InventoryType> getAll() {
         return inventoryRepository.findAll();
    }

    /**
     * Not a well designed method. Don't want to engineer anyty8hing beyond what you basically get out of the box
     * with spring boot so filtering on the client side to illustrate a point on the test code side. You'd obviously
     * just query the db for true values.
     * @return
     */
    @RequestMapping(value = "/api/allactiveinventory", method = RequestMethod.GET)
    public List<InventoryType> getAllActive() {
        List<InventoryType> items = inventoryRepository.findAll();
        List<InventoryType> retval = items.stream().filter(item -> item.getIsActive()).collect(Collectors.toList());
        return retval;
    }
}
