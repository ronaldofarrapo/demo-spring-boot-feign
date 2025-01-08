package com.farrapo.demospringbootfeign;

import com.farrapo.demospringbootfeign.services.BuscadorCepService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class StarterAppTests {

	@Autowired
	private BuscadorCepService buscadorCepService;

	@Test
	void contextLoads() {
		assertNotNull(buscadorCepService);
	}

}
