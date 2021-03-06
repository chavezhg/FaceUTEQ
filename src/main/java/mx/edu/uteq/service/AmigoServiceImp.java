/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.dao.IAmigo;
import mx.edu.uteq.domain.Amigo;
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
public class AmigoServiceImp implements IAmigoService{
    @Autowired
    private IAmigo amigoDao;
    @Override
    @Transactional(readOnly = true)
    public List<Amigo> getAll() {
        return (List<Amigo>) amigoDao.findAll();
    }

    @Override
    @Transactional
    public void insert(int idEmi, int idRec) {
        amigoDao.save(idEmi, idRec);
    }
    
    @Override
    @Transactional
    public void aceptarSolicitud(int idEmi, int idRec) {
        amigoDao.aceptarSolicitud(idEmi, idRec);
    }
    
    @Override
    @Transactional
    public void rechazarSolicitud(int idEmi, int idRec) {
        amigoDao.rechazarSolicitud(idEmi, idRec);
    }

    @Override
    @Transactional
    public void delete(Amigo amigo) {
        amigoDao.delete(amigo);
    }

    @Override
    @Transactional(readOnly = true)
    public Amigo findById(Amigo amigo) {
        return amigoDao.findById(amigo.getIdAmig()).orElse(null);
    }
    
}
