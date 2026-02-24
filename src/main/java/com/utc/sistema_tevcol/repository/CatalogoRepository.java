package com.utc.sistema_tevcol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utc.sistema_tevcol.entity.Catalogo;


public interface CatalogoRepository extends JpaRepository<Catalogo, Long> {
    // Esta es la firma que faltaba
    }