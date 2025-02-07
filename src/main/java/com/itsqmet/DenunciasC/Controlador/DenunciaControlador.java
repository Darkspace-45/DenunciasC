package com.itsqmet.DenunciasC.Controlador;

import com.itsqmet.DenunciasC.Entidad.Denuncia;
import com.itsqmet.DenunciasC.Servicio.DenunciaServicio;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
        model.addAttribute("denuncia", new Denuncia()); // Agregar un objeto Denuncia al modelo
        return "/Vistas/formulario"; // Asegúrate de que este sea el nombre correcto de tu vista
    }

    @PostMapping("/formularioDenuncia")
    public String enviarDenuncia(Denuncia denuncia) {
        denunciaServicio.guardarDenuncia(denuncia); // Guardar la denuncia en la base de datos
        return "redirect:/Denuncias"; // Redirigir a la página de denuncias o a donde desees
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

    @GetMapping("/autores/pdf")
    public ResponseEntity<byte[]> decargarpdf() throws Exception{
        byte[] pdf = DenunciaServicio.generarpdf();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "autores.pdf");
        return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
    }
    }

}
