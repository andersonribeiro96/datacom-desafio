package com.desafio.web.rest;

import com.desafio.domain.DmView;
import com.desafio.web.rest.errors.ServicoIndisponivelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class ServicosExternos {

    private final Logger logger = LoggerFactory.getLogger(ServicosExternos.class);

    public DmView obter() {
        try {
            String URL = "https://dmviewdemo.datacom.com.br:8101/license";
            logger.info("Acessando: {}", URL);
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(URL, DmView.class);
        } catch (HttpClientErrorException e){
            logger.info("Encontrado um erro: {}", e.getMessage());
            throw new ServicoIndisponivelException();
        }
    }

}
