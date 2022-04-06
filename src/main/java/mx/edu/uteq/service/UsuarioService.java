/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.edu.uteq.dao.IUsuario;
import mx.edu.uteq.domain.Usuario;



/**
 *
 * @author Ricardo
 */
@Service
@Slf4j
public class UsuarioService implements UserDetailsService{
    @Autowired
    private IUsuario interfazUsuario;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String emailUsua) throws UsernameNotFoundException{
        Usuario usuario = interfazUsuario.findByEmailUsua(emailUsua);
        if (usuario==null){
            throw new UsernameNotFoundException(emailUsua);
        }
        ArrayList<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(usuario.getRol().getNomRol()));
        User user = new User(usuario.getEmailUsua(), usuario.getPassUsua(), roles);
        return user;
    }
    
    @Transactional(readOnly = true)
    public Usuario findByEmailUsua(String email){
        return interfazUsuario.findByEmailUsua(email);
    }
}
