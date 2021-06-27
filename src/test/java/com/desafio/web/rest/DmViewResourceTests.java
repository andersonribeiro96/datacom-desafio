package com.desafio.web.rest;

import com.desafio.constants.Constantes;
import com.desafio.domain.DmView;
import com.desafio.domain.Product;
import com.desafio.service.DmViewService;
import com.desafio.web.rest.errors.FeatureNaoSuportadaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.LinkedHashSet;
import java.util.Set;

import static com.desafio.constants.Constantes.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
@AutoConfigureMockMvc
public class DmViewResourceTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DmViewService dmViewService;

    @Test
    @DisplayName("Deve retornar o nome do produto")
    public void deveRetornarNome() throws Exception {

        BDDMockito.given(dmViewService.obterNome()).willReturn(NOME_PRODUTO);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(URL_BASE.concat("/nome"));

        mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(NOME_PRODUTO));
    }

    @Test
    @DisplayName("Deve retornar a versao do produto")
    public void deveRetornarVersao() throws Exception {

        BDDMockito.given(dmViewService.obterVersao()).willReturn(VERSAO_PRODUTO);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(URL_BASE.concat("/versao"));

        mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(VERSAO_PRODUTO));
    }

    @Test
    @DisplayName("Deve retornar se contem a feature")
    public void deveRetornarFeature() throws Exception {

        BDDMockito.given(dmViewService.verificarFeatureSuportada(FEATURE_PRODUTO)).willReturn(FEATURE_SUPORTADA);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(URL_BASE.concat("/feature/ABC"));

        mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(FEATURE_SUPORTADA));
    }

    @Test
    @DisplayName("Nao deve retornar a feature")
    public void deveRetornarException() throws Exception {

        BDDMockito.given(dmViewService.verificarFeatureSuportada(anyString())).willThrow(FeatureNaoSuportadaException.class);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(URL_BASE.concat("/feature/ABC"));

        mockMvc
                .perform(request)
                .andExpect(status().isNotFound())
                .andExpect(content().string(FEATURE_NAO_SUPORTADA));
    }

}
