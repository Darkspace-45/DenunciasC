package com.itsqmet.DenunciasC.Repositorio;

import com.itsqmet.DenunciasC.Entidad.Denunciante;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DenuncianteRepositorio extends MongoRepository<Denunciante, String> {
    List<Denunciante> findByNombreContainingIgnoreCase(String nombre);

    Denunciante findByUsername(String username);
}