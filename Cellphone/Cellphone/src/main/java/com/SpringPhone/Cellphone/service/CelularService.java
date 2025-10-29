package com.SpringPhone.Cellphone.service;

import com.SpringPhone.Cellphone.exceptions.ObjectNotFoundException;
import com.SpringPhone.Cellphone.model.Celular;
import com.SpringPhone.Cellphone.repository.CelularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CelularService {
    @Autowired
    private CelularRepository celularRepository;

    public Celular findById(Long id){
        Optional<Celular> cll = celularRepository.findById(id);
        if(cll.isPresent()){
            return cll.get();
        }
        throw new ObjectNotFoundException("Celular não cadastrado com Id "+ id);
    }
    public List<Celular> findAllByMarca(Long id_mark) {
        celularRepository.findById(id_mark);
        return celularRepository.findAllByMarcaId(id_mark);
    }
    public Celular findByModelo(String mod){
        Optional<Celular> modelo = celularRepository.findByModeloIgnoreCase(mod);
        if(modelo.isPresent()){
            return modelo.get();
        }
        throw new ObjectNotFoundException("Celular de modelo " + mod + " não encontrado");
    }
    public List<Celular> findByMarcaNome(String nome){
        return celularRepository.findAllByMarcaNomeContainingIgnoreCase(nome);
    }
    public Celular save(Celular celular){
        buscarPorModelo(celular);
        Celular cllSave = celularRepository.save(celular);
        return cllSave;
    }
    public Celular update(Celular celular){
        findById(celular.getId());
        buscarPorModelo(celular);
        Celular cllUpdate = celularRepository.save(celular);
        return cllUpdate;
    }
    public void delete(Long id){
        findById(id);
        celularRepository.deleteById(id);
    }
    public void buscarPorModelo(Celular celular){
        Optional<Celular> cll = celularRepository.findByModeloIgnoreCase(celular.getModelo());
        if(cll.isPresent()){
            if(cll.get().getId() != celular.getId()){
                throw new IllegalArgumentException("Celular de modelo "+ celular.getModelo() + " já existe.");
            }
        }
    }
}
