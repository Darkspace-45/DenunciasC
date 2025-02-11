package com.itsqmet.DenunciasC.Servicio;

import com.itsqmet.DenunciasC.Entidad.Denunciante;
import com.itsqmet.DenunciasC.Repositorio.DenuncianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DenuncianteServicio {

    @Autowired
    DenuncianteRepositorio denuncianteRepositorio;

    //Método para mostrar todos los denunciantes
    public List<Denunciante> mostrarDenunciantes(){
        return denuncianteRepositorio.findAll();
    }

    //Método para buscar denunciantes por nombre
    public List<Denunciante> mostrarDenunciantePorNombre(String nombre){
        if (nombre == null || nombre.isEmpty()){
            return denuncianteRepositorio.findAll();
        }else {
            return denuncianteRepositorio.findByNombreContainingIgnoreCase(nombre);
        }
    }

    //Método para guardar un nuevo Denunciante
    public void guardarDenunciante(Denunciante denunciante){
        denuncianteRepositorio.save(denunciante);
    }

    //Método para eliminar Denunciante según el ID
    public void eliminarDenunciante(String id){
        denuncianteRepositorio.deleteById(id);
    }

    //Método para buscar Denunciante por ID
    public Optional<Denunciante> buscarDenunciantePorID(String id){
        return denuncianteRepositorio.findById(id);
    }
}
