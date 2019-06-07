package examen;

import java.util.ArrayList;

public abstract class Tecnico {
    protected String nif;
    protected String nombre;

    protected ArrayList<Atleta> atletas;

    public Tecnico(String nif, String nombre) {
        this.nif = nif;
        this.nombre = nombre;

        this.atletas=new ArrayList<>();
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean addAtleta(Atleta atleta){
        return atletas.add(atleta);
    }

    public ArrayList<Atleta> getAtletas() {
        return atletas;
    }
}
