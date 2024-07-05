package repositories;

import dto.UtenteGruppoDto;
import entities.Gruppi;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class GruppiRepository implements PanacheRepository<Gruppi> {

    @Inject
    UtenteRepository utenteRepository;

    @Inject
    GruppoRepository gruppoRepository;

    public void inserisciUtente(UtenteGruppoDto data){
        Gruppi nuovaAssegnazione = new Gruppi();
        nuovaAssegnazione.utente = utenteRepository.findById(data.idUtente);
        nuovaAssegnazione.gruppo = gruppoRepository
                .find("sigla", data.siglaGruppo.toUpperCase()).firstResult();
        nuovaAssegnazione.persist();
    }

}
