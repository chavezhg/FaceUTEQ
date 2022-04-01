package mx.edu.uteq.domain;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "publicacion")
public class Publicacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idPubl;
    @Column(name = "desc_publ", nullable = false)
    public String descPubl;
    @ManyToOne
    @JoinColumn(name = "id_usua", nullable = false)
    public Usuario usuario;
    @Column(name = "fa_publ", nullable = false)
    public Date faPubl;
    @Column(name = "fum_publ", nullable = true)
    public Date fumPubl;
    
}