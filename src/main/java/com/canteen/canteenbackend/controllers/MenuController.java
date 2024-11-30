package com.canteen.canteenbackend.controllers;

import com.canteen.canteenbackend.models.dbmodels.MenuItem;
import com.canteen.canteenbackend.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuItemRepository menuItemRepository;

    @GetMapping("/{canteenName}")
    public List<MenuItem> getMenu(@PathVariable String canteenName) {
    return menuItemRepository.findAllByCanteenName(canteenName);
    }
}
