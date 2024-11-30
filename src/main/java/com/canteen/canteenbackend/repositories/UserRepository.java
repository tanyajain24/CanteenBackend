package com.canteen.canteenbackend.repositories;

import com.canteen.canteenbackend.models.dbmodels.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByEmail(String email);
    public boolean existsByEmail(String email);
}
