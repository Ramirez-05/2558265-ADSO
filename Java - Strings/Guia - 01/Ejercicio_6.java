import java.util.Scanner;

public class Ejercicio_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del primer jugador: ");
        String jugador1 = scanner.nextLine();
        System.out.print("Ingrese el nombre del segundo jugador: ");
        String jugador2 = scanner.nextLine();

        System.out.println("Menú:");
        System.out.println("1. Iniciar juego");
        System.out.println("2. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            char[][] tablero = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
            };

            boolean turnoJugador1 = true;
            boolean juegoTerminado = false;

            while (!juegoTerminado) {
                mostrarTablero(tablero);

                String jugadorActual = turnoJugador1 ? jugador1 : jugador2;
                System.out.println(jugadorActual + ", es tu turno.");
                System.out.print("Ingresa la posición (1-9): ");
                int posicion = scanner.nextInt();

                if (posicion < 1 || posicion > 9) {
                    System.out.println("Posición inválida. Intenta nuevamente.");
                    continue;
                }

                int fila = (posicion - 1) / 3;
                int columna = (posicion - 1) % 3;

                if (tablero[fila][columna] != ' ') {
                    System.out.println("La casilla ya está ocupada. Intenta nuevamente.");
                    continue;
                }

                char simbolo = turnoJugador1 ? 'X' : 'O';
                tablero[fila][columna] = simbolo;

                if (verificarGanador(tablero, simbolo)) {
                    mostrarTablero(tablero);
                    System.out.println("¡" + jugadorActual + " ha ganado!");
                    juegoTerminado = true;
                } else if (tableroCompleto(tablero)) {
                    mostrarTablero(tablero);
                    System.out.println("El juego ha terminado en empate.");
                    juegoTerminado = true;
                }

                turnoJugador1 = !turnoJugador1;
            }
        } else {
            System.out.println("¡Gracias por jugar!");
        }
    }

    public static void mostrarTablero(char[][] tablero) {
        System.out.println("Tablero:");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j]);
                if (j < tablero[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < tablero.length - 1) {
                System.out.println("---------");
            }
        }
    }

    public static boolean verificarGanador(char[][] tablero, char simbolo) {
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][0] == simbolo && tablero[i][1] == simbolo && tablero[i][2] == simbolo) {
                return true;
            }
        }

        for (int j = 0; j < tablero[0].length; j++) {
            if (tablero[0][j] == simbolo && tablero[1][j] == simbolo && tablero[2][j] == simbolo) {
                return true;
            }
        }

        if ((tablero[0][0] == simbolo && tablero[1][1] == simbolo && tablero[2][2] == simbolo)
                || (tablero[0][2] == simbolo && tablero[1][1] == simbolo && tablero[2][0] == simbolo)) {
            return true;
        }

        return false;
    }

    public static boolean tableroCompleto(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

