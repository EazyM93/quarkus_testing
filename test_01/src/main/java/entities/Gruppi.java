package entities;

import entities.compositeKeys.G_U_KEY;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "gruppi")
@IdClass(G_U_KEY.class)
public class Gruppi extends PanacheEntityBase {

    @Id
    @ManyToOne
    @JoinColumn(name = "utente_id")
    public Utente utente;

    @Id
    @ManyToOne
    @JoinColumn(name = "gruppo_id")
    public Gruppo gruppo;

}
