package com.SpringPhone.Cellphone.controller;

import com.SpringPhone.Cellphone.dto.CelularDto;
import com.SpringPhone.Cellphone.model.Celular;
import com.SpringPhone.Cellphone.service.CelularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/celulares")
public class CelularController {

    @Autowired
    private CelularService celularService;
    //buscar pelo id do celular
    @GetMapping("/{id}")
    public ResponseEntity<CelularDto> findById(@PathVariable Long id){
        Celular celular = celularService.findById(id);
        return ResponseEntity.ok().body(new CelularDto(celular));
    }
    //buscar pelo id da categoria
    @GetMapping
    public ResponseEntity<List<CelularDto>> findByMarcaId(@RequestParam(value = "marca", defaultValue = "0")Long id){
        List<Celular> celular = celularService.findAllByMarca(id);
        return ResponseEntity.ok().body(celular.stream().map(x -> new CelularDto(x)).collect(Collectors.toList()));
        //exemplo de requisição: /celulares?marca=1
    }
    //buscar pelo nome do modelo
    @GetMapping("/modelo/{modelo}")
    public ResponseEntity<CelularDto> findByModelo(@PathVariable String modelo){
        Celular celular = celularService.findByModelo(modelo);
        return ResponseEntity.ok().body(new CelularDto(celular));
    }
    //buscar pelo nome da marca
    @GetMapping("/marca/{marca}")
    public ResponseEntity<List<CelularDto>> findAllByMarca(@PathVariable String marca){
        List<Celular> celularList = celularService.findByMarcaNome(marca);
        List<CelularDto> celularDtoList = celularList.stream().map(CelularDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(celularDtoList);
    }
    @PostMapping
    public ResponseEntity<CelularDto> criarCelular(@RequestParam(value = "marca", defaultValue = "0") Long id_mark,@Valid @RequestBody CelularDto celularDto){
        Celular celular = celularService.save(id_mark, celularDto);
        return ResponseEntity.ok().body(new CelularDto(celular));
        //localhost:8080/celulares?marca=1
    }
    @PutMapping("/{id}")
    public ResponseEntity<CelularDto> celularUpdate(@RequestParam(value = "marca", defaultValue = "0") Long id_mark, @PathVariable Long id, @Valid @RequestBody CelularDto celularDTO ){
        Celular celular = celularService.update(id_mark,id, celularDTO);
        return ResponseEntity.ok().body(new CelularDto(celular));
        //localhost:8080/celulares/1?marca=2
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCelular(@PathVariable Long id){
        celularService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
