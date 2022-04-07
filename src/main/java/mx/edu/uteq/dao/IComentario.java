/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.dao;

import java.util.List;
import mx.edu.uteq.domain.Carrera;
import mx.edu.uteq.domain.Comentario;
import mx.edu.uteq.domain.Profesor;
import mx.edu.uteq.domain.Publicacion;
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
public interface IComentario extends JpaRepository<Comentario, Long>{
    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM comentario\n"
            + "WHERE id_publ = ?1", nativeQuery = true)
    List<Comentario> findAllByPublicacion(int idPubl);
    
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO comentario(id_usua, id_publ, desc_come) VALUES(?1, ?2, ?3)", nativeQuery = true)
    void save(String idUsua, String idPubl, String descCome);
}
