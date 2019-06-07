package examen;


import java.util.Comparator;

public class Atleta {

    private static int autonumerico=1;
    private String nombre;
    private int edad;
    private int[] alturaPeso=new int[2];
    private int id;
    public Atleta(String nombre, int edad, int altura,int peso) {
        id=autonumerico;
        autonumerico++;
        this.nombre = nombre;
        this.edad = edad;
        this.alturaPeso[0]=altura;
        this.alturaPeso[1]=peso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getId() {
        return id;
    }
    public int getAltura(){
        return alturaPeso[0];
    }
    public int getPeso(){
        return alturaPeso[1];
    }
    public static class comparatorNombre implements Comparator<Atleta> {

        public int compare(Atleta o1,Atleta o2){
            return o1.getNombre().compareTo(o2.getNombre());
        }
    }
    public static class comparatorEstatura implements Comparator<Atleta>{
        public int compare(Atleta o1,Atleta o2){
            return o1.getAltura()-o2.getAltura();
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Atleta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", altura=" + this.getAltura()+
                ", peso=" + this.getPeso()+
                '}';
    }
}

