package com.itsqmet.DenunciasC.Repositorio;

import com.itsqmet.DenunciasC.Entidad.Denuncia;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DenunciaRepositorio extends MongoRepository<Denuncia, String> {
List<Denuncia> findByTituloContainingIgnoreCase(String titulo);
}
