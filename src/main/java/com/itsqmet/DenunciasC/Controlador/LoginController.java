package com.itsqmet.DenunciasC.Controlador;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {

    @GetMapping("/login")
    public String ingreso() {

        return "/Vistas/login";
    }
}
