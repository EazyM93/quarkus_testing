package entities.compositeKeys;

import entities.Gruppo;
import entities.Utente;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class G_U_KEY implements Serializable {

    @ManyToOne
    public Utente utente;

    @ManyToOne
    public Gruppo gruppo;

}
