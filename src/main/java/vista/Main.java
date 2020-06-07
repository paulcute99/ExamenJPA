/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.LigaFutbol;
import java.time.Year;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import modelo.Entrenador;
import modelo.Equipo;

/**
 *
 * @author Paul
 */
public class Main {

    public static void main(String[] args) {
        boolean parar = false;
        do {
            try {
                LigaFutbol lg = new LigaFutbol();

                System.out.println("---------Liga Futbol----------");

                System.out.println("Selecione una opcion:"
                        + "\n1.Creacion de un nuevo equipo\n"
                        + "2.Eliminar el equipo Real Betis\n"
                        + "3.Equipos que tienen mas de 5000 socios \n"
                        + "4.Entrenadores de Zinedine Zidane\n"
                        + "5.Salir.\n");

                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                List<Equipo> socios = new ArrayList<>();
                List<Entrenador> listaEntrenadores = new ArrayList<>();

                switch (n) {
                    case 1:

                        lg.crearEquipo(datosEntrenador());
                        break;
                    case 2:
                        try {
                        short equipo = 9;
                        lg.eliminarEquipo(equipo);
                        System.out.println("La operacion  se ha realizado correctamente\n");
                    } catch (Exception ex) {
                        System.out.println("La operacion no se ha realizado correctamente\n");
                    }

                    break;
                    case 3:
                        try {
                        socios = lg.filtroPorSocios(50000);
                        for (Equipo e : socios) {
                            System.out.println(e + "\n");
                        }
                        System.out.println("La operacion  se ha realizado correctamente\n");
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                    break;
                    case 4:
                        try {
                        listaEntrenadores = lg.filtroPorEntrenador("Zinedine");
                        for (Entrenador e : listaEntrenadores) {
                            System.out.println("\n" + e);
                        }
                        System.out.println("La operacion  se ha realizado correctamente\n");
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                    break;
                    case 5:
                        parar = true;
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("La opcion que ha escogido es incorrecta.Vuelva a intentarlo\n");
                                System.out.println(e);

            };
        } while (!parar);
    }

    private static Equipo datosEquipo() {
        Equipo equipo = null;
        Scanner sc = new Scanner(System.in);
        Short id = 1;

        System.out.println("---------Creacion de un nuevo equipo---------\n");
        System.out.println("Escriba id para el equipo ");
        try {
            id = sc.nextShort();
        } catch (InputMismatchException e) {
            System.out.println("La id debe de ser un numero ");
        }

        System.out.println("Escriba nombre del equipo");
        String nombre = sc.next();
        System.out.println("Escriba año de fundacion del equipo");
        int año = sc.nextInt();

        System.out.println("Escriba numero de socios del equipo");
        int socios = sc.nextInt();
        System.out.println("Escriba nombre del presidente del equipo");
        String presidente_nombre = sc.next();
        System.out.println("Escriba el primer apellido del presidente del equipo");
        String presidente_apellido1 = sc.next();
        System.out.println("Escriba el segundo apellido del presidente del equipo");
        String presidente_apellido2 = sc.next();
        System.out.println("Escriba el estadio del equipo");
        String estadio = sc.next();
        if (estadio.equals("")) {
            estadio = null;
        }

        equipo = new Equipo();
        equipo.setId(id);
        equipo.setNombre(nombre);
        equipo.setNum_socios(socios);
        equipo.setPresidente_nombre(presidente_nombre);
        equipo.setPresidente_apellido1(presidente_apellido1);
        equipo.setPresidente_apellido2(presidente_apellido2);
        equipo.setEstadio(estadio);
        equipo.setAño_fundacion(Year.of(año));
        return equipo;

    }

    private static Entrenador datosEntrenador() {
        Scanner sc = new Scanner(System.in);
       
        System.out.println("--------Creacion de un nuevo entrenador---------");
        System.out.println("Escriba id para el entrenador ");
        Short id = sc.nextShort();
        System.out.println("Escriba nombre del entrenador");
        String nombre = sc.next();
        System.out.println("Escriba el primer apellido del entrenador");
        String apellido1 = sc.next();
        System.out.println("Escriba el segundo apellido del entrenador");
        String apellido2 = sc.next();

        Entrenador entrenador = new Entrenador(id);
        entrenador.setNombre(nombre);
        entrenador.setApellido1(apellido1);
        entrenador.setApellido2(apellido2);
        entrenador.setEquipo(datosEquipo());
        
        return entrenador;
    }
}
