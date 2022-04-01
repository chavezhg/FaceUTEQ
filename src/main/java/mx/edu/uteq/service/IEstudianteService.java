/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.domain.Estudiante;
import mx.edu.uteq.domain.Usuario;

/**
 *
 * @author Ricardo
 */
public interface IEstudianteService {
    public List<Estudiante> getAll();
    public void insert(Estudiante estudiante);
    public void delete(Estudiante estudiante);
    public Estudiante findById(Estudiante estudiante);
}
