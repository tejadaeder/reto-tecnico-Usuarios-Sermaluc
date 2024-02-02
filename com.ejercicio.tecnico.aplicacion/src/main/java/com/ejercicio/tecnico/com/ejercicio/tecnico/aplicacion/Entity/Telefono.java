package com.ejercicio.tecnico.com.ejercicio.tecnico.aplicacion.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Telefono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String citycode;
    private String contrycode;

}
