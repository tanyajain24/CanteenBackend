package com.canteen.canteenbackend.repositories;

import com.canteen.canteenbackend.models.dbmodels.MenuItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MenuItemRepository extends MongoRepository<MenuItem, String> {
    public List<MenuItem> findAllByCanteenName(String canteenName);

}
