package com.SpringPhone.Cellphone.service;

import com.SpringPhone.Cellphone.dto.CelularDto;
import com.SpringPhone.Cellphone.exceptions.ObjectNotFoundException;
import com.SpringPhone.Cellphone.model.Celular;
import com.SpringPhone.Cellphone.model.Marca;
import com.SpringPhone.Cellphone.repository.CelularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CelularService {
    @Autowired
    private CelularRepository celularRepository;

    @Autowired
    private MarcaService marcaService;

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
    public Celular save(Long id_mark, CelularDto celularDto){
        celularDto.setId(null);
        Marca marcaId = marcaService.findById(id_mark);
        celularDto.setMarca(marcaId);
        return celularRepository.save(new Celular(celularDto));
    }
    public Celular update(Long id_mark, Long id_cll, CelularDto celularDto){
        Celular cellExistente = findById(id_cll);

        cellExistente.setModelo(celularDto.getModelo());
        cellExistente.setAno(celularDto.getAno());

        Marca marca = marcaService.findById(id_mark);
        cellExistente.setMarca(marca);
        return celularRepository.save(cellExistente);
    }
    public void delete(Long id){
        findById(id);
        celularRepository.deleteById(id);
    }
}
