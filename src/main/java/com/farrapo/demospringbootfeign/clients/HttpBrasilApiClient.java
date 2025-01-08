package com.farrapo.demospringbootfeign.clients;

import com.farrapo.demospringbootfeign.dtos.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "brasilapi", url = "${feign.url}")
public interface HttpBrasilApiClient {

    @GetMapping(value = "/api/cep/v2/{cep}", produces = "application/json")
    AddressDto getAddress(@PathVariable("cep") String cep);
}
