package com.example.models;

import com.example.models.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

	@Autowired
	private ClienteRepository clienteRepository;

	@Test
	void contextLoads() {
		System.out.println("Context loads test running...");
		// Teste do repositório
	}
}