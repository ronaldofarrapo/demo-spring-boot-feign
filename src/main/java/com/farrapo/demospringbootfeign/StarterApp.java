package com.farrapo.demospringbootfeign;

import com.farrapo.demospringbootfeign.dtos.AddressDto;
import com.farrapo.demospringbootfeign.services.BuscadorCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
public class StarterApp {

	public static void main(String[] args) {
		SpringApplication.run(StarterApp.class, args);
	}

	@RestController
	public static class HttpCatsApiController {

		@Autowired
		BuscadorCepService service;

		@GetMapping("/{cep}")
		public ResponseEntity<AddressDto> getAddress(@PathVariable("cep") String cep){
			return 	ResponseEntity.status(HttpStatus.OK).body(service.find(cep));
		}
	}

}
