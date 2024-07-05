package repositories;

import entities.Gruppo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GruppoRepository implements PanacheRepository<Gruppo> {
}
