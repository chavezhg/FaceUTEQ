/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.domain.Publicacion;
import mx.edu.uteq.domain.Usuario;

/**
 *
 * @author Ricardo
 */
public interface IPublicacionService {
    public List<Publicacion> getAll();
    public List<Publicacion> getAllDisponiblesByUsuario(String email);
    public void insert(Publicacion publicacion);
    public void delete(Publicacion publicacion);
    public Publicacion findById(Publicacion publicacion);
}
