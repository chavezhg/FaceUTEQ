/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.dao;

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
public interface IProfesor extends JpaRepository<Profesor, Long>{
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO profesor(id_carr, n1_prof, n2_prof, ap_prof, am_prof, ecivil_prof, fnac_prof, lnac_prof) VALUES(?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)", nativeQuery = true)
    void insertar(String carrUsua, String n1Usua, String n2Usua, String apUsua, String amUsua, String ecivilUsua, String fnacUsua, String lnacUsua);
    
    @Modifying
    @Query(value = "UPDATE profesor\n"
            + "SET id_carr = ?1\n"
            + ",lnac_prof = ?2\n"
            + ",ecivil_prof = ?3\n"
            + "WHERE id_prof = ?4", nativeQuery = true)
    void actualizar(int carrUsua, String lnacUsua, String ecivilUsua, int idUsua);
    
    @Transactional
    @Query(value = "SELECT MAX(id_prof) FROM profesor", nativeQuery = true)
    String getLastId();
}
