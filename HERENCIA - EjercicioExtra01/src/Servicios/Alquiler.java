/*
 En un puerto se alquilan amarres para barcos de distinto tipo. Para cada Alquiler se guarda: el
nombre, documento del cliente, la fecha de alquiler, fecha de devolución, la posición del
amarre y el barco que lo ocupará.
Un Barco se caracteriza por: su matrícula, su eslora en metros y año de fabricación.
Sin embargo, se pretende diferenciar la información de algunos tipos de barcos especiales:
• Número de mástiles para veleros.
• Potencia en CV para barcos a motor.
• Potencia en CV y número de camarotes para yates de lujo.
Un alquiler se calcula multiplicando el número de días de ocupación (calculado con la fecha de
alquiler y devolución), por un valor módulo de cada barco (obtenido simplemente
multiplicando por 10 los metros de eslora).
En los barcos de tipo especial el módulo de cada barco se calcula sacando el módulo normal y
sumándole el atributo particular de cada barco. En los veleros se suma el número de mástiles,
en los barcos a motor se le suma la potencia en CV y en los yates se suma la potencia en CV y
el número de camarotes.
Utilizando la herencia de forma apropiada, deberemos programar en Java, las clases y los
métodos necesarios que permitan al usuario elegir el barco que quiera alquilar y mostrarle el
precio final de su alquiler.*/
package Servicios;

import Entidades.Barco;
import Entidades.BarcoAMotor;
import Entidades.Velero;
import Entidades.YateDeLujo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

/**
 */
public class Alquiler {
    private String nombre;
    private int dni;
    private LocalDate fechaA;
    private LocalDate fechaD;
    private int pos;
    private Barco b;
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    
    public Alquiler(String nombre, int dni, LocalDate fechaA, LocalDate fechaD, int pos, Barco b) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaA = fechaA;
        this.fechaD = fechaD;
        this.pos = pos;
        this.b = b;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaA() {
        return fechaA;
    }

    public void setFechaA(LocalDate fechaA) {
        this.fechaA = fechaA;
    }

    public LocalDate getFechaD() {
        return fechaD;
    }

    public void setFechaD(LocalDate fechaD) {
        this.fechaD = fechaD;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public Barco getB() {
        return b;
    }

    public void setB(Barco b) {
        this.b = b;
    }
    

    public Alquiler() {
    }
    public long calcularFechas(){
        System.out.println("Ingrese la fecha inicial:");
        Date d1 = new Date(sc.nextInt()-1900, sc.nextInt()-1, sc.nextInt());
        System.out.println("Ingrese la fecha final:");
        Date d2 = new Date(sc.nextInt() - 1900 , sc.nextInt()-1, sc.nextInt());
        int milisecondsByDay = 86400000;
        return (d2.getTime()-d1.getTime()) / milisecondsByDay;
    }
    public void crearAlquiler(){
        System.out.print("Nombre del solicitante:");
        this.nombre=sc.next();
        System.out.print("DNI:");
        this.dni=sc.nextInt();        
        System.out.print("Posicion en el puerto:");
        this.pos=sc.nextInt();
        System.out.println("¿Que tipo de embarcacion desea amarrar?");
        System.out.println("1-Velero");
        System.out.println("2-Barco a Motor");
        System.out.println("3-Yate de Lujo");
        int p=sc.nextInt();
        switch(p){
            case 1:                
                System.out.print("Indique numero de mastiles:");
                int i= sc.nextInt();
                System.out.print("Indique la matricula del Velero:");
                int f=sc.nextInt();
                System.out.print("Indique el largo:");
                int j=sc.nextInt();
                System.out.print("Indique el año en que se fabricó el Velero:");
                int k=sc.nextInt();
                this.b=new Velero(i, f, j, k);
                b.calcularPrecio(calcularFechas());
                break;
                
            case 2:
                System.out.print("Indique la potencia del motor:");
                int l= sc.nextInt();
                System.out.print("Indique la matricula del Barco A Motor:");
                int m=sc.nextInt();
                System.out.print("Indique el largo:");
                int n=sc.nextInt();
                System.out.print("Indique el año en que se fabricó el Barco A Motor:");
                int q=sc.nextInt();
                this.b=new BarcoAMotor(l,m, n, q);
                b.calcularPrecio(calcularFechas());
                break;
                
            case 3:
                System.out.print("Indique la cantidad de camarotes:");
                int z=sc.nextInt();
                System.out.print("Indique la potencia del motor:");
                int t= sc.nextInt();
                System.out.print("Indique la matricula del Barco A Motor:");
                int y=sc.nextInt();
                System.out.print("Indique el largo:");
                int x=sc.nextInt();
                System.out.print("Indique el año en que se fabricó el Barco A Motor:");
                int s=sc.nextInt();
                this.b=new YateDeLujo(z,t, y, x,s);                
                b.calcularPrecio(calcularFechas());
                break;
            default:
                break;
                        
        }
        
    }
    /*Un alquiler se calcula multiplicando el número de días de ocupación (calculado con la fecha de
alquiler y devolución), por un valor módulo de cada barco (obtenido simplemente
multiplicando por 10 los metros de eslora).
En los barcos de tipo especial el módulo de cada barco se calcula sacando el módulo normal y
sumándole el atributo particular de cada barco. En los veleros se suma el número de mástiles,
en los barcos a motor se le suma la potencia en CV y en los yates se suma la potencia en CV y
el número de camarotes.
Utilizando la herencia de forma apropiada, deberemos programar en Java, las clases y los
métodos necesarios que permitan al usuario elegir el barco que quiera alquilar y mostrarle el
precio final de su alquiler.*/
    
   
}
