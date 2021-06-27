package com.desafio.constants;

import com.desafio.domain.DmView;
import com.desafio.domain.Product;

import java.util.LinkedHashSet;
import java.util.Set;

public final class Constantes {

    public Constantes() {
    }

    public static String URL_BASE = "/dmview";

    public static String URL_DM_VIEW = "https://dmviewdemo.datacom.com.br:8101/license";

    public static String BAD_URL_DM_VIEW = "AAAAAAAAAAA";

    public static String NOME_PRODUTO = "dmView";

    public static String VERSAO_PRODUTO = "123";

    public static String FEATURE_PRODUTO = "ABC";

    public static String FEATURE_SUPORTADA = "Feature suportada";

    public static String FEATURE_NAO_SUPORTADA = "Feature não suportado";

    public static DmView retornaDmview(){
        Product product = new Product();
        product.setProductName("dmView");
        product.setSwVersion("123");

        Set<String> features = new LinkedHashSet<>();
        features.add("ABC");
        DmView dmView = new DmView();
        dmView.setFeatures(features);
        dmView.setProduct(product);

        return dmView;
    }


}
