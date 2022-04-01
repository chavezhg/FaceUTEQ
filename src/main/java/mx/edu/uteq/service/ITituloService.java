/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.domain.Titulo;
import mx.edu.uteq.domain.Usuario;

/**
 *
 * @author Ricardo
 */
public interface ITituloService {
    public List<Titulo> getAll();
    public void insert(Titulo titulo);
    public void delete(Titulo titulo);
    public Titulo findById(Titulo titulo);
}
