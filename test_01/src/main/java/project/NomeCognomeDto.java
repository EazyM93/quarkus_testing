package project;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class NomeCognomeDto {

    public String nome;
    public String cognome;

    public NomeCognomeDto(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }
}
