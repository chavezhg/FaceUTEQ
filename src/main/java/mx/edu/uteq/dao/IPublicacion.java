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
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ricardo
 */
@Repository
public interface IPublicacion extends JpaRepository<Publicacion, Long> {

    @Query(value = "SELECT * FROM publicacion, usuario\n"
            + "WHERE publicacion.id_usua = usuario.id_usua\n"
            + "AND email_usua = ?1\n"
            + "ORDER BY(fa_publ) DESC", nativeQuery = true)
    List<Publicacion> getAllByUsuario(String email);

    @Query(value = "SELECT * FROM publicacion, usuario, privacidad, amigo\n"
            + "WHERE publicacion.id_usua = usuario.id_usua\n"
            + "AND privacidad.id_usua = usuario.id_usua\n"
            + "AND (\n"
            + "    	publi_priv = 1 OR\n"
            + "    		(\n"
            + "            	(\n"
            + "                	amigo.idemi_usua = usuario.id_usua OR amigo.idrec_usua = usuario.id_usua\n"
            + "            	)\n"
            + "                AND esta_amig = 2\n"
            + "        	)\n"
            + "	)\n"
            + "AND usuario.id_usua != ?1\n"
            + "GROUP BY(publicacion.id_publ)\n"
            + "ORDER BY(fa_publ) DESC", nativeQuery = true)
    List<Publicacion> getAllDisponiblesByUsuario(String email);

    @Modifying
    @Query(value = "INSERT INTO publicacion(id_usua, desc_publ, foto_publ) VALUES(?1, ?2, ?3)", nativeQuery = true)
    void insertar(int idUsua, String descPubl, String url);
}
