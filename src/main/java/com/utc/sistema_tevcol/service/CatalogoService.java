package com.utc.sistema_tevcol.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.utc.sistema_tevcol.entity.Catalogo;
import com.utc.sistema_tevcol.repository.CatalogoRepository;

@Service
public class CatalogoService {

    private final CatalogoRepository repository;

    public CatalogoService(CatalogoRepository repository) {
        this.repository = repository;
    }

    public List<Catalogo> listar() {
        return repository.findAll();
    }

    public Catalogo guardar(Catalogo c) {
        return repository.save(c);
    }

    public Catalogo buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}