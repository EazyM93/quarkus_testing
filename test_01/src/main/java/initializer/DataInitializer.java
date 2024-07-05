package initializer;

import entities.Gruppo;
import entities.UtenteStato;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.event.Startup;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DataInitializer {

    @Transactional
    void onStart(@Observes Startup startup){

        if(UtenteStato.count() == 0){

            UtenteStato attivo = new UtenteStato();
            attivo.nome = "Attivo";
            attivo.codice = "A";
            attivo.persist();

            UtenteStato sospeso = new UtenteStato();
            sospeso.nome = "Sospeso";
            sospeso.codice = "S";
            sospeso.persist();

            UtenteStato inattivo = new UtenteStato();
            inattivo.nome = "Inattivo";
            inattivo.codice = "I";
            inattivo.persist();

        }

        if(Gruppo.count() == 0){

            Gruppo sindacalisti = new Gruppo();
            sindacalisti.nome = "Sindacalisti";
            sindacalisti.descrizione = "Associazione Sindacale";
            sindacalisti.sigla = "SIN";
            sindacalisti.persist();

            Gruppo senior = new Gruppo();
            senior.nome = "Senior";
            senior.descrizione = "Senior Aziendali";
            senior.sigla = "SEN";
            senior.persist();

        }

    }

}
