package com.desafio.web.rest.errors.handler;

import com.desafio.web.rest.errors.FeatureNaoSuportadaException;
import com.desafio.web.rest.errors.ServicoIndisponivelException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerCustomizeException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FeatureNaoSuportadaException.class)
    public final ResponseEntity featureNaoSuportada(){
        FeatureNaoSuportadaException featureNaoSuportadaException = new FeatureNaoSuportadaException();
        return new ResponseEntity(featureNaoSuportadaException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ServicoIndisponivelException.class)
    public final ResponseEntity ServicoIndisponivel(){
        ServicoIndisponivelException servicoIndisponivelException = new ServicoIndisponivelException();
        return new ResponseEntity(servicoIndisponivelException.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
