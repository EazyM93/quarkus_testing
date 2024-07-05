package resource;

import dto.NewUtenteDataDto;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import repositories.UtenteRepository;

@Path("/utenti")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UtenteResource {

    @Inject
    UtenteRepository utenteRepository;

    @GET
    @Path("")
    public Response getUtentiList(){
        return Response.ok(utenteRepository.listAll()).build();
    }

    @POST
    @Path("/nuovo_utente")
    @Transactional
    public Response nuovoUtente(NewUtenteDataDto data){

        String cf = data.codiceFiscale.toUpperCase();

        if(cf.length() != 16)
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Codice Fiscale troppo" + (cf.length() < 16 ? " corto." : " lungo.")).build();

        if(utenteRepository.find("codiceFiscale", cf).firstResult() != null)
            return Response.status(Response.Status.CONFLICT)
                    .entity("Codice Fiscale già registrato.").build();

        utenteRepository.creaUtente(data);

        return Response.ok("Utente creato con successo").build();

    }

}
