
package org.example.domain.model;

import jakarta.persistence.*;
import org.example.annotation.NotEmpty;
import org.example.annotation.NotNull;

import java.util.UUID;

@Entity
@Table(name = "tb_produto_vendas")
public class SaleProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venda_id")
    private Sale sale;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    private Product product;

    @NotNull
    @NotEmpty
    @Column(name = "quantidade")
    private int quantity;

    @NotNull
    @NotEmpty
    @Column(name = "precoUnitario")
    private double unityPrice;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnityPrice() {
        return unityPrice;
    }

    public void setUnityPrice(double unityPrice) {
        this.unityPrice = unityPrice;
    }
}
