package com.SpringPhone.Cellphone.dto;

import com.SpringPhone.Cellphone.model.Celular;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class MarcaDto {
    private Long id;
    @NotNull
    @Length(min = 5, max = 20, message = "O campo nome deve ter entre 5 e 20 caracteres")
    private String nome;
    private List<Celular> celulares = new ArrayList<>();

    public MarcaDto(){
    }

    public MarcaDto(Long id, String nome, List<Celular> celulares) {
        this.id = id;
        this.nome = nome;
        this.celulares = celulares;
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
}
