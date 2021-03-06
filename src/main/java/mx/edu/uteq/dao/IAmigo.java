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
import mx.edu.uteq.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ricardo
 */
@Repository
public interface IAmigo extends JpaRepository<Amigo, Long> {
    @Modifying
    @Query(value = "INSERT INTO amigo(idemi_usua, idrec_usua) VALUES(?1, ?2)", nativeQuery = true)
    void save(int idEmi, int idRec);
    
    @Modifying
    @Query(value = "UPDATE amigo SET esta_amig = 2 WHERE idemi_usua = ?1 AND idrec_usua = ?2", nativeQuery = true)
    void aceptarSolicitud(int idEmi, int idRec);
    
    @Modifying
    @Query(value = "UPDATE amigo SET esta_amig = 3 WHERE idemi_usua = ?1 AND idrec_usua = ?2", nativeQuery = true)
    void rechazarSolicitud(int idEmi, int idRec);
}
