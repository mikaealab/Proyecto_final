package com.utc.sistema_tevcol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utc.sistema_tevcol.entity.Catalogo;
import java.util.List;

public interface CatalogoRepository extends JpaRepository<Catalogo, Long> {
    // Esto es lo que busca el Service y no encontraba
    List<Catalogo> findByTipoCat(String tipoCat);
}