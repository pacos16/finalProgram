package examen;
import com.github.javafaker.Faker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Lib {

    public static Scanner lector=new Scanner(System.in);
    public static Faker faker=new Faker(new Locale("es"));

    public static GregorianCalendar fakerFechas(String fecha1, String fecha2){
        GregorianCalendar calendar=new GregorianCalendar();
        SimpleDateFormat date=new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date date1 = date.parse(fecha1);
            Date date2 = date.parse(fecha2);
            calendar.setTime(faker.date().between(date1, date2));

        }catch (ParseException pe){
            System.out.println("fallo de formato");
        }
        return calendar;
    }

    public static GregorianCalendar gregorianFromString(String dd_slash_MM_slash_yyyy){
        GregorianCalendar calendar=new GregorianCalendar();
        SimpleDateFormat date=new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date1 = date.parse(dd_slash_MM_slash_yyyy);
            calendar.setTime(date1);

        }catch (ParseException pe){
            System.out.println("fallo de formato");
        }
        return calendar;
    }


    public static int aleatorio(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min +1 ) + min;
    }

    public static double aleatorio(double min, double max) {
        Random r = new Random();
        return min + r.nextDouble() * (max - min);
    }

    public static float aleatorio(float min, float max) {
        Random r = new Random();
        return min + r.nextFloat() * (max - min);
    }
    public static void limpiarPantalla() {
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
    }

    public static void pausa() {
        System.out.println("Pulsa INTRO para continuar...");
        lector.nextLine();
    }

    public static int pedirInt(int min, int max){
        int opcion;
        boolean correcto;
        do{
            correcto=false;
            try{
                opcion= Integer.parseInt(lector.nextLine());
                correcto=true;
            }catch (NumberFormatException nfe){
                System.out.println("Solo puede introducir numeros");
                opcion=min-1;
            }
            if(opcion<min || opcion >max){
                System.out.println("El numero no esta en el rango de opciones");
            }
        }while(!correcto || (opcion<min || opcion >max));
        return opcion;
    }

    public static boolean validarFecha(String fecha){
        if(fecha.length()>10)return false;
        try{
            SimpleDateFormat formatoFecha;
            formatoFecha= new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        }catch (ParseException pe){
            return false;
        }
        return true;
    }

    public static String generarAlfanumerico(int tamaño){
        StringBuilder stringBuilder=new StringBuilder();
        String abc="abcdefghijklmnopqrstuvwxyz";
        int num;
        for(int i=0; i<tamaño;i++){
            num=Lib.aleatorio(0,35);
            if(num<10){
                stringBuilder.append(num);
            }else{
                stringBuilder.append(abc.charAt(num-10));
            }
        }
        return stringBuilder.toString().toUpperCase();
    }

    public static Date setDate(String fecha, String hora){

        DateFormat format=new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            if (Integer.parseInt(hora.substring(0,2)) > 23 || Integer.parseInt(hora.substring(3,5)) >59) {
                System.out.println("Hora no correcta");
                return null;
            }
        }catch (NumberFormatException nfe){
            System.out.println("Hora no correcta");
            return null;
        }catch (IndexOutOfBoundsException ioob){
            return null;
        }
        try {
            return format.parse(fecha + " " + hora);
        }catch(ParseException pe){
            System.out.println("What????");

        }
        return null;
    }


}
