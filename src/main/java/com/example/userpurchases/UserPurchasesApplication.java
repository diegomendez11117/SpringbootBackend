package com.example.userpurchases;

import com.example.userpurchases.model.Purchase;
import com.example.userpurchases.model.User;
import com.example.userpurchases.repository.PurchaseRepository;
import com.example.userpurchases.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class UserPurchasesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UserPurchasesApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PurchaseRepository purchaseRepository;

	/**
	 * This method helps to run all the data saved on the repositories.
	 * @param args
	 * @throws {Exception}
	 */

	@Override
	public void run(String... args) throws Exception {

		Purchase purchase1 = new Purchase("bread", 190, "February");
		Purchase purchase2 = new Purchase("eggs", 45, "March");
		Purchase purchase3 = new Purchase("butter", 99, "February");
		Purchase purchase4 = new Purchase("water", 22, "March");
		Purchase purchase5 = new Purchase("meat", 221, "February");
		Purchase purchase6 = new Purchase("pasta", 177, "January");
		Purchase purchase7 = new Purchase("oil", 102, "January");
		Purchase purchase8 = new Purchase("gas", 301, "March");
		Purchase purchase9 = new Purchase("sugar", 12, "February");
		Purchase purchase10 = new Purchase("tortillas", 57, "January");
		Purchase purchase11 = new Purchase("salt", 201, "January");
		Purchase purchase12 = new Purchase("cumin", 171, "March");
		Purchase purchase13 = new Purchase("ice cream", 51, "February");
		Purchase purchase14 = new Purchase("tomato", 89, "March");
		Purchase purchase15 = new Purchase("garlic", 202, "January");
		Purchase purchase16 = new Purchase("onion", 78, "March");
		Purchase purchase17 = new Purchase("pepper", 232, "March");
		Purchase purchase18 = new Purchase("candy", 123, "January");
		Purchase purchase19 = new Purchase("avocado", 1, "January");
		Purchase purchase20 = new Purchase("yogurt", 120, "February");
		Purchase purchase21 = new Purchase("milk", 234, "March");

		User user = new User("Brian","Adams","badams@gmail.com");
		User user1 = new User("John","Smith","jsmith@gmail.com");
		User user2 = new User("Will","Cannon","wcannon@gmail.com");

		user.getPurchaseList().add(purchase1);
		user.getPurchaseList().add(purchase2);
		user.getPurchaseList().add(purchase3);
		user.getPurchaseList().add(purchase4);
		user.getPurchaseList().add(purchase5);
		user.getPurchaseList().add(purchase6);

		user1.getPurchaseList().add(purchase15);
		user1.getPurchaseList().add(purchase16);
		user1.getPurchaseList().add(purchase17);
		user1.getPurchaseList().add(purchase18);
		user1.getPurchaseList().add(purchase19);
		user1.getPurchaseList().add(purchase20);
		user1.getPurchaseList().add(purchase21);

		user2.getPurchaseList().add(purchase7);
		user2.getPurchaseList().add(purchase8);
		user2.getPurchaseList().add(purchase9);
		user2.getPurchaseList().add(purchase10);
		user2.getPurchaseList().add(purchase11);
		user2.getPurchaseList().add(purchase12);
		user2.getPurchaseList().add(purchase13);
		user2.getPurchaseList().add(purchase14);

		List<User> userList = new ArrayList<>();

		userList.add(user);
		userList.add(user1);
		userList.add(user2);
		this.userRepository.saveAll(userList);
	}
}
