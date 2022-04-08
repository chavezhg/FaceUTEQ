/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.domain.Amigo;
import mx.edu.uteq.domain.Token;
import mx.edu.uteq.domain.Usuario;

/**
 *
 * @author Ricardo
 */
public interface ITokenService {
    public void delete(String idToken);
    public Token findById(String idToken);
    public Token findByToken(String token);
}
