/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.dao;

import java.util.List;
import mx.edu.uteq.domain.Usuario;
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
public interface IUsuario extends JpaRepository<Usuario, Long> {

    public Usuario findByEmailUsua(String emailUsua);

    @Query(value = "SELECT * FROM usuario WHERE id_usua NOT IN(\n"
            + "    SELECT usuario.id_usua FROM usuario, amigo\n"
            + "    WHERE (amigo.idemi_usua = usuario.id_usua OR amigo.idrec_usua = usuario.id_usua)\n"
            + "    AND (idemi_usua = ?1 OR idrec_usua = ?1)\n"
            + "    AND (esta_amig = 2 OR esta_amig = 1)\n"
            + ")\n"
            + "AND usuario.id_usua != ?1", nativeQuery = true)
    List<Usuario> findAllNotFriends(int idUsua);

    @Query(value = "SELECT * FROM usuario, amigo\n"
            + "WHERE (amigo.idemi_usua = usuario.id_usua OR amigo.idrec_usua = usuario.id_usua)\n"
            + "AND (idemi_usua = ?1 OR idrec_usua = ?1)\n"
            + "AND esta_amig = 2\n"
            + "AND usuario.id_usua != ?1", nativeQuery = true)
    List<Usuario> findAllFriends(int idUsua);

    @Query(value = "SELECT * FROM usuario, amigo\n"
            + "            WHERE usuario.id_usua = idemi_usua\n"
            + "            AND idrec_usua = ?1\n"
            + "            AND esta_amig = 1", nativeQuery = true)
    List<Usuario> findAllRequests(int idUsua);
    
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO usuario(id_prof, id_estu, id_rol, email_usua, pass_usua, esta_usua) VALUES(?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void save(String idProf, String idEstu, String idRol, String emailUsua, String passUsua, String estaUsua);
    
    @Transactional
    @Query(value = "SELECT MAX(id_usua) FROM usuario", nativeQuery = true)
    String getLastId();
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE usuario SET esta_usua = 1 WHERE id_usua = ?1", nativeQuery = true)
    void activarCuenta(String idUsua);
}
