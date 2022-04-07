/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.domain.Privacidad;
import mx.edu.uteq.domain.Profesor;
import mx.edu.uteq.domain.Usuario;

/**
 *
 * @author Ricardo
 */
public interface IPrivacidadService {
    public List<Privacidad> getAll();
    public void update(String publiPriv, int idUsua);
    public void insert(String idUsua, String publi_priv, String perfil_priv);
    public void delete(Privacidad privacidad);
    public Privacidad findById(Privacidad profesor);
    public Privacidad findByIdUsua(int idUsua);
}
