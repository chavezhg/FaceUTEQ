/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.dao.IEstudiante;
import mx.edu.uteq.dao.IUsuario;
import mx.edu.uteq.domain.Estudiante;
import mx.edu.uteq.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ricardo
 */
@Service
public class UsuarioServiceImp implements IUsuarioService{
    @Autowired
    private IUsuario publicacionDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getAll() {
        return (List<Usuario>) publicacionDao.findAll();
    }

    @Override
    @Transactional
    public void insert(Usuario usuario) {
        publicacionDao.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        publicacionDao.delete(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Usuario usuario) {
        return publicacionDao.findById(usuario.getIdUsua()).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario findByEmailUsua(String email){
        return publicacionDao.findByEmailUsua(email);
    }
    
}
