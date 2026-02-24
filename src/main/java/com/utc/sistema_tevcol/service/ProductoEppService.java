package com.utc.sistema_tevcol.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.utc.sistema_tevcol.entity.ProductoEpp;
import com.utc.sistema_tevcol.repository.ProductoEppRepository;

@Service
public class ProductoEppService {

    private final ProductoEppRepository repository;

    public ProductoEppService(ProductoEppRepository repository) {
        this.repository = repository;
    }

    public List<ProductoEpp> listar() {
        return repository.findAll();
    }

    public void guardar(ProductoEpp producto) {
        repository.save(producto);
    }

    public ProductoEpp buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}