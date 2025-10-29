package com.SpringPhone.Cellphone.service;

import com.SpringPhone.Cellphone.model.Celular;
import com.SpringPhone.Cellphone.model.Marca;
import com.SpringPhone.Cellphone.repository.CelularRepository;
import com.SpringPhone.Cellphone.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBservice {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private CelularRepository celularRepository;

    public void instanciaDb(){
        Marca m1 = new Marca(null,"Apple");
        Marca m2 = new Marca(null, "Samsung");
        Marca m3 = new Marca(null, "Motorola");

        Celular c1 = new Celular(null,"Iphone-15",2023,m1);
        Celular c2 = new Celular(null, "Iphone-11", 2019, m1);
        Celular c3 = new Celular(null, "Galaxy-A05", 2023,m2);
        Celular c4 = new Celular(null, "Galaxy S25", 2025, m2);
        Celular c5 = new Celular(null, "Edge-60",2025 , m3);

        m1.getCelulares().addAll(Arrays.asList(c1,c2));
        m2.getCelulares().addAll(Arrays.asList(c3,c4));
        m3.getCelulares().add(c5);

        marcaRepository.saveAll(Arrays.asList(m1,m2,m3));
        celularRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5));
    }

}
