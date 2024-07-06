package resource;

import dto.UtenteGruppoDto;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import project.ListaUtentiFromGroupDto;
import repositories.GruppiRepository;

import java.util.List;

@Path("/gruppi")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GruppiResource {

    @Inject
    GruppiRepository gruppiRepository;


    @POST
    @Path("/assegnazione_utente")
    @Transactional
    public Response assegnaUtente(UtenteGruppoDto data){

        String query = "utente.id = ?1 AND gruppo.sigla =?2";

        if(gruppiRepository.find(query, data.idUtente, data.siglaGruppo).count() != 0)
            return Response.status(Response.Status.CONFLICT).entity("Utente già associato a questo gruppo").build();

        gruppiRepository.inserisciUtente(data);
        return Response.ok("Assegnazione avvenuta con successo.").build();
    }

    @GET
    @Path("/{sigla}/utenti")
    public Response getGruppo(@PathParam("sigla") String sigla){
        List<ListaUtentiFromGroupDto> utenti = gruppiRepository
                .find("gruppo.sigla", sigla)
                .project(ListaUtentiFromGroupDto.class)
                .list();
        return Response.ok(utenti).build();
    }

}
