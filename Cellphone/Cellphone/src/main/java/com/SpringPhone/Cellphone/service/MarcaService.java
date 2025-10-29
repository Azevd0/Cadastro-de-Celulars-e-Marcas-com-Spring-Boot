package com.SpringPhone.Cellphone.service;

import com.SpringPhone.Cellphone.exceptions.ObjectNotFoundException;
import com.SpringPhone.Cellphone.model.Marca;
import com.SpringPhone.Cellphone.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    public Marca findById(Long id){
        Optional<Marca> marca = marcaRepository.findById(id);
        if(marca.isPresent()){
            return marca.get();
        }
        throw new ObjectNotFoundException("Marca não cadastrada com Id "+ id);
    }
    public Marca findByNome(String nome){
        Optional<Marca> marca = marcaRepository.findByNomeContainingIgnoreCase(nome);
        if(marca.isPresent()){
            return marca.get();
        }
        throw new ObjectNotFoundException("Marca de nome " + nome + " não encontrada");
    }
    public List<Marca> findAll(){
        List<Marca> list = marcaRepository.findAll();
        return list;
    }
    public Marca save(Marca marca){
        buscarPorNome(marca);
        Marca mark = marcaRepository.save(marca);
        return mark;
    }
    public Marca update(Marca marca){
        buscarPorNome(marca);
        findById(marca.getId());
        Marca mark = marcaRepository.save(marca);
        return mark;
    }
    public void delete(Long id){
        Marca marca = findById(id);
        if(!marca.getCelulares().isEmpty()){
            throw new DataIntegrityViolationException("Erro! Marca não pode ser deletada, pois ainda contém itens associados");
        }
        marcaRepository.deleteById(id);
    }
    public void buscarPorNome(Marca marca){
        Optional<Marca> mark = marcaRepository.findByNomeIgnoreCase(marca.getNome());
        if(mark.isPresent()){
            if(mark.get().getId() != marca.getId()){
                throw new IllegalArgumentException("Marca de nome "+ marca.getNome() + " já existe.");
            }
        }
    }
}
