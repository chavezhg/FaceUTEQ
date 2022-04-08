/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.dao.IToken;
import mx.edu.uteq.domain.Token;
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
public class TokenServiceImp implements ITokenService{
    @Autowired
    private IToken tokenDao;

    @Override
    @Transactional
    public void delete(String idToken) {
        tokenDao.delete(idToken);
    }

    @Override
    @Transactional(readOnly = true)
    public Token findById(String idToken) {
        return tokenDao.findById(idToken);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Token findByToken(String token) {
        return tokenDao.findByToken(token);
    }
    
}
