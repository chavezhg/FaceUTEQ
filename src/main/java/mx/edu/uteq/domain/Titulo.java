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
@Table(name = "titulo")
public class Titulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTitu;
    @Column(name = "escu_titu", nullable = false)
    private String escuTitu;
    @Column(name = "nom_titu", nullable = false)
    private String nomTitu;
    @Column(name = "fec_titu", nullable = false)
    private String fecTitu;
    @Column(name = "fa_titu", nullable = false)
    private String faTitu;
    @Column(name = "fum_titu", nullable = true)
    private String fumTitu;
}
