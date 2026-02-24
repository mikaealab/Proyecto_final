package com.utc.sistema_tevcol.service;

import com.utc.sistema_tevcol.entity.Catalogo;
import com.utc.sistema_tevcol.repository.CatalogoRepository;

import java.sql.Connection;
import java.util.List;

public class CatalogoService {

    private CatalogoRepository repo;

    public CatalogoService(Connection con) {
        this.repo = new CatalogoRepository(con);
    }

    public void guardar(Catalogo c) throws Exception {

        if(c.getTipoCat() == null || c.getTipoCat().isEmpty()) {
            throw new Exception("El tipo no puede estar vacío");
        }

        repo.guardar(c);
    }

    public List<Catalogo> listar() throws Exception {
        return repo.listar();
    }

    public void actualizar(Catalogo c) throws Exception {
        repo.actualizar(c);
    }

    public void eliminar(Long id) throws Exception {
        repo.eliminar(id);
    }
}