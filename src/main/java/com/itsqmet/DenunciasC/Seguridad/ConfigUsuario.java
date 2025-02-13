package com.itsqmet.DenunciasC.Seguridad;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.itsqmet.DenunciasC.Repositorio.AutoridadRepositorio;
import com.itsqmet.DenunciasC.Repositorio.DenuncianteRepositorio;
import com.itsqmet.DenunciasC.Entidad.Autoridad;
import com.itsqmet.DenunciasC.Entidad.Denunciante;


import java.util.Collections;
import java.util.List;


@Service
public class ConfigUsuario implements UserDetailsService {

    private final AutoridadRepositorio autoridadRepositorio;
    private final DenuncianteRepositorio denuncianteRepositorio;
    private final PasswordEncoder passwordEncoder;

    public ConfigUsuario(AutoridadRepositorio autoridadRepositorio,
                         DenuncianteRepositorio denuncianteRepositorio,
                         PasswordEncoder passwordEncoder) {
        this.autoridadRepositorio = autoridadRepositorio;
        this.denuncianteRepositorio = denuncianteRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar en Autoridades
        List<Autoridad> autoridades = autoridadRepositorio.findByUsername(username);
        if (!autoridades.isEmpty()) {
            // Convertir la autoridad en un UserDetails
            return new User(
                    autoridades.get(0).getUsername(),
                    autoridades.get(0).getPassword(),
                    Collections.emptyList() // Lista de roles/authorities, puedes ajustarla según tu lógica
            );
        }

        // Buscar en Denunciantes
        List<Denunciante> denunciantes = denuncianteRepositorio.findByUsername(username);
        if (!denunciantes.isEmpty()) {
            // Convertir el denunciante en un UserDetails
            return new User(
                    denunciantes.get(0).getUsername(),
                    denunciantes.get(0).getPassword(),
                    Collections.emptyList() // Lista de roles/authorities, puedes ajustarla según tu lógica
            );
        }

        // Si no se encuentra el usuario, lanzar excepción
        throw new UsernameNotFoundException("Usuario no encontrado: " + username);
    }
}

