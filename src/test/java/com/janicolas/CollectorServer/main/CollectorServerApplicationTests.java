package com.janicolas.CollectorServer.main;

import com.janicolas.CollectorServer.controller.UserController;
import com.janicolas.CollectorServer.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CollectorServerApplicationTests {

	@Autowired
	private UserController userController;

	@Test
	void getAllUsers() {
		List<User> users = userController.getUsers();
		users.forEach(System.out::println);
	}

}
