package com.canteen.canteenbackend.repositories;

import com.canteen.canteenbackend.models.dbmodels.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository   extends MongoRepository<Order, String> {
    public List<Order> findAllByEmail(String email);

}
