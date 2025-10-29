package com.SpringPhone.Cellphone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "marca")
    private List<Celular> celulares = new ArrayList<>();

    public Marca() {
    }

    public Marca(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Celular> getCelulares() {
        return celulares;
    }

    public void setCelulares(List<Celular> celulares) {
        this.celulares = celulares;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Marca marca = (Marca) o;
        return Objects.equals(id, marca.id) && Objects.equals(nome, marca.nome) && Objects.equals(celulares, marca.celulares);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, celulares);
    }

    @Override
    public String toString() {
        return "Marca{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", celulares=" + celulares +
                '}';
    }
}
