/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.dao;

import mx.edu.uteq.domain.Estudiante;
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
public interface IEstudiante extends JpaRepository<Estudiante, Long>{
    
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO estudiante(id_carr, n1_estu, n2_estu, ap_estu, am_estu, ecivil_estu, fnac_estu, lnac_estu) VALUES(?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)", nativeQuery = true)
    void insert(String carrUsua, String n1Usua, String n2Usua, String apUsua, String amUsua, String ecivilUsua, String fnacUsua, String lnacUsua);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE estudiante\n"
            + "SET id_carr = ?1\n"
            + ",lnac_estu = ?2\n"
            + ",ecivil_estu = ?3\n"
            + "WHERE id_estu = ?4", nativeQuery = true)
    void actualizar(int carrUsua, String lnacUsua, String ecivilUsua, int idUsua);
    
    @Transactional
    @Query(value = "SELECT MAX(id_estu) FROM estudiante", nativeQuery = true)
    String getLastId();
}
