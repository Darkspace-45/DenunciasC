package com.itsqmet.DenunciasC.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DenuncianteControlador {

    @GetMapping("/Inicio")
    public String paginaInicio(){
        return "/Vistas/index";
    }

    @GetMapping("/formularioDenuncia")
    public String mostrarFormulario(){
        return "/Vistas/formulario";
    }
}
