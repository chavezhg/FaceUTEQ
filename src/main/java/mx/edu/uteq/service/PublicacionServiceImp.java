/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.dao.IPublicacion;
import mx.edu.uteq.domain.Publicacion;
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
public class PublicacionServiceImp implements IPublicacionService{
    @Autowired
    private IPublicacion publicacionDao;
    @Override
    @Transactional(readOnly = true)
    public List<Publicacion> getAll() {
        return (List<Publicacion>) publicacionDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Publicacion> getAllDisponiblesByUsuario(String email) {
        return (List<Publicacion>) publicacionDao.getAllDisponiblesByUsuario(email);
    }

    @Override
    @Transactional
    public void insert(Publicacion publicacion) {
        publicacionDao.save(publicacion);
    }

    @Override
    @Transactional
    public void delete(Publicacion publicacion) {
        publicacionDao.delete(publicacion);
    }

    @Override
    @Transactional(readOnly = true)
    public Publicacion findById(Publicacion publicacion) {
        return publicacionDao.findById(publicacion.getIdPubl()).orElse(null);
    }
    
}
