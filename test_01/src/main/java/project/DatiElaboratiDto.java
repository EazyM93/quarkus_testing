package project;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class DatiElaboratiDto {

    public Long idUtente;
    public String codiceFiscale;
    public String nomeCompleto;
    public String stato;

    public DatiElaboratiDto(Long idUtente, String codiceFiscale,
                            String nome, String cognome, String stato) {
        this.idUtente = idUtente;
        this.codiceFiscale = codiceFiscale;
        this.nomeCompleto = nome + ' ' + cognome;
        this.stato = stato;
    }
}
