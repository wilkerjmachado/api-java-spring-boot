package com.example.apijavaspringboot;

import com.example.apijavaspringboot.api.ClientApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("dev")
@SpringBootTest
class ApijavaspringbootApplicationTests {

	@Autowired
	private ClientApi clientApi;

	@Test
	void contextLoads() {

		assertThat(clientApi).isNotNull();
	}

}
