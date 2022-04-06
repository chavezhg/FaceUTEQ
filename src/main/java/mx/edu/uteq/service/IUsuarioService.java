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
public interface IUsuarioService {
    public List<Usuario> getAll();
    public void insert(Usuario usuario);
    public void delete(Usuario usuario);
    public Usuario findById(Usuario usuario);
    public Usuario findByEmailUsua(String email);
}
