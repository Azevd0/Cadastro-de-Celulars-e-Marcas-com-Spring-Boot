package com.SpringPhone.Cellphone.dto;

import com.SpringPhone.Cellphone.model.Celular;
import com.SpringPhone.Cellphone.model.Marca;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class CelularDto {
    private Long id;

    @NotNull
    @Length(min = 5, max = 20, message = "O campo modelo dete ter entre 5 e 20 caracteres")
    private String modelo;

    private Integer ano;
    private Marca marca;

    public CelularDto(){
    }

    public CelularDto(Celular celular) {
        this.id = celular.getId();
        this.modelo = celular.getModelo();
        this.ano = celular.getAno();
        this.marca = celular.getMarca();
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
}
