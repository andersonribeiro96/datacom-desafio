package com.desafio.web.rest.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FeatureNaoSuportadaException extends RuntimeException{

    static final String FEATURE_NAO_SUPORTADA = "Feature não suportado";

    public FeatureNaoSuportadaException(){
        super(FEATURE_NAO_SUPORTADA);
    }


}
