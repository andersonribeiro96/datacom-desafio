package com.desafio.web.rest.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ServicoIndisponivelException extends RuntimeException{

    static final String SERVICO_INDISPONIVEL = "Serviço encontra-se indisponível";

    public ServicoIndisponivelException(){
        super(SERVICO_INDISPONIVEL);
    }

}
