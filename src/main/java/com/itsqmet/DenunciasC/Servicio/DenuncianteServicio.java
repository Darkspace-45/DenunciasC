package com.itsqmet.DenunciasC.Servicio;

import com.itsqmet.DenunciasC.Entidad.Denunciante;
import com.itsqmet.DenunciasC.Repositorio.DenuncianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DenuncianteServicio implements UserDetailsService {

    @Autowired
    private DenuncianteRepositorio denuncianteRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Denunciante denunciante = denuncianteRepositorio.findByUsername(username);
        if (denunciante == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
        return denunciante;
    }

    //Método para mostrar todos los denunciantes
    public List<Denunciante> mostrarDenunciantes() {
        return denuncianteRepositorio.findAll();
    }

    //Método para buscar denunciantes por nombre
    public List<Denunciante> mostrarDenunciantePorNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return denuncianteRepositorio.findAll();
        } else {
            return denuncianteRepositorio.findByNombreContainingIgnoreCase(nombre);
        }
    }

    //Método para guardar un nuevo Denunciante
    public void guardarDenunciante(Denunciante denunciante) {
        // Encriptar la contraseña antes de guardar
        denunciante.setPassword(passwordEncoder.encode(denunciante.getPassword()));
        denuncianteRepositorio.save(denunciante);
    }

    //Método para actualizar un Denunciante existente
    public void actualizarDenunciante(Denunciante denunciante) {
        // Si la contraseña es nueva, encriptarla
        Optional<Denunciante> denuncianteExistente = denuncianteRepositorio.findById(denunciante.getId());
        if (denuncianteExistente.isPresent()) {
            if (!denunciante.getPassword().equals(denuncianteExistente.get().getPassword())) {
                denunciante.setPassword(passwordEncoder.encode(denunciante.getPassword()));
            }
        }
        denuncianteRepositorio.save(denunciante);
    }

    //Método para eliminar Denunciante según el ID
    public void eliminarDenunciante(String id) {
        denuncianteRepositorio.deleteById(id);
    }

    //Método para buscar Denunciante por ID
    public Optional<Denunciante> buscarDenunciantePorID(String id) {
        return denuncianteRepositorio.findById(id);
    }
}