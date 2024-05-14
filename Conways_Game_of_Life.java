/**
 * class Conways Game of Life
 *
 * Toby Steiner
 * 14/05/2024
 */
import java.util.Scanner;
import java.util.Arrays;

public class Conways_Game_of_Life{
    static void setBoard(int[][] board, int x, int y){
        for (int i = 0; i < y; i++){
            for (int j = 0; j < j; j++){
                board[i][j] = 0;
            }
        }
    }
    static void renderBoard(int[][] board, int x, int y){
        System.out.print('\u000c');
        System.out.print("    A  B C  D E  F G H  I J  K L M  N O  P Q  R S T");
        System.out.print("\n");
        
        for (int i = 0; i < y; i++){
            if(i < 9){
                System.out.print(" ");
                System.out.print(i + 1);
            }else{
                System.out.print(i + 1);
            }
            System.out.print("| ");
            for (int j = 0; j < x; j++){
                if(board[i][j] == 0){
                    System.out.print("⬜ ");
                }else{
                    System.out.print("⬛ ");
                }
            }
            System.out.println("");
        }
        // ⬛⬜
    }
    static void changeSquare(int[][] board){
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println(" ");
        System.out.println("in what x axis do you want to place the tile? put your answer as an uppercase letter \n(note, you can only place tiles on white squares)");
        int placeX = keyboard.nextInt();
        System.out.println(placeX);
        System.out.println("in what y axis do you want to place the tile? put your answer as an int \n(note, you can only place tiles on white squares)");
        int placeY = keyboard.nextInt();
        System.out.println(placeY);
        
        board[placeY][placeX] = 1;
        
        
    }
    public static void main(String[] args){
        int XLength = 20;
        int YLength = 20;
        int[][] board = new int [YLength][XLength];
        //char [] alp = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        
        setBoard(board, XLength, YLength);
        renderBoard(board, XLength, YLength);
        //changeSquare(board);
        
        renderBoard(board, XLength, YLength);
    }
}
