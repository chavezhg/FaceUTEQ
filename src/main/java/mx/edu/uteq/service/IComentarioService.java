/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.domain.Comentario;
import mx.edu.uteq.domain.Usuario;

/**
 *
 * @author Ricardo
 */
public interface IComentarioService {
    public List<Comentario> getAll();
    public List<Comentario> getAllByPublicacion(int idPubl);
    public void insert(String idUsua, String idPubl, String descCome);
    public void delete(Comentario comentario);
    public Comentario findById(Comentario comentario);
}
