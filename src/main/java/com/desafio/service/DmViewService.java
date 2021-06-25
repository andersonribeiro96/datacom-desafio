package com.desafio.service;

import com.desafio.domain.DmView;
import com.desafio.web.rest.ServicosExternos;
import com.desafio.web.rest.errors.FeatureNaoSuportadaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DmViewService {

    @Autowired
    private final ServicosExternos servicosExternos;

    public DmViewService(ServicosExternos servicosExternos) {
        this.servicosExternos = servicosExternos;
    }

    public String obterNome(){
        DmView dmView = servicosExternos.obter();
        return dmView.getProduct().getProductName();
    }

    public String obterVersao(){
        DmView dmView = servicosExternos.obter();
        return dmView.getProduct().getSwVersion();
    }

    public void verificarFeatureSuportada(String feature){
        DmView dmView = servicosExternos.obter();
        if(dmView.ehFeatureNaoSuportada(feature)){
            throw new FeatureNaoSuportadaException();
        }
    }

}
