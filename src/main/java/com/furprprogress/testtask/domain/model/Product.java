package com.furprprogress.testtask.domain.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;

    public Product() {
        this.id = UUID.randomUUID();
    }

    public Product(String name, String description, BigDecimal price) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }
}


