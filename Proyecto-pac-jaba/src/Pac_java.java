import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Pac_java {
    static Random random = new Random();
    static Scanner leer = new Scanner(System.in);
    static int pac_pos_int_fila = 0;
    static int pac_pos_int_columna = 0;
    static int blinki_pos_int_fila = 0;
    static int blinki_pos_int_columna = 0;
    static int inki_pos_int_fila = 0;
    static int inki_pos_int_columna = 0;
    static int kpinki_pos_int_fila = 0;
    static int kpinki_pos_int_columna = 0;
    static int clay_pos_int_fila = 0;
    static int clay_pos_int_columna = 0;
    static int punt_max_map = 0;
    static int punt_actual = 0;

    static String[][] mapa = {
            {"#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
            {"#",".",".",".",".",".",".",".",".",".",".",".",".","#",".",".",".",".",".",".",".",".",".",".",".",".","#"},
            {"#",".","#","#","#","#",".","#","#","#","#","#",".","#",".","#","#","#","#","#",".","#","#","#","#",".","#"},
            {"#","o","#","#","#","#",".","#","#","#","#","#",".","#",".","#","#","#","#","#",".","#","#","#","#","o","#"},
            {"#",".","#","#","#","#",".","#","#","#","#","#",".","#",".","#","#","#","#","#",".","#","#","#","#",".","#"},
            {"#",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","#"},
            {"#",".","#","#","#","#",".","#",".","#","#","#","#","#","#","#","#","#",".","#",".","#","#","#","#",".","#"},
            {"#",".",".",".",".",".",".","#",".",".",".",".",".","#",".",".",".",".",".","#",".",".",".",".",".",".","#"},
            {"#","#","#","#","#","#",".","#","#","#","#","#",".","#",".","#","#","#","#","#",".","#","#","#","#","#","#"},
            {"-","-","-","-","-","#",".","#","-","-","-","-","-","-","-","-","-","-","-","#",".","#","-","-","-","-","-"},
            {"-","-","-","-","-","#",".","#","-","-","-","-","-","-","-","-","-","-","-","#",".","#","-","-","-","-","-"},
            {"#","#","#","#","#","#",".","#","-","-","#","#","#","-","#","#","#","-","-","#",".","#","#","#","#","#","#"},
            {"-","-","-","-","-","-",".","-","-","-","#","B","I","-","K","C","#","-","-","-",".","-","-","-","-","-","-"},
            {"#","#","#","#","#","#",".","#","-","-","#","#","#","#","#","#","#","-","-","#",".","#","#","#","#","#","#"},
            {"-","-","-","-","-","#",".","#","-","-","-","-","-","-","-","-","-","-","-","#",".","#","-","-","-","-","-"},
            {"-","-","-","-","-","#",".","#","-","-","-","-","-","-","-","-","-","-","-","#",".","#","-","-","-","-","-"},
            {"#","#","#","#","#","#",".","#","-","-","#","#","#","#","#","#","#","-","-","#",".","#","#","#","#","#","#"},
            {"#",".",".",".",".",".",".",".",".",".",".",".",".","#",".",".",".",".",".",".",".",".",".",".",".",".","#"},
            {"#",".","#","#",".","#","#","#","#","#","#","#",".","#",".","#","#","#","#","#","#","#",".","#","#",".","#"},
            {"#","o",".","#","-","-","-","-","-","-","-","-",".","P",".","-","-","-","-","-","-","-","-","#",".","o","#"},
            {"#","#",".","#",".","#","-","#","#","#","#","#","#","#","#","#","#","#","#","#","-","#",".","#",".","#","#"},
            {"#",".",".",".",".","#",".",".",".",".",".",".",".","#",".",".",".",".",".",".",".","#",".",".",".",".","#"},
            {"#",".","#","#","#","#","#","#","#","#","#","#",".","#",".","#","#","#","#","#","#","#","#","#","#",".","#"},
            {"#",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","#"},
            {"#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"}
    };

    //static int mapa_largo = mapa.length;
    //int mapa_ancho = mapa[0].length;  // Esto obtiene el número de columnas de la primera fila

    private static void reconocer_pos_personajes(){
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[0].length; j++) {
                if(mapa[i][j] == "."){
                    punt_max_map++;
                } else if (mapa[i][j] == "B") {
                    blinki_pos_int_fila = i;
                    blinki_pos_int_columna = j;
                } else if (mapa[i][j] == "I") {
                    inki_pos_int_fila = i;
                    inki_pos_int_columna = j;
                } else if (mapa[i][j] == "K") {
                    kpinki_pos_int_fila = i;
                    kpinki_pos_int_columna = j;
                } else if (mapa[i][j] == "C") {
                    clay_pos_int_fila = i;
                    clay_pos_int_columna = j;
                } else if(mapa[i][j] == "P") {
                    pac_pos_int_fila = i;
                    pac_pos_int_columna = j;
                }
            }
        }
    }

    private static void mover_per(String mobimiento){
        switch (mobimiento){
            case "W","w"://mobimiento hacia rriba
                if (Objects.equals(mapa[pac_pos_int_fila - 1][pac_pos_int_columna], "#")){
                    return;
                }else if (Objects.equals(mapa[pac_pos_int_fila - 1][pac_pos_int_columna], ".")){
                    punt_actual = punt_actual +10;
                }
                mapa[pac_pos_int_fila - 1][pac_pos_int_columna] = "P";
                mapa[pac_pos_int_fila][pac_pos_int_columna] = " ";
                pac_pos_int_fila = pac_pos_int_fila-1;
                break;
            case "D","d"://movimiento derecha
                if (Objects.equals(mapa[pac_pos_int_fila][pac_pos_int_columna + 1], "#")){
                    return;
                }else if (Objects.equals(mapa[pac_pos_int_fila][pac_pos_int_columna+ 1], ".")){
                    punt_actual = punt_actual +10;
                }
                mapa[pac_pos_int_fila][pac_pos_int_columna + 1] = "P";
                mapa[pac_pos_int_fila][pac_pos_int_columna] = " ";
                pac_pos_int_columna = pac_pos_int_columna+1;
                break;
            case "A","a"://pobimiento izquierda
                if (Objects.equals(mapa[pac_pos_int_fila][pac_pos_int_columna - 1], "#")){
                    return;
                }else if (Objects.equals(mapa[pac_pos_int_fila][pac_pos_int_columna - 1], ".")){
                    punt_actual = punt_actual +10;
                }
                mapa[pac_pos_int_fila][pac_pos_int_columna - 1] = "P";
                mapa[pac_pos_int_fila][pac_pos_int_columna] = " ";
                pac_pos_int_columna = pac_pos_int_columna -1;
                break;
            case "S","s"://hacia bajo
                if (Objects.equals(mapa[pac_pos_int_fila + 1][pac_pos_int_columna], "#")){
                    return;
                }else if (Objects.equals(mapa[pac_pos_int_fila +1][pac_pos_int_columna], ".")){
                    punt_actual = punt_actual +10;
                }
                mapa[pac_pos_int_fila + 1][pac_pos_int_columna] = "P";
                mapa[pac_pos_int_fila][pac_pos_int_columna] = " ";
                pac_pos_int_fila = pac_pos_int_fila+1;
                break;
        }
    }

    private static void inprimir_mapa(){
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[0].length; j++) {
                if(mapa[i][j] == "."){
                    System.out.print(mapa[i][j]+" ");
                } else if (mapa[i][j] == "-") {
                    System.out.print("  ");
                } else if (mapa[i][j] == "B") {
                    System.out.print("д ");
                } else if (mapa[i][j] == "I") {
                    System.out.print("д ");
                } else if (mapa[i][j] == "K") {
                    System.out.print("д ");
                } else if (mapa[i][j] == "C") {
                    System.out.print("д ");
                } else if(mapa[i][j] == "P") {
                    System.out.print("₾ ");
                }else {
                    System.out.print(mapa[i][j]+" ");
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        reconocer_pos_personajes();

        inprimir_mapa();

    do{
        String mobimiento = leer.nextLine();
        mover_per(mobimiento);
        inprimir_mapa();
    }while (true);



    }
}