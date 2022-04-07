/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.dao;

import java.util.List;
import mx.edu.uteq.domain.Privacidad;
import mx.edu.uteq.domain.Profesor;
import mx.edu.uteq.domain.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ricardo
 */
@Repository
public interface IPrivacidad extends JpaRepository<Privacidad, Long> {

    @Modifying
    @Query(value = "UPDATE privacidad\n"
            + "SET publi_priv = ?1\n"
            + "WHERE id_usua = ?2", nativeQuery = true)
    void update(String publiPriv, int idUsua);

    @Query(value = "SELECT * FROM privacidad, usuario\n"
            + "WHERE usuario.id_usua = privacidad.id_usua\n"
            + "AND privacidad.id_usua = ?1", nativeQuery = true)
    Privacidad findByIdUsua(int idUsua);
    
    @Modifying
    @Query(value = "INSERT INTO privacidad(id_usua, publi_priv, perfil_priv) VALUES(?1, ?2, ?3)", nativeQuery = true)
    void save(String idUsua, String publiPriv, String perfilPriv);

}
