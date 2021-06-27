package com.desafio.web.rest;

import com.desafio.domain.DmView;
import com.desafio.web.rest.errors.ServicoIndisponivelException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;



import static com.desafio.constants.Constantes.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(DmViewRestTemplate.class)
@AutoConfigureWebClient(registerRestTemplate = true)
public class DmViewRestTemplateTests {

    @Autowired
    private DmViewRestTemplate dmViewRestTemplate;

    @Mock
    private RestTemplate restTemplate;



    @BeforeEach
    public void setUp() {
        restTemplate = mock(RestTemplate.class);
        dmViewRestTemplate = new DmViewRestTemplate(restTemplate);
    }

    @Test
    @DisplayName("Deve retornar DmView")
    public void deveRetonarOk() {
        Mockito.when(this.restTemplate.getForObject(URL_DM_VIEW, DmView.class)).thenReturn(retornaDmview());
        DmView dmView = dmViewRestTemplate.obter();
        Assertions.assertNotNull(dmView);
    }

    @Test
    @DisplayName("Deve retornar Exception")
    public void deveRetornarException(){
        Mockito.when(this.restTemplate.getForObject(URL_DM_VIEW, DmView.class)).thenThrow(HttpClientErrorException.class);
        Assertions.assertThrows(ServicoIndisponivelException.class, () -> {
            dmViewRestTemplate.obter();
        });
    }




}
