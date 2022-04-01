/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.dao.IProfesor;
import mx.edu.uteq.domain.Profesor;
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
public class ProfesorServiceImp implements IProfesorService{
    @Autowired
    private IProfesor profesorDao;
    @Override
    @Transactional(readOnly = true)
    public List<Profesor> getAll() {
        return (List<Profesor>) profesorDao.findAll();
    }

    @Override
    @Transactional
    public void insert(Profesor profesor) {
        profesorDao.save(profesor);
    }

    @Override
    @Transactional
    public void delete(Profesor profesor) {
        profesorDao.delete(profesor);
    }

    @Override
    @Transactional(readOnly = true)
    public Profesor findById(Profesor profesor) {
        return profesorDao.findById(profesor.getIdProf()).orElse(null);
    }
    
}
