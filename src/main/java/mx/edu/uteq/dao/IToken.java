/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.dao;

import java.util.List;
import mx.edu.uteq.domain.Amigo;
import mx.edu.uteq.domain.Carrera;
import mx.edu.uteq.domain.Profesor;
import mx.edu.uteq.domain.Publicacion;
import mx.edu.uteq.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ricardo
 */
@Repository
public interface IToken extends JpaRepository<Token, Long> {
    
    @Modifying
    @Query(value = "DELETE FROM token WHERE id_toke = ?1", nativeQuery = true)
    void delete(String idToken);
    
    @Query(value = "SELECT * FROM token WHERE id_toke = ?1", nativeQuery = true)
    Token findById(String idToken);
    
    @Transactional
    @Query(value = "SELECT * FROM token WHERE desc_toke = ?1", nativeQuery = true)
    Token findByToken(String token);
}
