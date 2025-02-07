package com.itsqmet.DenunciasC.Controlador;

import com.itsqmet.DenunciasC.Entidad.Denuncia;
import com.itsqmet.DenunciasC.Servicio.DenunciaServicio;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@NoArgsConstructor
@Controller
public class DenunciaControlador {

    @Autowired
    private DenunciaServicio denunciaServicio;

    @GetMapping("/Inicio")
    public String paginaInicio() {
        return "/Vistas/index";
    }

    @GetMapping("/formularioDenuncia")
    public String mostrarFormulario(Model model) {
        model.addAttribute("denuncia", new Denuncia());
        return "/Vistas/formulario";
    }

    @PostMapping("/registrar")
    public String enviarDenuncia(Denuncia denuncia) {
        denunciaServicio.guardarDenuncia(denuncia);
        return "redirect:/Denuncias";
    }

    @GetMapping("/Nosotros")
    public String paginaNosotros() {
        return "/Vistas/Nosotros";
    }

    @GetMapping("/Denuncias")
    public String paginaDenuncias() {
        return "/Vistas/Denuncias";
    }

    @GetMapping("/Reseñas")
    public String paginaResenias() {
        return "/Vistas/reseñas";
    }


}


