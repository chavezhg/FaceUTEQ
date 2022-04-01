/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.dao;

import mx.edu.uteq.domain.Profesor;
import mx.edu.uteq.domain.Publicacion;
import mx.edu.uteq.domain.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ricardo
 */
@Repository
public interface ITitulo extends JpaRepository<Titulo, Long>{
    
}
