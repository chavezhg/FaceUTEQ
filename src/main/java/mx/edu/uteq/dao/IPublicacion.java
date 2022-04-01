/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.dao;

import java.util.List;
import mx.edu.uteq.domain.Publicacion;
import mx.edu.uteq.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ricardo
 */
@Repository
public interface IPublicacion extends JpaRepository<Publicacion, Long> {

    @Query(value = "SELECT * FROM publicacion, usuario, privacidad, amigo\n"
            + "WHERE publicacion.id_usua = usuario.id_usua \n"
            + "AND privacidad.id_usua = usuario.id_usua \n"
            + "AND (publi_priv = 1\n"
            + "OR ((amigo.idemi_usua = usuario.id_usua OR amigo.idrec_usua = usuario.id_usua) AND esta_amig = 2))\n"
            + "AND usuario.id_usua != ?1", nativeQuery = true)
    List<Publicacion> getAllDisponiblesByUsuario(String email);
}
