/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.dao.IPrivacidad;
import mx.edu.uteq.domain.Privacidad;
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
public class PrivacidadServiceImp implements IPrivacidadService{
    @Autowired
    private IPrivacidad privacidadDao;

    @Override
    @Transactional(readOnly = true)
    public List<Privacidad> getAll() {
        return (List<Privacidad>) privacidadDao.findAll();
    }
    
    @Override
    @Transactional
    public void update(String publiPriv, int idUsua) {
        privacidadDao.update(publiPriv, idUsua);
    }

    @Override
    @Transactional
    public void insert(String idUsua, String publi_priv, String perfil_priv) {
        privacidadDao.save(idUsua, publi_priv, perfil_priv);
    }

    @Override
    @Transactional
    public void delete(Privacidad privacidad) {
        privacidadDao.delete(privacidad);
    }

    @Override
    @Transactional(readOnly = true)
    public Privacidad findById(Privacidad privacidad) {
        return privacidadDao.findById(privacidad.getIdPriv()).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Privacidad findByIdUsua(int idUsua) {
        return privacidadDao.findByIdUsua(idUsua);
    }
    
    
}
