/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.domain.Usuario;

/**
 *
 * @author Ricardo
 */
public interface IUsuarioService {
    public List<Usuario> getAll();
    public List<Usuario> getAllNotFriends(int idUsua);
    public List<Usuario> getAllFriends(int idUsua);
    public List<Usuario> getAllRequests(int idUsua);
    public void insert(String idProf, String idEstu, String idRol, String emailUsua, String passUsua, String estaUsua);
    public String getLastId();
    public void delete(Usuario usuario);
    public Usuario findById(Usuario usuario);
    public Usuario findByEmailUsua(String email);
    public Usuario findUsuaByEmail(String email);
    public void activarCuenta(String idUsua);
    public void recoverypassword(String idUsua, String token);
    public void changepassword(String idUsua, String newPassword);
}
