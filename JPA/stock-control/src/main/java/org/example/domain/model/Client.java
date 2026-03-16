package org.example.domain.model;

import jakarta.persistence.*;
import org.example.annotation.NotEmpty;
import org.example.annotation.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "tb_clientes")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @NotEmpty
    @Column(unique = false, nullable = false, name = "nome")
    private String name;

    @NotNull
    @Column(unique = false, nullable = false, name = "cpf")
    private String cpf;

    @NotEmpty
    @NotNull
    @Column(unique = false, nullable = true, name = "email")
    private String email;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Sale> sales;


    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public Client(){

    }

    public Client(String name) {
        this.name = name;
        sales = new ArrayList<>();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
