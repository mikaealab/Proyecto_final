package com.utc.sistema_tevcol.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "producto_epp")
public class ProductoEpp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_peep")
    private Long codigoPeep;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(name = "nombre_pepp", length = 1000, nullable = false)
    private String nombrePepp;

    @Column(name = "codigo_producto_pepp", length = 250)
    private String codigoProductoPepp;

    @Column(name = "marca_pepp", length = 250)
    private String marcaPepp;

    @Column(name = "proveedor_pepp", length = 500)
    private String proveedorPepp;

    @Column(name = "tiempo_reposicion_pepp", length = 500)
    private String tiempoReposicionPepp;

    @Column(name = "norma_tecnica_pepp", length = 500)
    private String normaTecnicaPepp;

    @Column(name = "unidad_pepp", length = 100)
    private String unidadPepp;

    @NotNull(message = "El impuesto es obligatorio")
    @Min(value = 0, message = "El impuesto debe ser mayor o igual a 0")
    @Column(name = "impuesto_pepp", nullable = false)
    private Long impuestoPepp;

    @Column(name = "deshabilitar_pepp", nullable = false)
    private Boolean deshabilitarPepp = false;

    @Column(name = "creacion_pepp", updatable = false)
    private LocalDateTime creacionPepp;

    @Column(name = "actualizacion_pepp")
    private LocalDateTime actualizacionPepp;

    @ManyToOne
    @JoinColumn(name = "tipo_proteccion_pepp")
    private Catalogo tipoProteccion;

    @ManyToOne
    @JoinColumn(name = "tipo_pepp")
    private Catalogo tipo;

    @PrePersist
    protected void onCreate() {
        creacionPepp = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        actualizacionPepp = LocalDateTime.now();
    }

    // ===== GETTERS & SETTERS =====

    public Long getCodigoPeep() { return codigoPeep; }
    public void setCodigoPeep(Long codigoPeep) { this.codigoPeep = codigoPeep; }

    public String getNombrePepp() { return nombrePepp; }
    public void setNombrePepp(String nombrePepp) { this.nombrePepp = nombrePepp; }

    public String getCodigoProductoPepp() { return codigoProductoPepp; }
    public void setCodigoProductoPepp(String codigoProductoPepp) { this.codigoProductoPepp = codigoProductoPepp; }

    public String getMarcaPepp() { return marcaPepp; }
    public void setMarcaPepp(String marcaPepp) { this.marcaPepp = marcaPepp; }

    public String getProveedorPepp() { return proveedorPepp; }
    public void setProveedorPepp(String proveedorPepp) { this.proveedorPepp = proveedorPepp; }

    public String getTiempoReposicionPepp() { return tiempoReposicionPepp; }
    public void setTiempoReposicionPepp(String tiempoReposicionPepp) { this.tiempoReposicionPepp = tiempoReposicionPepp; }

    public String getNormaTecnicaPepp() { return normaTecnicaPepp; }
    public void setNormaTecnicaPepp(String normaTecnicaPepp) { this.normaTecnicaPepp = normaTecnicaPepp; }

    public String getUnidadPepp() { return unidadPepp; }
    public void setUnidadPepp(String unidadPepp) { this.unidadPepp = unidadPepp; }

    public Long getImpuestoPepp() { return impuestoPepp; }
    public void setImpuestoPepp(Long impuestoPepp) { this.impuestoPepp = impuestoPepp; }

    public Boolean getDeshabilitarPepp() { return deshabilitarPepp; }
    public void setDeshabilitarPepp(Boolean deshabilitarPepp) { this.deshabilitarPepp = deshabilitarPepp; }

    public Catalogo getTipoProteccion() { return tipoProteccion; }
    public void setTipoProteccion(Catalogo tipoProteccion) { this.tipoProteccion = tipoProteccion; }

    public Catalogo getTipo() { return tipo; }
    public void setTipo(Catalogo tipo) { this.tipo = tipo; }
}