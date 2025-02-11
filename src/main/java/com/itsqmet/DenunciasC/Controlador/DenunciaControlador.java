package com.itsqmet.DenunciasC.Controlador;

import com.itsqmet.DenunciasC.Entidad.Denuncia;
import com.itsqmet.DenunciasC.Servicio.DenunciaServicio;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Controller
public class DenunciaControlador {

    @Autowired
    private DenunciaServicio denunciaServicio;

    @GetMapping("/")
    public String paginaInicio() {
        return "index";
    }

    // Método para mostrar todas las denuncias
    @GetMapping("/denuncias")
    public String listarDenuncias(@RequestParam(name = "buscarDenuncia", required = false, defaultValue = "") String buscarDenuncia, Model model) {
        List<Denuncia> denuncias = denunciaServicio.mostrarDenuncias();
        model.addAttribute("buscarDenuncia", buscarDenuncia);
        model.addAttribute("denuncias", denuncias);
        return "Vistas/listaDenuncias";
    }

    @GetMapping("/denuncia/{id}")
    public String mostrarDenuncia(@PathVariable String id, Model model) {
        Optional<Denuncia> denunciaOpt = denunciaServicio.buscarDenunciaPorId(id);
        if (denunciaOpt.isPresent()) {
            model.addAttribute("denuncia", denunciaOpt.get());
            return "Vistas/datosDenuncia"; // Asegúrate de que este nombre coincida con el archivo HTML
        } else {
            // Manejar el caso en que la denuncia no se encuentra
            return "redirect:/denuncias"; // O una página de error
        }
    }

    @GetMapping("/eliminarDenuncia/{id}")
    public String eliminarDenuncia(@PathVariable String id){
        denunciaServicio.eliminarDenuncia(id);
        return "redirect:/denuncias";
    }

    @GetMapping("/formularioDenuncia")
    public String mostrarFormulario(Model model) {
        model.addAttribute("denuncia", new Denuncia());
        return "/Vistas/formulario";
    }

    @PostMapping("/registrar")
    public String enviarDenuncia(Denuncia denuncia) {
        denunciaServicio.guardarDenuncia(denuncia);
        return "redirect:/denuncias";
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


