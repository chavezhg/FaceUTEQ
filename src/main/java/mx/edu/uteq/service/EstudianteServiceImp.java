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
    private IEstudiante estudianteDao;
    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> getAll() {
        return (List<Estudiante>) estudianteDao.findAll();
    }
    
    @Override
    @Transactional
    public void actualizar(int carrUsua, String lnacUsua, String ecivilUsua, int idUsua) {
        estudianteDao.actualizar(carrUsua, lnacUsua, ecivilUsua, idUsua);
    }

    @Override
    @Transactional
    public void insert(String carrUsua, String n1Usua, String n2Usua, String apUsua, String amUsua, String ecivilUsua, String fnacUsua, String lnacUsua) {
        estudianteDao.insert(carrUsua, n1Usua, n2Usua, apUsua, amUsua, ecivilUsua, fnacUsua, lnacUsua);
    }
    
    @Override
    @Transactional
    public String getLastId() {
        return estudianteDao.getLastId();
    }

    @Override
    @Transactional
    public void delete(Estudiante publicacion) {
        estudianteDao.delete(publicacion);
    }

    @Override
    @Transactional(readOnly = true)
    public Estudiante findById(Estudiante publicacion) {
        return estudianteDao.findById(publicacion.getIdEstu()).orElse(null);
    }
    
}
