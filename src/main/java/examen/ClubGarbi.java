package examen;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ClubGarbi {

    static ArrayList<Atleta> atletas=new ArrayList<>();
    static ArrayList<Tecnico> tecnicos=new ArrayList<>(10);
    static Scanner lector =new Scanner(System.in);
    public static void main(String[] args) {

        //anyadimos datos
         atletas.add(new Atleta("Pepe Torreblanca", 20,185,70));
         atletas.add(new Atleta("Juan Matoses", 18,180,72));
         atletas.add(new Atleta("Maria Peris", 15,175,70));
         atletas.add(new Atleta("Sonia Amat", 45,178,65));
         atletas.add(new Atleta("Pedro Ferrer", 21,182,68));
         atletas.add(new Atleta("Andrea Tomas", 19,174,60));
         atletas.add(new Atleta("Beatriz Luengo", 22,168,75));
         atletas.add(new Atleta("Andres Iniesta", 26,175,68));
         atletas.add(new Atleta("Federico Valdemoro", 35,180,75));
         atletas.add(new Atleta("Angel Gomez", 23,190,80));


         anyadirTecnico(new Entrenador("11111111A","Antonio Garcia", false) );
         anyadirTecnico(new Entrenador("22222222B","Ana Pastor", true) );
         anyadirTecnico(new Fisio("33333333C","Francisco Fuster",25));
         anyadirTecnico(new Fisio("44444444D","Vicente Mascarell",30));

         tecnicos.get(0).addAtleta(atletas.get(0));
         tecnicos.get(0).addAtleta(atletas.get(1));
         tecnicos.get(0).addAtleta(atletas.get(2));
         tecnicos.get(1).addAtleta(atletas.get(3));
         tecnicos.get(1).addAtleta(atletas.get(4));
         tecnicos.get(1).addAtleta(atletas.get(5));
         tecnicos.get(3).addAtleta(atletas.get(6));
         tecnicos.get(3).addAtleta(atletas.get(7));
         tecnicos.get(3).addAtleta(atletas.get(8));
         tecnicos.get(3).addAtleta(atletas.get(9));


        for (Atleta a:atletas
             ) {
            System.out.println(a.toString());
        }
        for (Tecnico t: tecnicos
             ) {
            System.out.println(t.toString());
        }
         //menuPrincipal
        int num;
        do {
            System.out.println(
                    "   ____ _       _        ____            _     _ \n" +
                            "  / ___| |_   _| |__    / ___| __ _ _ __| |__ (_)\n" +
                            " | |   | | | | | '_ \\  | |  _ / _` | '__| '_ \\| |\n" +
                            " | |___| | |_| | |_) | | |_| | (_| | |  | |_) | |\n" +
                            "  \\____|_|\\__,_|_.__/   \\____|\\__,_|_|  |_.__/|_|\n" +
                            "                                                 "
            );
            System.out.println("1-Alta nuevo Tecnico");
            System.out.println("2-Calcular sueldo tecnico");
            System.out.println("3-Imprimir informacion de un tipo de tecnico");
            System.out.println("4-Estadisticas Varias");
            System.out.println("5-Ordenar Lista de atletas");
            System.out.println("6-Eliminar un alumno del club");
            System.out.println("7-Cambiar nombres");
            System.out.println("------------------");
            System.out.println("0-Salir");
            num=Lib.pedirInt(0,8);

            switch (num){

                case 1:

                    String nombre;
                    String ident;
                    // aqui me he quedao... pero se hacerlo xD
                    //tipo de tecnico
                    //pedir
                    //xupao
                    break;
                case 2:
                    boolean correcto=false;
                    String nif;
                    do{
                        System.out.println("Dime el nif");
                        nif= lector.nextLine();
                        for (Tecnico t: tecnicos
                             ) {
                            if (nif.equals(t.getNif())){
                                correcto=true;
                                System.out.println("====Pago a tecnico====");
                                System.out.println("----------------------");
                                Date date=new Date();
                                SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
                                System.out.println("Fecha:    "+format.format(date));

                                System.out.println(t.toString());

                                System.out.println("=============");

                                System.out.print("Total a pagar ");
                                if(t instanceof Fisio){
                                    Fisio f=(Fisio) t;
                                    System.out.println(f.calcularSueldo());
                                }else{
                                    Entrenador e= (Entrenador) t;
                                    System.out.println(e.calcularSueldo());
                                }
                                Lib.pausa();
                            }
                        }
                        if(!correcto){
                            System.out.println("No correcto introduzca de nuevo");
                            Lib.pausa();
                        }
                    }while(!correcto);

                    break;
                case 3:
                    int tipo=0;


                    System.out.println("Elije el tipo");
                    System.out.println("-------------");
                    System.out.println("1.Entrenador");
                    System.out.println("2.Fisio");
                    tipo=Lib.pedirInt(1,2);



                    for (Tecnico t:tecnicos
                    ) {
                        if(tipo==1 && t instanceof Entrenador){

                            System.out.println(t.toString());
                            for (Atleta a: t.getAtletas()
                            ) {
                                System.out.println(a.toString());
                            }

                        }
                        if(tipo==2 && t instanceof Fisio){

                            System.out.println(t.toString());
                            for (Atleta a: t.getAtletas()
                            ) {
                                System.out.println(a.toString());
                            }

                        }
                    }
                    Lib.pausa();

                    break;
                case 4:
                    int peso=0;
                    int maxAltura=0;
                    for (Atleta a : atletas
                         ) {
                        peso+=a.getPeso();
                        if(maxAltura<a.getAltura()){
                            maxAltura=a.getAltura();
                        }
                    }
                    System.out.println(peso/atletas.size());

                    for (Atleta a:atletas
                         ) {
                        if(a.getAltura()==maxAltura){
                            System.out.println(a.toString());
                            break;//a ver que pasa
                        }

                    }
                    break;
                case 5:
                    System.out.println("Por nombre");
                    atletas.sort(new Atleta.comparatorNombre());
                    for (Atleta a: atletas
                         ) {
                        System.out.println(a.toString());
                    }
                    Lib.pausa();
                    System.out.println("Por estatura");

                    atletas.sort(new Atleta.comparatorEstatura());
                    for (Atleta a: atletas
                    ) {
                        System.out.println(a.toString());
                    }
                    break;
                case 6:
                     correcto=false;
                     int id;

                    do {
                        System.out.println("Dime el id");
                        id= Lib.pedirInt(1,Integer.MAX_VALUE);
                        Atleta adl=null;
                        for (Atleta a: atletas
                             ) {
                            if(a.getId()==id){
                                correcto=true;

                                for (Tecnico t: tecnicos
                                     ) {
                                    for (Atleta ad: t.getAtletas()
                                         ) {
                                        if(ad.equals(a)){
                                             adl=ad;
                                        }
                                    }
                                    if(adl!=null) t.getAtletas().remove(adl);
                                }
                                adl=a;
                            }
                        }
                        if(adl!=null) atletas.remove(adl);
                        if(correcto) {
                            Lib.pausa();
                        }
                        if(!correcto){
                            System.out.println("no encontrado");
                            Lib.pausa();
                        }
                    }while(!correcto);
                    break;
                case 7:

                    for (Atleta a: atletas
                         ) {
                        String[] jajaj=a.getNombre().split(" ");
                        a.setNombre(jajaj[1]+", "+jajaj[0]);
                    }
                    break;


            }
        }while(num!=0);
    }



    public static void anyadirTecnico(Tecnico tec){

        if(tecnicos.size()<10){
            tecnicos.add(tec);
        }else{
            System.out.println("Demasiados Tecnicos");
            Lib.pausa();
            Lib.limpiarPantalla();
        }
    }


}
