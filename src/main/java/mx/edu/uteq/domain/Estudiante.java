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
@Table(name = "estudiante")
public class Estudiante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstu;
    @ManyToOne
    @JoinColumn(name = "id_carr", nullable = false)
    public Carrera carrera;
    @Column(name = "n1_estu", nullable = false)
    private String n1Estu;
    @Column(name = "n2_estu", nullable = false)
    private String n2Estu;
    @Column(name = "ap_estu", nullable = false)
    private String apEstu;
    @Column(name = "am_estu", nullable = false)
    private String amEstu;
    @Column(name = "ecivil_estu", nullable = false)
    private String ecivilEstu;
    @Column(name = "fnac_estu", nullable = false)
    private String fnacEstu;
    @Column(name = "lnac_estu", nullable = false)
    private String lnacEstu;
    @Column(name = "fa_estu", nullable = false)
    private String faEstu;
    @Column(name = "fum_estu", nullable = true)
    private String fumEstu;
}
