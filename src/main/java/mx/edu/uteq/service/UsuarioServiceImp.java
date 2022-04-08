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
    private IUsuario usuarioDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getAllNotFriends(int idUsua) {
        return (List<Usuario>) usuarioDao.findAllNotFriends(idUsua);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getAllFriends(int idUsua) {
        return (List<Usuario>) usuarioDao.findAllFriends(idUsua);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getAllRequests(int idUsua) {
        return (List<Usuario>) usuarioDao.findAllRequests(idUsua);
    }

    @Override
    @Transactional
    public void insert(String idProf, String idEstu, String idRol, String emailUsua, String passUsua, String estaUsua) {
        usuarioDao.save(idProf, idEstu, idRol, emailUsua, passUsua, estaUsua);
    }
    
    @Override
    @Transactional
    public String getLastId() {
        return usuarioDao.getLastId();
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsua()).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario findByEmailUsua(String email){
        return usuarioDao.findByEmailUsua(email);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario findUsuaByEmail(String email){
        return usuarioDao.findUsuaByEmail(email);
    }
    
    @Override
    @Transactional
    public void activarCuenta(String idUsua){
        usuarioDao.activarCuenta(idUsua);
    }
    
    @Override
    @Transactional
    public void recoverypassword(String idUsua, String token){
        usuarioDao.recoverypassword(idUsua, token);
    }
    
    @Override
    @Transactional
    public void changepassword(String idUsua, String token){
        usuarioDao.changepassword(idUsua, token);
    }
    
}
