package com.example.crudrestapi.repos;

import com.example.crudrestapi.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserModel, Long> {
}
