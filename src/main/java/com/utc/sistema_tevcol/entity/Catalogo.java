package com.utc.sistema_tevcol.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "catalogo")
public class Catalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cat")
    private Long codigoCat;

    @Column(name = "tipo_cat")
    private String tipoCat;

    @Column(name = "descripcion_cat")
    private String descripcionCat;

    @Column(name = "estado_cat")
    private String estadoCat;

    // getters y setters
}