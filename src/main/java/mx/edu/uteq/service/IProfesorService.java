/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.domain.Profesor;
import mx.edu.uteq.domain.Usuario;

/**
 *
 * @author Ricardo
 */
public interface IProfesorService {
    public List<Profesor> getAll();
    public void insert(Profesor profesor);
    public void delete(Profesor profesor);
    public Profesor findById(Profesor profesor);
}
