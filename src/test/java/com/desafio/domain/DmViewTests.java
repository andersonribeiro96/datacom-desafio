package com.desafio.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.desafio.constants.Constantes.retornaDmview;

public class DmViewTests {


    @Test
    @DisplayName("feature nao deve ser suportada")
    public void featureNaoDeveConter(){
        DmView dmView = retornaDmview();
        Assertions.assertTrue(dmView.ehFeatureNaoSuportada("ADQ_NML"));
    }

    @Test
    @DisplayName("feature deve ser suportada")
    public void featureDeveConter(){
        DmView dmView = retornaDmview();
        Assertions.assertFalse(dmView.ehFeatureNaoSuportada("ABC"));
    }

}
