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
        utente.stato = UtenteStato.find("codice", "A").firstResult();
        utente.persist();
    }

    public String cambioStatoUtente(Long id, String codice){

        Utente utente = findById(id);
        UtenteStato utenteStato = UtenteStato.find("codice", codice).firstResult();

        if(utente.stato.codice.equals(codice))
            return utente.nome + " " + utente.cognome + " è già " + utenteStato.nome;

        if(utenteStato == null)
            return "Lo stato inserito non esiste.";

        utente.stato = utenteStato;
        utente.persist();

        return utente.nome + " " + utente.cognome + " è passato allo stato: " + utenteStato.nome;
    }

}
