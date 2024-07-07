package entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "utente")
public class Utente extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idUtente;

    @Column(name = "codice_fiscale", unique = true, nullable = false)
    public String codiceFiscale;

    @Column(name = "nome", nullable = false)
    public String nome;

    @Column(name = "cognome", nullable = false)
    public String cognome;

    @ManyToOne
    @JoinColumn(name = "stato_id", nullable = false)
    public UtenteStato stato;

}
