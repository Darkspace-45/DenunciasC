package com.itsqmet.DenunciasC.Repositorio;

import com.itsqmet.DenunciasC.Entidad.Autoridad;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AutoridadRepositorio extends MongoRepository<Autoridad, String> {
    List<Autoridad> findByNombreContainingIgnoreCase(String nombre);

    List<Autoridad> findByUsername(String username);

    boolean existsByUsername(String username);

}
