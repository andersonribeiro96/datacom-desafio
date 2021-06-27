package com.desafio.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.desafio.constants.Constantes.retornaDmview;

public class DmViewTests {


    @Test
    @DisplayName("Deve retornar verdadeiro se a feature nao for suportada")
    public void featureNaoDeveConter(){
        DmView dmView = retornaDmview();
        Assertions.assertTrue(dmView.ehFeatureNaoSuportada("ADQ_NML"));
    }

    @Test
    @DisplayName("Deve retornar falso se a feature for suportada")
    public void featureDeveConter(){
        DmView dmView = retornaDmview();
        Assertions.assertFalse(dmView.ehFeatureNaoSuportada("ABC"));
    }

}
