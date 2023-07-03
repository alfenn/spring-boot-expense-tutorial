package com.alex.springbootmongodbtutorial.respository;

import com.alex.springbootmongodbtutorial.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

// By extending the mongorepostiory, expense repository will inherit all the basic capabilities to do db operations
public interface ExpenseRepository extends MongoRepository<Expense, String> {
    @Query("{'name': ?0}")
    Optional<Expense> findByName(String name);
}
