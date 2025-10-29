package com.SpringPhone.Cellphone.controller;

import com.SpringPhone.Cellphone.dto.MarcaDto;
import com.SpringPhone.Cellphone.model.Marca;
import com.SpringPhone.Cellphone.service.MarcaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {
    @Autowired
    private MarcaService marcaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<MarcaDto>> listAll(){
    List<Marca> marca = marcaService.findAll();
    List<MarcaDto> listDto = new ArrayList<>();
    for(Marca m : marca){
        listDto.add(modelMapper.map(m, MarcaDto.class));
    }
    return ResponseEntity.ok().body(listDto);
    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity<MarcaDto> findByNome(@PathVariable String nome){
    Marca marcaNome = marcaService.findByNome(nome);
    return ResponseEntity.ok().body(modelMapper.map(marcaNome,MarcaDto.class));
    }
    @GetMapping("/{id}")
    public ResponseEntity<MarcaDto> findById(@PathVariable Long id){
        Marca marcaId = marcaService.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(marcaId,MarcaDto.class));
    }
    @PostMapping
    public ResponseEntity<MarcaDto> criarMarca(@RequestBody MarcaDto marcaDto){
    Marca marcaCriada = modelMapper.map(marcaDto, Marca.class);
    Marca mark = marcaService.save(marcaCriada);
    return ResponseEntity.ok().body(modelMapper.map(mark, MarcaDto.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaDto> update(@PathVariable Long id, @RequestBody MarcaDto marcaDto){
    Marca marcaUpdate = modelMapper.map(marcaDto, Marca.class);
    marcaUpdate.setId(id);
    Marca updateDto = marcaService.update(marcaUpdate);
    return ResponseEntity.ok().body(modelMapper.map(updateDto, MarcaDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarca(@PathVariable Long id){
        marcaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
