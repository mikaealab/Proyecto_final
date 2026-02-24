package com.utc.sistema_tevcol.entity;

import jakarta.persistence.*;

@Entity
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

    public Catalogo() {}

    public Catalogo(String tipoCat, String descripcionCat, String estadoCat) {
        this.tipoCat = tipoCat;
        this.descripcionCat = descripcionCat;
        this.estadoCat = estadoCat;
    }

    public Long getCodigoCat() { return codigoCat; }
    public void setCodigoCat(Long codigoCat) { this.codigoCat = codigoCat; }

    public String getTipoCat() { return tipoCat; }
    public void setTipoCat(String tipoCat) { this.tipoCat = tipoCat; }

    public String getDescripcionCat() { return descripcionCat; }
    public void setDescripcionCat(String descripcionCat) { this.descripcionCat = descripcionCat; }

    public String getEstadoCat() { return estadoCat; }
    public void setEstadoCat(String estadoCat) { this.estadoCat = estadoCat; }
}