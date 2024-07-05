package dto;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

public class UtenteGruppoDto extends PanacheEntityBase {

    public Long idUtente;
    public String siglaGruppo;

}
