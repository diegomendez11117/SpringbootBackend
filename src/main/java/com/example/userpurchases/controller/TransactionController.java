package com.example.userpurchases.controller;

import com.example.userpurchases.model.Purchase;
import com.example.userpurchases.model.Transaction;
import com.example.userpurchases.model.User;
import com.example.userpurchases.repository.PurchaseRepository;
import com.example.userpurchases.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Controller that helps to show the information about all the transactions made for a user.
 * This Controller also calculate the points earned by month and total.
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class TransactionController {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private UserRepository userRepository;


    /**
     * This method shows the transactions by month with Get method.
     * @return {List<Transaction>} is the list to show all the transactions made by months
     */
    @GetMapping("transactions/month")
    public List<Transaction> showTransactionsMonth(){
        return this.getTransactionsMonths();
    }

    /**
     * This method shows the transactions by total with Get method.
     * @return {List<Transaction>} is the list to show all the transactions made by total
     */
    @GetMapping("transactions/total")
    public List<Transaction> showTransactionsTotal(){
        return this.getTransactionsTotal();
    }

    /**
     * This method obtains the transactions by month that was saved on the repository.
     * @return {List<Transaction>}
     */
    public List<Transaction> getTransactionsMonths(){

        List<Transaction> transactions = new ArrayList<>();

        List<User> userList = userRepository.findAll();

        long id = 0;

        for (User user : userList) {

            Map<String, List<Purchase>> listMap =
                    user.getPurchaseList().stream().collect(Collectors.groupingBy(Purchase::getMonth));

            for (Map.Entry<String, List<Purchase>> entry : listMap.entrySet()){
                double rewards = entry.getValue().stream().mapToDouble(Purchase::getPrice).sum();
                Transaction transaction = new Transaction(id++,user.getFirstName(), user.getLastName(), entry.getKey(), entry.getValue().size(), rewards);
                transactions.add(transaction);
            }
        }

        return transactions;

    }

    /**
     * This method obtains the transactions total that was saved on the repository.
     * @return {List<Transaction>}
     */
    public List<Transaction> getTransactionsTotal(){
        List<Transaction> transactions = new ArrayList<>();

        List<User> userList = userRepository.findAll();

        long id = 0;

        for (User user : userList) {

            Map<String, List<Purchase>> listMap =
                    user.getPurchaseList().stream().collect(Collectors.groupingBy(Purchase::getMonth));

            int transactionsCount = 0;
            double rewards = 0;

            for (Map.Entry<String, List<Purchase>> entry : listMap.entrySet()){
                rewards += entry.getValue().stream().mapToDouble(Purchase::getPrice).sum();
                transactionsCount += entry.getValue().size();
            }

            transactions.add(new Transaction(id++,user.getFirstName(), user.getLastName(), transactionsCount, rewards));

        }

        return transactions;
    }

    /**
     * This method helps to get the rewards calculating how many points the user earned
     * @param {price} this is the price of the item bought by any user.
     * @return {double} the result of the calculation.
     */
    private double calcRewards(double price){
        double rewards = 0;
        if(price - 100 > 0 )
            rewards += (price - 100 ) * 2;
        if(price > 50)
            rewards += price;
        return rewards;
    }
}
