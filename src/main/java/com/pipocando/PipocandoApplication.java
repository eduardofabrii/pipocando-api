package com.pipocando;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pipocando.domain.user.User;
import com.pipocando.domain.user.UserRole;
import com.pipocando.repository.UserRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class PipocandoApplication implements CommandLineRunner{

	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(PipocandoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Users creation
		User usuario1 = new User();
		usuario1.setName("Cleverson Lima");
		usuario1.setEmail("clever@gmail.com");
		usuario1.setPassword(passwordEncoder.encode("webdev@123"));
		usuario1.setRole(UserRole.ADMIN);
		usuario1.setActive(true);

		List<User> usuarios = Arrays.asList(
			usuario1
		);
		
		userRepository.saveAll(usuarios);
	}
}
