package com.farrapo.demospringbootfeign.dtos;

import java.io.Serializable;

public class AddressDto implements Serializable {
    private static final long serialVersionUID = -2825660898277070331L;

    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String service;

    public String getCep() {
        return cep;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getService() {
        return service;
    }
}
