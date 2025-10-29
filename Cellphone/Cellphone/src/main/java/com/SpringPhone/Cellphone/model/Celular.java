package com.SpringPhone.Cellphone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Celular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String modelo;

    private Integer ano;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "marca_id")
    private Marca marca;

    public Celular() {
    }

    public Celular(Long id, String modelo, Integer ano, Marca marca) {
        this.id = id;
        this.modelo = modelo;
        this.ano = ano;
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Celular celular = (Celular) o;
        return Objects.equals(id, celular.id) && Objects.equals(modelo, celular.modelo) && Objects.equals(ano, celular.ano) && Objects.equals(marca, celular.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelo, ano, marca);
    }

    @Override
    public String toString() {
        return "Celular{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", marca=" + marca +
                '}';
    }
}
