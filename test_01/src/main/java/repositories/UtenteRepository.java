package repositories;

import dto.NewUtenteDataDto;
import entities.UtenteStato;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import entities.Utente;

@ApplicationScoped
public class UtenteRepository implements PanacheRepository<Utente> {

    public void creaUtente(NewUtenteDataDto data){
        Utente utente = new Utente();
        utente.codiceFiscale = data.codiceFiscale.toUpperCase();
        utente.nome = data.nome;
        utente.cognome = data.cognome;
        utente.stato = UtenteStato.find("codice", "A").singleResult();
        utente.persist();
    }

}
