package com.itsqmet.DenunciasC.Entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.html.Option;
import java.io.File;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Denuncia {
    private String titulo;
    private String descripcion;
    private String ubicacion;
    private String categoria;
    private String file;

}
