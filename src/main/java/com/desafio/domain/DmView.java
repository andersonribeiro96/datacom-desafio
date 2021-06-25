package com.desafio.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class DmView {

    private Set<String> features;

    private Product product;

}
