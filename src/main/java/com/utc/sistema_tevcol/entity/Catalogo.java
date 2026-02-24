package com.utc.sistema_tevcol.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "catalogo")
public class Catalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cat")
    private Long codigoCat;

    @NotBlank(message = "El tipo es obligatorio")
    @Column(name = "tipo_cat", nullable = false, length = 100)
    private String tipoCat;

    @NotBlank(message = "La descripción es obligatoria")
    @Column(name = "descripcion_cat", nullable = false, length = 100)
    private String descripcionCat;

    @NotNull(message = "El estado es obligatorio")
    @Column(name = "estado_cat", nullable = false)
    private Integer estadoCat;

    public Catalogo() {}

    public Catalogo(String tipoCat, String descripcionCat, Integer estadoCat) {
        this.tipoCat = tipoCat;
        this.descripcionCat = descripcionCat;
        this.estadoCat = estadoCat;
    }

    public Long getCodigoCat() {
        return codigoCat;
    }

    public void setCodigoCat(Long codigoCat) {
        this.codigoCat = codigoCat;
    }

    public String getTipoCat() {
        return tipoCat;
    }

    public void setTipoCat(String tipoCat) {
        this.tipoCat = tipoCat != null ? tipoCat.trim() : null;
    }

    public String getDescripcionCat() {
        return descripcionCat;
    }

    public void setDescripcionCat(String descripcionCat) {
        this.descripcionCat = descripcionCat != null ? descripcionCat.trim() : null;
    }

    public Integer getEstadoCat() {
        return estadoCat;
    }

    public void setEstadoCat(Integer estadoCat) {
        this.estadoCat = estadoCat;
    }
}