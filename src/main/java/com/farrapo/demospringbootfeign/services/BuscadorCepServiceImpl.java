package com.farrapo.demospringbootfeign.services;

import com.farrapo.demospringbootfeign.clients.HttpBrasilApiClient;
import com.farrapo.demospringbootfeign.dtos.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscadorCepServiceImpl implements BuscadorCepService {
    @Autowired
    HttpBrasilApiClient client;

    @Override
    public AddressDto find(String cep){
        return client.getAddress(cep);
    }
}
