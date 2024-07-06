package entities.compositeKeys;

import entities.Gruppo;
import entities.Utente;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class G_U_KEY implements Serializable {

    @ManyToOne
    public Utente utente;

    @ManyToOne
    public Gruppo gruppo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        G_U_KEY that = (G_U_KEY) o;
        return Objects.equals(utente, that.utente) && Objects.equals(gruppo, that.gruppo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(utente, gruppo);
    }

}
