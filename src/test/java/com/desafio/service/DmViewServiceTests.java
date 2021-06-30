package com.desafio.service;

import com.desafio.web.rest.errors.FeatureNaoSuportadaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.desafio.constants.ConstantesTests.*;
import static org.mockito.Mockito.mock;

public class DmViewServiceTests {

    private DmViewService dmViewService;

    @BeforeEach
    public void setUp(){
        DmViewRestTemplate dmViewRestTemplate = mock(DmViewRestTemplate.class);
        dmViewService = new DmViewService(dmViewRestTemplate);
        Mockito.when(dmViewRestTemplate.obter()).thenReturn(retornaDmview());
    }

    @Test
    @DisplayName("Deve retornar o nome do produto")
    public void deveRetornaNome(){
        String nomeObtido = dmViewService.obterNome();
        Assertions.assertEquals(nomeObtido, NOME_PRODUTO);
    }

    @Test
    @DisplayName("Deve retornar a versao do produto")
    public void deveRetornaVersao(){
        String versao = dmViewService.obterVersao();
        Assertions.assertEquals(versao, VERSAO_PRODUTO);
    }

    @Test
    @DisplayName("Deve retorna uma Exception se nao contem a feature")
    public void deveLancarFeatureNaoSuportadaException(){
        Assertions.assertThrows(FeatureNaoSuportadaException.class, () -> {
           dmViewService.verificarFeatureSuportada("ABD");
        });
    }

    @Test
    @DisplayName("Deve retorna uma informacao que contem a feature")
    public void deveVerificarFeature(){
        String feature = dmViewService.verificarFeatureSuportada(FEATURE_PRODUTO);
        Assertions.assertEquals(feature, FEATURE_SUPORTADA);
    }


}
