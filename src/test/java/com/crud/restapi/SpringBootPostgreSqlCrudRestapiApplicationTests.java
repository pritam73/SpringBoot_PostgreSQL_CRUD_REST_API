package com.crud.restapi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.crud.restapi.model.User;
import com.crud.restapi.repository.UserRepository;

@DataJpaTest
// By default @DataJpaTest replaces your DataSource with an embedded database,
// if you test with your local database then try with below line
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SpringBootPostgreSqlCrudRestapiApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void createUser() {
		User user = userRepository.save(new User(1, "Test User 1", "user1@gmail.com", "9876543210", "12345"));
		assertThat(user).hasFieldOrPropertyWithValue("name", "Test User 1");
		assertThat(user).hasFieldOrPropertyWithValue("email", "user1@gmail.com");
		assertThat(user).hasFieldOrPropertyWithValue("mobNo", "9876543210");
		assertThat(user).hasFieldOrPropertyWithValue("password", "12345");
	}

	@Test
	public void getAllUsers() {
		User user1 = userRepository.save(new User(1, "Test User 1", "user1@gmail.com", "9876543210", "12345"));
		entityManager.persist(user1);
		User user2 = userRepository.save(new User(2, "Test User 2", "user2@gmail.com", "9876543211", "123456"));
		entityManager.persist(user2);
		User user3 = userRepository.save(new User(3, "Test User 3", "user3@gmail.com", "9876543212", "1234"));
		entityManager.persist(user3);
		User user4 = userRepository.save(new User(4, "Test User 4", "user4@gmail.com", "9876543245", "123"));
		entityManager.persist(user4);
		Iterable<User> users = userRepository.findAll();
		assertThat(users).hasSize(4).contains(user1, user2, user3, user4);
	}

	@Test
	public void getUserById() {
		User user1 = userRepository.save(new User(1, "Test User 1", "user1@gmail.com", "9876543210", "12345"));
		entityManager.persist(user1);
		User user2 = userRepository.save(new User(2, "Test User 2", "user2@gmail.com", "9876543211", "123456"));
		entityManager.persist(user2);
		User user3 = userRepository.save(new User(3, "Test User 3", "user3@gmail.com", "9876543212", "1234"));
		entityManager.persist(user3);
		User user4 = userRepository.save(new User(4, "Test User 4", "user4@gmail.com", "9876543245", "123"));
		entityManager.persist(user4);
		User user = userRepository.findById(user4.getId()).get();
		assertThat(user).isEqualTo(user4);
	}

}
