/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.dao.ITitulo;
import mx.edu.uteq.domain.Titulo;
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
public class TituloServiceImp implements ITituloService{
    @Autowired
    private ITitulo tituloDao;
    @Override
    @Transactional(readOnly = true)
    public List<Titulo> getAll() {
        return (List<Titulo>) tituloDao.findAll();
    }

    @Override
    @Transactional
    public void insert(Titulo titulo) {
        tituloDao.save(titulo);
    }

    @Override
    @Transactional
    public void delete(Titulo titulo) {
        tituloDao.delete(titulo);
    }

    @Override
    @Transactional(readOnly = true)
    public Titulo findById(Titulo titulo) {
        return tituloDao.findById(titulo.getIdTitu()).orElse(null);
    }
    
}
