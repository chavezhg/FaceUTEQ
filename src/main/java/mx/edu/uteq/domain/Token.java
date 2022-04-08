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
@Table(name = "token")
public class Token implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idToke;
    @ManyToOne
    @JoinColumn(name = "id_usua", nullable = false)
    private Usuario usuario;
    @Column(name = "desc_toke", nullable = false)
    private String descToke;
    @Column(name = "fa_toke", nullable = false)
    private String faToke;
    @Column(name = "fum_toke", nullable = true)
    private String fumToke;
}
