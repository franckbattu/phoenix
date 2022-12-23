package dev.narradium.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product
{
    @lombok.Setter
    @lombok.Getter
    @Id
    private String sku;
}
