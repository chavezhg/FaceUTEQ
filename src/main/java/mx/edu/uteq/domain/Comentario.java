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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author Ricardo
 */
@Data
@Entity
@Table(name = "comentario")
public class Comentario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCome;
    @ManyToOne
    @JoinColumn(name = "id_usua", nullable = true)
    private Usuario usuario;
    @OneToOne
    @JoinColumn(name = "id_publ", nullable = false)
    public Publicacion publicacion;
    @Column(name = "desc_come", nullable = false)
    private String descCome;
    @Column(name = "fa_come", nullable = false)
    private String faCome;
    @Column(name = "fum_come", nullable = true)
    private String fumCome;
}
