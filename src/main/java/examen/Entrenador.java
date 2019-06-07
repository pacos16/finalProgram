package examen;

public class Entrenador extends Tecnico implements CalcularSueldo {
    private final int PRECIO_POR_ATLETA=20;
    private  int base=300;
    private boolean profesional;

    public Entrenador(String nif, String nombre, boolean profesional) {
        super(nif, nombre);
        this.profesional = profesional;
        if(!profesional){
            base=0;
        }
    }

    public float calcularSueldo(){
        if(profesional) return 300+(PRECIO_POR_ATLETA*atletas.size());
        return PRECIO_POR_ATLETA*atletas.size();
    }

    public String toString(){
        String prof="NO";
        if(profesional) prof="SI";

        return "=======Entrenador======= \n"+
                "Ident:       "+this.nif+"\n"+
                "Nombre:      "+this.nombre+"\n"+
                "Profesional: "+prof+"\n"+
                "Base:        "+base+"\n"+
                "NumAtletas:  "+atletas.size()+"\n";
    }
}
