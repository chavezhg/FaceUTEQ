/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.dao.IEstudiante;
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
public class EstudianteServiceImp implements IEstudianteService{
    @Autowired
    private IEstudiante publicacionDao;
    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> getAll() {
        return (List<Estudiante>) publicacionDao.findAll();
    }

    @Override
    @Transactional
    public void insert(Estudiante publicacion) {
        publicacionDao.save(publicacion);
    }

    @Override
    @Transactional
    public void delete(Estudiante publicacion) {
        publicacionDao.delete(publicacion);
    }

    @Override
    @Transactional(readOnly = true)
    public Estudiante findById(Estudiante publicacion) {
        return publicacionDao.findById(publicacion.getIdEstu()).orElse(null);
    }
    
}
