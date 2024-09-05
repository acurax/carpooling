package com.challenge.carpooling;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(IntegrationTestContainer.class)
@SpringBootTest
class CarpoolingApplicationTests {

	@Test
	void contextLoads() {
	}

}
