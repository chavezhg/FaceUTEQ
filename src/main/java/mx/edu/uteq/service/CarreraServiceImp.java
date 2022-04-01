/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.dao.ICarrera;
import mx.edu.uteq.domain.Carrera;
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
public class CarreraServiceImp implements ICarreraService{
    @Autowired
    private ICarrera carreraDao;
    @Override
    @Transactional(readOnly = true)
    public List<Carrera> getAll() {
        return (List<Carrera>) carreraDao.findAll();
    }

    @Override
    @Transactional
    public void insert(Carrera carrera) {
        carreraDao.save(carrera);
    }

    @Override
    @Transactional
    public void delete(Carrera carrera) {
        carreraDao.delete(carrera);
    }

    @Override
    @Transactional(readOnly = true)
    public Carrera findById(Carrera carrera) {
        return carreraDao.findById(carrera.getIdCarr()).orElse(null);
    }
    
}
