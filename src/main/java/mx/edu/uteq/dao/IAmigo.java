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
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ricardo
 */
@Repository
public interface IAmigo extends JpaRepository<Amigo, Long> {

    @Query(value = "SELECT usuario.id_usua, id_prof, id_estu, id_rol, email_usua, fa_usua, fum_usua FROM usuario WHERE id_usua NOT IN(\n"
            + "    SELECT usuario.id_usua FROM usuario, amigo\n"
            + "    WHERE (amigo.idemi_usua = usuario.id_usua OR amigo.idrec_usua = usuario.id_usua)\n"
            + "    AND (idemi_usua = ?1 OR idrec_usua = ?1)\n"
            + "    AND esta_amig = 2\n"
            + ")\n"
            + "AND usuario.id_usua != ?1", nativeQuery = true)
    List<Amigo> getAllNotFriends(int idUsua);
}
