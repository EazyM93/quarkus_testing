package entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "gruppo")
public class Gruppo extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idGruppo;
    
    @Column(name = "nome", nullable = false)
    public String nome;

    @Column(name = "sigla", length = 3, unique = true, nullable = false)
    public String sigla;

    @Column(name = "descrizione", nullable = false)
    public String descrizione;

}
