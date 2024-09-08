package org.example;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Random random = new Random();
        String[] opciones = {"piedra", "papel", "tijera"};
        int rondas = 3;
        int victoriasUsuario = 0;
        int victoriasComputadora = 0;

        System.out.println("Bienvenido al juego de Piedra, Papel o Tijera!");
        System.out.println("Tienes 3 rondas para jugar.");

        for (int i = 1; i <= rondas; i++) {
            System.out.println("\nRonda " + i + ":");
            System.out.print("Elige piedra, papel o tijera: ");
            String eleccionUsuario = leer.nextLine().toLowerCase();

            while (!esOpcionValida(eleccionUsuario)) {
                System.out.print("Opción inválida. Elige piedra, papel o tijera: ");
                eleccionUsuario = leer.nextLine().toLowerCase();
            }

            String eleccionComputadora = opciones[random.nextInt(opciones.length)];
            System.out.println("La computadora elige: " + eleccionComputadora);

            String resultado = determinarGanador(eleccionUsuario, eleccionComputadora);
            switch (resultado) {
                case "usuario":
                    victoriasUsuario++;
                    System.out.println("¡Ganaste esta ronda!");
                    break;
                case "computadora":
                    victoriasComputadora++;
                    System.out.println("La computadora ganó esta ronda.");
                    break;
                default:
                    System.out.println("Esta ronda es un empate.");
                    break;
            }
        }

        System.out.println("\nResultado final:");
        System.out.println("Victorias del usuario: " + victoriasUsuario);
        System.out.println("Victorias de la computadora: " + victoriasComputadora);

        if (victoriasUsuario > victoriasComputadora) {
            System.out.println("¡Felicidades, ganaste el juego!");
        } else if (victoriasUsuario < victoriasComputadora) {
            System.out.println("Lo siento, la computadora ganó el juego.");
        } else {
            System.out.println("El juego terminó en empate.");
        }

        leer.close();
    }

    private static boolean esOpcionValida(String opcion) {
        return opcion.equals("piedra") || opcion.equals("papel") || opcion.equals("tijera");
    }

    private static String determinarGanador(String usuario, String computadora) {
        if (usuario.equals(computadora)) {
            return "empate";
        }
        switch (usuario) {
            case "piedra":
                return computadora.equals("tijera") ? "usuario" : "computadora";
            case "papel":
                return computadora.equals("piedra") ? "usuario" : "computadora";
            case "tijera":
                return computadora.equals("papel") ? "usuario" : "computadora";
            default:
                return "empate";
        }
    }
}