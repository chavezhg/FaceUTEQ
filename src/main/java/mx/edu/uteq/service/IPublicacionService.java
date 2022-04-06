/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.io.IOException;
import java.util.List;
import mx.edu.uteq.domain.Publicacion;
import mx.edu.uteq.domain.Usuario;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Ricardo
 */
public interface IPublicacionService {
    public List<Publicacion> getAll();
    public List<Publicacion> getAllByUsuario(String email);
    public List<Publicacion> getAllDisponiblesByUsuario(String email);
    void guardarImagen(String ruta, MultipartFile file, String nomArchivo) throws IOException;
    public void insert(Publicacion publicacion);
    public void insertar(int idUsua, String descPubl, String url);
    public void delete(Publicacion publicacion);
    public Publicacion findById(Publicacion publicacion);
}
