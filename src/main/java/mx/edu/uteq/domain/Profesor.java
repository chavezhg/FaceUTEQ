/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author Ricardo
 */
@Data
@Entity
@Table(name = "profesor")
public class Profesor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProf;
    @ManyToOne
    @JoinColumn(name = "id_carr", nullable = false)
    public Carrera carrera;
    @Column(name = "n1_prof", nullable = false)
    private String n1Prof;
    @Column(name = "n2_prof", nullable = false)
    private String n2Prof;
    @Column(name = "ap_prof", nullable = false)
    private String apProf;
    @Column(name = "am_prof", nullable = false)
    private String amProf;
    @Column(name = "ecivil_prof", nullable = false)
    private String ecivilProf;
    @Column(name = "fnac_prof", nullable = false)
    private String fnacProf;
    @Column(name = "lnac_prof", nullable = false)
    private String lnacProf;
    @Column(name = "fa_prof", nullable = false)
    private String faProf;
    @Column(name = "fum_prof", nullable = true)
    private String fumProf;
}
