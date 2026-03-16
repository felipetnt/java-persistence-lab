
package org.example.domain.model;

import jakarta.persistence.*;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.example.annotation.NotEmpty;
import org.example.annotation.NotNull;

import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name = "tb_produtos")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @NotEmpty
    @Column(unique = false, nullable = false, name = "nome")
    private String name;

    @NotNull
    @Column(unique = false, nullable = false, name = "descricao")
    private String description;

    @NotEmpty
    @NotNull
    @Column(unique = false, nullable = false, name = "preco")
    private double price;

    @NotNull
    @NotEmpty
    @Column(unique = false, nullable = false, name = "quantidadeEstoque")
    private int quantityStock;

    @NotNull
    @NotEmpty
    @Column(unique = false, nullable = false, name = "estado")
    private boolean status; // true = ativo, false = inativo

    public Product(){

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(int stockQuantity) {
        this.quantityStock = stockQuantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
