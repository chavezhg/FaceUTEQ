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
@Table(name = "amigo")
public class Amigo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAmig;
    @ManyToOne
    @JoinColumn(name = "idemi_usua", nullable = true)
    private Usuario usuarioemi;
    @ManyToOne
    @JoinColumn(name = "idrec_usua", nullable = true)
    private Usuario usuariorec;
    @Column(name = "esta_amig", nullable = false)
    private int estaAmig;
    @Column(name = "fa_amig", nullable = false)
    private String faAmig;
    @Column(name = "fum_amig", nullable = true)
    private String fumAmig;
}
