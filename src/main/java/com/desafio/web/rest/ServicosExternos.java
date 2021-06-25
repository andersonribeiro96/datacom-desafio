package com.desafio.web.rest;

import com.desafio.domain.DmView;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ServicosExternos {

    public DmView obter() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://dmviewdemo.datacom.com.br:8101/license", DmView.class);
    }

}
