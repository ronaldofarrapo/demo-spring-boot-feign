package com.farrapo.demospringbootfeign.services;

import com.farrapo.demospringbootfeign.dtos.AddressDto;

public interface BuscadorCepService {
    AddressDto find(String cep);
}
