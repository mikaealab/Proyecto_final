package com.utc.sistema_tevcol.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utc.sistema_tevcol.entity.Catalogo;
import com.utc.sistema_tevcol.repository.CatalogoRepository;

@Service
public class CatalogoService {

    private final CatalogoRepository catalogoRepository;

    public CatalogoService(CatalogoRepository catalogoRepository) {
        this.catalogoRepository = catalogoRepository;
    }

    public List<Catalogo> listar() {
        return catalogoRepository.findAll();
    }

    public void guardar(Catalogo catalogo) {
        catalogoRepository.save(catalogo);
    }

    public Catalogo buscarPorId(Long id) {
        return catalogoRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        catalogoRepository.deleteById(id);
    }
}