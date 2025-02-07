package com.itsqmet.DenunciasC.Servicio;

import com.itsqmet.DenunciasC.Entidad.Denuncia;
import com.itsqmet.DenunciasC.Repositorio.DenunciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.Document;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DenunciaServicio {

    @Autowired
    private DenunciaRepositorio denunciaRepositorio;

    // Método para mostrar todas las denuncias
    public List<Denuncia> mostrarDenuncias() {
        return denunciaRepositorio.findAll();
    }

    // Método para buscar denuncias por título
    public List<Denuncia> buscarDenunciaPorTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty()) {
            return denunciaRepositorio.findAll();
        } else {
            return denunciaRepositorio.findByTituloContainingIgnoreCase(titulo);
        }
    }

    // Método para guardar una nueva denuncia
    public void guardarDenuncia(Denuncia denuncia) {
        denunciaRepositorio.save(denuncia);
    }

    // Método para eliminar una denuncia por ID
    public void eliminarDenuncia(String id) {
        denunciaRepositorio.deleteById(id);
    }

    // Método para buscar una denuncia por ID
    public Optional<Denuncia> buscarDenunciaPorId(String id) {
        return denunciaRepositorio.findById(id);
    }

    //Metodo para generar el pdf
    public static byte [] generarPdf() throws DocumentException, IOException {
    List<Denuncia> autores = DenunciaRepositorio.findAll();
    Document document = new Document();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PdfWriter.getInstance(document, baos);
        document.open();        document.add(new Paragraph("Lista de autores", FontFactory.getFont("Arial", 14, Font.BOLD)));
    PdfPTable table = new PdfPTable(5);        table.setWidthPercentage(100);
        table.addCell(new PdfPCell(new Phrase("Codigo", FontFactory.getFont("Arial", 12))));        table.addCell(new PdfPCell(new Phrase("Nombre", FontFactory.getFont("Arial", 12))));
        table.addCell(new PdfPCell(new Phrase("Nacionalidad", FontFactory.getFont("Arial", 12))));        table.addCell(new PdfPCell(new Phrase("Genero", FontFactory.getFont("Arial", 12))));
        table.addCell(new PdfPCell(new Phrase("Fecha Nacimiento", FontFactory.getFont("Arial", 12))));        for (Autor autor: autores){
        table.addCell(new PdfPCell(new Phrase(String.valueOf(autor.getId()), FontFactory.getFont("Arial", 11))));            table.addCell(new PdfPCell(new Phrase(String.valueOf(autor.getNombre()), FontFactory.getFont("Arial", 11))));
        table.addCell(new PdfPCell(new Phrase(String.valueOf(autor.getNacionalidad()), FontFactory.getFont("Arial", 11))));            table.addCell(new PdfPCell(new Phrase(String.valueOf(autor.getGenero()), FontFactory.getFont("Arial", 11))));
        table.addCell(new PdfPCell(new Phrase(String.valueOf(autor.getFechaNacimiento()), FontFactory.getFont("Arial", 11))));
    }        document.add(table);
        document.close();       