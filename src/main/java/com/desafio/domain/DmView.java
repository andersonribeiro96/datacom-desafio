package com.desafio.domain;


import java.util.Objects;
import java.util.Set;

public class DmView {

    private Set<String> features;

    private Product product;

    public Set<String> getFeatures() {
        return features;
    }

    public void setFeatures(Set<String> features) {
        this.features = features;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public boolean ehFeatureNaoSuportada(String feature){
        return !this.features.contains(feature);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DmView dmView = (DmView) o;
        return Objects.equals(features, dmView.features) &&
                Objects.equals(product, dmView.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(features, product);
    }

    @Override
    public String toString() {
        return "DmView{" +
                "features=" + features +
                ", product=" + product +
                '}';
    }
}
