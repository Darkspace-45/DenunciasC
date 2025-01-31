package com.itsqmet.DenunciasC.Entidad;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.text.html.Option;
import java.io.File;

@Data
@AllArgsConstructor
public class Denunciante {
    private String titulo;
    private String descripcion;
    private String ubicacion;
    private Option categoria;
    private File file;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Option getCategoria() {
        return categoria;
    }

    public void setCategoria(Option categoria) {
        this.categoria = categoria;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
