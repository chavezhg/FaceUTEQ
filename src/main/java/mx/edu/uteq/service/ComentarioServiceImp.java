/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.dao.IComentario;
import mx.edu.uteq.domain.Comentario;
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
public class ComentarioServiceImp implements IComentarioService{
    @Autowired
    private IComentario comentarioDao;
    @Override
    @Transactional(readOnly = true)
    public List<Comentario> getAll() {
        return (List<Comentario>) comentarioDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Comentario> getAllByPublicacion(int idPubl){
        return (List<Comentario>) comentarioDao.findAllByPublicacion(idPubl);
    }

    @Override
    @Transactional
    public void insert(String idUsua, String idPubl, String descCome) {
        comentarioDao.save(idUsua, idPubl, descCome);
    }

    @Override
    @Transactional
    public void delete(Comentario comentario) {
        comentarioDao.delete(comentario);
    }

    @Override
    @Transactional(readOnly = true)
    public Comentario findById(Comentario comentario) {
        return comentarioDao.findById(comentario.getIdCome()).orElse(null);
    }
    
}
