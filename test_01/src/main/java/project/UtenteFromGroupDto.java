package project;

import entities.Utente;
import entities.UtenteStato;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class UtenteFromGroupDto {

    public Long idUtente;
    public String codiceFiscale;
    public String nome;
    public String cognome;
    public UtenteStato stato;

    public UtenteFromGroupDto(Utente utente) {
        this.idUtente = utente.idUtente;
        this.codiceFiscale = utente.codiceFiscale;
        this.nome = utente.nome;
        this.cognome = utente.cognome;
        this.stato = utente.stato;
    }
}
