package com.itsqmet.DenunciasC.Servicio;

import com.itsqmet.DenunciasC.Entidad.Contacto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactoServicio {

    private List<Contacto> contactos = new ArrayList<>();

    public void guardarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public List<Contacto> obtenerContactos() {
        return contactos;
    }
}