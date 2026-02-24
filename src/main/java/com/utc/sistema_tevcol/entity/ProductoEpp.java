package com.utc.sistema_tevcol.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "producto_epp")
public class ProductoEpp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_peep")
    private Long codigoPeep;

    @Column(name = "nombre_pepp")
    private String nombrePepp;

    @Column(name = "codigo_producto_pepp")
    private String codigoProductoPepp;

    @Column(name = "marca_pepp")
    private String marcaPepp;

    @Column(name = "proveedor_pepp")
    private String proveedorPepp;

    @Column(name = "unidad_pepp")
    private String unidadPepp;

    @Column(name = "impuesto_pepp")
    private Long impuestoPepp;

    @Column(name = "deshabilitar_pepp")
    private Boolean deshabilitarPepp = false;

    // 🔹 RELACIONES (FK a catalogo)
    @ManyToOne
    @JoinColumn(name = "tipo_proteccion_pepp")
    private Catalogo tipoProteccion;

    @ManyToOne
    @JoinColumn(name = "tipo_pepp")
    private Catalogo tipo;

    // ===== GETTERS & SETTERS =====

    public Long getCodigoPeep() {
        return codigoPeep;
    }

    public void setCodigoPeep(Long codigoPeep) {
        this.codigoPeep = codigoPeep;
    }

    public String getNombrePepp() {
        return nombrePepp;
    }

    public void setNombrePepp(String nombrePepp) {
        this.nombrePepp = nombrePepp;
    }

    public String getCodigoProductoPepp() {
        return codigoProductoPepp;
    }

    public void setCodigoProductoPepp(String codigoProductoPepp) {
        this.codigoProductoPepp = codigoProductoPepp;
    }

    public String getMarcaPepp() {
        return marcaPepp;
    }

    public void setMarcaPepp(String marcaPepp) {
        this.marcaPepp = marcaPepp;
    }

    public String getProveedorPepp() {
        return proveedorPepp;
    }

    public void setProveedorPepp(String proveedorPepp) {
        this.proveedorPepp = proveedorPepp;
    }

    public String getUnidadPepp() {
        return unidadPepp;
    }

    public void setUnidadPepp(String unidadPepp) {
        this.unidadPepp = unidadPepp;
    }

    public Long getImpuestoPepp() {
        return impuestoPepp;
    }

    public void setImpuestoPepp(Long impuestoPepp) {
        this.impuestoPepp = impuestoPepp;
    }

    public Boolean getDeshabilitarPepp() {
        return deshabilitarPepp;
    }

    public void setDeshabilitarPepp(Boolean deshabilitarPepp) {
        this.deshabilitarPepp = deshabilitarPepp;
    }

    public Catalogo getTipoProteccion() {
        return tipoProteccion;
    }

    public void setTipoProteccion(Catalogo tipoProteccion) {
        this.tipoProteccion = tipoProteccion;
    }

    public Catalogo getTipo() {
        return tipo;
    }

    public void setTipo(Catalogo tipo) {
        this.tipo = tipo;
    }
}