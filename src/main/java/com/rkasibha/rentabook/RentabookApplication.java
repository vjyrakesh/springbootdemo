package com.rkasibha.rentabook;

import com.rkasibha.rentabook.model.Role;
import com.rkasibha.rentabook.model.User;
import com.rkasibha.rentabook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class RentabookApplication {


	public static void main(String[] args) {

		SpringApplication.run(RentabookApplication.class, args);
	}
}

@Component
class DemoCommandLineRunner implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUsername("test");
		user.setPassword(passwordEncoder.encode("test"));
		user.grantAuthority(Role.ROLE_ADMIN);

		//userRepository.save(user);
	}
}
