package examen;

public class Fisio extends Tecnico implements CalcularSueldo {

    private float costeServicio;
    public Fisio(String nif, String nombre,float costeServicio) {
        super(nif, nombre);
        this.costeServicio=costeServicio;

    }

    public float calcularSueldo(){
        return costeServicio*atletas.size();
    }

    public String toString(){

        return "=======Fisio======= \n"+
                "Ident:          "+this.nif+"\n"+
                "Nombre:         "+this.nombre+"\n"+
                "Coste servicio: "+this.costeServicio+"\n"+
                "NumAtletas:     "+atletas.size()+"\n";
    }

}
