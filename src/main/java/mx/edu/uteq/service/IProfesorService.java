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
    public void actualizar(int carrUsua, String lnacUsua, String ecivilUsua, int idUsua);
    public void insert(String carrUsua, String n1Usua, String n2Usua, String apUsua, String amUsua, String ecivilUsua, String fnacUsua, String lnacUsua);
    public String getLastId();
    public void delete(Profesor profesor);
    public Profesor findById(Profesor profesor);
}
