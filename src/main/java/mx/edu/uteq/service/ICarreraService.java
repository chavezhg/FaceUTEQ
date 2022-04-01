/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.domain.Carrera;
import mx.edu.uteq.domain.Usuario;

/**
 *
 * @author Ricardo
 */
public interface ICarreraService {
    public List<Carrera> getAll();
    public void insert(Carrera publicacion);
    public void delete(Carrera publicacion);
    public Carrera findById(Carrera publicacion);
}
