package dto;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

public class NewUtenteDataDto extends PanacheEntityBase {

    public String codiceFiscale;
    public String nome;
    public String cognome;

}
