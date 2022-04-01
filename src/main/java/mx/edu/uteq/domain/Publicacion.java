package mx.edu.uteq.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idUsua;
    @Column(name = "id_prof", nullable = true)
    public int idProf;
    @Column(name = "id_estu", nullable = true)
    public int idEstu;
    @OneToOne
    @JoinColumn(name = "id_rol")
    public Rol rol;
    @Column(name = "email_usua", nullable = false)
    public String emailUsua;
    @Column(name = "pass_usua", nullable = false)
    public String passUsua;
    @Column(name = "fa_usua", nullable = false)
    public String faUsua;
    @Column(name = "fum_usua", nullable = true)
    public String fumUsua;

}