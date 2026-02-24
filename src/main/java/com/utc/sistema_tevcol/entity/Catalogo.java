package com.utc.sistema_tevcol.entity;

public class Catalogo {

    private Long codigoCat;
    private String tipoCat;
    private String descripcionCat;
    private String estadoCat;

    public Catalogo() {}

    public Catalogo(Long codigoCat, String tipoCat, String descripcionCat, String estadoCat) {
        this.codigoCat = codigoCat;
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