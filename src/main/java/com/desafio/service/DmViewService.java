package com.desafio.service;

import com.desafio.domain.DmView;
import com.desafio.web.rest.DmViewRestTemplate;
import com.desafio.web.rest.errors.FeatureNaoSuportadaException;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
public class DmViewService {

    private static final String FEATURE_SUPORTADA = "Feature suportada";

    private final DmViewRestTemplate dmViewRestTemplate;

    public DmViewService(DmViewRestTemplate dmViewRestTemplate) {
        this.dmViewRestTemplate = dmViewRestTemplate;
    }

    public String obterNome(){
        DmView dmView = dmViewRestTemplate.obter();
        return dmView.getProduct().getProductName();
    }

    public String obterVersao(){
        DmView dmView = dmViewRestTemplate.obter();
        return dmView.getProduct().getSwVersion();
    }

    public String verificarFeatureSuportada(String feature){
        DmView dmView = dmViewRestTemplate.obter();
        if(dmView.ehFeatureNaoSuportada(feature)){
            throw new FeatureNaoSuportadaException();
        }
        return FEATURE_SUPORTADA;
    }

}
