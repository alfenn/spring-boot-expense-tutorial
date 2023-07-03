package com.alex.springbootmongodbtutorial.controller;

import com.alex.springbootmongodbtutorial.model.Expense;
import com.alex.springbootmongodbtutorial.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    // To be able to implement these methods, we need a service layer... so def new package
    // ... now we go back to the expensecontroller and autowire the expense controller.
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping // post mapping annotation
    public ResponseEntity addExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
        // Standard REST api convention for post method to return status as "created"
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    // This is an update request so according to rest conventions, we use PUT request
    public ResponseEntity<Object> updateExpense(@RequestBody Expense expense) {
        expenseService.updateExpense(expense);
        return ResponseEntity.ok().build();
    }

    // Implementing this so we can read all the expenses from the database back to the service
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        // encapsulate the find all in a response entity and return it from the controller back to the client
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Expense> getExpenseByName(@PathVariable String name) {
        return ResponseEntity.ok(expenseService.getExpenseByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
