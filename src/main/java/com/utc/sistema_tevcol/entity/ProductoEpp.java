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

    @Column(name = "tiempo_reposicion_pepp")
    private String tiempoReposicionPepp;

    @Column(name = "norma_tecnica_pepp")
    private String normaTecnicaPepp;

    @Column(name = "unidad_pepp")
    private String unidadPepp;

    @Column(name = "imagen_archivo_pepp")
    private String imagenArchivoPepp;

    @Column(name = "archivo_norma_tecnica_pepp")
    private String archivoNormaTecnicaPepp;

    @Column(name = "creacion_pepp")
    private LocalDateTime creacionPepp;

    @Column(name = "actualizacion_pepp")
    private LocalDateTime actualizacionPepp;

    @Column(name = "impuesto_pepp")
    private Long impuestoPepp;

    @Column(name = "deshabilitar_pepp")
    private Boolean deshabilitarPepp;

    // 🔹 RELACIÓN 1
    @ManyToOne
    @JoinColumn(name = "tipo_proteccion_pepp")
    private Catalogo tipoProteccion;

    // 🔹 RELACIÓN 2
    @ManyToOne
    @JoinColumn(name = "tipo_pepp")
    private Catalogo tipo;

    public ProductoEpp() {
    }

    // Getters y Setters
}