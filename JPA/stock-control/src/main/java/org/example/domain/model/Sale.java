package org.example.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.example.annotation.NotEmpty;
import org.example.annotation.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_vendas")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @NotNull
    @NotEmpty
    @Column(name = "data", unique = false, nullable = false)
    private Date date;

    @NotNull
    @NotEmpty
    @Column(name = "valorTotal", unique = false, nullable = false)
    private double totalValue;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleProduct> products;

    public Sale(){

    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public List<SaleProduct> getProducts() {
        return products;
    }

    public void setProducts(List<SaleProduct> products) {
        this.products = products;
    }

    public Sale(Client client){
        setClient(client);
        products = new ArrayList<>();
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getValorTotal() {
        return totalValue;
    }

    public void setValorTotal(double totalValue) {
        this.totalValue = totalValue;
    }
}
