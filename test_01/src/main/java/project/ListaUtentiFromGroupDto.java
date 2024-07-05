package project;

import entities.Utente;
import entities.UtenteStato;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class ListaUtentiFromGroupDto {

    public Long id;
    public String codiceFiscale;
    public String nome;
    public String cognome;
    public UtenteStato stato;

    public ListaUtentiFromGroupDto(Utente utente) {
        this.id = utente.id;
        this.codiceFiscale = utente.codiceFiscale;
        this.nome = utente.nome;
        this.cognome = utente.cognome;
        this.stato = utente.stato;
    }
}
