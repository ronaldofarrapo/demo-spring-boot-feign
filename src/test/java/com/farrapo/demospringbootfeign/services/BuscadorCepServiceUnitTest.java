package com.farrapo.demospringbootfeign.services;

import com.farrapo.demospringbootfeign.dtos.AddressDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.wiremock.spring.ConfigureWireMock;
import org.wiremock.spring.EnableWireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@EnableWireMock({@ConfigureWireMock(port = 8082)})
class BuscadorCepServiceUnitTest {

    @Autowired
    private BuscadorCepService buscadorCepService;

    @Test
    void returns_a_cep_from_leblon() {
        stubFor(get("/api/cep/v2/22431050").willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withBody("{\"cep\": \"22431050\"," +
                        " \"state\": \"RJ\"," +
                        "\"city\": \"Rio de Janeiro\", " +
                        "\"service\": \"wiremock-service\", " +
                        " \"neighborhood\": \"Leblon\"}")
                .withStatus(200)));

        AddressDto address = buscadorCepService.find("22431050");

        assertEquals("22431050", address.getCep());
        assertEquals("RJ", address.getState());
        assertEquals("Rio de Janeiro", address.getCity());
        assertEquals("Leblon", address.getNeighborhood());
        assertEquals("wiremock-service", address.getService());
    }

}
